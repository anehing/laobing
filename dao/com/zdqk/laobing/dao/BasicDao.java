package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;

/**
 * @说明通用接口
 * @author lfx
 *
 * @param <T>
 */

public interface BasicDao<T> {
		
	public abstract boolean insert(T t);
	
	public abstract boolean update(T t);
	
	public abstract boolean delete(T t);
	
	public abstract List<T> findObjectsPage(Map<String,String> mapConditions,T t);
	
	public abstract Long findObjectsPageCount(Map<String,String> mapConditions,T t);
	
	public abstract T findObjectById(int long1,T t);	
	
	public abstract T findObjectNameById(int long1,T t);	
	
	public abstract List<T> findObjects(Map<String,String> mapConditions,T t);	
	
}
