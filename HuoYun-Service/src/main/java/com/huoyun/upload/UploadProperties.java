package com.huoyun.upload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConfigurationProperties(locations = "classpath:application.properties", prefix = "huoyun.upload", ignoreUnknownFields = false)
public class UploadProperties {

	private String extensionWhitelist;

	public String getExtensionWhitelist() {
		return extensionWhitelist;
	}

	public void setExtensionWhitelist(String extensionWhitelist) {
		this.extensionWhitelist = extensionWhitelist;
	}

	public List<String> getExtensions() {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isEmpty(extensionWhitelist)) {
			return list;
		}

		for (String it : extensionWhitelist.split(";")) {
			list.add(it);
		}

		return list;
	}
}
