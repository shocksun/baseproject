package org.shock.weixin.button;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 *  二级菜单
 * @author shock
 *
 */
@Getter
public class SubButton implements ButtonInterface{
	private String name;
	public SubButton(String name) {
		super();
		this.name = name;
	}
	private List<ButtonBase> sub_button = new ArrayList<ButtonBase>();
	public void addSubButton(ButtonBase buttonBase) {
		if(sub_button.size()<5) {
			sub_button.add(buttonBase);
		}
	}
	public ButtonBase[] getSub_button() {
		return sub_button.toArray(new ButtonBase[0]);
	}
	
}
