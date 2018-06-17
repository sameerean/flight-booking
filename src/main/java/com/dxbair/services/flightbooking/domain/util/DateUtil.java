package com.dxbair.services.flightbooking.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static final DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public static LocalDateTime toLocalDateTime(String strDate) {
		return LocalDateTime.parse(strDate, GlobalDateFormatter);
	}
	
}
