package com.zdqk.laobing.action.vo;

import java.io.Serializable;
public class Photos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4890148778432391116L;
	private Long photoId;
	private String photoUrl;
	private String photoName;
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Photos(Long photoId, String photoUrl) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
	}
	public Photos() {
	}
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}	
}
