package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ImageFMessage extends FMessage{
	/**图片链接*/
	private String PicUrl;
	/**媒体id*/
	private String MediaId;
	@Override
	public String toString() {
		return super.toString()+", PicUrl=" + PicUrl + ", MediaId=" + MediaId;
	}

}
