package org.shock.weixin.button;

import java.util.ArrayList;
import java.util.List;

/**
 * 按钮基类
 * @author shock
 *
 */
public class Button {
	private List<ButtonInterface> button=new ArrayList<ButtonInterface>();
	public void addButton(ButtonInterface btn) {
		if(button.size()<3) {
			button.add(btn);
		}
	}
	public ButtonInterface[] getButton() {
		return button.toArray(new ButtonInterface[0]);
	}
}
