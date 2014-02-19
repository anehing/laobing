package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.User;




@Component("userDAO")
public class UserDAOImpl extends BasicDaoImpl<User> implements UserDAO<User>{
	
	public User findUserByTelphone(Map map,String hzm) {
		User  u= new User();
		List<User> list=(List<User>)getSqlMapClientTemplate().queryForList(u.getClass().getName()+"."+hzm,map);
		u= null;
		if(list!=null && list.size()>0){ 
        	  u = (User)list.get(0);
        }
		return u;
	}

}