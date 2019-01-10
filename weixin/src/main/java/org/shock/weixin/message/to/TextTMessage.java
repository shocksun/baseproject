package org.shock.weixin.message.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TextTMessage extends TMessage{

	public TextTMessage() {
		super("text");
	}

	private String Content;

}
