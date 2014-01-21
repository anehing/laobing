package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("user")	
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	
	@TODO("telphone")	
	private String telphone;	
	@TODO("self_code")
	private String self_code;	
	@TODO("use_code")	
    private String use_code;
	@TODO("logintime")
    private Date logintime;
	@TODO("use_time")
    private Date use_time;
	@TODO("askcode")	
    private String askcode;//邀请码
	@TODO("asktime")
    private int asktime;
	@TODO("isbind")
    private int isbind;//是否绑定优惠券1：是
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getSelf_code() {
		return self_code;
	}
	public void setSelf_code(String self_code) {
		this.self_code = self_code;
	}
	public String getUse_code() {
		return use_code;
	}
	public void setUse_code(String use_code) {
		this.use_code = use_code;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public Date getUse_time() {
		return use_time;
	}
	public void setUse_time(Date use_time) {
		this.use_time = use_time;
	}
	public String getAskcode() {
		return askcode;
	}
	public void setAskcode(String askcode) {
		this.askcode = askcode;
	}
	public int getAsktime() {
		return asktime;
	}
	public void setAsktime(int asktime) {
		this.asktime = asktime;
	}
	public int getIsbind() {
		return isbind;
	}
	public void setIsbind(int isbind) {
		this.isbind = isbind;
	}
	
	
}