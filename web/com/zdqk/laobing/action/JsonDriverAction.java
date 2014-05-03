package com.zdqk.laobing.action;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.zdqk.laobing.action.vo.ResultVo;
import com.zdqk.laobing.action.vo.DriverIncome;
import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.dao.Driver_judge_CustomerDAO;
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.dao.Pre_priceDAO;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Driver_order;
import com.zdqk.laobing.po.Pre_price;
import com.zdqk.laobing.tools.ComStaticValue;
import com.zdqk.laobing.tools.FxJsonUtil;
/**
 * @author：lfx
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results( {
		@Result(name = "UserJsonList", location = "/WEB-INF/json/json.jsp"),
		})
public class JsonDriverAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	 private final double EARTH_RADIUS = 6378.0; //千米 
	 private static String host = ComStaticValue.init("host");
	 
	@Autowired
	private Driver_orderDAO driver_orderDAO;
	@Autowired
	private DriverDAO driverDAO;
	@Autowired
	private Customer_judge_driverDAO customer_judge_driverDAO;
	@Autowired
	private Pre_priceDAO pre_priceDAO;
	
	private Pre_price pre_price;
	private Customer_judge_driver customer_judge_driver;
	private String id;
	private Driver driver;
	private String longitude;
	private String latitude;
	private String mc;
	private String jobstatus;
	private String name;
	private String telphone;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	/**
	 * 司机列表接口
	 * @throws 
	 * */
	@Action("selectByjobstatus")
	public String selectByjobstatusAciton() {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		
		if(this.latitude==null||this.latitude.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:latitude");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.longitude==null||this.longitude.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:longitude");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("job_status",0);//空闲
		List <Driver> list= driverDAO.selectByjobstatus(map, "selectByjobstatus");
		if(list==null||list.size()<=0){
			rv = new ResultVo(1,"暂无空闲的司机");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}else{
		

			
			
			List <com.zdqk.laobing.action.vo.Driver> listdriver=new ArrayList<com.zdqk.laobing.action.vo.Driver>();
			com.zdqk.laobing.action.vo.DriverList Driverlistvo=new com.zdqk.laobing.action.vo.DriverList();
			com.zdqk.laobing.action.vo.Driver drivervo = null;	
			for(Driver driver : list){
				double gpsdis= gps2m(driver.getLatitude(),driver.getLongitude(),Double.parseDouble(this.latitude),Double.parseDouble(this.longitude));
				    if(gpsdis<=10){
				    	driver.setDistance(gpsdis+"公里");
				    	driver.setPicture(host + "photo/" +driver.getPicture());
				    	drivervo = new com.zdqk.laobing.action.vo.Driver();
				    	BeanUtils.copyProperties(driver,drivervo);
						listdriver.add(drivervo);
				    }
	          	}
			if(listdriver.size()>0){
				Driverlistvo.setDriverlistvo(listdriver);
				Driverlistvo.setReusltNumber(0);
				Driverlistvo.setReusltMessage("操作成功");
			}else{
				Driverlistvo.setReusltNumber(1);
				Driverlistvo.setReusltMessage("附近暂无空闲的司机");
			}
			return FxJsonUtil.jsonListHandle(Driverlistvo,resutUrl,request);
		}
	}
	private double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
	       double radLat1 = (lat_a * Math.PI / 180.0);
	       double radLat2 = (lat_b * Math.PI / 180.0);
	       double a = radLat1 - radLat2;
	       double b = (lng_a - lng_b) * Math.PI / 180.0;
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
	              + Math.cos(radLat1) * Math.cos(radLat2)
	              * Math.pow(Math.sin(b / 2), 2)));
	       s = s * EARTH_RADIUS;
	       s = Math.round(s * 10000) / 10000;
	       return s;
	    }
	/**
	 * 司机详情接口
	 * */
	@Action("selectDriverDetial")
	public String selectDriverDetialAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("drivertelphone",this.telphone);
		List <Customer_judge_driver> list= customer_judge_driverDAO.selectByDrivertelphone(map, "selectByDrivertelphone");
		if(list==null||list.size()<=0){
			rv = new ResultVo(1,"该司机暂无车主短信评价");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}else{
			List <com.zdqk.laobing.action.vo.Customer_judge_driver> listc=new ArrayList<com.zdqk.laobing.action.vo.Customer_judge_driver>();
			com.zdqk.laobing.action.vo.JudgeList JudgeListvo=new com.zdqk.laobing.action.vo.JudgeList();
			com.zdqk.laobing.action.vo.Customer_judge_driver judgevo = null;
			for(Customer_judge_driver c : list){
				judgevo = new com.zdqk.laobing.action.vo.Customer_judge_driver();
				BeanUtils.copyProperties(c,judgevo);
				listc.add(judgevo);
			}
			JudgeListvo.setCustomer_judge_driverListvo(listc);
			JudgeListvo.setReusltNumber(0);
			JudgeListvo.setReusltMessage("操作成功");
			return FxJsonUtil.jsonListHandle(JudgeListvo,resutUrl,request);
	    }
	}
	/**
	 * 司机工作状态接口
	 * */
	@Action("adjustJobStatus")
	public String adjustJobStatusAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.id==null||this.id.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:id");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}if(this.jobstatus==null||this.jobstatus.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:jobstatus，0：开始工作，1：结束工作，3：结伴返程");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		
		map.put("id",Integer.parseInt(this.id));
		Driver d=new Driver();
		Driver ds= (Driver) driverDAO.findObjectById(Integer.parseInt(this.id),d);
		if(ds==null){
			rv = new ResultVo(1,"暂时没有找到该司机信息");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			int status =Integer.parseInt(this.jobstatus);
			if(status == 0){
				Map<String, Object> mapprice = new HashMap<String, Object>();
	        	mapprice.put("drivertelphone", ds.getTelphone());
	        	Pre_price p =(Pre_price) pre_priceDAO.seletcbytel(mapprice, "selectAll");
	        	if(p.getPre_price()<p.getPre_account()){
	        		rv = new ResultVo(1,"账户不足,请充值");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
	        	}
			}
			ds.setJob_status(status);
			boolean flag= driverDAO.update(ds);
			if(flag){
				rv = new ResultVo(0,"操作成功");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}else{
				rv = new ResultVo(1,"操作失败");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
		}
			
	}
	/**
	 * 司机登陆接口
	 * */
	@Action("loginDriver")
	public String loginDriverAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.name==null||this.name.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:name");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		map.put("name",this.name);
		map.put("telphone",this.telphone);
		Driver dr= (Driver) driverDAO.loginByNameAndTel(map, "loginByNameAndTel");
		if(dr==null){
			rv = new ResultVo(2,"用户名或者密码错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			dr.setPicture(host + "photo/" +dr.getPicture());
			dr.setJob_status(1);
			com.zdqk.laobing.action.vo.Driver drivervo =  new com.zdqk.laobing.action.vo.Driver();;	
			BeanUtils.copyProperties(dr,drivervo);
			drivervo.setReusltNumber(0);
			drivervo.setReusltMessage("操作成功");
			return FxJsonUtil.jsonHandle(drivervo,resutUrl,request);
		}
		
	}
	/**
	 * 获取司机收入
	 * @throws Exception 
	 * */
	@Action("getdriverincome")
	public String getdriverincomeAction() throws Exception{
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		Map conditionMap =new HashMap();
		conditionMap.put("drivertelphone", telphone);
		conditionMap.put("status", 1);
	
		float yesfee = driver_orderDAO.selectyesincome(conditionMap, "selectyesincome");
		float monthfee = driver_orderDAO.selectmonthincome(conditionMap, "selectmonthincome");
		float allfee = driver_orderDAO.selectallincome(conditionMap,"selectallincome");
		Map<String, Object> mapprice = new HashMap<String, Object>();
    	mapprice.put("drivertelphone", telphone);
    	Pre_price p =(Pre_price) pre_priceDAO.seletcbytel(mapprice, "selectAll");
		float account = p.getPre_price();
		DriverIncome income=new DriverIncome();
		income.setAllfee(allfee);
		income.setMonthfee(monthfee);
		income.setYesfee(yesfee);
		income.setReusltNumber(0);
		income.setAccount(account);
		income.setReusltMessage("操作成功");
		return FxJsonUtil.jsonHandle(income,resutUrl,request);
	}
	/**
	 * 评价司机接口
	 * */
	@Action("valuedriver")
	public String valuedriverAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		map.put("telphone",this.telphone);
		Driver dr= (Driver) driverDAO.loginByNameAndTel(map, "loginByNameAndTel");
		if(dr==null){
			rv = new ResultVo(2,"目前查询不到该司机信息");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			dr.setPicture(host + "photo/" +dr.getPicture());
			com.zdqk.laobing.action.vo.Driver drivervo =  new com.zdqk.laobing.action.vo.Driver();;	
			BeanUtils.copyProperties(dr,drivervo);
			drivervo.setReusltNumber(0);
			drivervo.setReusltMessage("操作成功");
			return FxJsonUtil.jsonHandle(drivervo,resutUrl,request);
		}
		
	}
	/**
	 * 司机更新位置接口
	 * */
	@Action("updatelocation")
	public String updatelocationAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		if(this.latitude==null||this.latitude.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:latitude");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.longitude==null||this.longitude.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:longitude");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("telphone",this.telphone);
		Driver dr= (Driver) driverDAO.loginByNameAndTel(map, "loginByNameAndTel");
		if(dr==null){
			rv = new ResultVo(2,"目前查询不到该司机信息");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			try {
				dr.setLatitude(Double.parseDouble(this.latitude));
				dr.setLongitude(Double.parseDouble(this.longitude));
				dr.setAddress(this.address);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				rv = new ResultVo(2,"更新失败");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
			driverDAO.update(dr);
			rv = new ResultVo(0,"更新成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		
	}
	
	/**
	 * 结伴返程接口
	 * */
	@Action("togetherback")
	public String togetherbackAction(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		if(this.jobstatus==null||this.jobstatus.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:jobstatus");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		map.put("telphone",this.jobstatus);
		Driver dr= (Driver) driverDAO.loginByNameAndTel(map, "loginByNameAndTel");
		if(dr==null){
			rv = new ResultVo(2,"目前查询不到该司机信息");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			dr.setJob_status(Integer.parseInt(this.jobstatus));
			driverDAO.update(dr);
			rv = new ResultVo(0,"提交成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		
	}
	
}
