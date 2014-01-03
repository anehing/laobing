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


import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.User;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "userList", location = "/userList.jsp"),
		})

public class UserAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserDAO userDAO;
	
	private User user;
	
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @author ane
	 *  查看手机端用户信息
	 */
	@Action("queryUser")
	public String queryUser() {
		User a = new User();
		Map<String, Object> map = this.getPmapNew();
		if(this.user!=null){
			if(user.getTelphone()!=null) map.put("telphone", user.getTelphone());
			if(user.getLogintime()!=null) map.put("logintime", user.getLogintime());
			}
		List<User> list = publicQuery(map, a, userDAO); 
		return "userList";
	}
	
}
