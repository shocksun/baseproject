package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FMessage {
	/**开发者微信号*/
	private String ToUserName;
	/**发送者微信号*/
	private String FromUserName;
	/**创建时间*/
	private String CreateTime;
	/**消息类型*/
	private String MsgType;
	/**消息id*/
	private String MsgId;
	/**加密数据*/
	private String Encrypt;
	@Override
	public String toString() {
		return "ToUserName=" + ToUserName + ", FromUserName=" + FromUserName
				+ ", CreateTime=" + CreateTime + ", MsgType=" + MsgType
				+ ", MsgId=" + MsgId;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends FMessage> T getMessage() {
		return (T) this;
	}

}
