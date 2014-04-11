package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;



public interface TranrecordDAO<Tranrecord>  extends BasicDao<Tranrecord>{
	
	public float selectmoney(Map<String, Object> map,String hzm);
}