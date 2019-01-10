package org.shock.weixin.message.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VideoTMessage extends TMessage{

	private Video Video;

	public VideoTMessage() {
		super("video");
	}
	
}
