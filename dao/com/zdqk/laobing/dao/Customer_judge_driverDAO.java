package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;



public interface Customer_judge_driverDAO<Customer_judge_driver>  extends BasicDao<Customer_judge_driver>{
	
	public List<Customer_judge_driver> selectByDriverid(Map<String, Object> map,String hzm);
	
}