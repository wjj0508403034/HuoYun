package com.huoyun.core.common;

import com.huoyun.core.common.entity.BaseEntity;
import com.huoyun.core.employee.entity.Employee;
import com.huoyun.core.user.UserInfo;
import com.huoyun.exception.BusinessException;

public interface BoFacade {

	<T extends BaseEntity> T create(Class<T> entityType) throws BusinessException;
	
	UserInfo currentUser();
	
	Employee currentEmployee() throws BusinessException;
	
	boolean isAdmin();
}
