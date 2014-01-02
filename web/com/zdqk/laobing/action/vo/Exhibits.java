package com.zdqk.laobing.action.vo;

import java.io.Serializable;

public class Exhibits implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long exhibitId;	
	private String chineseName;	
	private String englishName;	
	private String photoUrl;
	private String note;	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Exhibits(Long exhibitId, String chineseName, String englishName,
			String photoUrl) {
		super();
		this.exhibitId = exhibitId;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.photoUrl = photoUrl;
	}
	public Exhibits() {
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

	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Exhibits(Long exhibitId, String chineseName, String englishName,
			String photoUrl, String note) {
		super();
		this.exhibitId = exhibitId;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.photoUrl = photoUrl;
		this.note = note;
	}
	public Long getExhibitId() {
		return exhibitId;
	}
	public void setExhibitId(Long exhibitId) {
		this.exhibitId = exhibitId;
	}
}