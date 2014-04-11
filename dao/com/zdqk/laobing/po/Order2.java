package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("order2")	
public class Order2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("customer_telphone")	
	private String customer_telphone;	
	@TODO("create_time")
    private Date create_time;
	@TODO("driver_telphone")
	private String driver_telphone;
	
	public String getCustomer_telphone() {
		return customer_telphone;
	}
	public void setCustomer_telphone(String customer_telphone) {
		this.customer_telphone = customer_telphone;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getDriver_telphone() {
		return driver_telphone;
	}
	public void setDriver_telphone(String driver_telphone) {
		this.driver_telphone = driver_telphone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}