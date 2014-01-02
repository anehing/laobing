package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class PhotosVo extends ResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long museumId;
	private List<Photos> photoList;
	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
	}
	public List<Photos> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<Photos> photoList) {
		this.photoList = photoList;
	}
	public PhotosVo(int reusltNumber, String reusltMessage, Long museumId) {
		super(reusltNumber, reusltMessage);
		this.museumId = museumId;
	}
	public PhotosVo(Long museumId) {
		this.museumId = museumId;
	}	
}