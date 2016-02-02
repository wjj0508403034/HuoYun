package com.huoyun.business.leave.repository;

import org.springframework.data.repository.CrudRepository;

import com.huoyun.business.leave.entity.LeaveApprover;
import com.huoyun.core.employee.entity.Employee;

public interface LeaveApproverRepository extends CrudRepository<LeaveApprover, Long>{

	public LeaveApprover findByEmployee(Employee employee);
}
