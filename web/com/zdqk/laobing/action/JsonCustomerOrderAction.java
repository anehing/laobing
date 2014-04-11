package com.zdqk.laobing.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.zdqk.laobing.dao.CouponDAO;
import com.zdqk.laobing.dao.Customer_orderDAO;
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.Coupon;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Driver_order;
import com.zdqk.laobing.po.Order2;
import com.zdqk.laobing.po.Price;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.service.ILoginService;
import com.zdqk.laobing.tools.FxJsonUtil;
import com.zdqk.laobing.tools.ValidateTools;
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
public class JsonCustomerOrderAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private Customer_orderDAO customer_orderDAO;
	private String telphone;
	private String telphone1;
	private String telphone2;
	private String telphone3;
	private String telphone4;
	private String start_place;
	private String start_time;
	private String driver;
	private String longitude;
	private String latitude;
	private Customer_order customer_order;
    private String customer_telphone;
    private String drivertelphone;
    private String source;
	public String getTelphone1() {
		return telphone1;
	}
	public void setTelphone1(String telphone1) {
		this.telphone1 = telphone1;
	}
	public String getTelphone2() {
		return telphone2;
	}
	public void setTelphone2(String telphone2) {
		this.telphone2 = telphone2;
	}
	public String getTelphone3() {
		return telphone3;
	}
	public void setTelphone3(String telphone3) {
		this.telphone3 = telphone3;
	}
	public String getTelphone4() {
		return telphone4;
	}
	public void setTelphone4(String telphone4) {
		this.telphone4 = telphone4;
	}
	public String getStart_place() {
		return start_place;
	}
	public void setStart_place(String start_place) {
		this.start_place = start_place;
	}
	
	public Customer_order getCustomer_order() {
		return customer_order;
	}
	public void setCustomer_order(Customer_order customer_order) {
		this.customer_order = customer_order;
	}
	public String getCustomer_telphone() {
		return customer_telphone;
	}
	public void setCustomer_telphone(String customer_telphone) {
		this.customer_telphone = customer_telphone;
	}
	public String getDrivertelphone() {
		return drivertelphone;
	}
	public void setDrivertelphone(String drivertelphone) {
		this.drivertelphone = drivertelphone;
	}
	

	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	

	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	/**
	 * 用户下单
	 * */
	@Action("postCoustomerOrder")
	public String postcoustomerorderAction(){
		ResultVo rv = null;
		if(this.start_place==null||this.start_place.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:start_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.start_time==null||this.start_time.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:start_time");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.driver==null||this.driver.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:driver");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.longitude==null||this.latitude==null||this.latitude.trim().equals("")||this.longitude.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:longitude,latitude");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Date dt=new Date();
		if(this.customer_telphone==null||this.customer_telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customer_telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}else{  
		    	Customer_order c_order =new Customer_order(); 
		    	boolean flag=false;
		        c_order.setCustomer_telphone(this.customer_telphone);
		        c_order.setDriver(Integer.parseInt(this.driver));
		        c_order.setStart_place(this.start_place);
		        c_order.setStart_time(Integer.parseInt(this.start_time));
		        c_order.setCreate_time(dt);
		        c_order.setLatitude(Double.parseDouble(this.latitude));
		        c_order.setLongitude(Double.parseDouble(this.longitude));
		        c_order.setStatus(0);
		        String return_time=nDaysAfterOneDate(dt,Integer.parseInt(this.start_time));
		        c_order.setReturn_time(return_time);
		        c_order.setSource(0);
		        long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
		        c_order.setOrdernum(num+customer_telphone.substring(customer_telphone.length()-4));
		        flag=customer_orderDAO.insert(c_order);
		        if(flag){
					rv = new ResultVo(0,"下单成功");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}else{
					rv = new ResultVo(1,"下单失败");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}
		}
      
   }
	public String nDaysAfterOneDate(Date basicDate,int  n) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        long nDay= (basicDate.getTime()+2*n*30*60*1000); 
        basicDate.setTime(nDay); 
        return   df.format(basicDate); 
    } 

	/**
	 * 用户查历史看下单
	 * */
	@Action("getCustomerOrderlist")
	public String getcustomerorderlistAction(){
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customer_telphone", this.telphone);
		if(this.rows==null||this.rows.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:rows");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.offset==null||this.offset.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:offset");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("rows", Integer.parseInt(this.rows));
		map.put("offset", Integer.parseInt(this.offset));
		Customer_order c_order =new Customer_order(); 
        List<Customer_order> clist =customer_orderDAO.findObjects(map,c_order);
        if (clist==null||clist.size()<=0) {
        	rv = new ResultVo(2,"暂无记录");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
        }else{
        	com.zdqk.laobing.action.vo.Customer_orderList clistvo=new com.zdqk.laobing.action.vo.Customer_orderList();
        	List<com.zdqk.laobing.action.vo.Customer_order> list= new ArrayList<com.zdqk.laobing.action.vo.Customer_order>();
        	com.zdqk.laobing.action.vo.Customer_order cvo=null;
        	for(Customer_order corder:clist){
        		cvo=new com.zdqk.laobing.action.vo.Customer_order(); 
        		BeanUtils.copyProperties(corder,cvo);
        		list.add(cvo);
        	}
        	clistvo.setCustomer_orderlistvo(list);
        	clistvo.setReusltMessage("查询成功");
        	clistvo.setReusltNumber(0);
        	return FxJsonUtil.jsonListHandle(clistvo,resutUrl,request);
        }
       
   }
//	/**
//	 * 司机查看未处理下单
//	 * */
//	@Action("getdriverorderlist")
//	public String getdriverorderlistAction(){
//		ResultVo rv = null;
//		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:telphone");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("drivertelphone", this.drivertelphone);
//		map.put("status", 0);
//        List<Customer_order> clist =customer_orderDAO.selectByTel(map, "selectByTel");
//        if (clist==null||clist.size()<=0) {
//        	rv = new ResultVo(2,"暂无记录");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
//        }else{
//        	com.zdqk.laobing.action.vo.Customer_orderList clistvo=new com.zdqk.laobing.action.vo.Customer_orderList();
//        	List<com.zdqk.laobing.action.vo.Customer_order> list= new ArrayList<com.zdqk.laobing.action.vo.Customer_order>();
//        	for(Customer_order c_order:clist){
//        		com.zdqk.laobing.action.vo.Customer_order cvo =new com.zdqk.laobing.action.vo.Customer_order(); 
//        		BeanUtils.copyProperties(c_order,cvo);
//        		list.add(cvo);
//        	}
//        	clistvo.setCustomer_orderlistvo(list);
//        	clistvo.setReusltMessage("查询成功");
//        	clistvo.setReusltNumber(0);
//        	return FxJsonUtil.jsonListHandle(clistvo,resutUrl,request);
//        }
//       
//   }
	/**
	 * 用户下单
	 * */
	@Action("callrecord")
	public String callrecord(){
		ResultVo rv = null;
		
		Boolean   flag = false;
		Date dt=new Date();
		if(this.customer_telphone==null||this.customer_telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customer_telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Order2 o =new Order2();
		o.setCustomer_telphone(this.customer_telphone);
		o.setDriver_telphone(this.drivertelphone);
		o.setCreate_time(dt);
		o.setCreate_time(dt);
		flag=customer_orderDAO.insert(o);
	    if(flag){
			rv = new ResultVo(0,"记录成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"记录失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
      
   }
}