package com.xin.demo.Util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat df = new SimpleDateFormat();
    public static final String DATETIME    = "yyyy-MM-dd HH:mm:ss";
    public static final String DATENOTIME  = "yyyy-MM-dd";
    public static final String ONLYTIME    = "HH:mm:ss";
    public static Date getCurrentTime(){
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }
    public static Calendar date2Calendar(Date datetime){
        if(datetime==null)return null;
        Calendar c = Calendar.getInstance();
        c.setTime(datetime);
        return c;
    }
    public static Calendar sqldate2Calendar(java.sql.Date datetime){
        if(datetime==null)return null;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(datetime.getTime());
        return c;
    }
    public static String calendar2String(Calendar time){
        return date2String(time.getTime());
    }
    public static String date2String(Date time,String datepattern){
        setDatePattern(datepattern);
        try{
            return df.format(time);
        }catch(Exception e){
            return null;
        }
    }
    public static Calendar string2Calendar(String strtime){
        Date d = string2Date(strtime);
        if(d != null){
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c;
        }
        return null;
    }
    public static Date string2Date(String strtime){
        try{
            setDatePattern(null);
            return df.parse(strtime, new ParsePosition(0));
        }catch(Exception e){}
        return null;
    }
    public static Date string2Date(String strtime,String datepattern){
        try{
            setDatePattern(datepattern);
            return df.parse(strtime, new ParsePosition(0));
        }catch(Exception e){}
        return null;
    }
    public static String date2String(Date time){
        return date2String(time,null);
    }
    private static void setDatePattern(String datepattern){
        if (datepattern != null && datepattern.length() > 0) {
            df.applyPattern(datepattern);
        }else{
            df.applyPattern(DATETIME);
        }
    }
    
    public static String getCurrentYear(){
    	Calendar  cl = Calendar.getInstance();
    	int year = cl.get(Calendar.YEAR);
    	return String.valueOf(year);
    }
}
