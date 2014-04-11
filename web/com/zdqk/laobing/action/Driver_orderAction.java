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


import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Driver_order;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "driverorderList", location = "/driverorderList.jsp"),
        	@Result(name = "driverorderdetail", location = "/driverorderdetail.jsp")
		})

public class Driver_orderAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Driver_orderDAO driver_orderDAO;
	
	private Driver_order driver_order;
	
	
	
	
	 
	public Driver_order getdriver_order() {
		return driver_order;
	}
	public void setdriver_order(Driver_order driver_order) {
		this.driver_order = driver_order;
	}
	/**
	 * @author ane
	 *  查询订单信息
	 */
	@Action("queryDriver_order")
	public String querydriver_order() {
		Driver_order a = new Driver_order();
		Map<String, Object> map = this.getPmapNew();
		map.put("status", 1);
		if(this.driver_order!=null){
			if(driver_order.getDrivertelphone()!=null&&!driver_order.getDrivertelphone().trim().equals("")){
				map.put("drivertelphone", driver_order.getDrivertelphone());
			}if(driver_order.getCustomertelphone()!=null&&!driver_order.getCustomertelphone().trim().equals("")){
				map.put("customertelphone", driver_order.getCustomertelphone());
			}
			}
		List<Driver_order> list = publicQuery(map, a, driver_orderDAO); 
		return "driverorderList";
	}
	/**
	 * @author ane
	 *  查询订单信息
	 */
	@Action("queryDriverorderId")
	public String queryDriverorderId() {
		Driver_order a = new Driver_order();
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
        this.driver_order = (Driver_order) driver_orderDAO.findObjectById(id, a);
		
		if (totype == 1) {
			return "driverorderdetail";
		}
		return null;
	}
	
}
