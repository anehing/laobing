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
import com.zdqk.laobing.po.Driver_order;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "driver_orderList", location = "/driver_orderList.jsp"),
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
		if(this.driver_order!=null){
			
			}
		List<Driver_order> list = publicQuery(map, a, driver_orderDAO); 
		return "driver_orderList";
	}
	
	
}
