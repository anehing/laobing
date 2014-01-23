package com.zdqk.laobing.action;



import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登陆
 * 
 */
import com.opensymphony.xwork2.ActionSupport;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.service.ILoginService;
import com.zdqk.laobing.tools.DateConverter;
import com.zdqk.laobing.tools.ValidateTools;

@Namespace("/lfx")
@ParentPackage("lfx-default")
@InterceptorRefs( { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("defaultStack") })
@Results( { @Result(name = "success", location = "/json/formResult.jsp"),
		@Result(name = "failed", location = "/json/formResult.jsp"),
		@Result(name = "logout", location = "/top.html"),
		@Result(name = "isexist", location = "/json/isexist.jsp"),
		@Result(name = "regUser", location = "/regUserByMobile.jsp"),
		@Result(name = "loginError", location = "/json/formResult.jsp") })

public class LoginAction extends ActionSupport{

	protected HttpSession session=null;
	
	protected HttpServletRequest request =null;
	
	protected HttpServletResponse response =null;	
	
	public LoginAction(){
		
		session=ServletActionContext.getRequest().getSession();
		
		response = ServletActionContext.getResponse();
		
		request = ServletActionContext.getRequest();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(LoginAction.class);

	private Admin adminInfo ;
	
	/**
	 * 帐号
	 */
	private String username;

	private String password;

	private String tmpImg ;
	
	
	@Autowired
	private ILoginService iLoginService;	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTmpImg() {
		return tmpImg;
	}

	public void setTmpImg(String tmpImg) {
		this.tmpImg = tmpImg;
	}
	
	
	/**
	 * 用户登录
	 */
	@Action("login")
	public String login() {
		String remoteAddr = request.getRemoteAddr();
		boolean flag = this.validateParam();
		if (!flag) {
			return "loginError";
		}
		String result = "failed";
		try{
			Map<String, Object> loginUserMap = new HashMap<String, Object>();
			loginUserMap.put("username", username);
			loginUserMap.put("password", password);	
			
			
			adminInfo = iLoginService.checkAdminByUsernameAndPassword(loginUserMap,"loginByUsernameAndPassword");// 用户名登陆
		} catch (Exception e) {
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "数据库链接异常，登录失败，请联系管理员");
			result = "failed";
			e.printStackTrace();
			return result;
		}	
		if(adminInfo!=null){
			if(adminInfo.getStatus()==1){
				session.setAttribute("result", false);
				session.setAttribute("error", "-1");
				request.setAttribute("message", "账户已被冻结或禁用，请联系管理员");
				return result;
			}
			// 登陆成功
			try {
				session.setAttribute("admin", adminInfo);
				session.setAttribute("result", true);
				session.setAttribute("error", "0");
				request.setAttribute("message", "登录成功");
	
				
				String tree=iLoginService.loadPopedomTree(adminInfo);
				session.setAttribute("tree", tree);//设置右边树的列表
				
			//	session.setAttribute("tree2", "<a href=\"base/queryAdmin.action\" target=\"main\">后台用户2管理</a>");//设置右边树的列表
				logger.info("登陆成功，正在转发 : ");
				result = "success";

			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		else {
			// 登陆失败
			logger.error("用户名或密码有误请重新输入");
			try {
				// ServletActionContext.getResponse().sendRedirect("/IcpProject_ISP/json/failed.jsp");
				session.setAttribute("result", false);
				session.setAttribute("error", "-1");
				request.setAttribute("message", "用户名或密码有误请重新输入");
				result = "failed";

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean validateParam() {
		String remoteAddr = request.getRemoteAddr();
		String mess="";
		boolean flag = true;

		String img = (String) session.getAttribute("vc");
		if(img==null){
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "请求非法，IP将被锁定");			
			return   false;  
		}
		tmpImg = tmpImg.toLowerCase();
		flag = ValidateTools.checkDateRange(new Date(), DateConverter.convertFromString("2014-12-31"+" 23:59:59",null));
        if(!flag){
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "系统已经被锁定或过期，请联系管理员");
			mess=remoteAddr+"系统已经被锁定或过期，请联系管理员";
			return   flag;      	
        }
		img = img.toLowerCase();
		if (!tmpImg.equals(img)) {
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "验证码错误！");
			mess=remoteAddr+"验证码错误";
			flag =false;
		}
		if (null == this.getUsername() || "".equals(this.getUsername())) {

			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "用户名不能为空！");
			mess+="  用户名不能为空";
			flag = false;
		}
		if (null == this.getPassword() || "".equals(this.getPassword())) {
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "密码不能为空！");
			mess+="  密码不能为空";
			flag = false;
		}
		if (null == this.getTmpImg() || "".equals(this.getTmpImg())) {
			
			session.setAttribute("result", false);
			session.setAttribute("error", "-1");
			request.setAttribute("message", "验证码不能为空！");
			mess+="  验证码不能为空";
			flag = false;
		}
        
		return flag;
	}


	/**
	 * 用户退出
	 */
	@Action("logout")
	public String logout() {
		adminInfo = (Admin)session.getAttribute("admin");
	
		session.invalidate();
		try {
			ServletActionContext.getResponse().sendRedirect("/laobing/login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "logout";
	}
	@Action("isExist")
	public String queryUserNameIsExist() {
		boolean  flag= true;
		
		if (null != this.getAdminInfo().getUsername() || !"".equals(this.getAdminInfo().getUsername())) {
			flag = iLoginService.queryUserNameIsExist(this.getAdminInfo().getUsername());
		}
		if(flag){
			request.setAttribute("message", "用户名可用");
		}else{
			request.setAttribute("message", "用户名已存在，不可用");
		}
		return "isexist";
	}

	/** 获取真实IP（通过代理服务器访问）	
	 * 
	 * @param request
	 * @return
	 */
	 public String getIpAddr(HttpServletRequest request) {
		 String ip = request.getHeader("x-forwarded-for");
		 if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			 ip = request.getHeader("Proxy-Client-IP");
		 }
		 if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			 ip = request.getHeader("WL-Proxy-Client-IP");
		 }
		 if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			 ip = request.getRemoteAddr();
		 }
		 return ip;
	 }

	public Admin getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(Admin adminInfo) {
		this.adminInfo = adminInfo;
	}


}
