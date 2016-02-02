package com.huoyun.core.common.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

public class EmailValidtor implements Validator {
	
	private static Logger logger = Logger.getLogger(EmailValidtor.class);

	@Override
	public boolean validator(Object obj) {
		try {
			new InternetAddress((String) obj);
			return true;
		} catch (AddressException ex) {
			logger.error(ex);
			return false;
		}

	}

}
