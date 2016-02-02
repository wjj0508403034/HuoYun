package com.huoyun.business.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.huoyun.business.leave.entity.LeaveRecord;
import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.core.employee.entity.Employee;

public interface LeaveRecordRepository extends
		PagingAndSortingRepository<LeaveRecord, Long> {

	/*
	 * 计算用户已经记录的所有请假时间总和（不包括被取消的假期）
	 */
	@Query("SELECT SUM(total) FROM LeaveRecord t0 WHERE t0.employee = ?1 and t0.type = ?2 and t0.year = ?3 and status <> 2")
	public double getTotalUsedDays(Employee employee, LeaveType type, int year);

	public List<LeaveRecord> findLeaveRecordsByEmployeeAndYear(
			Employee employee, int year);
}
