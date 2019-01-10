package org.shock.weixin.message.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MusicTMessage extends TMessage{

	public MusicTMessage() {
		super("music");
	}

	private Music Music;

}
