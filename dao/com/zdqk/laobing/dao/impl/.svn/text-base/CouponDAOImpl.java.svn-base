package com.zdqk.laobing.dao.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.CouponDAO;
import com.zdqk.laobing.po.Coupon;




@Component("couponDAO")
public class CouponDAOImpl extends BasicDaoImpl<Coupon> implements CouponDAO<Coupon>{

	@Override
	public Coupon selectByNum(String coupon_num) {
		// TODO Auto-generated method stub

		Coupon Coupon = new Coupon();
		Map<String,String> map = new HashMap<String,String>();
		map.put("coupon_num", coupon_num);
		List<Coupon> list=null;
		try {
			list=getSqlMapClientTemplate().queryForList(Coupon.getClass().getName()+".selectByNum",map);
			
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	
	}
	
	
}