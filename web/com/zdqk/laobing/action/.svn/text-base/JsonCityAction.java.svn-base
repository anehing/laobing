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
import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.Dmb_city;
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
public class JsonCityAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private Dmb_cityDAO dmb_cityDAO;
	
	private Dmb_city dmb_city;

	public Dmb_city getDmb_city() {
		return dmb_city;
	}

	public void setDmb_city(Dmb_city dmb_city) {
		this.dmb_city = dmb_city;
	}
	
	/**
	 * 城市列表查询接口，供价格查看使用
	 * */
	@Action("selectCityAllbyStatus")
	public String selectCityAllbyStatus(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("status",1);
		List <Dmb_city> list= dmb_cityDAO.selectAllbyStatus(map, "selectAllbyStatus");
		List <com.zdqk.laobing.action.vo.Dmb_city> listvo=new ArrayList<com.zdqk.laobing.action.vo.Dmb_city>();
		com.zdqk.laobing.action.vo.Dmb_cityList dmb_citylistvo=new com.zdqk.laobing.action.vo.Dmb_cityList();
		if(list!=null&&list.size()>0){
			
			com.zdqk.laobing.action.vo.Dmb_city	vocity = null;	
			for(Dmb_city dmb_city : list){
					vocity = new com.zdqk.laobing.action.vo.Dmb_city();
					BeanUtils.copyProperties(dmb_city,vocity);
					listvo.add(vocity);
	          	}
				dmb_citylistvo.setDmb_cityListvo(listvo);
				dmb_citylistvo.setReusltNumber(0);
				dmb_citylistvo.setReusltMessage("操作成功");
		
	   }else{
			dmb_citylistvo.setReusltNumber(1);
			dmb_citylistvo.setReusltMessage("操作失败，没有城市可用");
		}
		return FxJsonUtil.jsonListHandle(dmb_citylistvo,resutUrl,request);
	}
}
