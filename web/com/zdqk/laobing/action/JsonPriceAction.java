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
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.dao.UserDAO;
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
public class JsonPriceAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private PriceDAO priceDAO;
	
	private Price price;

    
	private String cityid;
	
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}


	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	/**
	 * 选择城市，提供价格信息
	 * */
	@Action("selectByCity")
	public String selectByCity(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		ResultVo rv = null;
		if(this.cityid==null||this.cityid.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:cityid");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("cityid",Integer.parseInt(this.cityid));
		List <Price> list= priceDAO.selectByCity(map, "selectByCity");
		List <com.zdqk.laobing.action.vo.Price> listvo=new ArrayList<com.zdqk.laobing.action.vo.Price>();
		com.zdqk.laobing.action.vo.PriceList Pricelistvo=new com.zdqk.laobing.action.vo.PriceList();
		if(list!=null&&list.size()>0){
			
			com.zdqk.laobing.action.vo.Price voprice = null;	
			for(Price Price : list){
			    	voprice = new com.zdqk.laobing.action.vo.Price();
					BeanUtils.copyProperties(Price,voprice);
					listvo.add(voprice);
	          	}
				Pricelistvo.setPricelistvo(listvo);
				Pricelistvo.setReusltNumber(0);
				Pricelistvo.setReusltMessage("操作成功");
		
	   }else{
			Pricelistvo.setReusltNumber(1);
			Pricelistvo.setReusltMessage("操作失败，该城市没有价格信息可用");
		}
		return FxJsonUtil.jsonListHandle(Pricelistvo,resutUrl,request);
	}
}
