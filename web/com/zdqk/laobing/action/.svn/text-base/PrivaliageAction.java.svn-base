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
import com.zdqk.laobing.dao.PermissionDAO;
import com.zdqk.laobing.dao.UrlDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.po.Permission;
import com.zdqk.laobing.po.Url;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "privaliageList", location = "/privaliageList.jsp"),
	       @Result(name = "queryprivaliage", type = "chain", location = "queryprivaliage"),
		})

public class PrivaliageAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private UrlDAO urlDAO;
	@Autowired
	private PermissionDAO permissionDAO;
	private Admin admin;
	private List<Admin> adminlist; 
	private Url url;
	private List<Url> urllist; 
	private Permission permission;
	private String value;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Admin> getAdminlist() {
		return adminlist;
	}
	public void setAdminlist(List<Admin> adminlist) {
		this.adminlist = adminlist;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}
	public List<Url> getUrllist() {
		return urllist;
	}

	public void setUrllist(List<Url> urllist) {
		this.urllist = urllist;
	}
	
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	
	
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @author ane
	 *  设置权限
	 */
	@Action("queryprivaliage")
	public String queryprivaliageAction() {
		Admin a = new Admin();
		Url u = new Url();
		Map<String, Object> map =new HashMap();
		Map<String, Object> map2 = new HashMap();
		map.put("usertype", 0);
		this.adminlist = adminDAO.findObjects(map, a); //普通用户
		this.urllist = urlDAO.findObjects(map2, u);
		return "privaliageList";
	}
	
	/**
	 * @author ane
	 *  添加权限
	 */
	@Action("addprivaliage")
	public String addprivaliageAction() {
		if(this.permission!=null&&this.value!=null){
			String[] urlid =this.value.split(",");
			for(String id :urlid){
				this.permission.setUrlid(Integer.parseInt(id));
				permissionDAO.insert(this.permission);
			}
		}
		
		return "queryprivaliage";
	}
}
