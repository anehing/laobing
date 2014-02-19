package com.zdqk.laobing.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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


import com.lfx.tools.DateConverter;
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
	private String logintime;
	
	private String tologintime;
	
	
	
	 
	public String getTologintime() {
		return tologintime;
	}
	public void setTologintime(String tologintime) {
		this.tologintime = tologintime;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @author ane
	 *  查看手机端用户信息
	 * @throws ParseException 
	 */
	@Action("queryUser")
	public String queryUser() throws ParseException {
		User a = new User();
		Map<String, Object> map = this.getPmapNew();
		if(this.user!=null){
			if(user.getTelphone()!=null) map.put("telphone", user.getTelphone());
		}
		if(this.logintime!=null&&!this.logintime.trim().equals("")&&this.tologintime!=null&&!this.tologintime.trim().equals("")){
			map.put("logintime", DateConverter.convertFromString(this.logintime));
			map.put("tologintime", DateConverter.convertFromString(this.tologintime));
		}
		List<User> list = publicQuery(map, a, userDAO); 
		return "userList";
	}
	
}
