package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LinkFMessage extends FMessage{
	/**消息标题*/
	private String Title;
	/**消息描述*/
	private String Description;
	/**消息链接*/
	private String Url;
	@Override
	public String toString() {
		return super.toString()+", Title=" + Title + ", Description=" + Description + ", Url="
				+ Url;
	}

}
