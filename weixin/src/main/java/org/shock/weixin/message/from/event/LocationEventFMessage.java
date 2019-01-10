package org.shock.weixin.message.from.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LocationEventFMessage extends EventFMessage{
	/**地理位置纬度*/
	private String Latitude;
	/**地理位置经度*/
	private String Longitude;
	/**地理位置精度*/
	private String Precision;
	@Override
	public String toString() {
		return super.toString()+", Latitude=" + Latitude + ", Longitude=" + Longitude
				+ ", Precision=" + Precision;
	}

}
