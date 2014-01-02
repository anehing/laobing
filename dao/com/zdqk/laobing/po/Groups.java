package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("groups")
public class Groups implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
    private Long id;
	@TODO("groupname")
    private String groupName;
	@TODO("grouptype")
    private Long groupType;
	@TODO("status")
	private Long status;
	@TODO("note")
    private String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getGroupType() {
		return groupType;
	}
	public void setGroupType(Long groupType) {
		this.groupType = groupType;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}


}