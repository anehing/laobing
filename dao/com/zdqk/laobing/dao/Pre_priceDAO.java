package com.zdqk.laobing.dao;

import java.util.Map;

import com.zdqk.laobing.po.Pre_price;



public interface Pre_priceDAO<Pre_price>  extends BasicDao<Pre_price>{

	public Pre_price seletcbytel(Map<String, Object> map, String hzm);
	
	
}