package org.shock.weixin.message.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VoiceTMessage extends TMessage{

	private Voice Voice;
	
	public VoiceTMessage() {
		super("voice");
	}

}
