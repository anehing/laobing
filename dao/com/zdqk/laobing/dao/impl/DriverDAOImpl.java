package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.po.Driver;





@Component("driverDAO")
public class DriverDAOImpl extends BasicDaoImpl<Driver> implements DriverDAO<Driver>{

	@Override
	public List<Driver> selectByjobstatus(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		
		List<Driver> list=null;
		Driver driver= new Driver();
      try{
			
			list=getSqlMapClientTemplate().queryForList(driver.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public Driver loginByNameAndTel(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		List<Driver> list=null;
		Driver driver= new Driver();
		 try{
				list=getSqlMapClientTemplate().queryForList(driver.getClass().getName()+"."+hzm,map);
			}catch(Exception e){
				System.out.println("数据连接失败，请检查数据服务是否开启");
				throw new RuntimeException(e.getMessage());
			}
		 if(list!=null&&list.size()>0){
			 return list.get(0);
		 }
		 return null;
	}
	
}