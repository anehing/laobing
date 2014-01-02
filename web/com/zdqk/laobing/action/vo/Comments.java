package com.zdqk.laobing.action.vo;

import java.io.Serializable;


public class Comments implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long commentId;
	private Long userId;
	private String userName;
	private String userPhotoUrl;
	private Long exhibitId;	
	private String content;	
	private String inputDateTimeStr;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInputDateTimeStr() {
		return inputDateTimeStr;
	}
	public void setInputDateTimeStr(String inputDateTimeStr) {
		this.inputDateTimeStr = inputDateTimeStr;
	}
	public Comments(Long commentId, Long userId, String userName, String userPhotoUrl,
			String content, String inputDateTime) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.userName = userName;
		this.userPhotoUrl = userPhotoUrl;
		this.content = content;
		this.inputDateTimeStr = inputDateTime;
	}
	public Comments() {
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getExhibitId() {
		return exhibitId;
	}
	public void setExhibitId(Long exhibitId) {
		this.exhibitId = exhibitId;
	}
}
