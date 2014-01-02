package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("videos")
public class Videos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")		
	private Long id;
	@TODO("name")		
	private String name;
	@TODO("exhibitid")
	private Long exhibitId;
	@TODO("exhibitname")
	private String exhibitName;	
	@TODO("videourl")
	private String videoUrl;	
	@TODO("inputdate")
	private Date inputDate;
	@TODO("inputdatetime")
	private Date inputDateTime;
	@TODO("status")
	private Long status;
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
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Date getInputDateTime() {
		return inputDateTime;
	}
	public void setInputDateTime(Date inputDateTime) {
		this.inputDateTime = inputDateTime;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}