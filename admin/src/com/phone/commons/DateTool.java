package com.phone.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
	/**
     * 获取当前日期是星期几
     * 
     * @param date
     * @return 当前日期是星期几
     */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0){
			w = 0;
		}
		return weekDays[w];
	}
	
	public static String getFormatDate(Date date , String pattern){
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
}
