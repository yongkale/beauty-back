package com.wechat.context;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 微信基础配置上下文
 * @Author wuwz
 * @TypeName WeChatContext
 */

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatContext {
	private WeChatContext() {}
	private static WeChatContext context;
	private String appId;
	private String appSecrct;
	private String token;
	private String templateId;
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecrct() {
		return appSecrct;
	}

	public void setAppSecrct(String appSecrct) {
		this.appSecrct = appSecrct;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
}

