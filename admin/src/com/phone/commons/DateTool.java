package com.phone.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
	/**
     * ��ȡ��ǰ���������ڼ�
     * 
     * @param date
     * @return ��ǰ���������ڼ�
     */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
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
