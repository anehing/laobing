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


import com.zdqk.laobing.dao.App_commentDAO;
import com.zdqk.laobing.po.App_comment;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "app_commentList", location = "/app_commentList.jsp"),
		})

public class App_commentAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private App_commentDAO app_commentDAO;
	
	private App_comment app_comment;
	
	
	
	
	 
	public App_comment getApp_comment() {
		return app_comment;
	}
	public void setApp_comment(App_comment app_comment) {
		this.app_comment = app_comment;
	}
	/**
	 * @author ane
	 *  查询反馈信息
	 */
	@Action("queryApp_comment")
	public String queryApp_comment() {
		App_comment a = new App_comment();
		Map<String, Object> map = this.getPmapNew();
		if(this.app_comment!=null){
			}
		List<App_comment> list = publicQuery(map, a, app_commentDAO); 
		return "app_commentList";
	}
	
}
