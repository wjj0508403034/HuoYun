package com.huoyun.exception;

import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.ErrorCode;

public class NotAdminException extends BusinessException {
	private static final long serialVersionUID = -4461235874707939336L;

	public NotAdminException(LocaleService localeService) {
		super(ErrorCode.User_Is_Not_Admin, localeService);
	}

}
