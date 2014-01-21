package com.zdqk.laobing.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Price;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "priceList", location = "/priceList.jsp"),
	       @Result(name = "updatePrice", location = "/updatePrice.jsp"),
	       @Result(name = "queryPrice", type = "chain", location = "queryPrice"),
	       @Result(name = "addPrice", location = "/addPrice.jsp"),
		})

public class PriceAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PriceDAO priceDAO;
	@Autowired
	private Dmb_cityDAO dmb_cityDAO;
	
	private Price price;
	
	private List<Dmb_city> dmb_citylist;
	
	 
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	

	public List<Dmb_city> getDmb_citylist() {
		return dmb_citylist;
	}
	public void setDmb_citylist(List<Dmb_city> dmb_citylist) {
		this.dmb_citylist = dmb_citylist;
	}
	/**
	 * @author ane
	 *  后台查询价格
	 */
	@Action("queryPrice")
	public String queryPrice() {
		this.dmb_citylist=getcity();
		Price a = new Price();
		Map<String, Object> map = this.getPmapNew();
		if(this.price!=null){
			if(!price.getNote().equals("请选择")){
				map.put("note", price.getNote());
				}
			}
		List<Price> list = publicQuery(map, a, priceDAO); 
		return "priceList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改后价格户信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用queryPrice().
	 *  
	 */
	@Action("queryPricebyId")
	public String queryPricebyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Price a=new Price();
		this.price = (Price) priceDAO.findObjectById(id, a);
		
		if (totype == 1){ 
			this.dmb_citylist=getcity();
			return "updatePrice";
			}
		if (totype == 2) {
			boolean flag;
		    flag=priceDAO.delete(this.price);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    this.price=null;
		    return "queryPrice";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新后台价格
	 */
	@Action("updatePrice")
	public String updatePrice() {
		this.dmb_citylist=getcity();
		if(this.price!=null){
			boolean  flag=priceDAO.update(this.price);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updatePrice";
	}
	/**
	 * @author ane
	 *  添加后台价格
	 */
	@Action("addPrice")
	public String addPrice() {
		this.dmb_citylist=getcity();
		if(this.price!=null){
			boolean  flag=priceDAO.insert(this.price);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}			
			return "addPrice";
		
	}
	private List<Dmb_city> getcity(){
		Dmb_city a = new Dmb_city();
		Map<String, Object> map = this.getPmapNew();
		List<Dmb_city> list = publicQuery(map, a, dmb_cityDAO);
		return list;
	}
}
