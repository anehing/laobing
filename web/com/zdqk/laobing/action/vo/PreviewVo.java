package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class PreviewVo extends ResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long groupId;
    private List<PreviewMuseum> museumList;
	private List<Photos> photoList;
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public List<PreviewMuseum> getMuseumList() {
		return museumList;
	}
	public void setMuseumList(List<PreviewMuseum> museumList) {
		this.museumList = museumList;
	}
	public List<Photos> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<Photos> photoList) {
		this.photoList = photoList;
	}
}