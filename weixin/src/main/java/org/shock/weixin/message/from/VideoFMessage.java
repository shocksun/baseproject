package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VideoFMessage extends FMessage{
	/**媒体id*/
	private String MediaId;
	/**媒体缩略图id*/
	private String ThumbMediaId;
	@Override
	public String toString() {
		return super.toString()+", MediaId=" + MediaId + ", ThumbMediaId=" + ThumbMediaId;
	}

}
