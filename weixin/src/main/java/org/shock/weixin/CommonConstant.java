package org.shock.weixin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="wxprops")
public class CommonConstant {
	private String appid;
	private String appsecret;
	private String token;
	private String encodingaeskey;
	private boolean isDebug;
}
