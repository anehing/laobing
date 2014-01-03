package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("coupon")	
public class Coupon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("coupon_num")	
	private String coupon_num;	
	@TODO("telphone")
	private String telphone;
	@TODO("is_use")		
    private int is_use;
	@TODO("discount_amount")		
    private float discount_amount;
	@TODO("use_time")		
    private Date use_time;
	@TODO("is_invitation_code")		
    private int is_invitation_code;
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
	public String getCoupon_num() {
		return coupon_num;
	}
	public void setCoupon_num(String coupon_num) {
		this.coupon_num = coupon_num;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getIs_use() {
		return is_use;
	}
	public void setIs_use(int is_use) {
		this.is_use = is_use;
	}
	public float getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(float discount_amount) {
		this.discount_amount = discount_amount;
	}
	public Date getUse_time() {
		return use_time;
	}
	public void setUse_time(Date use_time) {
		this.use_time = use_time;
	}
	public int getIs_invitation_code() {
		return is_invitation_code;
	}
	public void setIs_invitation_code(int is_invitation_code) {
		this.is_invitation_code = is_invitation_code;
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