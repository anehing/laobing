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
		@Result(name = "JsonUpdateUser", location = "/JsonUpdateUser.jsp"),
		})
public class JsonUsersAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private UserDAO<User> userDAO;	
	@Autowired
	private ILoginService iLoginService;	
	
	private User user;	
	private String telphone;
	
	
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


	/**
	 * 登陆接口
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
		if(this.user==null || !ValidateTools.checkNull(user.getTelphone())){
			rv = new ResultVo(1,"注册失败,参数错误");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			Map map = new HashMap();
			map.put("telphone", user.getTelphone());
			List<User> userList = publicQueryNoPage(map, new User(), userDAO);
			if(userList!=null && userList.size()>0){
				rv = new ResultVo(1,"该用户已存在,直接登陆，无需绑定");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);					
			}else{
				//发送验证码
			}
			
		}	
			
		return null;	
		
		
	}
}
