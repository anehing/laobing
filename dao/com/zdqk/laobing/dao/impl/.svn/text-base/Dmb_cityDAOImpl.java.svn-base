package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.po.Dmb_city;





@Component("dmb_cityDAO")
public class Dmb_cityDAOImpl extends BasicDaoImpl<Dmb_city> implements Dmb_cityDAO<Dmb_city>{

	@Override
	public List<Dmb_city> selectAllbyStatus(Map map,String hzm) {
		// TODO Auto-generated method stub
		List<Dmb_city> list=null;
		Dmb_city dmb_city= new Dmb_city();
      try{
			
			list=getSqlMapClientTemplate().queryForList(dmb_city.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
	
	
}