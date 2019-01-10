package org.shock.weixin.message.from.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClickEventFMessage extends EventFMessage{
	/**设置的跳转URL*/
	private String EventKey;

	@Override
	public String toString() {
		return super.toString()+", EventKey=" + EventKey;
	}


}
