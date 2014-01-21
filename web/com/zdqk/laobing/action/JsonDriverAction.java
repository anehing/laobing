package com.zdqk.laobing.action;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Price;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.service.ILoginService;
import com.zdqk.laobing.tools.FxJsonUtil;
import com.zdqk.laobing.tools.ValidateTools;
import com.zdqk.laobing.tools.ibatis.TODO;
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
	@Autowired
	private DriverDAO driverDAO;
	@Autowired
	private Customer_judge_driverDAO customer_judge_driverDAO;
	private int id;
	private Driver driver;
	private Double longitude;
	private Double latitude;
	private String mc;
	private int jobstatus;
	private String name;
	private String telphone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	
	public int getJobstatus() {
		return jobstatus;
	}
	public void setJobstatus(int jobstatus) {
		this.jobstatus = jobstatus;
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
	 * */
	@Action("selectByjobstatus")
	public String selectByjobstatusAciton(){
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.mc!=null){
			rv = new ResultVo(3,"缺少参数:mc");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
     	map.put("mc",this.mc);
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
				double gpsdis= gps2m(driver.getLatitude(),driver.getLongitude(),this.latitude,this.longitude);
				    if(gpsdis<=10){
				    	driver.setDistance(gpsdis+"公里");
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
		if(this.id==0){
			rv = new ResultVo(3,"缺少参数:id");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("id",this.id);
		List <Customer_judge_driver> list= customer_judge_driverDAO.selectByDriverid(map, "selectByDriverid");
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
		if(this.id==0){
			rv = new ResultVo(3,"缺少参数:id");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		map.put("id",this.id);
		Driver d=new Driver();
		Driver ds= (Driver) driverDAO.findObjectById(this.id,d);
		if(ds==null){
			rv = new ResultVo(1,"暂时没有找到该司机信息");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			ds.setAge(this.jobstatus);
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
		Driver dr= (Driver) driverDAO.selectByjobstatus(map, "loginByNameAndTel");
		if(dr==null){
			rv = new ResultVo(2,"用户名或者密码错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
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
		conditionMap.put("telphone", telphone);
		conditionMap.put("status", 1);
		Driver d=new Driver();
		float yesfee = selectIncome(conditionMap, d, driverDAO,"selectyesincome");
		float monthfee = selectIncome(conditionMap, d, driverDAO,"selectmonthincome");
		float allfee = selectIncome(conditionMap, d, driverDAO,"selectallincome");
		DriverIncome income=new DriverIncome();
		income.setAllfee(allfee);
		income.setMonthfee(monthfee);
		income.setYesfee(yesfee);
		income.setReusltNumber(0);
		income.setReusltMessage("操作成功");
		return FxJsonUtil.jsonHandle(income,resutUrl,request);
	}
	
	
	private float selectIncome(Object mapObject,
			Object object,Object daoObject,String select) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		
		float fee =0;
			
		Object returnObject = null;
		
		Method invokeMethod = daoObject.getClass().getMethod(select, new Class[]{Map.class,Object.class});
		
		invokeMethod.setAccessible(true);

		returnObject = invokeMethod.invoke(daoObject,mapObject,object);	
		
		fee = (Float) returnObject;
		
		return fee;
		
	}
}
