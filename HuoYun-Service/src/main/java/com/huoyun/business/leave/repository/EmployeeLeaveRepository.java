package com.huoyun.business.leave.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.business.leave.entity.EmployeeLeave;
import com.huoyun.business.leave.entity.LeaveType;
import com.huoyun.core.employee.entity.Employee;

public interface EmployeeLeaveRepository extends
		CrudRepository<EmployeeLeave, Long> {

	public EmployeeLeave findByEmployeeAndTypeAndYear(Employee employee,
			LeaveType leaveType, int year);
	
	public List<EmployeeLeave> findAllByYear(int year);
}
