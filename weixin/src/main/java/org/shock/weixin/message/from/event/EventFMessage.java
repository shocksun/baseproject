package org.shock.weixin.message.from.event;

import org.shock.weixin.message.from.FMessage;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class EventFMessage extends FMessage{
	/**事件类型*/
	private String Event;

	@Override
	public String toString() {
		return super.toString()+", Event=" + Event;
	}

}
