package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("app_comment")	
public class App_comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@PK		
	@TODO("id")		
    private int id;
	@TODO("type")		
    private int type;//0:用户，1司机
	@TODO("comment")	
	private String comment;	
	@TODO("telphone")
	private String telphone;
	@TODO("createtime")		
    private Date createtime;
	@TODO("email")		
    private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
	
}