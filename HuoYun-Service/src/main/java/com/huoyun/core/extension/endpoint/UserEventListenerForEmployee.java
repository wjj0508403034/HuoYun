package com.huoyun.core.extension.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.user.entity.User;

@Configuration
public class UserEventListenerForEmployee implements BoEventListener<User> {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public void postCreate(User user) {
		this.employeeService.create(user);
	}

}
