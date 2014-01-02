package com.zdqk.laobing.action.vo;

import java.io.Serializable;

public class PreviewMuseum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long museumId;	
	private String chineseName;	
	private String photoUrl;
	public PreviewMuseum(Long museumId, String chineseName,String photoUrl) {
		super();
		this.museumId = museumId;
		this.chineseName = chineseName;
		this.photoUrl = photoUrl;
	}
	public PreviewMuseum() {
	}	
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
	}
}