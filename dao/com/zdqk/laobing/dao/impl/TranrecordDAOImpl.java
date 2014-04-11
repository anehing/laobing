package com.zdqk.laobing.dao.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.TranrecordDAO;
import com.zdqk.laobing.po.Coupon;
import com.zdqk.laobing.po.Driver_order;
import com.zdqk.laobing.po.Tranrecord;






@Component("tranrecordDAO")
public class TranrecordDAOImpl extends BasicDaoImpl<Tranrecord> implements TranrecordDAO<Tranrecord>{

	@Override
	public float selectmoney(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		Tranrecord t= new Tranrecord();
		   float selectallincome=0;
		try{
			
		Object selectallincome2=(Float) getSqlMapClientTemplate().queryForObject(t.getClass().getName()+"."+hzm,map);
				
			if(selectallincome2!=null){
				selectallincome=(Float) selectallincome2;
	        	
	        }
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}

		return selectallincome;
	}
	
	
}