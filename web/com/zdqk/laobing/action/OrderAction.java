package com.zdqk.laobing.action;

import java.text.ParseException;
import java.util.HashMap;
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
import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.OrderDAO;
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Order2;
import com.zdqk.laobing.po.Price;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "orderList", location = "/orderList.jsp")
		})

public class OrderAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OrderDAO orderDAO;
	
	private Order2 order;
	private String customer_telphone;
	private String driver_telphone;
	private String create_time;
	private String tocreate_time;

	
	public Order2 getOrder() {
		return order;
	}
	public void setOrder(Order2 order) {
		this.order = order;
	}
	public String getCustomer_telphone() {
		return customer_telphone;
	}
	public void setCustomer_telphone(String customer_telphone) {
		this.customer_telphone = customer_telphone;
	}
	public String getDriver_telphone() {
		return driver_telphone;
	}
	public void setDriver_telphone(String driver_telphone) {
		this.driver_telphone = driver_telphone;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getTocreate_time() {
		return tocreate_time;
	}
	public void setTocreate_time(String tocreate_time) {
		this.tocreate_time = tocreate_time;
	}
	/**
	 * @author ane
	 *  后台查询记录
	 * @throws ParseException 
	 */
	@Action("queryorder")
	public String queryorder(){
		Order2 a = new Order2();
		Map<String, Object> map = this.getPmapNew();
		if(this.order!=null){
			if(this.order.getCustomer_telphone()!=null&&!this.order.getCustomer_telphone().equals("")){
				map.put("customer_telphone", this.order.getCustomer_telphone());
			}
			if(this.order.getDriver_telphone()!=null&&!this.order.getDriver_telphone().equals("")){
				map.put("driver_telphone", this.order.getDriver_telphone());
			}
		}
		
		List<Order2> list = publicQuery(map, a, orderDAO); 
		return "orderList";
	}
	
}
