package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class CollettionsVo extends ResultVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long pageIndex;
	private Long pageSize;
	private List<Exhibits> exhibitsList;
	public CollettionsVo(Long userId, Long pageIndex, Long pageSize) {
		super();
		this.userId = userId;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public CollettionsVo() {
	}	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public List<Exhibits> getExhibitsList() {
		return exhibitsList;
	}
	public void setExhibitsList(List<Exhibits> exhibitsList) {
		this.exhibitsList = exhibitsList;
	}
}
