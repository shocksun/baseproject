package org.shock.weixin.message.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
@Data
@XStreamAlias("Music")
public class Music {
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;
	private String ThumbMediaId;

}
