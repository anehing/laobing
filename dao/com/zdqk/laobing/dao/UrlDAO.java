package com.zdqk.laobing.dao;

import java.util.Map;



public interface UrlDAO<Url>  extends BasicDao<Url>{
	
	public Url selectById(Map<String, Object> map);
}