package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("price")	
public class Price implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PK		
	@TODO("id")		
    private int id;
	@TODO("cityid")		
    private int cityid;
	@TODO("time")		
    private String time;
	@TODO("price")		
    private float price;
	@TODO("note")		
    private String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}