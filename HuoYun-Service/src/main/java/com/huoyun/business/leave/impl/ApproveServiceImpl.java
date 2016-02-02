package com.huoyun.business.leave.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.business.leave.ApproveService;
import com.huoyun.business.leave.ErrorCode;
import com.huoyun.business.leave.LeaveService;
import com.huoyun.business.leave.MailService;
import com.huoyun.business.leave.entity.LeaveApprover;
import com.huoyun.business.leave.entity.LeaveRecord;
import com.huoyun.business.leave.enums.LeaveRecordStatus;
import com.huoyun.business.leave.repository.LeaveApproverRepository;
import com.huoyun.core.common.BoService;
import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;

@Service
public class ApproveServiceImpl extends BoService implements ApproveService {

	@Autowired
	private LeaveApproverRepository leaveApproverRepository;

	@Autowired
	private LeaveService leaveService;

	@Autowired
	private MailService mailService;

	@Autowired
	private EmployeeService employeeService;

	@Override
	public void approve(Long id) throws BusinessException {
		LeaveRecord leaveRecord = this.leaveService.get(id);
		if (leaveRecord == null) {
			throw new BusinessObjectNotFoundException(LeaveRecord.class, id,
					this.localeService);
		}

		if (leaveRecord.getStatus() != LeaveRecordStatus.NEW) {
			throw new BusinessException(ErrorCode.Leave_Not_Allow_Approver,
					this.localeService);
		}

		Employee employee = this.boFacade.currentEmployee();
		Employee approver = this.getApprover(leaveRecord);
		if (approver == null || approver.getId() != employee.getId()) {
			throw new BusinessException(ErrorCode.Leave_Incorrect_Approver,
					this.localeService);
		}

		leaveRecord.setStatus(LeaveRecordStatus.CLOSE);

		this.mailService.sendApproveResult(leaveRecord);
	}

	@Override
	public void reject(Long id) throws BusinessException {
		LeaveRecord leaveRecord = this.leaveService.get(id);
		if (leaveRecord == null) {
			throw new BusinessObjectNotFoundException(LeaveRecord.class, id,
					this.localeService);
		}

		if (leaveRecord.getStatus() != LeaveRecordStatus.NEW) {
			throw new BusinessException(ErrorCode.Leave_Not_Allow_Reject,
					this.localeService);
		}

		Employee employee = this.boFacade.currentEmployee();
		Employee approver = this.getApprover(leaveRecord);
		if (approver == null || approver.getId() != employee.getId()) {
			throw new BusinessException(ErrorCode.Leave_Incorrect_Approver,
					this.localeService);
		}

		leaveRecord.setStatus(LeaveRecordStatus.REJECT);

		this.mailService.sendApproveResult(leaveRecord);
	}

	@Override
	public void setApprover(Long employeeId, Long approverId)
			throws BusinessException {
		Employee employee = this.employeeService.get(employeeId);
		if (employee == null) {
			throw new BusinessObjectNotFoundException(Employee.class,
					employeeId, this.localeService);
		}

		Employee approver = this.employeeService.get(approverId);
		if (approver == null) {
			throw new BusinessObjectNotFoundException(Employee.class,
					approverId, this.localeService);
		}

		LeaveApprover leaveApprover = this.leaveApproverRepository
				.findByEmployee(employee);
		if (leaveApprover == null) {
			leaveApprover = new LeaveApprover();
			leaveApprover.setEmployee(employee);
		}

		leaveApprover.setApprover(approver);
		this.leaveApproverRepository.save(leaveApprover);
		this.mailService.sendSetApproverSuccess(leaveApprover);
	}

	@Override
	public Employee getApprover() throws BusinessException {
		Employee employee = this.boFacade.currentEmployee();
		LeaveApprover leaveApprover = this.leaveApproverRepository
				.findByEmployee(employee);
		if (leaveApprover != null) {
			return leaveApprover.getApprover();
		}

		return null;
	}

	private Employee getApprover(LeaveRecord leaveRecord) {
		LeaveApprover leaveApprover = this.leaveApproverRepository
				.findByEmployee(leaveRecord.getEmployee());
		return leaveApprover.getApprover();
	}

}
