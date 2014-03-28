package com.zdqk.laobing.action;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;
import com.zdqk.laobing.action.vo.ResultVo;
import com.zdqk.laobing.dao.CouponDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.Coupon;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.tools.FxJsonUtil;
/**
 * @author：lfx
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results( {
		@Result(name = "UserJsonList", location = "/WEB-INF/json/json.jsp"),
		})
public class JsonCouponAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private CouponDAO couponDAO;
	@Autowired
	private UserDAO<User> userDAO;	
	
    private String telphone;
    private String coupon_num;
    

	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(String coupon_num) {
		this.coupon_num = coupon_num;
	}



	/**
	 * 绑定优惠
	 * */
	@Action("bindCoupon")
	public String bindCouponAction(){
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.coupon_num==null||this.coupon_num.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:coupon_num");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Coupon coupon =	(Coupon) couponDAO.selectByNum(this.coupon_num);
		if(coupon==null){
			rv = new ResultVo(7,"无此优惠券");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			if(coupon.getTelphone()!=null){
				rv = new ResultVo(1,"此优惠券已被其他手机号绑定");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
			coupon.setTelphone(this.telphone);
			coupon.setUse_time(new Date());
			boolean flag= couponDAO.update(coupon);
			User use=new User();
			use.setTelphone(this.telphone);
			use.setIsbind(1);
			boolean flag2= userDAO.update(use);
			if(flag&&flag2){
				rv = new ResultVo(0,"绑定成功");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}else{
				rv = new ResultVo(1,"绑定失败，请稍后尝试");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
		}
   }
}