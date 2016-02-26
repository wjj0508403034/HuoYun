package com.huoyun.api.user.model;

import java.time.LocalDate;

public class SmsValidateCode {

	public SmsValidateCode(String code, LocalDate expireDate) {
		this.code = code;
		this.expireDate = expireDate;
	}

	private String code;
	private LocalDate expireDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

}
