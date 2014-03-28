package com.zdqk.laobing.action;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

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

import com.jtd.sms.SmsImpl;
import com.jtd.sms.SmsInterface;
import com.zdqk.laobing.action.vo.ResultVo;
import com.zdqk.laobing.dao.CouponDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.Coupon;
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
	private String username="jddlwl";
	private String password="jddlwl";
	
	@Autowired
	private UserDAO<User> userDAO;	
	@Autowired
	private ILoginService iLoginService;
	@Autowired
	private CouponDAO couponDAO;
	
	private Coupon coupon;
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
				Long num=Math.round(Math.random() * 100000);
				String content ="您申请注册会员，账户您申请注册会员，账户"+this.telphone+"，验证码："+num.toString()+"，谢谢！如非本人操作，请忽略本信息。【老兵代驾】"; 
				try {
					sendsms.sendmsg(username, password, this.telphone, content);
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					 rv = new ResultVo(7,"验证码发送失败");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					 rv = new ResultVo(7,"验证码发送失败");
				}
//				try {
//					SmsInterface s=SmsImpl.getInterface(this.Url);
//					System.out.println(s.getBalance("jddl", "jddl123"));
//					String mes=s.sendSms(this.username, this.password, this.telphone, content, "43");
//					System.out.println(s.getReport("jddl", "jddl123")); 
//					System.out.println(mes); 
//					 
//				} catch (MalformedURLException e) {
//					// TODO Auto-generated catch block
//					 rv = new ResultVo(7,"验证码发送失败");
//					 return FxJsonUtil.jsonHandle(rv,resutUrl,request);
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					 rv = new ResultVo(7,"验证码发送失败");
//					 return FxJsonUtil.jsonHandle(rv,resutUrl,request);
//				} catch (ServiceException e) {
//					// TODO Auto-generated catch block
//					 rv = new ResultVo(7,"验证码发送失败");
//					 return FxJsonUtil.jsonHandle(rv,resutUrl,request);
//				}
				User u=new User();
				u.setTelphone(this.telphone);
				u.setIsbind(0);
				u.setLogintime(new Date());
				u.setAskcode(num.toString());
				Coupon c= (Coupon) couponDAO.selectByuse();
				if (c!=null){
					u.setUse_code(c.getCoupon_num());
					u.setUseaskcode(0);
				}
				flag=userDAO.insert(u);
				if(flag){
					System.out.println("短信提交成功");
					rv = new ResultVo(2,"验证码发送成功");
					return FxJsonUtil.jsonHandle(rv,resutUrl,request);
				}else{
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
