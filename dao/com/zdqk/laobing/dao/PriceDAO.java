package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;

import com.zdqk.laobing.po.Price;



public interface PriceDAO<Price>  extends BasicDao<Price>{
	
	public List<Price> selectByCity(Map<String, Object> map,String hzm);
}