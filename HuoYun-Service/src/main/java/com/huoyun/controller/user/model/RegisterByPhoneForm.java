package com.huoyun.controller.user.model;

import org.springframework.validation.BindingResult;

import com.huoyun.core.common.BaseForm;

public class RegisterByPhoneForm extends BaseForm {

	private String phone;
	private String code;
	private String password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void onValid(BindingResult result) {
		// TODO Auto-generated method stub

	}

}
