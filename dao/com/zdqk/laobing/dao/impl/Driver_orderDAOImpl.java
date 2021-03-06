package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Driver_order;




@Component("driver_orderDAO")
public class Driver_orderDAOImpl extends BasicDaoImpl<Driver_order> implements Driver_orderDAO<Driver_order>{

	@Override
	public float selectyesincome(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		Driver_order d= new Driver_order();
		   float selectyesincome=0;
		try{
			
			Object selectyesincome2=getSqlMapClientTemplate().queryForObject(d.getClass().getName()+"."+"selectyesincome",map);
			if(selectyesincome2!=null){
	        	selectyesincome=(Float) selectyesincome2;
	        	
	        }
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		return selectyesincome;
		
	}

	@Override
	public float selectmonthincome(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		Driver_order d= new Driver_order();
		   float selectmonthincome=0;
		try{
			
			Object selectmonthincome2=(Float) getSqlMapClientTemplate().queryForObject(d.getClass().getName()+"."+"selectmonthincome",map);
				
			if(selectmonthincome2!=null){
				selectmonthincome=(Float) selectmonthincome2;
	        	
	        }
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}

		return selectmonthincome;
	}

	@Override
	public float selectallincome(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		Driver_order d= new Driver_order();
		   float selectallincome=0;
		try{
			
		Object selectallincome2=(Float) getSqlMapClientTemplate().queryForObject(d.getClass().getName()+"."+"selectallincome",map);
				
			if(selectallincome2!=null){
				selectallincome=(Float) selectallincome2;
	        	
	        }
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}

		return selectallincome;
	}
	@Override
	public Driver_order selectdriverorder(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		   Driver_order d= new Driver_order();
		   List<Driver_order> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(d.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){ 
			return list.get(0);
        }	
		
		return null;
		
	}
	
}