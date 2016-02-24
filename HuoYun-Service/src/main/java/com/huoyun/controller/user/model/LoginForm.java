package com.huoyun.controller.user.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.BindingResult;

import com.huoyun.core.common.BaseForm;

public class LoginForm extends BaseForm {

	@NotNull
	private String account;

	@NotNull
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
