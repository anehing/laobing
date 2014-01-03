package com.zdqk.laobing.tools.ibatis;

import java.util.HashMap;
import java.util.Map;

import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.Coupon;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Permission;
import com.zdqk.laobing.po.Pre_price;
import com.zdqk.laobing.po.Price;
import com.zdqk.laobing.po.Tranrecord;
import com.zdqk.laobing.po.Twitter;
import com.zdqk.laobing.po.Url;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.po.Version;





public class PoMap {

	/**
	 * @param args
	 */
	public static Map<String,Object>  putObject()
	{
		Map<String,Object> hashmap=new HashMap<String,Object>();
		Dmb_city Dmb_city=new Dmb_city();
		hashmap.put("Dmb_city",Dmb_city);
        App_comment App_comment =new App_comment();
        hashmap.put("App_comment", App_comment);
        Coupon Coupon =new Coupon();
        hashmap.put("Coupon", Coupon);
        Customer_judge_driver Customer_judge_driver =new Customer_judge_driver();
        hashmap.put("Customer_judge_driver", Customer_judge_driver);
        Customer_order Customer_order = new Customer_order();
        hashmap.put("Customer_order", Customer_order);
        Driver Driver = new Driver();
        hashmap.put("Driver", Driver);
        Permission Permission =new Permission();
        hashmap.put("Permission", Permission);
        Pre_price Pre_price =new Pre_price();
        hashmap.put("Pre_price", Pre_price);
        Price Price =new Price();
        hashmap.put("Price", Price);
        Tranrecord Tranrecord =new Tranrecord();
        hashmap.put("Tranrecord", Tranrecord);
        Twitter Twitter =new Twitter();
        hashmap.put("Twitter", Twitter);
        Url Url=new Url();
        hashmap.put("Url", Url);
        User User =new User();
        hashmap.put("User", User);
        Version Version =new Version();
        hashmap.put("Version", Version);
		return hashmap; 
	}
}
