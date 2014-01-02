package com.zdqk.laobing.action.vo;

import java.io.Serializable;


public class Music implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long musicId;
	private String name;
	private String musicUrl;
	public Long getMusicId() {
		return musicId;
	}
	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
}
