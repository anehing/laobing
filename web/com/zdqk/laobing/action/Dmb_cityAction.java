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
import com.zdqk.laobing.po.Dmb_city;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "dmb_cityList", location = "/dmb_cityList.jsp"),
	       @Result(name = "updateDmb_city", location = "/dmb_cityList.jsp"),
	       @Result(name = "queryDmb_city", type = "chain", location = "queryDmb_city"),
	       @Result(name = "addDmb_city", location = "/addDmb_city.jsp"),
		})

public class Dmb_cityAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Dmb_cityDAO dmb_cityDAO;
	
	private Dmb_city dmb_city;
	 
	public Dmb_city getdmb_city() {
		return dmb_city;
	}

	public void setdmb_city(Dmb_city dmb_city) {
		this.dmb_city = dmb_city;
	}
	/**
	 * @author ane
	 *  查询城市信息
	 */
	@Action("querydmb_city")
	public String querydmb_city() {
		Dmb_city a = new Dmb_city();
		Map<String, Object> map = this.getPmapNew();
		if(this.dmb_city!=null){
			
			}
		List<Dmb_city> list = publicQuery(map, a, dmb_cityDAO); 
		return "dmb_cityList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改城市信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用querydmb_city().
	 *  
	 */
	@Action("queryDmb_citybyId")
	public String queryDmb_citybyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Dmb_city a=new Dmb_city();
		this.dmb_city = (Dmb_city) dmb_cityDAO.findObjectById(id, a);
		
		if (totype == 1) return "updateDmb_city";
		if (totype == 2) {
			boolean flag;
		    flag=dmb_cityDAO.delete(this.dmb_city);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryDmb_city";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新城市信息
	 */
	@Action("updateDmb_city")
	public String updateDmb_city() {
		if(this.dmb_city!=null){
			boolean  flag=dmb_cityDAO.update(this.dmb_city);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateDmb_city";
	}
	/**
	 * @author ane
	 *  添加后台账户
	 */
	@Action("addDmb_city")
	public String addDmb_city() {
		if(this.dmb_city!=null){
			boolean  flag=dmb_cityDAO.insert(this.dmb_city);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addDmb_city";
		
	}
}
