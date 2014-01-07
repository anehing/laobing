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


import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.po.Driver;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "driverList", location = "/driverList.jsp"),
	       @Result(name = "updateDriver", location = "/driverList.jsp"),
	       @Result(name = "queryDriver", type = "chain", location = "queryDriver"),
	       @Result(name = "addDriver", location = "/addDriver.jsp"),
		})

public class DriverAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DriverDAO driverDAO;
	
	private Driver driver;
	
	
	
	
	 
	public Driver getdriver() {
		return driver;
	}
	public void setdriver(Driver driver) {
		this.driver = driver;
	}
	/**
	 * @author ane
	 *  查询司机信息
	 */
	@Action("queryDriver")
	public String querydriver() {
		Driver a = new Driver();
		Map<String, Object> map = this.getPmapNew();
		if(this.driver!=null){
			}
		List<Driver> list = publicQuery(map, a, driverDAO); 
		return "driverList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改司机信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用querydriver().
	 *  
	 */
	@Action("queryDriverbyId")
	public String queryDriverbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Driver a=new Driver();
		this.driver = (Driver) driverDAO.findObjectById(id, a);
		
		if (totype == 1) return "updateDriver";
		if (totype == 2) {
			boolean flag;
		    flag=driverDAO.delete(this.driver);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryDriver";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新司机信息
	 */
	@Action("updateDriver")
	public String updatedriver() {
		if(this.driver!=null){
			boolean  flag=driverDAO.update(this.driver);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateDriver";
	}
	/**
	 * @author ane
	 *  添加司机
	 */
	@Action("addDriver")
	public String addDriver() {
		if(this.driver!=null){
			boolean  flag=driverDAO.insert(this.driver);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addDriver";
		
	}
}
