package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;


import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("collections")
public class Collections implements Serializable{
//	select C.ID ID,U.ID USERID,U.USERNAME USERNAME,U.PHOTOURL USERPHOTOURL,E.ID EXHIBITID,E.CHINESENAME EXHIBITNAME,C.INPUTDATE INPUTDATE,C.INPUTDATETIME INPUTDATETIME,C.STATUS STATUS 
//	from COLLECTIONS C JOIN USERS U ON C.USERID = U.ID JOIN EXHIBITS E ON E.ID = C.EXHIBITID AND U.USERNAME='lfx' and E.CHINESENAME='ff';
// select count(1) from COLLECTIONS C JOIN USERS U ON C.USERID = U.ID JOIN EXHIBITS E ON E.ID = C.EXHIBITID AND U.USERNAME='lfx' and E.CHINESENAME='ff';
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
	@TODO("exhibitphotourl")
	private String exhibitPhotoUrl;		
	@TODO("inputdate")
	private Date inputDate;
	@TODO("inputdatetime")
	private Date inputDateTime;
	@TODO("status")
	private Long status;
	@TODO("exhibitEnglishName")	
	private String englishName;	
	@TODO("note")		
	private String note;
	
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
	public Collections() {}
	public Collections(Long status) {
		super();
		Date date = new Date();
		this.inputDate = date;
		this.inputDateTime = date;
		this.status = status;
	}
	public String getExhibitPhotoUrl() {
		return exhibitPhotoUrl;
	}
	public void setExhibitPhotoUrl(String exhibitPhotoUrl) {
		this.exhibitPhotoUrl = exhibitPhotoUrl;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}