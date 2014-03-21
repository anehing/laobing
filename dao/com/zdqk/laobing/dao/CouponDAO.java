package com.zdqk.laobing.dao;

import java.util.Map;

import com.zdqk.laobing.po.Coupon;



public interface CouponDAO<Coupon>  extends BasicDao<Coupon>{
	
	public Coupon selectByNum(String coupon_num);

	public Coupon selectByuse();
}