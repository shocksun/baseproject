package org.shock.weixin.button.other;

import org.shock.weixin.button.ButtonBase;

import lombok.Getter;

/**
 * 小程序类按钮
 * @author shock
 *
 */
@Getter
public class MiniprogramButton extends ButtonBase{

	private String url;
	private String appid;
	private String pagepath;
	
	public MiniprogramButton(String name,String url,String appid,String pagepath) {
		super(name,"miniprogram");
		this.url=url;
		this.appid=appid;
		this.pagepath=pagepath;
	}
	
}
