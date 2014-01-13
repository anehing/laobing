package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.TODO;


public class User extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userIdStr;
    private int id;
	private String telphone;	
	private String self_code;	
	private String use_code;
	private Date logintime;
	private Date use_time;
	private String askcode;//邀请码
    private int asktime;
	public String getUserIdStr() {
		return userIdStr;
	}
	public void setUserIdStr(String userIdStr) {
		this.userIdStr = userIdStr;
	}
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
	

}