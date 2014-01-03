package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("url")	
public class Url implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PK		
	@TODO("id")		
    private int id;
	@TODO("urlid")		
    private int urlid;
	@TODO("adminid")		
    private int adminid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUrlid() {
		return urlid;
	}
	public void setUrlid(int urlid) {
		this.urlid = urlid;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}


	
	
	
}