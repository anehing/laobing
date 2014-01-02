package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("museums")
public class Versions implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
	private Long id;
	@TODO("name")
	private String name;
	@TODO("introduction")
	private String introduction;
    @TODO("publishdatetime")
    private Date publishdatetime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getPublishdatetime() {
		return publishdatetime;
	}
	public void setPublishdatetime(Date publishdatetime) {
		this.publishdatetime = publishdatetime;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	@TODO("publishdate")
    private Date publishdate;
	@TODO("status")
	private Long status;
	
}