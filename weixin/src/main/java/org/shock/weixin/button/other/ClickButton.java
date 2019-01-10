package org.shock.weixin.button.other;

import org.shock.weixin.button.ButtonBase;

import lombok.Getter;

/**
 * 点击类按钮
 * @author shock
 *
 */
@Getter
public class ClickButton extends ButtonBase{

	private String key;
	
	public ClickButton(String name,String key) {
		super(name,"click");
		this.key=key;
	}
	protected ClickButton(String name,String key,String type) {
		super(name,type);
		this.key=key;
	}
	
}
