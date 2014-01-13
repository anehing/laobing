package com.zdqk.laobing.action;

import java.text.ParseException;
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
import com.zdqk.laobing.dao.App_commentDAO;
import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.Version;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "app_commentList", location = "/app_commentList.jsp"),
	       @Result(name = "app_commentDetails", location = "/app_commentDetails.jsp"),
		})

public class App_commentAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private App_commentDAO app_commentDAO;
	
	private App_comment app_comment;
	
	
	
	 private String createtime;
	 private String tocreatetime;

		
		
		
		 
			
	 
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getTocreatetime() {
		return tocreatetime;
	}
	public void setTocreatetime(String tocreatetime) {
		this.tocreatetime = tocreatetime;
	}
	public App_comment getApp_comment() {
		return app_comment;
	}
	public void setApp_comment(App_comment app_comment) {
		this.app_comment = app_comment;
	}
	/**
	 * @author ane
	 *  查询反馈信息
	 * @throws ParseException 
	 */
	@Action("queryApp_comment")
	public String queryApp_comment() throws ParseException {
		App_comment a = new App_comment();
		Map<String, Object> map = this.getPmapNew();
		
			if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
				map.put("createtime", DateConverter.convertFromString(this.createtime));
				map.put("tocreatetime", DateConverter.convertFromString(this.tocreatetime));
			}
		List<App_comment> list = publicQuery(map, a, app_commentDAO); 
		return "app_commentList";
	}
	
	@Action("queryApp_commentbyId")
	public String queryApp_commentbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		App_comment a=new App_comment();
		this.app_comment = (App_comment) app_commentDAO.findObjectById(id, a);
		
		if (totype == 1){
			
			return "app_commentDetails";
			}
		
		
		return null;

	}
}
