package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class MusicsVO extends ResultVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List<Music> musicList;
	public List<Music> getMusicList() {
		return musicList;
	}
	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}

}
