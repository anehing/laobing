package com.zdqk.laobing.dao;

import java.util.Map;



public interface Driver_orderDAO<Driver_order>  extends BasicDao<Driver_order>{
	public float selectyesincome(Map<String, Object> map,String hzm);
	public float selectmonthincome(Map<String, Object> map,String hzm);
	public float selectallincome(Map<String, Object> map,String hzm);
	public Driver_order selectdriverorder(Map<String, Object> map, String hzm);
	
}