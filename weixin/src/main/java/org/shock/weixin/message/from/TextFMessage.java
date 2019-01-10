package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TextFMessage extends FMessage{
	/**文本消息内容*/
	private String Content;

	@Override
	public String toString() {
		return super.toString()+", Content=" + Content;
	}

}
