package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class VideoVO extends ResultVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<Video> videosList;

	public List<Video> getVideosList() {
		return videosList;
	}
	public void setVideosList(List<Video> videosList) {
		this.videosList = videosList;
	}

}
