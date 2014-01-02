package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class ExhibitsListVo extends ResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long museumId;
	private Long pageIndex;
	private Long pageSize;
    private List<Exhibits> exhibitsList;
	public ExhibitsListVo(Long museumId, Long pageIndex, Long pageSize) {
		super();
		this.museumId = museumId;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public ExhibitsListVo() {
	}	
	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
	}

	public List<Exhibits> getExhibitsList() {
		return exhibitsList;
	}
	public void setExhibitsList(List<Exhibits> exhibitsList) {
		this.exhibitsList = exhibitsList;
	}

	public Long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
}