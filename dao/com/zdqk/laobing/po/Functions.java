package com.zdqk.laobing.po;

import java.io.Serializable;


import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("functions")
public class Functions implements Serializable {
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
	private Long id;	
	@TODO("name")
	private String name;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	@TODO("note")
	private String note;
	@TODO("status")
	private Long status;
}
