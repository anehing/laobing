package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("photos")
public class Photos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4890148778432391116L;
	@PK
	@TODO("id")
	private Long id;	
	@TODO("photoname")
	private String photoName;
	@TODO("exhibitid")
	private Long exhibitId;
	@TODO("exhibitname")
	private String exhibitName;
	@TODO("photourl")
	private String photoUrl;
	@TODO("inputdatetime")
	private Date inputDateTime;
	@TODO("inputdate")
	private Date inputDate;	
	@TODO("priority")
	private Long priority;
	@TODO("status")
	private Long status;
	@TODO("type")
	private Long type;
	private Long museumId;

	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public Long getExhibitId() {
		return exhibitId;
	}
	public void setExhibitId(Long exhibitId) {
		this.exhibitId = exhibitId;
	}
	public String getExhibitName() {
		return exhibitName;
	}
	public void setExhibitName(String exhibitName) {
		this.exhibitName = exhibitName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Date getInputDateTime() {
		return inputDateTime;
	}
	public void setInputDateTime(Date inputDateTime) {
		this.inputDateTime = inputDateTime;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}	

}
