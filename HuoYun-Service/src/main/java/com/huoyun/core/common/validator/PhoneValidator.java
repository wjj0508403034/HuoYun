package com.huoyun.core.common.validator;

import java.util.regex.Pattern;

public class PhoneValidator implements Validator {

	private final String phonePattern = "^1[1-8][0-9]{9}$";

	@Override
	public boolean validator(Object phone) {
		return Pattern.matches(phonePattern, (String)phone);
	}

}
