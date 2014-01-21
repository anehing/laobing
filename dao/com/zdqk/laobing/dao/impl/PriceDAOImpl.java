package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Price;




@Component("priceDAO")
public class PriceDAOImpl extends BasicDaoImpl<Price> implements PriceDAO<Price>{

	@Override
	public List<Price> selectByCity(Map<String, Object> map, String hzm) {
		// TODO Auto-generated method stub
		List<Price> list=null;
		Price price= new Price();
      try{
			
			list=getSqlMapClientTemplate().queryForList(price.getClass().getName()+"."+hzm,map);
				
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
	
	
}