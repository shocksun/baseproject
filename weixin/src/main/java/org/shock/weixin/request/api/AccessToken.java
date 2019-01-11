package org.shock.weixin.request.api;

import lombok.Data;

@Data
public class AccessToken {
	private String token;
	private String jsapiTicket;
}
