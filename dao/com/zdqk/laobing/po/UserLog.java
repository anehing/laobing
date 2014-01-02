package com.zdqk.laobing.po;

import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("userlog")
public class UserLog {
	@TODO("id")
	@PK		
    private Long id;
	@TODO("userid")    
    private Long userid;
	@TODO("usertype")      
    private Long usertype;
	@TODO("username")      
	private String userName;
	@TODO("operadate")     
    private Date operadate;
	@TODO("optdate")     
	private Date optdate;// 
	@TODO("operatype")  
    private Long operatype;
	@TODO("operadesc")      
    private String operadesc;
	@TODO("ip")      
    private String ip;
	@TODO("isWorking")    
	private Long isWorking;
	
	private String showDate;
	


	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public Long getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Long isWorking) {
		this.isWorking = isWorking;
	}

	public Long getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

	public Date getOperadate() {
		return operadate;
	}

	public String getOperadesc() {
		return operadesc;
	}

	public Long getOperatype() {
		return operatype;
	}

	public Long getUserid() {
		return userid;
	}

	public Long getUsertype() {
		return usertype;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setOperadate(Date operadate) {
		this.operadate = operadate;
	}

	public void setOperadesc(String operadesc) {
		this.operadesc = operadesc;
	}

	public void setOperatype(Long operatype) {
		this.operatype = operatype;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public void setUsertype(Long usertype) {
		this.usertype = usertype;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserLog(Long userid, String userName, Long operatype,
			String operadesc, Long usertype) {
		this.userid = userid;
		this.userName = userName;
		this.operatype = operatype;
		this.operadesc = operadesc;
		this.usertype=usertype;
	}
	public UserLog() {
		
	}

	public Date getOptdate() {
		return optdate;
	}

	public void setOptdate(Date optdate) {
		this.optdate = optdate;
	}
 
}