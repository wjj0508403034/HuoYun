package com.huoyun.thirdparty.alibaba.dayu;

public class RegisterTemplateParam {

	public RegisterTemplateParam() {

	}

	public RegisterTemplateParam(String code, String product) {
		this.code = code;
		this.product = product;
	}

	private String code;
	private String product;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
}
