package com.zdqk.laobing.action;

import java.util.HashMap;
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


import com.zdqk.laobing.dao.AdminDAO;
import com.zdqk.laobing.po.Admin;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "adminList", location = "/adminList.jsp"),
	       @Result(name = "updateAdmin", location = "/updateAdmin.jsp"),
	       @Result(name = "queryAdmin", type = "chain", location = "queryAdmin"),
	       @Result(name = "addAdmin", location = "/addAdmin.jsp"),
		})

public class AdminAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AdminDAO adminDAO;
	
	private Admin admin;
	 
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	/**
	 * @author ane
	 *  查询后台账户
	 */
	@Action("queryAdmin")
	public String queryAdmin() {
		Admin a = new Admin();
		Map<String, Object> map = this.getPmapNew();
		if(admin!=null){
			if(admin.getUsername()!=null&& !admin.getUsername().trim().equals("")){
				map.put("username",admin.getUsername());
				}
			if(admin.getStatus()!=3){
				map.put("status", admin.getStatus());
				}
			if(admin.getUsertype()!=3){
				map.put("usertype", admin.getUsertype());
				}
			}
		List<Admin> list = publicQuery(map, a, adminDAO); 
		return "adminList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改后台账户信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用queryAdmin().
	 *  
	 */
	@Action("queryAdminbyId")
	public String queryAdminbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Admin a=new Admin();
		this.admin = (Admin) adminDAO.findObjectById(id, a);
		
		if (totype == 1) return "updateAdmin";
		if (totype == 2) {
			boolean flag;
		    flag=adminDAO.delete(this.admin);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    this.admin=null;
		    return "queryAdmin";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新后台账户
	 */
	@Action("updateAdmin")
	public String updateAdmin() {
		if(this.admin!=null){
			boolean  flag=adminDAO.update(this.admin);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateAdmin";
	}
	/**
	 * @author ane
	 *  添加后台账户
	 */
	@Action("addAdmin")
	public String addAdmin() {
		if(this.admin!=null){
			Map map=new HashMap();
			map.put("username", admin.getUsername());
	    	Admin a= (Admin) adminDAO.findAdminByUsernameAndPassword(map, "loginByUsernameAndPassword");
		    if(a!=null){
		    	this.addActionError("用户名已存在");
		    	return "addAdmin";
		    }
			boolean  flag=adminDAO.insert(this.admin);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addAdmin";
		
	}
}
