package com.huoyun.core.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public abstract class BaseForm {
	public static final String Error_Code_Prefix = "huoyun.error.code.";

	public abstract void onValid(BindingResult result);

	protected void addFieldError(BindingResult result, String formName,
			String fieldName, int[] codes, Object[] arguments) {
		String[] strCodes = new String[codes.length];
		for (int i = 0; i < codes.length; i++) {
			strCodes[i] = Error_Code_Prefix + codes[i];
		}

		FieldError error = new FieldError(formName, fieldName, null, false,
				strCodes, arguments, null);
		result.addError(error);
	}

	public void addError(BindingResult result, int errorCode) {
		result.reject(Error_Code_Prefix + errorCode);
	}

	protected void addFieldError(BindingResult result, String formName,
			String fieldName, int code) {
		this.addFieldError(result, formName, fieldName, new int[] { code },
				null);
	}
}
