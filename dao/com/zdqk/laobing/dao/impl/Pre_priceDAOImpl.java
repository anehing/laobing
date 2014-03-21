package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.Pre_priceDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.po.Pre_price;




@Component("pre_priceDAO")
public class Pre_priceDAOImpl extends BasicDaoImpl<Pre_price> implements Pre_priceDAO<Pre_price>{
	
	@Override
	public Pre_price seletcbytel(Map<String, Object> map,String hzm) {
		   Pre_price p  = new Pre_price();
		   List<Pre_price> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(p.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		p= null;
		if(list!=null && list.size()>0){ 
        	  p = list.get(0);
        }	
		
		return p;
	}
}