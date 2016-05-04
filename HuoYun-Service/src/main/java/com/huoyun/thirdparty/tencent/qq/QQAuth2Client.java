package com.huoyun.thirdparty.tencent.qq;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huoyun.core.tools.CodeGeneratorUtils;
import com.huoyun.thirdparty.common.OAuth2Client;

@Service
public class QQAuth2Client implements OAuth2Client {

	@Autowired
	private QQProperties properties;

	@SuppressWarnings("deprecation")
	@Override
	public String getAuthorizeURL() {
		String url = this.join(properties.getBaseUrl(), "oauth2.0/authorize")
				+ "?response_type=code&client_id=" + properties.getAppId()
				+ "&scope=" + properties.getScope() + "&redirect_uri="
				+ URLEncoder.encode(properties.getRedirectUrl()) + "&state="
				+ CodeGeneratorUtils.generator();
		
		return url;
	}

	private String join(String baseUrl, String path) {
		if (!StringUtils.endsWith(baseUrl, "/")) {
			baseUrl += "/";
		}

		if (StringUtils.startsWith(path, "/")) {
			path = path.replaceFirst("/", "");
		}

		return baseUrl + path;
	}

}
