package com.zdqk.laobing.dao.impl;



import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.User;




@Component("userDAO")
public class UserDAOImpl extends BasicDaoImpl<User> implements UserDAO<User>{
	
	
}