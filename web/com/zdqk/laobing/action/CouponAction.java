package com.zdqk.laobing.action;

import java.text.ParseException;
import java.util.Date;
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


import com.lfx.tools.DateConverter;
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
	       @Result(name = "addCoupon", location = "/addCoupon.jsp"),
	       @Result(name = "addCoupons", location = "/addCoupons.jsp"),
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
	
	private String use_time;
	private String create_time;
	private String touse_time;
	private String tocreate_time;
	private int num;
	 
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTouse_time() {
		return touse_time;
	}
	public void setTouse_time(String touse_time) {
		this.touse_time = touse_time;
	}
	public String getTocreate_time() {
		return tocreate_time;
	}
	public void setTocreate_time(String tocreate_time) {
		this.tocreate_time = tocreate_time;
	}
	public String getUse_time() {
		return use_time;
	}
	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}



	/**
	 * @author ane
	 *  查询优惠券
	 * @throws ParseException 
	 */
	@Action("queryCoupon")
	public String queryCoupon() throws ParseException {
		Coupon a = new Coupon();
		Map<String, Object> map = this.getPmapNew();
		if(this.coupon!=null){
			if(coupon.getCoupon_num()!=null&&!coupon.getCoupon_num().trim().equals("")) map.put("coupon_num", coupon.getCoupon_num());
			if(coupon.getDiscount_amount()!=0&&coupon.getDiscount_amount()!=0.0) map.put("discount_amount", coupon.getDiscount_amount());
			if(coupon.getIs_invitation_code()!=3) map.put("is_invitation_code", coupon.getIs_invitation_code());
			if(coupon.getIs_use()!=3) map.put("is_use", coupon.getIs_use());
			if(coupon.getTelphone()!=null) map.put("telphone", coupon.getTelphone());
			}
		if(this.create_time!=null&&!this.create_time.trim().equals("")&&this.tocreate_time!=null&&!this.create_time.equals("")){
			map.put("create_time", DateConverter.convertFromString(this.create_time));
			map.put("tocreate_time", DateConverter.convertFromString(this.tocreate_time));
		}
		if(this.use_time!=null&&!this.use_time.trim().equals("")&&this.touse_time!=null&&!this.touse_time.equals("")){
			map.put("use_time", DateConverter.convertFromString(this.use_time));
			map.put("touse_time", DateConverter.convertFromString(this.touse_time));
		}
		List<Coupon> list = publicQuery(map, a, couponDAO); 
		return "couponList";
	}
	/**
	 * @author ane
	 *  添加后台账户
	 */
	@Action("addCoupon")
	public String addCoupon() {
		if(this.coupon!=null){
			Object c= couponDAO.selectByNum(coupon.getCoupon_num());
			if(c!=null){
				this.addActionError("号码已存在");
				return "addCoupon";
			}
			this.coupon.setCreate_time(new Date());
			boolean  flag=couponDAO.insert(this.coupon);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addCoupon";
		
	}
	/**
	 * @author ane
	 *  添加后台账户
	 */
	@Action("addCoupons")
	public String addCoupons() {
		if(this.coupon!=null){
			long code = new Date().getTime();
			this.coupon.setCreate_time(new Date());
			if (this.num>0){
				for(int i=1;i<=num;i++){
					this.coupon.setCoupon_num(code+""+i);
					couponDAO.insert(this.coupon);
				}
				this.addActionMessage("新增成功");
			}else{
				this.addActionError("张数必须大于0");
			}
			
		    
			
		}
			
			return "addCoupons";
		
	}
	
}
