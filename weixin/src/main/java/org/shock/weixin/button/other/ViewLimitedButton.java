package org.shock.weixin.button.other;

import lombok.Getter;

/**
 * 图文消息
 * @author shock
 *
 */
@Getter
public class ViewLimitedButton extends MediaIdButton{

	public ViewLimitedButton(String name,String media_id) {
		super(name,"view_limited",media_id);
	}
	
}
