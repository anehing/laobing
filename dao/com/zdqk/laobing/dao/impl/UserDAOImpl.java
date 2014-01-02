package com.zdqk.laobing.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.User;


@SuppressWarnings("unchecked")
@Component("userDAO")
public class UserDAOImpl extends BasicDaoImpl<User> implements UserDAO<User>{
	@SuppressWarnings("rawtypes")
	@Override
	public User findUserByUsernameOrMobileOrEmailAndPass(Map map,String hzm) {
		User  u= new User();
		List<User> list=(List<User>)getSqlMapClientTemplate().queryForList(u.getClass().getName()+"."+hzm,map);
		u= null;
		if(list!=null && list.size()>0){ 
        	  u = (User)list.get(0);
        }
		return u;
	}

	@Override
	public boolean checkUserNameIsExits(String userName) {
		try {
			User user = new User();
			Map map = new HashMap();
			map.put("userName", userName);
			List<User> list=(List<User>)getSqlMapClientTemplate().queryForList(user.getClass().getName()+".findByusername",map);
			if(list!=null && list.size()>0){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			System.out.println("�������ʧ�ܣ�������ݷ����Ƿ���");
			throw new RuntimeException(e.getMessage());
		}
	}
	
}