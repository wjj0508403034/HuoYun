package com.huoyun.core.employee;

import com.huoyun.core.common.CrudService;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.user.entity.User;
import com.huoyun.exception.BusinessException;

public interface EmployeeService extends CrudService<Employee> {

	/*
	 * 创建员工
	 */
	void create(User user);

	/*
	 * 查找员工
	 */
	Employee findByUser(User user);
	
	/*
	 * 设置员工为管理员-员工ID
	 */
	void setAdmin(Long id) throws BusinessException;
	
	/*
	 * 当前登录的员工
	 */
	Employee currentEmployee() throws BusinessException;
}
