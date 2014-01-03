package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("tranrecord")	
public class Tranrecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("driverid")	
	private int driverid;	
	@TODO("orderid")	
	private int orderid;
	@TODO("type")	
	private int type;
	@TODO("trans_datetime")
    private Date trans_datetime;
	@TODO("account")
    private float account;
	@TODO("note")
	private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getTrans_datetime() {
		return trans_datetime;
	}
	public void setTrans_datetime(Date trans_datetime) {
		this.trans_datetime = trans_datetime;
	}
	public float getAccount() {
		return account;
	}
	public void setAccount(float account) {
		this.account = account;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}	
	
	
	
	
	
	
}