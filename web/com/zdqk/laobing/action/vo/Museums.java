package com.zdqk.laobing.action.vo;

import java.io.Serializable;

public class Museums extends ResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long museumId;	
	private String chineseName;	
	private String englishName;	
	private String note;
	private String photoUrl;

	public Museums(Long museumId, String chineseName, String englishName,
			String note, String photoUrl) {
		super();
		this.museumId = museumId;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.note = note;
		this.photoUrl = photoUrl;
	}
	public Museums() {
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
	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
	}
}