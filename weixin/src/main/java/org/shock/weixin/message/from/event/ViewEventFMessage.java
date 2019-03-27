package org.shock.weixin.message.from.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ViewEventFMessage extends EventFMessage{
	private String EventKey;
	private String MenuId;

	@Override
	public String toString() {
		return super.toString()+", EventKey=" + EventKey;
	}

}
