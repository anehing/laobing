package com.zdqk.laobing.action;

import java.util.Date;
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


import com.zdqk.laobing.dao.Pre_priceDAO;
import com.zdqk.laobing.dao.TranrecordDAO;
import com.zdqk.laobing.po.Pre_price;
import com.zdqk.laobing.po.Tranrecord;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "pre_priceList", location = "/pre_priceList.jsp"),
	       @Result(name = "updatepre_price", location = "/updatePre_price.jsp"),
	       @Result(name = "updatepre_account", location = "/updatePre_account.jsp"),
	       @Result(name = "queryPre_price", type = "chain", location = "queryPre_price"),
	      
		})

public class Pre_priceAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Pre_priceDAO pre_priceDAO;
	@Autowired
	private TranrecordDAO tranrecordDAO;
	
	private Tranrecord tranrecord;
	
	private Pre_price pre_price;
	private float price;
	public Pre_price getpre_price() {
		return pre_price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setpre_price(Pre_price pre_price) {
		this.pre_price = pre_price;
	}
	/**
	 * @author ane
	 *  查询预付款信息
	 */
	@Action("queryPre_price")
	public String queryPre_price() {
		Pre_price a = new Pre_price();
		Map<String, Object> map = this.getPmapNew();
		if(this.pre_price!=null&& !pre_price.getDrivertelphone().trim().equals("")){
			map.put("drivertelphone", pre_price.getDrivertelphone());
			}
		List<Pre_price> list = publicQuery(map, a, pre_priceDAO); 
		return "pre_priceList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改后台账户信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用querypre_price().
	 *  
	 */
	@Action("querypre_pricebyId")
	public String querypre_pricebyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Pre_price a=new Pre_price();
		this.pre_price = (Pre_price) pre_priceDAO.findObjectById(id, a);
		
		if (totype == 1) return "updatepre_price";
		if (totype == 2) return "updatepre_account";
		return null;

	} 
	/**
	 * @author ane
	 *  充值预付款
	 */
	@Action("updatePre_price")
	public String updatePre_price() {
		if(this.pre_price!=null && this.price>0){
			float thisprice = this.pre_price.getPre_price();
			this.pre_price.setPre_price(thisprice+this.price);
			boolean  flag=pre_priceDAO.update(this.pre_price);
		    if(flag) { 
		    	Tranrecord t =new Tranrecord();
	        	t.setTrans_datetime(new Date());
	        	t.setType(1);//0:扣款，1：充值
	        	t.setTelphone(this.pre_price.getDrivertelphone());
	        	tranrecordDAO.insert(t);
		    	this.addActionMessage("充值成功");
		    }
			else{ this.addActionError("充值失败");}
		}
		
		return "updatepre_price";
	}
	/**
	 * @author ane
	 *  充值预付款
	 */
	@Action("updatePre_account")
	public String updatePre_account() {
		if(this.pre_price!=null){
			boolean  flag=pre_priceDAO.update(this.pre_price);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		return "updatepre_account";
	}

}
