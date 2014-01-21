package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;



public class DriverList extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    List <Driver> driverlistvo;

	public List<Driver> getDriverlistvo() {
		return driverlistvo;
	}

	public void setDriverlistvo(List<Driver> driverlistvo) {
		this.driverlistvo = driverlistvo;
	}


	

}