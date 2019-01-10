package org.shock.weixin.message.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
@Data
@XStreamAlias("item")
public class Item {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;

}
