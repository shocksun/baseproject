package org.shock.weixin.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	public static int subTime(Date date1, Date date2) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date1);
		int t1 = aCalendar.get(Calendar.SECOND);
		aCalendar.setTime(date2);
		int t2 = aCalendar.get(Calendar.SECOND);
		return t1-t2;
	}

}
