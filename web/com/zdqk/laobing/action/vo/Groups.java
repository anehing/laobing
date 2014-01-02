package com.zdqk.laobing.action.vo;

import java.io.Serializable;


public class Groups implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long groupId;
    private String groupName;
    private Long groupType;
	
	public Groups(Long groupId, String groupName, Long groupType) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupType = groupType;
	}
	public Groups() {
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
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}