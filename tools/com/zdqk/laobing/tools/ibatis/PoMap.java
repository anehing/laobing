package com.zdqk.laobing.tools.ibatis;

import java.util.HashMap;
import java.util.Map;

import com.zdqk.laobing.po.Driver_order;




public class PoMap {

	/**
	 * @param args
	 */
	public static Map<String,Object>  putObject()
	{
    	Map<String,Object> hashmap=new HashMap<String,Object>();
//		Dmb_city Dmb_city=new Dmb_city();
//		hashmap.put("Dmb_city",Dmb_city);
    	Driver_order Driver_order =new Driver_order();
        hashmap.put("Driver_order", Driver_order);
//        Customer_judge_driver Customer_judge_driver =new Customer_judge_driver();
//        hashmap.put("Customer_judge_driver", Customer_judge_driver);
//        Customer_order Customer_order = new Customer_order();
//        hashmap.put("Customer_order", Customer_order);
//        Driver Driver = new Driver();
//        hashmap.put("Driver", Driver);
//        Permission Permission =new Permission();
//        hashmap.put("Permission", Permission);
//        Pre_price Pre_price =new Pre_price();
//        hashmap.put("Pre_price", Pre_price);
//        Price Price =new Price();
//        hashmap.put("Price", Price);
//        Tranrecord Tranrecord =new Tranrecord();
//        hashmap.put("Tranrecord", Tranrecord);
//        Twitter Twitter =new Twitter();
//        hashmap.put("Twitter", Twitter);
//        Url Url=new Url();
//        hashmap.put("Url", Url);
//        User User =new User();
//        hashmap.put("User", User);
//        Version Version =new Version();
//        hashmap.put("Version", Version);
		return hashmap; 
	}
}
