package com.huoyun.exception;

import org.apache.log4j.Logger;

import com.huoyun.core.common.ErrorCode;
import com.huoyun.core.locale.LocaleService;

public class BusinessObjectNotFoundException extends BusinessException {

	private static Logger logger = Logger
			.getLogger(BusinessObjectNotFoundException.class);

	private static final long serialVersionUID = 4039411171796443512L;

	public <T> BusinessObjectNotFoundException(Class<T> boClass, Long id,
			LocaleService localeService) {
		super(ErrorCode.BusinessObject_Not_Found, localeService);
		logger.error(String.format("Cannot find business object:%s-%d",
				boClass, id));
	}
}
