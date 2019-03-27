package org.shock.weixin.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web")
public class WeixinWebController {
	@RequestMapping("sendRedirectUri")
	@ResponseBody
	public String sendRedirectUri(Map<String,Object> data) {
		System.out.println(data);
		return "123131232";
	}
}
