package com.huoyun.business.leave.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.huoyun.business.leave.ApproveService;
import com.huoyun.business.leave.ErrorCode;
import com.huoyun.business.leave.HolidayService;
import com.huoyun.business.leave.LeaveService;
import com.huoyun.business.leave.MailService;
import com.huoyun.business.leave.entity.EmployeeLeave;
import com.huoyun.business.leave.entity.LeaveRecord;
import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.business.leave.enums.LeaveRecordStatus;
import com.huoyun.business.leave.enums.TimeRange;
import com.huoyun.business.leave.repository.EmployeeLeaveRepository;
import com.huoyun.business.leave.repository.LeaveRecordRepository;
import com.huoyun.business.leave.repository.LeaveTypeRepository;
import com.huoyun.core.common.BoService;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;
import com.huoyun.exception.LocalableBusinessException;

@Service
public class LeaveServiceImpl extends BoService implements LeaveService {

	@Autowired
	private LeaveRecordRepository leaveRecordRepository;

	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	@Autowired
	private LeaveTypeRepository leaveTypeRepository;

	@Autowired
	private HolidayService holidayService;

	@Autowired
	private MailService mailService;

	@Autowired
	private ApproveService approveService;

	@Override
	public void create(LeaveRecord leaveRecord) throws BusinessException {
		/*
		 * 必须先设置审批人才能请假
		 */
		if (this.approveService.getApprover() == null) {
			throw new BusinessException(ErrorCode.Employee_Not_Set_Approver,
					this.localeService);
		}

		LocalDate startDate = leaveRecord.getStartDate();
		LocalDate endDate = leaveRecord.getEndDate();

		/*
		 * 请假不允许跨年份
		 */
		if (startDate.getYear() != endDate.getYear()) {
			throw new BusinessException(ErrorCode.Leave_Not_Allow_Corss_Year,
					this.localeService);
		}

		/*
		 * 请假有效时间不能为0
		 */
		double availableDays = this.getAvailableDays(leaveRecord.getType(),
				startDate.getYear());
		if (availableDays <= 0) {
			throw new BusinessException(ErrorCode.Leave_Total_Time_Equal_Zero,
					this.localeService);
		}

		leaveRecord.setEmployee(this.boFacade.currentEmployee());
		leaveRecord.setStatus(LeaveRecordStatus.NEW);
		leaveRecord.setTotal(this.calcTotalDays(startDate, endDate,
				leaveRecord.getStart(), leaveRecord.getEnd()));

		/*
		 * 请假有效时间不能超过今年剩余的假期天数
		 */
		if (leaveRecord.getTotal() > availableDays) {
			throw new BusinessException(ErrorCode.Leave_Exceed_Available_Days,
					this.localeService);
		}

		/*
		 * 请假时间不能与历史请假时间重复
		 */
		for (LeaveRecord myLeave : this.getLeaveRecords(startDate.getYear())) {
			if (myLeave.getStatus() != LeaveRecordStatus.CANCEL)
				this.checkDuplicateLeave(myLeave, leaveRecord);
		}

		this.leaveRecordRepository.save(leaveRecord);

		/*
		 * 发送请假邮件给审批人
		 */
		this.mailService.sendLeaveRequest(leaveRecord);
	}

	@Override
	public LeaveRecord get(Long id) {
		return this.leaveRecordRepository.findOne(id);
	}

	@Override
	public Page<LeaveRecord> query(Pageable pageable) {
		return this.leaveRecordRepository.findAll(pageable);
	}

	@Override
	public void cancel(Long id) throws BusinessException {
		LeaveRecord leaveRecord = this.get(id);
		if (leaveRecord == null) {
			throw new BusinessObjectNotFoundException(LeaveRecord.class, id,
					this.localeService);
		}

		if (leaveRecord.getStatus() != LeaveRecordStatus.NEW) {
			throw new BusinessException(ErrorCode.Leave_Not_Allow_Cancel,
					this.localeService);
		}

		if (leaveRecord.getEmployee().getId() != this.boFacade
				.currentEmployee().getId()) {
			throw new BusinessException(
					ErrorCode.Leave_Not_Allow_Cancel_By_Other,
					this.localeService);
		}

		leaveRecord.setStatus(LeaveRecordStatus.CANCEL);
	}

	@Override
	public List<EmployeeLeave> get(int year) {
		return this.employeeLeaveRepository.findAllByYear(year);
	}

	/*
	 * 获取指定年份的所有请假记录
	 */
	public List<LeaveRecord> getLeaveRecords(int year) throws BusinessException {
		return this.leaveRecordRepository.findLeaveRecordsByEmployeeAndYear(
				this.boFacade.currentEmployee(), year);
	}

	/*
	 * 获取用户指定年里该类型假期的剩余天数
	 */
	public double getAvailableDays(LeaveType type, int year)
			throws BusinessException {
		Employee employee = this.boFacade.currentEmployee();

		EmployeeLeave leave = this.employeeLeaveRepository
				.findByEmployeeAndTypeAndYear(employee, type, year);

		double totalUsed = this.leaveRecordRepository.getTotalUsedDays(
				employee, type, year);
		return leave.getDays() - totalUsed;
	}

	/*
	 * 计算请假周期内有效的天数
	 */
	private double calcTotalDays(LocalDate startDate, LocalDate endDate,
			TimeRange start, TimeRange end) throws BusinessException {
		if (endDate.isBefore(startDate)) {
			throw new LocalableBusinessException(
					ErrorCode.EndDate_Before_StartDate, this.localeService,
					"endDate");
		}

		if (this.isSameDay(startDate, endDate)) {
			if (end.getEnumCode() <= start.getEnumCode()) {
				throw new LocalableBusinessException(
						ErrorCode.EndTime_Before_StartTime, this.localeService,
						"endDate");
			}

			if (this.holidayService.isNotWorkDay(startDate)) {
				throw new BusinessException(ErrorCode.LeaveDate_Is_Holiday,
						this.localeService);
			}

			return (end.getEnumCode() - start.getEnumCode()) * 0.5;
		}

		double total = 0;
		LocalDate nextDay = startDate.plusDays(1);
		while (nextDay.isBefore(endDate)) {
			if (!this.holidayService.isNotWorkDay(nextDay)) {
				total += 1;
			}
			nextDay = nextDay.plusDays(1);
		}

		total += (TimeRange.AFTERNOON.getEnumCode() - start.getEnumCode()) * 0.5;
		total += (end.getEnumCode() - TimeRange.MORNING.getEnumCode()) * 0.5;

		if (total == 0) {
			throw new BusinessException(ErrorCode.Leave_Total_Time_Equal_Zero,
					this.localeService);
		}

		return total;
	}

	/*
	 * 检查两个请假是否有时间冲突
	 */
	private void checkDuplicateLeave(LeaveRecord sourceLeave,
			LeaveRecord targetLeave) throws BusinessException {
		boolean isAfterEndDate = targetLeave.getStartDate().isAfter(
				sourceLeave.getEndDate())
				|| targetLeave.getStartDate().isEqual(sourceLeave.getEndDate());
		boolean isBeforeStartDate = targetLeave.getEndDate().isBefore(
				sourceLeave.getStartDate())
				|| targetLeave.getEndDate().isEqual(sourceLeave.getStartDate());

		if (isAfterEndDate || isBeforeStartDate) {
			return;
		}

		boolean inDateRange = this.inDateRange(sourceLeave, targetLeave);
		if (inDateRange) {
			throw new BusinessException(ErrorCode.Leave_Date_Range_Is_Conflict,
					this.localeService);
		}

		boolean isAfterStartDate = targetLeave.getStartDate().isAfter(
				sourceLeave.getStartDate())
				|| targetLeave.getStartDate().isEqual(
						sourceLeave.getStartDate());

		if (isAfterStartDate) {
			double totalDays = this.calcTotalDays(targetLeave.getStartDate(),
					sourceLeave.getEndDate(), targetLeave.getStart(),
					sourceLeave.getEnd());
			if (totalDays != 0) {
				throw new BusinessException(
						ErrorCode.Leave_Date_Range_Is_Conflict,
						this.localeService);
			}

			return;
		}

		double totalDays = this.calcTotalDays(sourceLeave.getStartDate(),
				targetLeave.getEndDate(), sourceLeave.getStart(),
				targetLeave.getEnd());
		if (totalDays != 0) {
			throw new BusinessException(ErrorCode.Leave_Date_Range_Is_Conflict,
					this.localeService);
		}
	}

	private boolean inDateRange(LeaveRecord sourceLeave, LeaveRecord targetLeave) {
		boolean isAfter = targetLeave.getStartDate().isAfter(
				sourceLeave.getStartDate())
				|| targetLeave.getStartDate().isEqual(
						sourceLeave.getStartDate());
		boolean isBefore = targetLeave.getEndDate().isBefore(
				sourceLeave.getEndDate())
				|| targetLeave.getEndDate().isEqual(sourceLeave.getEndDate());
		return isAfter && isBefore;
	}

	private boolean isSameDay(LocalDate date1, LocalDate date2) {
		return date1.getYear() == date2.getYear()
				&& date1.getMonth() == date2.getMonth()
				&& date1.getDayOfMonth() == date2.getDayOfMonth();
	}

	@Override
	public List<LeaveType> getLeaveTypes() {
		return (List<LeaveType>) Lists.newArrayList(this.leaveTypeRepository
				.findAll());
	}

}
