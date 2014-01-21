package com.zdqk.laobing.action;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.zdqk.laobing.action.vo.ResultVo;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.service.ILoginService;
import com.zdqk.laobing.tools.FxJsonUtil;
import com.zdqk.laobing.tools.ValidateTools;
/**
 * @author：lfx
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results( {
		@Result(name = "UserJsonList", location = "/WEB-INF/json/json.jsp"),
		})
public class JsonUsersAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	private static String Url = "http://116.213.72.20/SMSHttpService/send.aspx";
	@Autowired
	private UserDAO<User> userDAO;	
	@Autowired
	private ILoginService iLoginService;	
	
	private User user;	
	private String telphone;
	private String askcode;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getTelphone() {
		return telphone;
	}


	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}


	public String getAskcode() {
		return askcode;
	}


	public void setAskcode(String askcode) {
		this.askcode = askcode;
	}


	/**
	 * 用户登陆接口
	 * 
	 * */
	@Action("loginJson")
	public String loginJsonAction(){

		ResultVo rv = null;
		if(this.telphone==null || this.telphone.trim().equals("") ){
			rv = new ResultVo(3,"缺少参数:telphone");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);			
		}else{
			Map<String, Object> loginUserMap = new HashMap<String, Object>();
			loginUserMap.put("telphone",this.telphone);
			loginUserMap.put("isbind",1);
			User userInfo= userDAO.findUserByTelphone(loginUserMap, "loginByTelphone");
			if(userInfo!=null){
				com.zdqk.laobing.action.vo.User u = new com.zdqk.laobing.action.vo.User();
				BeanUtils.copyProperties(userInfo,u);
				u.setUserIdStr(userInfo.getId()+"");
				u.setReusltNumber(0);
				u.setReusltMessage("操作成功");
				return FxJsonUtil.jsonHandle(u,resutUrl,request);
			}else{
				rv = new ResultVo(1,"此手机号码尚未注册验证");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
			}
		
	}
	/**
	 * 绑定手机借口
	 * 
	 * */
	@Action("bindTelphone")
	public String bindTelphoneAction(){
		boolean flag  = false;		
		ResultVo rv = null;
		if(this.telphone==null || this.telphone.trim().equals("")){
			rv = new ResultVo(5,"注册失败,参数错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			Map map = new HashMap();
			map.put("isbind",1);
			map.put("telphone",this.telphone);
			List<User> userList = publicQueryNoPage(map, new User(), userDAO);
			if(userList!=null && userList.size()>0){
				rv = new ResultVo(1,"该用户已存在,直接登陆，无需绑定");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);					
			}else{
				//发送验证码
				HttpClient client = new HttpClient();
				PostMethod method = new PostMethod(Url);
				// client.getParams().setContentCharset("GBK");
				client.getParams().setContentCharset("UTF-8");
				method.setRequestHeader("ContentType",
						"application/x-www-form-urlencoded;charset=UTF-8");
				Long num=Math.round(Math.random() * 100000);
				String content = new String("您的验证码是："+num.toString()+"。请不要把验证码泄露给其他人。");

				NameValuePair[] data = {// 提交短信
				new NameValuePair("username", "cf_aameimei"),
						new NameValuePair("password", "784533"),
						new NameValuePair("mobile", this.telphone),
						new NameValuePair("content", content), };
				method.setRequestBody(data);
				try {
					client.executeMethod(method);
					System.out.println(method.getResponseBodyAsString());
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					 rv = new ResultVo(7,"验证码发送失败");
					 return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					 rv = new ResultVo(7,"验证码发送失败");
					 return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}
				User u=new User();
				u.setTelphone(this.telphone);
				u.setIsbind(0);
				u.setAskcode(num.toString());
				flag=userDAO.insert(u);
				if(flag){
					System.out.println("短信提交成功");
					rv = new ResultVo(2,"验证码发送成功");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}
				else{
					rv = new ResultVo(7,"验证码发送失败");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}
			}
		}	
	}
	/**
	 * 验证短信码借口
	 * 
	 * */
	@Action("checkAskcode")
	public String checkAskcodeAction()	{
		boolean flag  = false;		
		ResultVo rv = null;
		if(this.askcode==null || this.askcode.trim().equals("")){
			rv = new ResultVo(5,"注册失败,参数错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		if(this.telphone==null || this.telphone.trim().equals("")){
			rv = new ResultVo(5,"注册失败,参数错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		Map map = new HashMap();
		map.put("isbind",0);
		map.put("telphone",this.telphone);
		map.put("askcode",this.askcode);
		List<User> userList = publicQueryNoPage(map, new User(), userDAO);
		if(userList!=null && userList.size()>0){
			User u=userList.get(0);
			u.setIsbind(1);
			flag=userDAO.update(u);
			if(flag){
				rv = new ResultVo(2,"验证成功");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}else{
				rv = new ResultVo(7,"验证失败");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);
			}
								
		}else{
			rv = new ResultVo(7,"验证失败");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
	}
}
