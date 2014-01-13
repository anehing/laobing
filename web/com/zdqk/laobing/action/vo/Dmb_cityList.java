package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.List;



public class Dmb_cityList extends ResultVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    List <Dmb_city> Dmb_cityListvo;

    public List<Dmb_city> getDmb_cityListvo() {
	      return Dmb_cityListvo;
    }

    public void setDmb_cityListvo(List<Dmb_city> dmb_cityListvo) {
    	  Dmb_cityListvo = dmb_cityListvo;
    }
	
	

}