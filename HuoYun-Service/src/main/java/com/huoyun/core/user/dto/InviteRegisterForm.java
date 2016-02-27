package com.huoyun.core.user.dto;

import org.thymeleaf.util.StringUtils;

import com.huoyun.core.common.validator.EmailValidator;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.core.user.ErrorCode;
import com.huoyun.exception.BusinessException;
import com.huoyun.exception.LocalableBusinessException;

public class InviteRegisterForm {

	private String code;
	private String email;
	private String password;
	private String repeatPassword;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		if (StringUtils.isEmpty(this.email)) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Field_Empty, localeService, "email");
		}

		if (StringUtils.isEmpty(password)) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Field_Empty, localeService, "password");
		}

		EmailValidator emailValidtor = new EmailValidator();
		if (!emailValidtor.validator(this.email)) {
			throw new LocalableBusinessException(
					ErrorCode.Invalid_Email_Format, localeService,
					"email");
		}

		if (!StringUtils.equals(password, repeatPassword)) {
			throw new LocalableBusinessException(
					ErrorCode.Register_Password_NotMatch, localeService,
					"repeatPassword");
		}
	}

}
