package org.shock.weixin.message.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ImageTMessage extends TMessage{

	private Image Image;

	public ImageTMessage() {
		super("image");
	}

}
