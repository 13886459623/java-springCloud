package com.ycb.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public   class  DateUtil {
	public static  String getTime(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(date);
		return   time;
	}

	public static  String getTime2(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String time = dateFormat.format(date);
		return   time;
	}
	public static  String getTime3(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		String time = dateFormat.format(date);
		return   time;
	}

}
