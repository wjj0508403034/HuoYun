package com.huoyun.core.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.user.entity.User;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

	public Page<Employee> findAll(Pageable pageable);
	
	@Query("SELECT MAX(t0.code) FROM Employee t0")
	public Long maxEmployeeCode();
	
	public Employee findByUser(User user);
}
