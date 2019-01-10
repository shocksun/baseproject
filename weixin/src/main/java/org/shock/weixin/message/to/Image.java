package org.shock.weixin.message.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
@Data
@XStreamAlias("Image")
public class Image {
	private String MediaId;

	@Override
	public String toString() {
		return "MediaId=" + MediaId;
	}

}
