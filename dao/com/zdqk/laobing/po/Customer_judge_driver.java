package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("customer_judge_driver")	
public class Customer_judge_driver implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	@TODO("orderid")		
    private int orderid;
	@TODO("driverid")		
    private int driverid;
	@TODO("score")		
    private int score;
	@TODO("telphone")	
	private String telphone;	
	@TODO("note")
	private String note;	

	@TODO("judge_time")
    private Date judge_time;

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

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getJudge_time() {
		return judge_time;
	}

	public void setJudge_time(Date judge_time) {
		this.judge_time = judge_time;
	}
	
	
}