package com.huoyun.thirdparty.alibaba.dayu;

import com.huoyun.exception.BusinessException;

public interface AlidayuService {

	public void sendSms();
	
	public String sendRegisterSms(String phones) throws BusinessException;
}
