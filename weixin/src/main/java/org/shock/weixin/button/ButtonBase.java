package org.shock.weixin.button;

import lombok.Getter;

@Getter
public abstract class ButtonBase implements ButtonInterface {
	private String name;
	private String type;
	
	public ButtonBase(String name, String type) {
		this.name = name;
		this.type = type;
	}
}
