package org.shock.weixin.message.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
@XStreamAlias("Video")
public class Video extends Image{
	private String Title;
	private String Description;

}
