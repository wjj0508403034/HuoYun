package com.huoyun.api.user.model;

import java.time.LocalDateTime;

public class SmsValidateCode {

	public SmsValidateCode(String code, LocalDateTime expireDate) {
		this.code = code;
		this.expireDate = expireDate;
	}

	private String code;
	private LocalDateTime expireDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}

}
