package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;



public class JudgeList extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    List <Customer_judge_driver> Customer_judge_driverListvo;

	public List<Customer_judge_driver> getCustomer_judge_driverListvo() {
		return Customer_judge_driverListvo;
	}

	public void setCustomer_judge_driverListvo(
			List<Customer_judge_driver> customer_judge_driverListvo) {
		Customer_judge_driverListvo = customer_judge_driverListvo;
	}
}