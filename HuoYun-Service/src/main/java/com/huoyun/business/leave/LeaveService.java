package com.huoyun.business.leave;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.huoyun.business.leave.entity.EmployeeLeave;
import com.huoyun.business.leave.entity.LeaveRecord;
import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.exception.BusinessException;

public interface LeaveService {

	/*
	 * 取消请假 -请假记录的id
	 */
	void cancel(Long id) throws BusinessException;

	/*
	 * 获取当前员工指定年份的拥有的所有假期信息
	 */
	List<EmployeeLeave> get(int year);

	/*
	 * 创建一个请假请求
	 */
	void create(LeaveRecord leaveRecord) throws BusinessException;

	/*
	 * 获取指定的请假记录
	 */
	LeaveRecord get(Long id);

	/*
	 * 获取所有的请假记录
	 */
	Page<LeaveRecord> query(Pageable pageable);

	/*
	 * 获取所有假期类型
	 */
	List<LeaveType> getLeaveTypes();
}
