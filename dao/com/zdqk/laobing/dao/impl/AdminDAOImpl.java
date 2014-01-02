package com.zdqk.laobing.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.AdminDAO;
import com.zdqk.laobing.po.Admin;




@Component("adminDAO")
public class AdminDAOImpl extends BasicDaoImpl<Admin> implements AdminDAO<Admin>{
	
	@Override
	public Admin findAdminByUsernameAndPassword(Map<String, Object> map,String hzm) {
		   Admin admin= new Admin();
		   List<Admin> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(admin.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		admin= null;
		if(list!=null && list.size()>0){ 
        	  admin = list.get(0);
        }	
		
		return admin;
	}

	@Override
	public boolean checkUserNameIsExits(String username) {
		Admin admin = new Admin();
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		List<Admin> list=null;
		try {
			list=getSqlMapClientTemplate().queryForList(admin.getClass().getName()+".findByusername",map);
			
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){
			return false;
		}else{
			return true;
		}
	}
}