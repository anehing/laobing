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
	       @Result(name = "updateAdmin", location = "/updateUserPass.jsp"),
	       @Result(name = "queryAdmin", type = "chain", location = "queryAdmin"),
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
		
		Admin admin = new Admin();
		admin = (Admin) adminDAO.findObjectById(id, admin);
		request.setAttribute("admin", admin);
		
		if (totype == 1) return "updateAdmin";
		if (totype == 2) {
			boolean flag;
		    flag=adminDAO.delete(id);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryAdmin";
		}
		
		return null;

	}
	
}
