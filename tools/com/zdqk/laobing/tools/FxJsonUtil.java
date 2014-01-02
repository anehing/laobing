package com.zdqk.laobing.tools;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.http.HttpServletRequest;

public class FxJsonUtil {

	public static String jsonHandle(Object object,String url,HttpServletRequest request) {
		JSONObject json = JSONObject.fromObject(object);  
		System.out.println(json.toString());  		
		request.setAttribute("jsondata", json.toString());
		return url;	
	}	
	public static String jsonListHandle(Object object,String url,HttpServletRequest request) {
		JSON json = JSONSerializer.toJSON(object);  
		System.out.println(json.toString());  		
		request.setAttribute("jsondata", json.toString());
		return url;	
	}		
}
