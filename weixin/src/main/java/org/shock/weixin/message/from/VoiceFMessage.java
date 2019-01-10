package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VoiceFMessage extends FMessage{
	/**媒体id*/
	private String MediaId;
	/**语言格式*/
	private String Format;
	/**翻译*/
	private String Recognition;
	@Override
	public String toString() {
		return super.toString()+", MediaId=" + MediaId + ", Format=" + Format + ", Recognition="
				+ Recognition;
	}

}
