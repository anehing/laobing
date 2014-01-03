package com.zdqk.laobing.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


import com.zdqk.laobing.dao.CouponDAO;
import com.zdqk.laobing.po.Coupon;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "couponList", location = "/couponList.jsp"),
	       @Result(name = "updateUser", location = "/updateUser.jsp"),
	       @Result(name = "queryUser", type = "chain", location = "queryUser"),
	       @Result(name = "addUser", location = "/addUser.jsp"),
		})

public class CouponAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CouponDAO couponDAO;
	
	private Coupon coupon;
	
	 

	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}



	/**
	 * @author ane
	 *  查询优惠券
	 */
	@Action("queryCoupon")
	public String queryCoupon() {
		Coupon a = new Coupon();
		Map<String, Object> map = this.getPmapNew();
		if(this.coupon!=null){
			if(coupon.getCoupon_num()!=null&&!coupon.getCoupon_num().trim().equals("")) map.put("coupon_num", coupon.getCoupon_num());
			if(coupon.getCreate_time()!=null) map.put("create_time", coupon.getCreate_time());
			if(coupon.getDiscount_amount()!=0) map.put("discount_amount", coupon.getDiscount_amount());
			if(coupon.getIs_invitation_code()!=3) map.put("is_invitation_code", coupon.getIs_invitation_code());
			if(coupon.getIs_use()!=3) map.put("is_use", coupon.getIs_use());
			if(coupon.getTelphone()!=null) map.put("telphone", coupon.getTelphone());
			if(coupon.getUse_time()!=null) map.put("use_time", coupon.getUse_time());
			}
		List<Coupon> list = publicQuery(map, a, couponDAO); 
		return "couponList";
	}
	
}
