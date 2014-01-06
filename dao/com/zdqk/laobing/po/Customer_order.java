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
    private Date start_time;
	@TODO("arrive_datetime")
    private Date arrive_datetime;
	@TODO("order_num")	
    private String order_num;
	@TODO("start_datetime")
    private Date start_datetime;
	@TODO("fee")
    private float fee;
	@TODO("driver_num")
    private int driver_num;
	@TODO("status")
    private int status;
	@TODO("create_time")
    private Date create_time;
	@TODO("note")
    private String note;
	
	
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
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getArrive_datetime() {
		return arrive_datetime;
	}
	public void setArrive_datetime(Date arrive_datetime) {
		this.arrive_datetime = arrive_datetime;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public Date getStart_datetime() {
		return start_datetime;
	}
	public void setStart_datetime(Date start_datetime) {
		this.start_datetime = start_datetime;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getDriver_num() {
		return driver_num;
	}
	public void setDriver_num(int driver_num) {
		this.driver_num = driver_num;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}