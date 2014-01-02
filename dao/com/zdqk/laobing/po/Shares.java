package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("museums")
public class Shares implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")
	private Long id;
	@TODO("userid")
	private Long userid;
	@TODO("username")
	private String userName;	
	@TODO("userphotourl")
	private String userphotourl;
	@TODO("EXHIBITID")
	private Long exhibitid;
	@TODO("sharedate")
    private Date sharedate;
	@TODO("sharedatetime")
    private Date sharedatetime;
	@TODO("exhibitname")
	private String exhibitname;
	@TODO("status")
	private Long status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserphotourl() {
		return userphotourl;
	}
	public void setUserphotourl(String userphotourl) {
		this.userphotourl = userphotourl;
	}
	public Long getExhibitid() {
		return exhibitid;
	}
	public void setExhibitid(Long exhibitid) {
		this.exhibitid = exhibitid;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	public Date getSharedatetime() {
		return sharedatetime;
	}
	public void setSharedatetime(Date sharedatetime) {
		this.sharedatetime = sharedatetime;
	}
	public String getExhibitname() {
		return exhibitname;
	}
	public void setExhibitname(String exhibitname) {
		this.exhibitname = exhibitname;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}