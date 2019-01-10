package org.shock.weixin.message.from;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LocationFMessage extends FMessage{
	/**地理位置维度*/
	private String Location_X;
	/**地理位置经度*/
	private String Location_Y;
	/**地图缩放大小*/
	private String Scale;
	/**地理位置信息*/
	private String Label;
	@Override
	public String toString() {
		return super.toString()+", Location_X=" + Location_X + ", Location_Y=" + Location_Y
				+ ", Scale=" + Scale + ", Label=" + Label;
	}
}
