package org.shock.weixin.button.other;

import lombok.Getter;

/**
 * 图片类按钮
 * @author shock
 *
 */
@Getter
public class MediaIdButton extends ClickButton{

	private String media_id;
	
	public MediaIdButton(String name,String media_id) {
		super(name,"location_select");
		this.media_id=media_id;
	}
	public MediaIdButton(String name,String type,String media_id) {
		super(name,type);
		this.media_id=media_id;
	}
	
}
