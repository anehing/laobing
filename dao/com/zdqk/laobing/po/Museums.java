package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("museums")
public class Museums implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
	private Long id;
	@TODO("chinesename")
	private String chineseName;	
	@TODO("englishname")
	private String englishName;	
	@TODO("groupid")
	private Long groupId;	
	@TODO("groupname")
	private String groupName;
	@TODO("address")
	private String address;
	@TODO("note")
	private String note;
	@TODO("photourl")
	private String photoUrl;
	@TODO("status")
	private Long status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
}