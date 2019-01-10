package org.shock.weixin.utils;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.shock.weixin.message.from.FMessage;
import org.shock.weixin.message.from.ImageFMessage;
import org.shock.weixin.message.from.LinkFMessage;
import org.shock.weixin.message.from.LocationFMessage;
import org.shock.weixin.message.from.TextFMessage;
import org.shock.weixin.message.from.VideoFMessage;
import org.shock.weixin.message.from.VoiceFMessage;
import org.shock.weixin.message.from.event.ClickEventFMessage;
import org.shock.weixin.message.from.event.SubscribeEventFMessage;
import org.shock.weixin.message.from.event.ViewEventFMessage;
import org.shock.weixin.message.to.TMessage;

import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	public static FMessage fromMessage(HttpServletRequest request,boolean isDebug,String appid,String encodingaeskey){
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(request.getInputStream());
			Element ele = doc.getRootElement();
			if(!isDebug){
				String encrypt = ele.elementText("Encrypt");
				String xml=WXMsgCrypt.decrypt(encrypt,appid,encodingaeskey);
				doc=DocumentHelper.parseText(xml);
				ele = doc.getRootElement();
			}
			String type=ele.elementText("MsgType");
			FMessage message=getMessage(type,ele.elementText("Event"));
			Class<?> clazz = message.getClass();
			@SuppressWarnings("unchecked")
			List<Element> list=ele.elements();
			for (Element e : list) {
				Method method=clazz.getMethod("set"+e.getName(), String.class);
				method.invoke(message, e.getText());
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static FMessage getMessage(String type,String event) {
		switch (type) {
		case "text":
			return new TextFMessage();
		case "image":
			return new ImageFMessage();
		case "voice":
			return new VoiceFMessage();
		case "shortvideo":
		case "video":
			return new VideoFMessage();
		case "location":
			return new LocationFMessage();
		case "link":
			return new LinkFMessage();
		case "event":
			switch (event) {
			case "subscribe":
			case "unsubscribe":
			case "SCAN":
				return new SubscribeEventFMessage();
			case "LOCATION":
				return new LocationFMessage();
			case "CLICK":
				return new ClickEventFMessage();
			case "VIEW":
				return new ViewEventFMessage();
			default:
				throw new NullPointerException("未知事件:"+event);
			}
		default:throw new NullPointerException("没找到信息:"+type);
		}

	}

	public static String toMessage(TMessage message){
		XStream stream = new XStream();
		stream.alias("xml", message.getClass());
		stream.processAnnotations(message.getClass());
		return stream.toXML(message);
	}
}
