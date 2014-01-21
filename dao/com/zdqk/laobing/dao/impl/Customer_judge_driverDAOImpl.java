package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.po.Customer_judge_driver;




@Component("customer_judge_driverDAO")
public class Customer_judge_driverDAOImpl extends BasicDaoImpl<Customer_judge_driver> implements Customer_judge_driverDAO<Customer_judge_driver>{

	@Override
	public List<Customer_judge_driver> selectByDriverid(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		List<Customer_judge_driver> list=null;
		Customer_judge_driver c= new Customer_judge_driver();
      try{
			
			list=getSqlMapClientTemplate().queryForList(c.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
	
	
}