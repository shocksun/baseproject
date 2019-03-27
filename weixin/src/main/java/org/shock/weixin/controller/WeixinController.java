package org.shock.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.shock.weixin.CommonConstant;
import org.shock.weixin.message.from.FMessage;
import org.shock.weixin.message.from.event.EventFMessage;
import org.shock.weixin.message.to.Item;
import org.shock.weixin.message.to.NewsTMessage;
import org.shock.weixin.message.to.TextTMessage;
import org.shock.weixin.utils.CheckUtil;
import org.shock.weixin.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeixinController {
	
	@Autowired
	private CommonConstant commonConstant;
	
	@GetMapping("weixin")
	public String checkAuth(String signature,String echostr,String timestamp,String nonce){
		System.out.println("开始验证");
		if(CheckUtil.checksignature(commonConstant.getToken(),signature, timestamp, nonce)){
			System.out.println("验证成功");
			return echostr;
		}
		System.out.println("验证失败");
		return "false";
	}
	@PostMapping("weixin")
	public String receiveMessages(HttpServletRequest request) {
		FMessage message = MessageUtil.fromMessage(request, commonConstant.isDebug(), commonConstant.getAppid(), commonConstant.getEncodingaeskey());
		System.out.println(message);
		return null;
	}
}
