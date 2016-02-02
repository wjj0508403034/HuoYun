package com.huoyun.core.common.impl;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.core.common.BoFacade;
import com.huoyun.core.common.ErrorCode;
import com.huoyun.core.common.entity.BaseEntity;
import com.huoyun.core.employee.EmployeeService;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.UserInfo;
import com.huoyun.core.user.UserService;
import com.huoyun.core.user.entity.Role;
import com.huoyun.exception.BusinessException;

@Service
public class BoFacadeImpl implements BoFacade {

	private static Logger logger = Logger.getLogger(BoFacadeImpl.class);

	@Autowired
	private LocaleService localeService;

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@Override
	public <T extends BaseEntity> T create(Class<T> entityType)
			throws BusinessException {
		T entity = null;
		UserInfo userInfo = this.currentUser();
		try {
			entity = entityType.getConstructor().newInstance();
			if (userInfo != null) {
				entity.setCreateBy(userInfo.getUser());
				entity.setUpdateBy(userInfo.getUser());
				entity.setOwner(userInfo.getUser());
			}
			entity.setCreateTime(LocalDate.now());
			entity.setUpdateTime(LocalDate.now());
		} catch (Exception e) {
			logger.error("Create entity failed", e);
			throw new BusinessException(ErrorCode.General_Error, localeService);
		}

		return entity;
	}

	@Override
	public UserInfo currentUser() {
		return this.userService.getCurrentUser();
	}

	@Override
	public Employee currentEmployee() throws BusinessException {
		UserInfo userInfo = this.currentUser();
		if (userInfo == null) {
			throw new BusinessException(
					com.huoyun.core.user.ErrorCode.Session_No_User,
					localeService);
		}

		return this.employeeService.findByUser(userInfo.getUser());
	}

	@Override
	public boolean isAdmin() {
		UserInfo userInfo = this.currentUser();
		Role role = userInfo.getUser().getRole();
		return StringUtils.equals(role.getCode(), "ADMIN");
	}

}
