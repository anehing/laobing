package com.zdqk.laobing.action;


import java.util.ArrayList;
import java.util.Date;
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
import com.zdqk.laobing.dao.App_commentDAO;
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.Price;
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
public class JsonAppCommentAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private App_commentDAO app_commentDAO;
	
    private String comment;
    private String email;
    private String telphone;
    private int type;//0:用户，1：司机
    
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * 意见反馈接口
	 * */
	@Action("commentMyApp")
	public String commentMyAppAction(){
		ResultVo rv = null;
		if(this.comment==null||this.comment.trim().equals("")){
			rv = new ResultVo(3,"请填写评论");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		Date date=new Date();
		App_comment app_comment=new App_comment();
		app_comment.setComment(this.comment);
		app_comment.setCreatetime(date);
		app_comment.setTelphone(this.telphone);
		if(this.type==0){
			if(this.email==null||this.email.trim().equals("")){
				rv = new ResultVo(3,"请填写邮箱");
				return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
			}else{
				app_comment.setEmail(this.email);
			}
		}
		boolean flag= app_commentDAO.insert(app_comment);
		if(flag){
			rv = new ResultVo(0,"发送成功");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}else{
			rv = new ResultVo(1,"发送失败，请稍后尝试");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
			
		
	}
}
