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


import com.zdqk.laobing.dao.Customer_orderDAO;
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Driver_order;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "customer_orderList", location = "/customer_orderList.jsp"),
		})

public class Customer_orderAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Customer_orderDAO customer_orderDAO;
	
	private Customer_order customer_order;
	
	
	
	
	 
	public Customer_order getCustomer_order() {
		return customer_order;
	}





	public void setCustomer_order(Customer_order customer_order) {
		this.customer_order = customer_order;
	}





	/**
	 * @author ane
	 *  查询订单信息
	 */
	@Action("querycustomer_order")
	public String queryCustomerorder() {
		Customer_order c = new Customer_order();
		Map<String, Object> map = this.getPmapNew();
		map.put("status", 0);
		List<Customer_order> list = publicQuery(map, c, customer_orderDAO); 
		return "customer_orderList";
	}
	
	
}
