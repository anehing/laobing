package com.zdqk.laobing.dao;

import java.util.Map;

import com.zdqk.laobing.po.User;



public interface UserDAO<User>  extends BasicDao<User>{
	
	public User findUserByTelphone(Map map,String hzm) ;
	}