package com.zdqk.laobing.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Driver_order;
import com.zdqk.laobing.tools.DateConverter;
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
public class JsonDriverOrderAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private Driver_orderDAO driver_orderDAO;
	
	private String drivertelphone;
	private String customertelphone;
	private String start_place;
	private String startwait;
	private String endwait;
	private int start_time;
	private String end_place;
	private String end_time;
	private float distance;
	private float fee;
    private int status;
    private int judgecustomer;
    private int source;
    private int judgedriver;
    private int id;
    private Driver_order driver_order;
    private String createtime;
    private String telphone;
    private int type;
    
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
	public String getStartwait() {
		return startwait;
	}
	public void setStartwait(String startwait) {
		this.startwait = startwait;
	}
	public String getEndwait() {
		return endwait;
	}
	public void setEndwait(String endwait) {
		this.endwait = endwait;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public String getEnd_place() {
		return end_place;
	}
	public void setEnd_place(String end_place) {
		this.end_place = end_place;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
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
	public int getJudgecustomer() {
		return judgecustomer;
	}
	public void setJudgecustomer(int judgecustomer) {
		this.judgecustomer = judgecustomer;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getJudgedriver() {
		return judgedriver;
	}
	public void setJudgedriver(int judgedriver) {
		this.judgedriver = judgedriver;
	}
	public Driver_order getDriver_order() {
		return driver_order;
	}
	public void setDriver_order(Driver_order driver_order) {
		this.driver_order = driver_order;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
	/**
	 * 司机下单开始代驾
	 * @throws ParseException 
	 * */
	@Action("postcoustomerorder")
	public String postcoustomerorderAction() throws ParseException{
		ResultVo rv = null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.customertelphone==null||this.customertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.start_place==null||this.start_place.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:start_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Date dt=new Date();
		Driver_order d_order =new Driver_order();
		boolean flag=false;
		d_order.setDrivertelphone(this.drivertelphone);
		d_order.setCustomertelphone(this.customertelphone);
		d_order.setStart_place(this.start_place);
		d_order.setStart_time(this.start_time);
		d_order.setSource(1);
		d_order.setCreatetime(dt);
		d_order.setTime(dt.getTime());
		if(this.startwait!=null||!this.startwait.trim().equals("")){
			d_order.setStartwait(DateConverter.convertFromString(this.startwait));
		}
		if(this.endwait!=null||!this.endwait.trim().equals("")){
			d_order.setEndwait(DateConverter.convertFromString(this.endwait));
		}
		long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
        d_order.setOrdernum(num+this.customertelphone.substring(customertelphone.length()-4));
	    flag=driver_orderDAO.insert(d_order);
        if(flag){
			rv = new ResultVo(0,"下单成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"下单失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
      
	public String nDaysAfterOneDate(Date basicDate,int  n) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        long nDay= (basicDate.getTime()+2*n*30*60*1000); 
        basicDate.setTime(nDay); 
        return   df.format(basicDate); 
    } 
	
	
	/**
	 * 司机结束代驾
	 * @throws ParseException 
	 * */
	@Action("enddriverorder")
	public String enddriverorderAction() throws ParseException{
		ResultVo rv = null;
		if(this.id==0){
			rv = new ResultVo(3,"缺少参数:id");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.distance==0){
			rv = new ResultVo(3,"缺少参数:distance");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.fee==0){
			rv = new ResultVo(3,"缺少参数:fee");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.end_place==null||this.end_place.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:end_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Date dt=new Date();
		Driver_order d_order =new Driver_order();
		boolean flag=false;
		d_order.setId(this.id);
		d_order.setDistance(this.distance);
		d_order.setFee(this.fee);
		d_order.setEnd_place(this.end_place);
		d_order.setStatus(1);
	    flag=driver_orderDAO.update(d_order);
        if(flag){
			rv = new ResultVo(0,"确认成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"确认失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
      
	/**
	 * 司机补单
	 * @throws ParseException 
	 * */
	@Action("adddriverorder")
	public String adddriverorderAction() throws ParseException{
		ResultVo rv = null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.customertelphone==null||this.customertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.start_place==null||this.start_place.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:start_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.end_place==null||this.end_place.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:end_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.createtime==null||this.createtime.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:createtime");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.startwait==null||this.startwait.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:startwait");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.endwait==null||this.endwait.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:endwait");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.end_time==null||this.end_time.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:end_time");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.endwait==null||this.endwait.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:start_place");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.distance==0){
			rv = new ResultVo(3,"缺少参数:distance");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.fee==0){
			rv = new ResultVo(3,"缺少参数:fee");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Driver_order d_order =new Driver_order();
		boolean flag=false;
		d_order.setDrivertelphone(this.drivertelphone);
		d_order.setCustomertelphone(this.customertelphone);
		d_order.setStart_place(this.start_place);
		d_order.setEnd_place(this.end_place);
		d_order.setStart_time(this.start_time);
		d_order.setSource(this.source);
		d_order.setCreatetime(DateConverter.convertFromString(this.createtime));
		d_order.setStartwait(DateConverter.convertFromString(this.startwait));
		d_order.setEndwait(DateConverter.convertFromString(this.endwait));
		d_order.setFee(this.fee);
		d_order.setDistance(this.distance);
		d_order.setStatus(1);
		long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
        d_order.setOrdernum(num+this.customertelphone.substring(customertelphone.length()-4));
	    flag=driver_orderDAO.insert(d_order);
        if(flag){
			rv = new ResultVo(0,"下单成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"下单失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
      
	
	/**
	 * 用户和司机查历史看下单
	 * */
	@Action("getcustomerorderlist")
	public String getcustomerorderlistAction(){
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, String> map = new HashMap<String, String>();
		if(this.type==1){
			map.put("drivertelphone", this.telphone);
		}else if(this.type==2){
			map.put("customertelphone", this.telphone);
		}else{
			rv = new ResultVo(3,"缺少参数:type");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
        List<Driver_order> clist =driver_orderDAO.findObjects(map, "selectAll");
        if (clist==null||clist.size()<=0) {
        	rv = new ResultVo(2,"暂无记录");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
        }else{
        	com.zdqk.laobing.action.vo.Driver_orderList clistvo=new com.zdqk.laobing.action.vo.Driver_orderList();
        	List<com.zdqk.laobing.action.vo.Driver_order> list= new ArrayList<com.zdqk.laobing.action.vo.Driver_order>();
        	com.zdqk.laobing.action.vo.Driver_order cvo=null;
        	for(Driver_order c_order:clist){
        		cvo=new com.zdqk.laobing.action.vo.Driver_order(); 
        		BeanUtils.copyProperties(c_order,cvo);
        		list.add(cvo);
        	}
        	clistvo.setDriverorderlistvo(list);
        	clistvo.setReusltMessage("查询成功");
        	clistvo.setReusltNumber(0);
        	return FxJsonUtil.jsonListHandle(clistvo,resutUrl,request);
        }
       
   }
}