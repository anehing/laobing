package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("messages")
public class Messages implements Serializable {
	private static final long serialVersionUID = 1L;
	@PK
	@TODO("id")
	private Long id;
	@TODO("userid")
	private Long userId;
	@TODO("username")
	private String userName;
	@TODO("msgdatetime")
	private Date msgDateTime;
	@TODO("msgdate")
	private Date msgDate;
	@TODO("message")
	private String message;
	@TODO("status")
	private Long status;
	private String msgDateTimeStr;
	
	public String getMsgDateTimeStr() {
		return msgDateTimeStr;
	}
	public void setMsgDateTimeStr(String msgDateTimeStr) {
		this.msgDateTimeStr = msgDateTimeStr;
	}
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Date getMsgDateTime() {
		return msgDateTime;
	}

	public void setMsgDateTime(Date msgDateTime) {
		this.msgDateTime = msgDateTime;
	}

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Messages(String message) {
		super();
		this.message = message;
		Date date = new Date();
		this.msgDate = date;
		this.msgDateTime = date;
		this.status = 1L;
	}

	public Messages() {
	}
}
