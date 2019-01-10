package org.shock.weixin.message.from.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**未关注的推送事件*/
@Data
@EqualsAndHashCode(callSuper=false)
public class SubscribeEventFMessage extends EventFMessage{
	/**事件KEY值，qrscene_为前缀，后面为二维码的参数值*/
	private String EventKey;
	/**二维码的ticket，可用来换取二维码图片*/
	private String Ticket;
	@Override
	public String toString() {
		return super.toString()+", EventKey=" + EventKey + ", Ticket=" + Ticket;
	}

}
