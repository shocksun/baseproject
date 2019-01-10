package org.shock.weixin.message.to;

import org.shock.weixin.utils.MessageUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class TMessage {
	private String ToUserName;
	private String FromUserName;
	private Long CreateTime = System.currentTimeMillis();
	private String MsgType;
	
	protected TMessage(String msgType) {
		super();
		MsgType = msgType;
	}
	
	public String toMessage() {
		return MessageUtil.toMessage(this);
	}

}
