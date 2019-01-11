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
		if(message.getMsgType().equals("event")){
			EventFMessage event = (EventFMessage) message;
			if(event.getEvent().equals("subscribe")){
				NewsTMessage news = new NewsTMessage();
				news.setFromUserName(message.getToUserName());
				news.setToUserName(message.getFromUserName());
				Item item = new Item();
				item.setTitle("点兔");
				item.setDescription("今天要来点兔子吗");
				item.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/qpQicXpNxpALIcndfgK9S3nPEGcM9xvoiciaFoeOFgd13bgy7QoRcANYcMsjw7l8wNPxiaYxpWjXeP8YaHnVenXKbg/0");
				item.setUrl("https://bangumi.bilibili.com/anime/191?from=search&seid=7694169360049327962");
				news.addItem(item);
				Item item2 = new Item();
				item2.setTitle("埃罗芒阿老师");
				item2.setDescription("埃罗芒阿老师");
				item2.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/qpQicXpNxpALTkJbXXsibiajGHJxEr5oicric4mRCUv3v6EubMsiclmhmAhj0AAGgjDjsuiambhrJd8qPLT0IXUxgoeFg/0");
				item2.setUrl("https://bangumi.bilibili.com/anime/5997?from=search&seid=16211846540622891491");
				news.addItem(item2);
				return news.toMessage();
			}
		}
		TextTMessage textMessage = new TextTMessage();
		textMessage.setFromUserName(message.getToUserName());
		textMessage.setToUserName(message.getFromUserName());
		textMessage.setContent("数据");
		return textMessage.toMessage();
	}
}
