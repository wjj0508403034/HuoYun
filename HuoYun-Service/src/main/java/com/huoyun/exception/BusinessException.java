package com.huoyun.exception;

import com.huoyun.core.locale.LocaleService;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 2681232591152686817L;
	private int code;

	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public BusinessException(int code,LocaleService localeService){
		super(localeService.getErrorMessage(code));
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
