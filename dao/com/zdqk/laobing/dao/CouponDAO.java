package com.zdqk.laobing.dao;



public interface CouponDAO<Coupon>  extends BasicDao<Coupon>{
	
	public Coupon selectByNum(String coupon_num);
}