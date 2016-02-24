package com.huoyun.thirdparty.alibaba.dayu;

import org.springframework.beans.factory.annotation.Autowired;

import com.taobao.api.TaobaoClient;
import com.taobao.api.DefaultTaobaoClient;
import com.aliyun.api.AliyunRequest;

public class AlidayuImpl implements Alidayu {

	@Autowired
	private SMSProperties smsProperties;

	@Override
	public void sendSms() {
		// TODO Auto-generated method stub
		TaobaoClient client = new DefaultTaobaoClient(
				this.smsProperties.getUrl(), this.smsProperties.getAppKey(),
				this.smsProperties.getAppSecret());
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("阿里大鱼");
		req.setSmsParamString("{\"code\":\"1234\",\"product\":\"阿里大鱼\",\"item\":\"阿里大鱼\"}");
		req.setRecNum("13000000000");
		req.setSmsTemplateCode("SMS_585014");
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}

}
