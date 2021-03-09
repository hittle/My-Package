package com.lzl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据格式转换
 */
public class Formatter {
    public static String toLongDateString(long date) {
    	if(date != 0) {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return df.format(date);
        }else
        	return null;
    }
    public static String toShortDateString(long date) {
    	if(date != 0) {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        return df.format(date);
        }else
        	return null;
    }
    public static String toShortTimeString(long date) {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        return df.format(date);
    }
    public static Long todayDateString() throws ParseException {
    	Date date = new Date();
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	String today = simpleDateFormat.format(date.getTime());
    	long daytime1 = simpleDateFormat.parse(today).getTime();
    	return daytime1;
    }
    public static Long todayNoonDate() throws Exception{
    	return todayDateString()+12*60*60*1000;
    }
    public static Long tomorrowNoonDate() throws Exception{
    	return todayDateString()+36*60*60*1000;
    }
    public static Long yesterdayNoonDate()throws Exception{
    	return todayDateString()-12*60*60*1000;
    }
    public static Long thisTimeString()throws ParseException{
    	
    	return System.currentTimeMillis();
    }
    public static Long tomorrowDateString() throws ParseException {
    	return todayDateString()+24*60*60*1000;
    }
    public static Long yesterdayDateString()throws Exception{
    	return todayDateString()-24*60*60*1000;
    }
    public static Long sevenDayFrontDateString()throws ParseException{
    	return todayDateString()-7*24*60*60*1000-12*3600*1000;
    }
    public static Long sevenDayAfterDateString()throws ParseException{
    	return todayDateString()+7*24*60*60*1000+12*3600*1000;
    }
    public static Long dateToStamp(String s) throws ParseException{
    	if(s!=null) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    	}else {
			return null;
		}
    }
    public static Long dateToLongStamp(String s) throws ParseException{
    	if(s!=null) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    	}else {
			return null;
		}
    }
    public static void main(String args[]) throws Exception {
//    	System.out.println(todayDateString());
//    	System.out.println(toLongDateString(1614312000000L));
//    	System.out.println(1614182400000L+12*3600*1000);
//    	System.out.println(todayNoonDate());
//    	System.out.println(toLongDateString(tomorrowDateString()));
//    	Long s = dateToLongStamp("2021-2-26 13:00:00");
//    	1614315600000
//    	System.out.println(s-1*3600*1000);
//    	System.out.println(toLongDateString(s-1));
    	System.out.println(thisTimeString());
    	System.out.println(toLongDateString(1614268800000L));
    	System.out.println(toLongDateString(1614312000000L));
//    	1614312000000
    	System.out.println(dateToLongStamp("2021-02-26 00:00:00"));
    	System.out.println(dateToLongStamp("2021-02-28 00:00:00"));
//    	System.out.println(toLongDateString(1614235688000L-3600*1000*10));
    }
}
