package com.huoyun.controller.user.model;

import javax.validation.constraints.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.springframework.validation.BindingResult;

import com.huoyun.core.common.BaseForm;
import com.huoyun.core.user.ErrorCode;

public class RegisterForm extends BaseForm {
	public static final String FORM_NAME = "registerForm";
	private static final String Email_Format_Invalid = "{" + Error_Code_Prefix
			+ ErrorCode.Register_Invalid_Email_Format + "}";
	private static final String Password_Strategy = "{" + Error_Code_Prefix
			+ ErrorCode.Register_Failed_Password_Strategy_Not_Match + "}";

	@Email(message = Email_Format_Invalid)
	private String email;

	@Pattern(regexp = "[0-9a-zA-Z@/！_*$]{6,18}", message = Password_Strategy)
	private String password;

	private String repeatPassword;

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

	@Override
	public void onValid(BindingResult result) {
		if (StringUtils.isEmpty(this.email)) {
			this.addFieldError(result, FORM_NAME, "email",
					ErrorCode.Register_Field_Empty);
			return;
		}

		if (result.hasErrors()) {
			return;
		}

		if (!StringUtils.equals(this.password, this.repeatPassword)) {
			this.addFieldError(result, FORM_NAME, "repeatPassword",
					ErrorCode.Register_Failed_Password_Not_Match);
		}
	}
}
