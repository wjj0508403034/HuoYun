package com.huoyun.core.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huoyun.core.common.BoFacade;
import com.huoyun.core.common.BoService;
import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.employee.repository.EmployeeRepository;
import com.huoyun.core.user.ErrorCode;
import com.huoyun.core.user.UserService;
import com.huoyun.core.user.entity.User;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.BusinessObjectNotFoundException;

@Service
public class EmployeeServiceImpl extends BoService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private BoFacade boFacade;

	@Override
	public Employee get(Long id) {
		return this.employeeRepository.findOne(id);
	}

	@Override
	public void update(Employee object) throws BusinessException {
		this.employeeRepository.save(object);
	}

	@Override
	public void delete(Long id) throws BusinessException {
		Employee oldEntity = this.employeeRepository.findOne(id);
		if (oldEntity == null) {
			throw new BusinessObjectNotFoundException(Employee.class, id,
					localeService);
		}

		this.employeeRepository.delete(id);
	}

	@Override
	public Page<Employee> query(Pageable pageable) {
		return this.employeeRepository.findAll(pageable);
	}

	@Override
	public void create(User user) {
		Long maxCode = this.employeeRepository.maxEmployeeCode();
		Employee employee = new Employee();
		employee.setCode(maxCode == null ? 1 : maxCode);
		employee.setEmail(user.getEmail());
		employee.setUser(user);
		this.create(employee);
	}

	@Override
	public void create(Employee object) {
		this.employeeRepository.save(object);
	}

	@Override
	public Employee findByUser(User user) {
		return this.employeeRepository.findByUser(user);
	}

	@Override
	public void setAdmin(Long id) throws BusinessException {
		Employee employee = this.get(id);
		if (employee == null) {
			throw new BusinessObjectNotFoundException(Employee.class, id,
					this.localeService);
		}

		User user = employee.getUser();
		if (user.getRole().getCode() == "ADMIN") {
			throw new BusinessException(
					ErrorCode.Set_User_Admin_Failed_Due_To_User_Already_Admin,
					this.localeService);
		}

		this.userService.setAdmin(user);

	}

	@Override
	public Employee currentEmployee() throws BusinessException {
		return this.boFacade.currentEmployee();
	}
}
