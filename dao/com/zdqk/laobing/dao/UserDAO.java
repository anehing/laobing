package com.zdqk.laobing.dao;

import java.util.Map;


public interface UserDAO<User>  extends BasicDao<User>{
	
	public User findUserByUsernameOrMobileOrEmailAndPass(Map map,String hzm);
	
	public boolean checkUserNameIsExits(String userName);
}