package com.zdqk.laobing.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * @说明：Struts2 Date类型转换器
 * @author lfx
 *
 */
public class DateConverter extends StrutsTypeConverter {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Date date = null;
		if (null == values[0] || "".equals(values[0])) {
			return null;
		} else if (!ValidateTools.checkDate(values[0])) {
			return null;
		}
		try {
			date = df.parse(values[0]);
			return date;
		} catch (ParseException e) {
			throw new TypeConversionException(); 
		}
	}
	public static Date convertFromString(String values, Class toClass) {
		Date date = null;
		try {
			date = df.parse(values);
			return date;
		} catch (ParseException e) {
			throw new TypeConversionException(); 
		}
	}

	@Override
	public String convertToString(Map context, Object o) {
		Date date = (Date)o;
		if (null != date) {
			return df.format(date);
		} else {
			return "";
		}
	}
  	public static String toDateString()
	{  		
	   Date date=new Date();
	   String dateformat="yyyy-MM-dd HH:mm:ss";
	  
	   SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
	   
	   String str=sdf.format(date); 
		StringBuilder sb = new StringBuilder(); 
		char c1 = ' '; 
		char c2 = ':';
		char c3 = '-';
		for(int i = 0 ; i < str.length() ; i++){ 
			char ch = str.charAt(i); 
			if(ch != c1 && ch!=c2 && ch!=c3){ 
				sb.append(ch); 
			} 
		} 
		return sb.toString(); 
	}
	public static String toDateString(Date date)
  	{  		
        return date.toLocaleString();
  	}
  	/**
	 * 产生keyId
	 * return String
	 */	  	
  	public static String generateKeyId(String key)
  	{  		
  		if(!key.equals("") && key!=null){
  			key=key+toDateString()+getRandomDigit();
  		}else{
  			key=toDateString()+getRandomDigit();
  		}
  		return key;
  	}
  	/**
	 * 产生随机数
	 * return String
	 */	
	public static String getRandomDigit()
	{
		Random rd1 = new Random();
		String str=rd1.nextInt()+"";
		StringBuilder sb = new StringBuilder(); 
		char ch1= '-';
		for(int i = 0 ; i < 4 ; i++){ 
			char ch = str.charAt(i); 
			if(ch != ch1){ 
				sb.append(ch); 
			} 
		} 
		return sb.toString(); 
	}		
	public static Date convertFromString(String StringDate) throws ParseException{
		Date date = null;
		if(StringDate==null || StringDate.equals(""))
		{
			date=new Date();
			return date;
		}
		date = java.sql.Date.valueOf(StringDate);
		return date;
	}  	
	public static void main(String[] args){
		try {
			System.out.println(getAgeFromBirthday(convertFromString("2013-7-24")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	

	} 
	/**
	 * 传入今天日期
	 * @param date
	 * @return 返回本日所在周的开始日期 结束日期
	 */
	public static Map<String,String> getbeginDateAndendDate(Date date)
	{
		Map<String,String> datemap = new HashMap<String, String>();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		
		 int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		 cal.add(Calendar.DATE, -day_of_week);
	
		 datemap.put("beginDate", ff.format(cal.getTime()));
		 System.out.println(ff.format(cal.getTime()));
		 cal.add(Calendar.DATE, 6);
		 System.out.println(ff.format(cal.getTime()));
		 datemap.put("endDate", ff.format(cal.getTime()));
		 
		 return datemap;
	}	
	/**
	 * 传入出生日期
	 * @param date
	 * @return 返回年龄
	 */
	public static String getAgeFromBirthday(Date bitrhday)
	{
		String age = null;
		Date nowDate = new Date();
		try {
			if(!checkDateRange(bitrhday, nowDate)){
				return age;
			}
		} catch (Exception e) {
			return age;
		}			
		Long  st= bitrhday.getTime();
		Long  dt= nowDate.getTime();
		Long  ds =0L;
		ds = dt - st;
		
		ds = ds / (1000 * 60 * 60 * 24);	
		ds = ds / 365;
		age = ds + "";
		 return age;
	}	
	public static boolean checkDateRange(Date beginDate, Date endDate) {
		if (beginDate.compareTo(endDate) == -1 || beginDate.compareTo(endDate) == 0) {
			return true;
		} else {
			return false;
		}
	}	
}
