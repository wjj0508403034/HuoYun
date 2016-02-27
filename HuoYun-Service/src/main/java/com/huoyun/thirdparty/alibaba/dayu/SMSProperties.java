package com.huoyun.thirdparty.alibaba.dayu;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * see http://www.alidayu.com/admin/service/sign
 */
@Configuration
@ConfigurationProperties(locations = "classpath:application.properties", ignoreUnknownFields = false, prefix = "alibaba.dayu")
public class SMSProperties {

	private String url;
	private String appKey;
	private String appSecret;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
