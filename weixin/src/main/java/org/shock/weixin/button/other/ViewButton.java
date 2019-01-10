package org.shock.weixin.button.other;

import org.shock.weixin.button.ButtonBase;

import lombok.Getter;

/**
 * 网页类型
 * @author shock
 *
 */
@Getter
public class ViewButton extends ButtonBase{

	private String url;
	
	public ViewButton(String name,String url) {
		super(name, "view");
		this.url = url;
	}
	
}
