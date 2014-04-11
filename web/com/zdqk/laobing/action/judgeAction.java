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
import com.zdqk.laobing.dao.App_commentDAO;
import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.dao.Driver_judge_CustomerDAO;
import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Driver_judge_Customer;
import com.zdqk.laobing.po.Twitter;
import com.zdqk.laobing.po.Version;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "driverjudgeList", location = "/driverjudgeList.jsp"),
	       @Result(name = "customejudgeList", location = "/customejudgeList.jsp"),
	       @Result(name = "customerjudgeDetail", location = "/customerjudgeDetail.jsp"),
		})

public class judgeAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Customer_judge_driverDAO customer_judge_driverDAO;
	@Autowired
	private Driver_judge_CustomerDAO driver_judge_customerDAO;
	
	private Customer_judge_driver customer_judge_driver;
	private Driver_judge_Customer driver_judge_customer;
	

	 private String createtime;
	 private String tocreatetime;

	
	
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getTocreatetime() {
		return tocreatetime;
	}

	public void setTocreatetime(String tocreatetime) {
		this.tocreatetime = tocreatetime;
	}

	public Customer_judge_driver getCustomer_judge_driver() {
		return customer_judge_driver;
	}

	public void setCustomer_judge_driver(Customer_judge_driver customer_judge_driver) {
		this.customer_judge_driver = customer_judge_driver;
	}

	public Driver_judge_Customer getDriver_judge_customer() {
		return driver_judge_customer;
	}

	public void setDriver_judge_customer(Driver_judge_Customer driver_judge_customer) {
		this.driver_judge_customer = driver_judge_customer;
	}

	/**
	 * @author ane
	 *  获取司机评价
	 * @throws ParseException 
	 */
	@Action("querydriverjudge")
	public String getdriverjudge() throws ParseException {
		Driver_judge_Customer d =new Driver_judge_Customer();
		Map<String, Object> map = this.getPmapNew();
		if(this.driver_judge_customer!=null){
			if(driver_judge_customer.getDrivertelphone()!=null&&!driver_judge_customer.getDrivertelphone().trim().equals("")){
				map.put("drivertelphone", driver_judge_customer.getDrivertelphone());
			}if(driver_judge_customer.getCustomertelphone()!=null&&!driver_judge_customer.getCustomertelphone().trim().equals("")){
				map.put("customertelphone", driver_judge_customer.getCustomertelphone());
			}
		 }
		List<Driver_judge_Customer> list = publicQuery(map, d, driver_judge_customerDAO); 
		return "driverjudgeList";
	}
	
	@Action("querycustomejudge")
	public String querycustomejudge() {

		Customer_judge_driver c =new Customer_judge_driver();
		Map<String, Object> map = this.getPmapNew();
		if(this.customer_judge_driver!=null){
			if(customer_judge_driver.getDrivertelphone()!=null&&!customer_judge_driver.getDrivertelphone().trim().equals("")){
				map.put("drivertelphone", customer_judge_driver.getDrivertelphone());
			}if(customer_judge_driver.getTelphone()!=null&&!customer_judge_driver.getTelphone().trim().equals("")){
				map.put("telphone", customer_judge_driver.getTelphone());
			}
		}
		List<Customer_judge_driver> list = publicQuery(map, c, customer_judge_driverDAO); 
		return "customejudgeList";
	
	}
	@Action("queryCustomer_judgebyId")
	public String queryCustomer_judgebyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Customer_judge_driver c =new Customer_judge_driver();
		this.customer_judge_driver = (Customer_judge_driver) customer_judge_driverDAO.findObjectById(id, c);
		if(customer_judge_driver.getContent()==null){
			customer_judge_driver.setContent("暂无评论");
		}
		if (totype == 1) {
			return "customerjudgeDetail";
		}
		return null;

	}
}
