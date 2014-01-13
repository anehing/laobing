package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;



public interface Dmb_cityDAO<Dmb_city>  extends BasicDao<Dmb_city>{
	
	public List<Dmb_city> selectAllbyStatus(Map map,String hzm);
}