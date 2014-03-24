package com.zdqk.laobing.action;


import java.io.UnsupportedEncodingException;
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

    
	private String note;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}



	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 选择城市，提供价格信息
	 * @throws UnsupportedEncodingException 
	 * */
	@Action("selectByCity")
	public String selectByCity() {
		Map<String, String> map = new HashMap<String, String>();
		ResultVo rv = null;
		if(this.note==null||this.note.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:note");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		 
		map.put("note",this.note);
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
			Pricelistvo.setReusltMessage("操作失败，该城市没有价格信息可用"+this.note);
		}
		return FxJsonUtil.jsonListHandle(Pricelistvo,resutUrl,request);
	}
	/**
	 * 选择城市，提供价格信息
	 * @throws UnsupportedEncodingException 
	 * */
	@Action("selectpay")
	public String selectpay() {
		Map<String, Object> map = new HashMap<String, Object>();
		ResultVo rv = null;
		if(this.city==null||this.city.trim().equals("")){
			rv = new ResultVo(3,"缺少参数:city");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		 
		map.put("note",this.city);
		Date date =new Date();
		int hour = date.getHours();
        if (1<=hour&&hour<=6){
        	map.put("sort", 4);
        }else if (7<=hour&&hour<=21){
        	map.put("sort", 1);
        }else if (22<=hour&&hour<=23){
        	map.put("sort", 2);
        }else {
        	map.put("sort", 3);
        }

		List <Price> list= priceDAO.selectByCity(map, "selectByCity");
		if(list!=null&&list.size()>0){
			Price pr =list.get(0);
			com.zdqk.laobing.action.vo.Price voprice =  new com.zdqk.laobing.action.vo.Price();
			BeanUtils.copyProperties(pr,voprice);
			voprice.setReusltNumber(0);
			voprice.setReusltMessage("价格获取成功");
			return FxJsonUtil.jsonListHandle(voprice,resutUrl,request);
	   }else{
		   rv = new ResultVo(1,"价格获取失败");
		   return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		
	}
}
