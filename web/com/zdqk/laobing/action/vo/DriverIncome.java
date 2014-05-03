package com.zdqk.laobing.action.vo;

import java.io.Serializable;




public class DriverIncome extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private float yesfee;
    private float monthfee;
    private float allfee;
    private float account;
	public float getYesfee() {
		return yesfee;
	}
	public void setYesfee(float yesfee) {
		this.yesfee = yesfee;
	}
	public float getMonthfee() {
		return monthfee;
	}
	public void setMonthfee(float monthfee) {
		this.monthfee = monthfee;
	}
	public float getAllfee() {
		return allfee;
	}
	public void setAllfee(float allfee) {
		this.allfee = allfee;
	}
	public float getAccount() {
		return account;
	}
	public void setAccount(float account) {
		this.account = account;
	}
	
	

}