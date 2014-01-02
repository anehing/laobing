package com.zdqk.laobing.dao.impl;


import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.UserLogDAO;
import com.zdqk.laobing.po.UserLog;

@Component("userLogDAO")

public class UserLogDAOImpl extends BasicDaoImpl<UserLog> implements UserLogDAO<UserLog> {

	@Override
	public UserLog findObjectById(Long id) {
		try {
			return (UserLog)getSqlMapClientTemplate().queryForObject(getClass().getName()+".findById",id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

}