package org.shock.weixin.request;

import org.shock.weixin.request.api.AccessToken;
import org.shock.weixin.request.api.Material;
import org.shock.weixin.request.api.Menu;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="weixinapi")
public class WeixinApi {
	private AccessToken accessToken;
	private Material material;
	private Menu menu;
}
