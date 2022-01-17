package com.offcn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//����ת�ַ���
	public static String dateToString(Date dt) {
		return sdf.format(dt);
	}
	//�ַ���ת����
	public static Date  stringToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
