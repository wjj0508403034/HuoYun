package com.huoyun.exception;

public class BusinessExceptionResponse {

	private int code;
	private String message;

	public BusinessExceptionResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public BusinessExceptionResponse(BusinessException ex) {
		this.code = ex.getCode();
		this.message = ex.getMessage();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
