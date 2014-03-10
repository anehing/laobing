package com.zdqk.laobing.action;

import java.text.ParseException;
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
import com.zdqk.laobing.dao.Customer_orderDAO;
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.po.Admin;
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
	       @Result(name = "updateCustomer_order", location = "/updateCustomer_order.jsp"),
	       @Result(name = "queryCustomer_order", type = "chain", location = "querycustomer_order"),
		})

public class Customer_orderAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Customer_orderDAO customer_orderDAO;
	
	private Customer_order customer_order;
	
	
	private String create_time;
	private String tocreate_time;
    
    

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
	public Customer_order getCustomer_order() {
		return customer_order;
	}
	public void setCustomer_order(Customer_order customer_order) {
		this.customer_order = customer_order;
	}


	/**
	 * @author ane
	 *  查询订单信息
	 * @throws ParseException 
	 */
	@Action("querycustomer_order")
	public String queryCustomerorder() throws ParseException {
		Customer_order c = new Customer_order();
		Map<String, Object> map = this.getPmapNew();
		if(this.customer_order!=null){
			if(this.customer_order.getStatus()!=4) {map.put("status", customer_order.getStatus());}
		}
		if(this.create_time!=null&&!this.create_time.trim().equals("")&&this.tocreate_time!=null&&!this.tocreate_time.trim().equals("")){
			map.put("create_time", DateConverter.convertFromString(this.create_time));
			map.put("tocreate_time", DateConverter.convertFromString(this.tocreate_time));
		}
		List<Customer_order> list = publicQuery(map, c, customer_orderDAO); 
		return "customer_orderList";
	}
	
	@Action("queryCustomer_orderbyId")
	public String queryCustomer_orderbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Customer_order c=new Customer_order();
		this.customer_order = (Customer_order) customer_orderDAO.findObjectById(id, c);
		
		if (totype == 1) return "updateCustomer_order";
		if (totype == 2) {
			boolean flag;
		    flag=customer_orderDAO.delete(this.customer_order);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    this.customer_order=null;
		    return "queryCustomer_order";
		}		
		return null;
	}
	
	@Action("updateCustomer_order")
	public String updateCustomer_order() {
		if(this.customer_order!=null){
			boolean  flag=customer_orderDAO.update(this.customer_order);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateCustomer_order";
	}
}
