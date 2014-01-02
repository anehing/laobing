package com.zdqk.laobing.dao;


public interface UserLogDAO<UserLog> extends BasicDao<UserLog>{
	
	public abstract UserLog findObjectById(Long id);
	
}