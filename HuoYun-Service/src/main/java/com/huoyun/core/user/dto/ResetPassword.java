package com.huoyun.core.user.dto;

import org.thymeleaf.util.StringUtils;

import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.ErrorCode;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.LocalableBusinessException;

public class ResetPassword {

	private String orgianlPassword;
	private String password;
	private String repeatPassword;

	public String getOrgianlPassword() {
		return orgianlPassword;
	}

	public void setOrgianlPassword(String orgianlPassword) {
		this.orgianlPassword = orgianlPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public void onValid(LocaleService localeService) throws BusinessException {
		if (!StringUtils.equals(password, repeatPassword)) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Password_NotMatch, localeService,
					"repeatPassword");
		}
	}

}
