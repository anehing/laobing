package com.zdqk.laobing.po;

import java.io.Serializable;


import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("functions")
public class UserFunction implements Serializable {
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
	private Long id;
	@TODO("userid")
	private Long userid;
	@TODO("username")
	private String username;
	@TODO("functionid")
	private Long functionid;
	@TODO("name")
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getFunctionid() {
		return functionid;
	}
	public void setFunctionid(Long functionid) {
		this.functionid = functionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
