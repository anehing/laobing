package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.TODO;





public class Driver_order extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int id;
	
    private String drivertelphone;
    private String customertelphone;
	private String start_place;
	private int start_time;	
    private Date startwait;
    private Date endwait;
	private String end_place;	
    private Date end_time;
    private float distance;
    private float fee;
    private int status;
    private int source;
    private int judgecustomer;
    private int judgedriver;
    private String ordernum;
    private Date createtime;
    private long time;
    private String begintime;
    private String endtime;
	private String discount_amount;
    private String askcode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDrivertelphone() {
		return drivertelphone;
	}
	public void setDrivertelphone(String drivertelphone) {
		this.drivertelphone = drivertelphone;
	}
	public String getCustomertelphone() {
		return customertelphone;
	}
	public void setCustomertelphone(String customertelphone) {
		this.customertelphone = customertelphone;
	}
	public String getStart_place() {
		return start_place;
	}
	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public Date getStartwait() {
		return startwait;
	}
	public void setStartwait(Date startwait) {
		this.startwait = startwait;
	}
	public Date getEndwait() {
		return endwait;
	}
	public void setEndwait(Date endwait) {
		this.endwait = endwait;
	}
	public String getEnd_place() {
		return end_place;
	}
	public void setEnd_place(String end_place) {
		this.end_place = end_place;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getJudgecustomer() {
		return judgecustomer;
	}
	public void setJudgecustomer(int judgecustomer) {
		this.judgecustomer = judgecustomer;
	}
	public int getJudgedriver() {
		return judgedriver;
	}
	public void setJudgedriver(int judgedriver) {
		this.judgedriver = judgedriver;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(String discount_amount) {
		this.discount_amount = discount_amount;
	}
	public String getAskcode() {
		return askcode;
	}
	public void setAskcode(String askcode) {
		this.askcode = askcode;
	}

}