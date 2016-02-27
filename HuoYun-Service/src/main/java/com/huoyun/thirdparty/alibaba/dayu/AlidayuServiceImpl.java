package com.huoyun.thirdparty.alibaba.dayu;

import java.util.Random;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.core.common.web.ProxyProperties;
import com.huoyun.core.locale.LocaleService;
import com.huoyun.exception.BusinessException;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.response.*;
import com.taobao.api.request.*;
import com.taobao.api.DefaultTaobaoClient;

@Service
public class AlidayuServiceImpl implements AlidayuService {

	private final static String SMS_TYPE = "normal";
	private final static String Sign_Name = "火云科技";
	private final static String Product_Name = "火云科技";

	private static Logger logger = Logger.getLogger(AlidayuServiceImpl.class);

	@Autowired
	private SMSProperties smsProperties;

	@Autowired
	private LocaleService localeService;
	
	@Autowired
	private ProxyProperties proxyProperties;

	/*
	 * 阿里大鱼开发文档
	 * 
	 * @see http://open.taobao.com/doc2/apiDetail?spm=0.0.0.0.D1PYJd&apiId=25450
	 */
	@Override
	public void sendSms() {
		TaobaoClient client = new DefaultTaobaoClient(
				this.smsProperties.getUrl(), this.smsProperties.getAppKey(),
				this.smsProperties.getAppSecret());
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType(SMS_TYPE);
		req.setSmsFreeSignName("阿里大鱼");
		req.setSmsParamString("{\"code\":\"1234\",\"product\":\"阿里大鱼\",\"item\":\"阿里大鱼\"}");
		req.setRecNum("13000000000");
		req.setSmsTemplateCode("SMS_585014");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String sendRegisterSms(String phones) throws BusinessException {
		logger.info("send register sms...");
		RegisterTemplateParam params = new RegisterTemplateParam(
				this.generatorCode(), Product_Name);
		try {
			this.send(SMSTemplate.Register, Sign_Name, params, phones);
		} catch (BusinessException e) {
			if (e.getCode() == ErrorCode.SMS_Send_Failed) {
				throw new BusinessException(
						ErrorCode.SMS_Send_Validate_Code_Failed, localeService);
			} else {
				throw e;
			}
		}
		logger.info("send register sms successfully.");
		
		return params.getCode();
	}

	private void send(String template, String signName, Object params,
			String phones) throws BusinessException {
		TaobaoClient client = new DefaultTaobaoClient(
				this.smsProperties.getUrl(), this.smsProperties.getAppKey(),
				this.smsProperties.getAppSecret());

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType(SMS_TYPE);
		req.setSmsFreeSignName(signName);
		req.setSmsParamString(this.paramsToString(params));
		req.setRecNum(phones);
		req.setSmsTemplateCode(template);
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			if (!rsp.isSuccess()) {
				logger.error(rsp.getBody());
				throw new BusinessException(ErrorCode.SMS_Send_Failed,
						localeService);
			} else {
				logger.info(rsp.getBody());
			}
		} catch (ApiException e) {
			logger.error(e);
			throw new BusinessException(ErrorCode.SMS_Internal_Error,
					localeService);
		}
	}

	private String generatorCode() {
		Random random = new Random();
		random.setSeed(LocalDateTime.now().getMillisOfSecond());
		int num = random.nextInt(1000000);
		return String.format("%06d", num);
	}

	private String paramsToString(Object params) throws BusinessException {
		try {
			ObjectWriter ow = new ObjectMapper().writer();
			return ow.writeValueAsString(params);
		} catch (Exception ex) {
			logger.error("Parse object failed", ex);
			throw new BusinessException(ErrorCode.SMS_Internal_Error,
					localeService);
		}
	}
}
