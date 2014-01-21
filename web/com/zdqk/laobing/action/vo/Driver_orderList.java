package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;



public class Driver_orderList extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    List <Driver_order> driverorderlistvo;

	public List<Driver_order> getDriverorderlistvo() {
		return driverorderlistvo;
	}

	public void setDriverorderlistvo(List<Driver_order> driverorderlistvo) {
		this.driverorderlistvo = driverorderlistvo;
	}



	

}