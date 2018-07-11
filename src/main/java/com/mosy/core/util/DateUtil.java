package com.mosy.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String DateFrom(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static Date getCurrentTime() {
		return new Date();
	}
}
