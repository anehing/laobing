package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;



public class PublicNoteList extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    List <PublicNote> publicnotelistvo;

	public List<PublicNote> getPublicnotelistvo() {
		return publicnotelistvo;
	}

	public void setPublicnotelistvo(List<PublicNote> publicnotelistvo) {
		this.publicnotelistvo = publicnotelistvo;
	}


	

}