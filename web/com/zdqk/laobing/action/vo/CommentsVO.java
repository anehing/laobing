package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;


public class CommentsVO extends ResultVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long exhibitId;
	private Long pageIndex;
	private Long pageSize;
    private List<Comments> CommentsList;
	public List<Comments> getCommentsList() {
		return CommentsList;
	}
	public void setCommentsList(List<Comments> commentsList) {
		CommentsList = commentsList;
	}
	public Long getExhibitId() {
		return exhibitId;
	}
	public void setExhibitId(Long exhibitId) {
		this.exhibitId = exhibitId;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public CommentsVO(Long exhibitId,Long pageIndex, Long pageSize) {
		this.exhibitId = exhibitId;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

}
