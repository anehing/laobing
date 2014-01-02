package com.zdqk.laobing.action;



import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.po.UserLog;
import com.zdqk.laobing.service.UsersService;
import com.zdqk.laobing.tools.DateConverter;

/**
 * 
 * 此类通过统一方法进行访问鉴权及审计
 * 
 * @category 鉴权及审计
 * 
 */

public class BasicAction extends ActionSupport {
	
	private static final long serialVersionUID = -6218505502426151011L;

	protected final Log logger = LogFactory.getLog(getClass());
	
	protected HttpSession session=null;
	
	protected HttpServletRequest request =null;
	
	protected HttpServletResponse response =null;
	
	@Autowired
	protected UsersService usersService;
	
	protected UserLog log=null;
	
	protected User basicUser=null;
	

	private void loadSession(){
		
		session=ServletActionContext.getRequest().getSession();
		
		response = ServletActionContext.getResponse();
		
		request = ServletActionContext.getRequest();
		 
		
	}

	//验证访问权限
	
	@Before	
	public void verifyPermissions(){

		System.out.println("验证权限已经开启");
		
		loadSession();
		if(session.getAttribute("user")!=null){
			basicUser =(User)session.getAttribute("user");
			System.out.println("检测到用户"+basicUser.getUserName()+"登录成功");
		}
		else	
		{
			System.out.println("检测到用户未登录，进行操作");
			try {
				ServletActionContext.getResponse().sendRedirect("/laobing/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//记录审计日志
	
	@After
	public void auditLog(){

		System.out.println("用户操作日志开启");
		
		if(log!=null){
			if(basicUser == null){
				try {
					ServletActionContext.getResponse().sendRedirect("/laobing/login.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			log.setOperadate(new Date());
			log.setOptdate(new Date());
			log.setIsWorking(1L);
			log.setIp(getIpAddr(request));
			try {
				if(usersService.addUserLog(log)){
					System.out.println("记录成功");
				}else{
					System.out.println("记录失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("time"+DateConverter.toDateString(new Date())+"["+basicUser.getUserName()+"]");
			
		}	
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
//		Enumeration e= request.getParameterNames();
//		while(e.hasMoreElements()){
//			System.out.println(e.nextElement());
//		}
		printRequest(request);
		 return ip;
	 }	
	 private void printRequest(HttpServletRequest request) { 
		 StringBuilder sb = new StringBuilder("request----"); 
		 sb.append("servletPath:").append(request.getServletPath()).append("\n");; 
		 sb.append("servletPort:").append(request.getServerPort()).append("\n");; 
		 sb.append("serverName:").append(request.getServerName()).append("\n");; 
		 sb.append("scheme:").append(request.getScheme()).append("\n");; 
		 sb.append("requestUrl:").append(request.getRequestURL().toString()).append("\n"); 
		 sb.append("requestUri:").append(request.getRequestURI()).append("\n");; 
		 sb.append("RequestedSessionId:").append(request.getRequestedSessionId()).append("\n");; 
		 sb.append("remoteUser:").append(request.getRemoteUser()).append("\n");; 
		 sb.append("authType:").append(request.getAuthType()).append("\n");; 
		 sb.append("characterEncoding:").append(request.getCharacterEncoding()).append("\n");; 
		 sb.append("contentLength:").append(request.getContentLength()).append("\n");; 
		 sb.append("contentType:").append(request.getContentType()).append("\n");; 
		 sb.append("contextPath:").append(request.getContextPath()).append("\n");; 
		 sb.append("method:").append(request.getMethod()).append("\n");; 
		 sb.append("pathInfo:").append(request.getPathInfo()).append("\n");; 
		 sb.append("pathTranslated:").append(request.getPathTranslated()).append("\n");; 
		 sb.append("protocol:").append(request.getProtocol()).append("\n");; 
		 sb.append("queryString:").append(request.getQueryString()).append("\n");; 
		 sb.append("remoteAddr:").append(request.getRemoteAddr()).append("\n");;  
//		 System.out.println(sb.toString()); 
		 } 


}
