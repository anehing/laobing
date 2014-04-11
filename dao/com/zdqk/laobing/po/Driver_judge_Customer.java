package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("driver_judge_customer")	
public class Driver_judge_Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	@TODO("orderid")		
    private int orderid;
	@TODO("customertelphone")	
	private String customertelphone;	
	@TODO("drivertelphone")
	private String drivertelphone;	
	@TODO("judge")
    private int judge;
	@TODO("create_time")
    private Date create_time;
	@TODO("ordernum")		
    private String ordernum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustomertelphone() {
		return customertelphone;
	}
	public void setCustomertelphone(String customertelphone) {
		this.customertelphone = customertelphone;
	}
	public String getDrivertelphone() {
		return drivertelphone;
	}
	public void setDrivertelphone(String drivertelphone) {
		this.drivertelphone = drivertelphone;
	}
	public int getJudge() {
		return judge;
	}
	public void setJudge(int judge) {
		this.judge = judge;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
	
	
	
}