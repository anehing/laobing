package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("customer_order")	
public class Customer_order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("customer_telphone")	
	private String customer_telphone;	
	@TODO("start_place")
	private String start_place;	
	@TODO("start_time")
    private int start_time;
	@TODO("status")
    private int status;
	@TODO("driver")
    private int driver;//司机人数
	@TODO("create_time")
    private Date create_time;
	@TODO("latitude")	
	private double latitude;
	@TODO("longitude")	
	private double longitude;
	@TODO("return_time")
	private String return_time;	//返回客户端显示的出发时间
	@TODO("ordernum")
    private String ordernum;//订单号
	@TODO("source")
	private int source;
	@TODO("drivernum1")
	private String drivernum1;
	@TODO("drivernum2")
	private String drivernum2;
	@TODO("drivernum3")
	private String drivernum3;
	@TODO("drivernum4")
	private String drivernum4;
	@TODO("isvalue")
	private int isvalue;//是否评价
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_telphone() {
		return customer_telphone;
	}
	public void setCustomer_telphone(String customer_telphone) {
		this.customer_telphone = customer_telphone;
	}
	public String getStart_place() {
		return start_place;
	}
	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getDrivernum1() {
		return drivernum1;
	}
	public void setDrivernum1(String drivernum1) {
		this.drivernum1 = drivernum1;
	}
	public String getDrivernum2() {
		return drivernum2;
	}
	public void setDrivernum2(String drivernum2) {
		this.drivernum2 = drivernum2;
	}
	public String getDrivernum3() {
		return drivernum3;
	}
	public void setDrivernum3(String drivernum3) {
		this.drivernum3 = drivernum3;
	}
	public String getDrivernum4() {
		return drivernum4;
	}
	public void setDrivernum4(String drivernum4) {
		this.drivernum4 = drivernum4;
	}
	public int getIsvalue() {
		return isvalue;
	}
	public void setIsvalue(int isvalue) {
		this.isvalue = isvalue;
	}

	
	
	
	
}