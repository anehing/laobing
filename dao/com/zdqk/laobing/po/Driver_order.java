package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("customer_order")	
public class Driver_order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("customer_order_id")		
    private int customer_order_id;
	@TODO("driver_id")		
    private int driver_id;
	@TODO("telphone")	
	private String telphone;
	@TODO("order_status")
    private int order_status;
	@TODO("create_time")
    private Date create_time;
	@TODO("start_place")
	private String start_place;	
	@TODO("end_place")
	private String end_place;	
	@TODO("distance")	
    private String distance;
	@TODO("wait_start")
    private Date wait_start;
	@TODO("wait_end")
    private Date wait_end;
	@TODO("call_time")
    private Date call_time;
	@TODO("price")
    private float price;
	@TODO("driver_card")
    private int driver_card;
	@TODO("source")
    private String source;
	@TODO("judge")		
    private int judge;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_order_id() {
		return customer_order_id;
	}
	public void setCustomer_order_id(int customer_order_id) {
		this.customer_order_id = customer_order_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getStart_place() {
		return start_place;
	}
	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}
	public String getEnd_place() {
		return end_place;
	}
	public void setEnd_place(String end_place) {
		this.end_place = end_place;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public Date getWait_start() {
		return wait_start;
	}
	public void setWait_start(Date wait_start) {
		this.wait_start = wait_start;
	}
	public Date getWait_end() {
		return wait_end;
	}
	public void setWait_end(Date wait_end) {
		this.wait_end = wait_end;
	}
	public Date getCall_time() {
		return call_time;
	}
	public void setCall_time(Date call_time) {
		this.call_time = call_time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getDriver_card() {
		return driver_card;
	}
	public void setDriver_card(int driver_card) {
		this.driver_card = driver_card;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	
	
}