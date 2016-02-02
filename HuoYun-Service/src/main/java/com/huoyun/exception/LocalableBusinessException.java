package com.huoyun.exception;

import com.huoyun.core.locale.LocaleService;

public class LocalableBusinessException extends BusinessException {

	private static final long serialVersionUID = -3254104888634241202L;

	private String path;

	public LocalableBusinessException(int code,
			LocaleService localeService,String path) {
		super(code, localeService);
		this.path = path;
	}

	public LocalableBusinessException(int code, String message, String path) {
		super(code, message);
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
