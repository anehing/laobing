package com.zdqk.laobing.action.vo;

import java.io.Serializable;





public class Customer_judge_driver extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int id;
	    private int score;
		private String telphone;	
		private String drivertelphone;	
	    private String judge_time;
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