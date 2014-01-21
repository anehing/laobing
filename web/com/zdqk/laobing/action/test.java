package com.zdqk.laobing.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.zdqk.laobing.po.Driver;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		
		String telphone="15122554903";
		long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
		System.out.println( new Date().getTime()); 

	}
	public String nDaysAfterOneDate(Date basicDate,int  n) { 
		SimpleDateFormat df = new SimpleDateFormat("yyddhhmmss"); 
        long nDay= (basicDate.getTime()+2*n*30*60*1000); 
        basicDate.setTime(nDay); 
        return   df.format(basicDate); 
    } 

}
