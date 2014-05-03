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
import com.zdqk.laobing.dao.Customer_orderDAO;
import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.dao.Pre_priceDAO;
import com.zdqk.laobing.dao.TranrecordDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.Customer_order;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Driver_order;
import com.zdqk.laobing.po.Pre_price;
import com.zdqk.laobing.po.Tranrecord;
import com.zdqk.laobing.po.User;
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
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Pre_priceDAO pre_priceDAO;
	@Autowired
	private DriverDAO driverDAO;
	@Autowired
	private Customer_orderDAO customer_orderDAO;
	private Pre_price pre_price;
	@Autowired
	private TranrecordDAO tranrecordDAO;
	
	private Tranrecord tranrecord;
	private User user;
	private String drivertelphone;
	private String customertelphone;
	private String start_place;
	private String startwait;
	private String endwait;
	private String start_time;
	private String end_place;
	private String end_time;
	private String distance;
	private String fee;
    private String status;
    private String judgecustomer;
    private String source;
    private String judgedriver;
    private String id;
    private Driver_order driver_order;
    private String createtime;
    private String telphone;
    private String type;
    private String orderunm;
    private String waittime;
    private String begintime;
    private String endtime;
    private String discount_amount;
    private String askcode;
    private String city;
    private String use_code;
    
    
    
	public String getUse_code() {
		return use_code;
	}
	public void setUse_code(String use_code) {
		this.use_code = use_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWaittime() {
		return waittime;
	}
	public void setWaittime(String waittime) {
		this.waittime = waittime;
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
	public String getOrderunm() {
		return orderunm;
	}
	public void setOrderunm(String orderunm) {
		this.orderunm = orderunm;
	}

	private SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
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

	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	
	
	
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJudgecustomer() {
		return judgecustomer;
	}
	public void setJudgecustomer(String judgecustomer) {
		this.judgecustomer = judgecustomer;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getJudgedriver() {
		return judgedriver;
	}
	public void setJudgedriver(String judgedriver) {
		this.judgedriver = judgedriver;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 司机下单开始代驾
	 * @throws ParseException 
	 * */
	@Action("postDriverOrder")
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("telphone",this.drivertelphone);
		Driver dr= (Driver) driverDAO.loginByNameAndTel(map, "loginByNameAndTel");
		if (dr==null){
			rv = new ResultVo(1,"司机不存在");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
//		if(dr.getJob_status()!=0&&dr.getJob_status()!=3){
//			rv = new ResultVo(1,"司机当前无法接单");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
//		}
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("telphone",this.customertelphone);
		userMap.put("isbind",1);
		userMap.put("useaskcode",0);
		User userInfo= (User) userDAO.findUserByTelphone(userMap, "loginByTelphone");
	
		Date dt=new Date();
		Driver_order d_order =new Driver_order();
		boolean flag=false;
		d_order.setDrivertelphone(this.drivertelphone);
		d_order.setCustomertelphone(this.customertelphone);
		d_order.setSource(1);
		d_order.setStatus(0);//0:输入订单
		d_order.setCreatetime(dt);
		d_order.setTime(dt.getTime());
	    if(userInfo!=null){
	    	d_order.setAskcode(userInfo.getAskcode());
	    	d_order.setDiscount_amount(userInfo.getDiscount_amount()+"");
		}
		long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
        d_order.setOrdernum(num+this.customertelphone.substring(customertelphone.length()-4));
	    flag=driver_orderDAO.insert(d_order);
	    //获取代价价格
        if(flag){
        	com.zdqk.laobing.action.vo.Driver_order driver_order =  new com.zdqk.laobing.action.vo.Driver_order();;	
			BeanUtils.copyProperties(d_order,driver_order);
			driver_order.setReusltNumber(0);
			driver_order.setReusltMessage("下单成功");
			dr.setJob_status(2);//忙碌
			driverDAO.update(dr);
			return FxJsonUtil.jsonHandle(driver_order,resutUrl,request);
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
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.customertelphone==null||this.customertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.orderunm==null||this.orderunm.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:orderunm");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.waittime==null||this.waittime.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:waittime");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.begintime==null||this.begintime.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:begintime");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.endtime==null||this.endtime.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:endtime");
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
		if(this.distance==null||this.distance.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:distance");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.fee==null||this.fee.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:fee");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drivertelphone",this.drivertelphone);
		map.put("customertelphone", this.customertelphone);
		map.put("ordernum", this.orderunm);
		map.put("status", 0);
		Driver_order d = (Driver_order) driver_orderDAO.selectdriverorder(map, "selectall2");
		Customer_order c=(Customer_order) customer_orderDAO.selectByTel(map, "selectAll2");
		if(c!=null){
			c.setStatus(2);
			customer_orderDAO.update(c);
		}
		if (d ==null){
			rv = new ResultVo(1,"订单确认失败，请联系管理员");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		boolean flag=false;
		d.setStart_place(this.start_place);
		d.setEnd_place(this.end_place);
		d.setBegintime(this.begintime);
		d.setEndtime(this.endtime);
		d.setAskcode(this.use_code);
		d.setDiscount_amount(this.discount_amount);
		d.setDistance(Float.parseFloat(this.distance));
		float count = Float.parseFloat(this.fee);
		d.setFee(count);
		d.setStatus(1);//1:订单完成
	    flag=driver_orderDAO.update(d);
        if(flag){
        	Map<String, Object> mapprice = new HashMap<String, Object>();
        	mapprice.put("drivertelphone", this.drivertelphone);
        	Pre_price p =(Pre_price) pre_priceDAO.seletcbytel(mapprice, "selectAll");
        	if(p==null || p.getPre_price()<=p.getPre_account()){
        		rv = new ResultVo(1,"司机不存在,或者账户额度太低");
    			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
        	}
        	Tranrecord t =new Tranrecord();
        	float price =p.getPre_price();
        	if(count<=58){
        		t.setAccount(2);
        		p.setPre_price(price-2);
        	}else if (58<count&&count<=79){
        		t.setAccount(5);
        		p.setPre_price(price-5);
        	}else if (79<count&&count<=98){
        		t.setAccount(10);
        		p.setPre_price(price-10);
        	}else{
        		t.setAccount(15);
        		p.setPre_price(price-15);
        	}
        	pre_priceDAO.update(p);//修改预付款
        	
        	t.setOrder_num(this.orderunm);
        	t.setTrans_datetime(new Date());
        	t.setType(0);//0:扣款，1：充值
        	t.setTelphone(this.drivertelphone);
        	
        	tranrecordDAO.insert(t);
        	Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("telphone",this.drivertelphone);
			Driver dr= (Driver) driverDAO.loginByNameAndTel(map2, "loginByNameAndTel");
			dr.setJob_status(0);//空闲
			dr.setTimes(dr.getTimes()+1);
			driverDAO.update(dr);
			rv = new ResultVo(0,"订单确认成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"订单确认失败");
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
//		if(this.waittime==null||this.waittime.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:waittime");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//		if(this.begintime==null||this.begintime.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:begintime");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//		if(this.endtime==null||this.endtime.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:endtime");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//		if(this.start_place==null||this.start_place.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:start_place");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//		if(this.end_place==null||this.end_place.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:end_place");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
//				if(this.distance==null||this.distance.trim().equals("")){
//			rv = new ResultVo(3,"缺少参数:distance");
//			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
//		}
		float count=0;
		float distance2=0;
		if(this.fee==null||this.fee.trim().equals("")){
			count=0;
		}else{
			count= Float.parseFloat(this.fee);
		}
		if(this.distance==null||this.distance.trim().equals("")){
			distance2=0;
		}else{
			distance2= Float.parseFloat(this.distance);
		}
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drivertelphone",this.drivertelphone);
		map.put("customertelphone", this.customertelphone);
		map.put("status", 0);
		Driver_order d = (Driver_order) driver_orderDAO.selectdriverorder(map, "selectall2");
		Customer_order c=(Customer_order) customer_orderDAO.selectByTel(map, "selectAll2");
		if(c!=null){
			c.setStatus(2);
			customer_orderDAO.update(c);
		}
		if (d!=null){
			rv = new ResultVo(1,"该订单尚未取消");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		Driver_order d_order =new Driver_order();
		boolean flag=false;
		d_order.setDrivertelphone(this.drivertelphone);
		d_order.setCustomertelphone(this.customertelphone);
		d_order.setStart_place(this.start_place);
		d_order.setEnd_place(this.end_place);
		d_order.setBegintime(this.begintime);
		d_order.setEndtime(this.endtime);
		if(this.askcode!=null&&!this.askcode.trim().equals("")){
			d_order.setAskcode(this.askcode);
		}
		if(this.discount_amount!=null&&!this.discount_amount.trim().equals("")){
			d_order.setDiscount_amount(this.discount_amount);
		}
		long num=Math.round(Math.random() * 1000) +Math.round(Math.random() * 1000);
        d_order.setOrdernum(num+this.customertelphone.substring(customertelphone.length()-4));
		d_order.setCreatetime(new Date());
		d_order.setFee(count);
		d_order.setDistance(distance2);
		d_order.setStatus(1);
	    flag=driver_orderDAO.insert(d_order);
        if(flag){
        	Map<String, Object> mapprice = new HashMap<String, Object>();
        	mapprice.put("drivertelphone", this.drivertelphone);
        	Pre_price p =(Pre_price) pre_priceDAO.seletcbytel(mapprice, "selectAll");
        	if(p==null || p.getPre_price()<=p.getPre_account()){
        		rv = new ResultVo(1,"司机不存在,或者账户额度太低");
    			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
        	}
        	Tranrecord t =new Tranrecord();
        	float price =p.getPre_price();
        	if(count<=58){
        		t.setAccount(2);
        		p.setPre_price(price-2);
        	}else if (58<count&&count<=79){
        		t.setAccount(5);
        		p.setPre_price(price-5);
        	}else if (79<count&&count<=98){
        		t.setAccount(10);
        		p.setPre_price(price-10);
        	}else{
        		t.setAccount(15);
        		p.setPre_price(price-15);
        	}
        	pre_priceDAO.update(p);//修改预付款
        	
        	t.setOrder_num(this.orderunm);
        	t.setTrans_datetime(new Date());
        	t.setType(0);//0:扣款，1：充值
        	t.setTelphone(this.drivertelphone);
        	tranrecordDAO.insert(t);
        	Map<String, Object> map2 = new HashMap<String, Object>();
    		map2.put("telphone",this.drivertelphone);
    		Driver dr= (Driver) driverDAO.loginByNameAndTel(map2, "loginByNameAndTel");
    		dr.setTimes(dr.getTimes()+1);
			driverDAO.update(dr);
			rv = new ResultVo(0,"补单成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"补单失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
      
	
	/**
	 * 司机查历史看下单
	 * */
	@Action("getdriverrorderlist")
	public String getdriverrorderlistAction(){
		ResultVo rv = null;
		if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.rows==null||this.rows.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:rows");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.offset==null||this.offset.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:offset");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if(this.type.equals("1")){
			map.put("drivertelphone", this.telphone);
			map.put("status",1);
		}else if(this.type.equals("2")){
			map.put("customertelphone", this.telphone);
		}else{
			rv = new ResultVo(3,"缺少参数:type");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		map.put("rows", Integer.parseInt(this.rows));
		map.put("offset", Integer.parseInt(this.offset));
		
		Driver_order  driver_order  =new Driver_order();
        List<Driver_order> clist =driver_orderDAO.findObjects(map,driver_order);
        if (clist==null||clist.size()<=0) {
        	rv = new ResultVo(2,"暂无记录");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
        }else{
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	com.zdqk.laobing.action.vo.Driver_orderList clistvo=new com.zdqk.laobing.action.vo.Driver_orderList();
        	List<com.zdqk.laobing.action.vo.Driver_order> list= new ArrayList<com.zdqk.laobing.action.vo.Driver_order>();
        	com.zdqk.laobing.action.vo.Driver_order cvo=null;
        	for(Driver_order c_order:clist){
        		cvo=new com.zdqk.laobing.action.vo.Driver_order(); 
        		BeanUtils.copyProperties(c_order,cvo);
        		cvo.setClientdatetime(sdf.format(cvo.getCreatetime()));
        		list.add(cvo);
        	}
        	clistvo.setDriverorderlistvo(list);
        	clistvo.setReusltMessage("查询成功");
        	clistvo.setReusltNumber(0);
        	return FxJsonUtil.jsonListHandle(clistvo,resutUrl,request);
        }
       
   }
	
	/**
	 * 司机查看未处理下单
	 * */
	@Action("getDriverOrderList")
	public String getdriverorderlistAction(){
		ResultVo rv = null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drivertelphone", this.drivertelphone);
		map.put("status", 0);
		Driver_order  driver_order  =new Driver_order();
        List<Driver_order> clist =driver_orderDAO.findObjects(map,driver_order);
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
	/**未处理
	 * 取消订单
	 * @throws ParseException 
	 * */
	@Action("offdriverorder")
	public String offdriverorder() {
		ResultVo rv = null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.customertelphone==null||this.customertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:customertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.orderunm==null||this.orderunm.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:orderunm");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drivertelphone",this.drivertelphone);
		map.put("orderunm", this.orderunm);
		map.put("customertelphone", this.customertelphone);
		map.put("status", 0);
		Driver_order d = (Driver_order) driver_orderDAO.selectdriverorder(map, "selectall2");
		Customer_order c=(Customer_order) customer_orderDAO.selectByTel(map, "selectAll2");
		if(c!=null){
			c.setStatus(2);
			customer_orderDAO.update(c);
		}
		if (d ==null){
			rv = new ResultVo(1,"订单确认失败，请联系管理员");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		d.setStatus(2);//订单作废
	  Boolean flag=  driver_orderDAO.update(d);
        if(flag){
			rv = new ResultVo(0,"取消成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"取消失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
      
      

}