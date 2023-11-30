package com.onlinebanking.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	public int getRandom() {
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	public String systemDate() {
		Date date=new Date();
		String systemdate=date.toString();
		return systemdate;
	}
	public String systemDateFormat() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date=new Date();
		String systemDateFormat=dateformat.format(date);
		return systemDateFormat;
	}

}
