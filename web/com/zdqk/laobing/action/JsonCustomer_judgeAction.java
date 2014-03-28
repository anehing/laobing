package com.zdqk.laobing.action;


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
import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.dao.Driver_judge_CustomerDAO;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Driver_judge_Customer;
import com.zdqk.laobing.po.Driver_order;
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
public class JsonCustomer_judgeAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private Customer_judge_driverDAO customer_judge_driverDAO;
	@Autowired
	private Driver_judge_CustomerDAO driver_judge_customerDAO;
	private Customer_judge_driver customer_judge_driver;
    private String drivertelphone;
    private String customertelphone;
    private Driver_order driver_order;
    private String telphone;
    private String score;
  
    private String orderid;

    private String judge;
  
	public Customer_judge_driver getCustomer_judge_driver() {
		return customer_judge_driver;
	}
	public void setCustomer_judge_driver(Customer_judge_driver customer_judge_driver) {
		this.customer_judge_driver = customer_judge_driver;
	}
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
	public Driver_order getDriver_order() {
		return driver_order;
	}
	public void setDriver_order(Driver_order driver_order) {
		this.driver_order = driver_order;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	/**
	 * 获取司机评价
	 * */
	@Action("getcustomerjudge")
	public String getcustomerjudgeAction(){
		ResultVo rv = null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
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
		map.put("drivertelphone", this.drivertelphone);
		map.put("rows", Integer.parseInt(this.rows));
		map.put("offset", Integer.parseInt(this.offset));
		List<Customer_judge_driver> list=customer_judge_driverDAO.selectByDrivertelphone(map, "selectAll");
		if(list==null||list.size()<=0){
			rv = new ResultVo(7,"暂无评论");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
	    	com.zdqk.laobing.action.vo.Customer_judge_driver c_vo=null;
	    	List listvo=new ArrayList();
	    	com.zdqk.laobing.action.vo.JudgeList judgelist=new com.zdqk.laobing.action.vo.JudgeList();
			for(Customer_judge_driver c:list){
				c_vo=new com.zdqk.laobing.action.vo.Customer_judge_driver();
				BeanUtils.copyProperties(c,c_vo);
	    		listvo.add(c_vo);
		    }
			judgelist.setCustomer_judge_driverListvo(listvo);
			judgelist.setReusltNumber(0);
			judgelist.setReusltMessage("操作成功");
	    	return FxJsonUtil.jsonListHandle(judgelist,resutUrl,request);
		}
   }
	
	/**
	 * 客户评价司机
	 * */
	@Action("judgedriver")
	public String judgedriverAction(){
		ResultVo rv = null;
		Boolean flag=null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.score==null||this.score.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:score");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Customer_judge_driver c=new Customer_judge_driver();
		c.setDrivertelphone(this.drivertelphone);
		c.setTelphone(this.telphone);
		c.setScore(Integer.parseInt(this.score));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
		c.setJudge_time(df.format(new Date()));
		flag=customer_judge_driverDAO.insert(c);
		if(flag){
			rv = new ResultVo(2,"评论成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"评论失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
   }
	
	/**
	 * 司机评价客户
	 * */
	@Action("judgecustomer")
	public String judgecustomerAction(){
		ResultVo rv = null;
		Boolean flag=null;
		if(this.drivertelphone==null||this.drivertelphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:drivertelphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}if(this.telphone==null||this.telphone.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		if(this.orderid==null||this.orderid.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:orderid");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Driver_judge_Customer d=new Driver_judge_Customer();
		d.setDrivertelphone(this.drivertelphone);
		d.setCustomertelphone(this.telphone);
		d.setJudge(Integer.parseInt(this.judge));
		d.setOrderid(Integer.parseInt(this.orderid));
		d.setCreate_time(new Date());
		flag=driver_judge_customerDAO.insert(d);
		if(flag){
			rv = new ResultVo(0,"评论成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"评论失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
   }
  
}