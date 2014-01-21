package com.zdqk.laobing.action;


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
import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.po.Customer_judge_driver;
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
	
	private Customer_judge_driver customer_judge_driver;
    private String drivertelphone;
    

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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("drivertelphone", this.drivertelphone);
		List<Customer_judge_driver> list=customer_judge_driverDAO.selectByDriverid(map, "selectAll");
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
}