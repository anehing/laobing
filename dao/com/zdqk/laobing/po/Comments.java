package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("comments")
public class Comments implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")	
	private Long id;
	@TODO("userid")	
	private Long userId;
	@TODO("username")
	private String userName;
	@TODO("userphotourl")
	private String userPhotoUrl;
	@TODO("exhibitid")
	private Long exhibitId;
	@TODO("exhibitname")
	private String exhibitName;	
	@TODO("content")
	private String content;	
	@TODO("inputdate")
	private Date inputDate;
	@TODO("inputdatetime")
	private Date inputDateTime;
	@TODO("status")
	private Long status;
	private String inputDateTimeStr;
	public String getInputDateTimeStr() {
		return inputDateTimeStr;
	}
	public void setInputDateTimeStr(String inputDateTimeStr) {
		this.inputDateTimeStr = inputDateTimeStr;
	}
	public Comments(Long exhibitId, String exhibitName, String content) {
		super();
		this.exhibitId = exhibitId;
		this.exhibitName = exhibitName;
		this.content = content;
		this.status = 1L;
		Date date = new Date();
		this.setInputDate(date);
		this.setInputDateTime(date);
	}
	public Comments() {

	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}
	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
