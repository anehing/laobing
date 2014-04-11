package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("customer_judge_driver")	
public class Customer_judge_driver implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK		
	@TODO("id")		
    private int id;
	@TODO("score")		
    private int score;
	@TODO("telphone")	
	private String telphone;	
	@TODO("drivertelphone")
	private String drivertelphone;	
	@TODO("judge_time")
    private String judge_time;
	@TODO("content")
    private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getDrivertelphone() {
		return drivertelphone;
	}
	public void setDrivertelphone(String drivertelphone) {
		this.drivertelphone = drivertelphone;
	}
	public String getJudge_time() {
		return judge_time;
	}
	public void setJudge_time(String judge_time) {
		this.judge_time = judge_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}