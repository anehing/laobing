package com.zdqk.laobing.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.UrlDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.po.Url;




@Component("urlDAO")
public class UrlDAOImpl extends BasicDaoImpl<Url> implements UrlDAO<Url>{

	@Override
	public Url selectById(Map<String, Object> map) {
		// TODO Auto-generated method stub

    	Url u= new Url();
		List<Url> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(u.getClass().getName()+"."+"selectById",map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		u= null;
		if(list!=null && list.size()>0){ 
     	  u = list.get(0);
     }	
		
		return u;
	
	}

	
	
}