package org.shock.weixin.button.other;

import lombok.Getter;

/**
 * 位置选择类按钮
 * @author shock
 *
 */
@Getter
public class LocationSelectButton extends ClickButton{

	public LocationSelectButton(String name,String key) {
		super(name,"location_select");
	}
	
}
