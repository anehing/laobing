package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.Customer_orderDAO;
import com.zdqk.laobing.po.Customer_order;




@Component("customer_orderDAO")
public class Customer_orderDAOImpl extends BasicDaoImpl<Customer_order> implements Customer_orderDAO<Customer_order>{

	@Override
	public List selectByTel(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
	       Customer_order c= new Customer_order();
		   List<Customer_order> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(c.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){ 
			return list;
        }	
		
		return null;
	}
	
	
}