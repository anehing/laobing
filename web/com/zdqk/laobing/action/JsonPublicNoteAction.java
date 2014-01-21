package com.zdqk.laobing.action;


import java.util.ArrayList;
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
import com.zdqk.laobing.dao.PriceDAO;
import com.zdqk.laobing.dao.PublicNoteDAO;
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.dao.VersionDAO;
import com.zdqk.laobing.po.Price;
import com.zdqk.laobing.po.PublicNote;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.po.Version;
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
public class JsonPublicNoteAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private PublicNoteDAO publicnoteDAO;
	
    private int id;
    
    

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取公告
	 * */
	@Action("getPublicNote")
	public String getPublicNoteAction(){
		ResultVo rv = null;
		List<PublicNote> list= publicnoteDAO.selectAllByDesc();
	    if(list==null){
		    	rv = new ResultVo(1,"暂时没有公告");
		    	return FxJsonUtil.jsonHandle(rv,resutUrl,request);
	    	}else{
	    		List<com.zdqk.laobing.action.vo.PublicNote> listvo =new ArrayList<com.zdqk.laobing.action.vo.PublicNote>();
		    	com.zdqk.laobing.action.vo.PublicNoteList PublicNoteListvo = new com.zdqk.laobing.action.vo.PublicNoteList();
		    	for(PublicNote p:list){
		    		com.zdqk.laobing.action.vo.PublicNote po=new com.zdqk.laobing.action.vo.PublicNote();
		    		p.setContent(null);
		    		p.setCreatetime(null);
		    		BeanUtils.copyProperties(p,po);
		    		listvo.add(po);
		    	}
		    	PublicNoteListvo.setPublicnotelistvo(listvo);
		    	PublicNoteListvo.setReusltNumber(0);
		    	PublicNoteListvo.setReusltMessage("操作成功");
		    	return FxJsonUtil.jsonListHandle(PublicNoteListvo,resutUrl,request);
		    }
	}
	/**
	 * 获取公告内容详情
	 * */
	@Action("getPublicNoteById")
	public String getPublicNoteById(){
		ResultVo rv = null;
		if(this.id==0){
			rv = new ResultVo(1,"缺少参数id");
	    	return FxJsonUtil.jsonHandle(rv,resutUrl,request);
		}
		PublicNote p = (PublicNote) publicnoteDAO.selectAllById(this.id);
	    if(p==null){
		    	rv = new ResultVo(1,"公告内容获取失败，请稍后尝试");
		    	return FxJsonUtil.jsonHandle(rv,resutUrl,request);
	    	}else{
	    		com.zdqk.laobing.action.vo.PublicNote po=new com.zdqk.laobing.action.vo.PublicNote();
	    		p.setCreatetime(null);
		    	BeanUtils.copyProperties(p,po);
		    	po.setReusltNumber(0);
		 	    po.setReusltMessage("操作成功");
		 	   return FxJsonUtil.jsonHandle(po,resutUrl,request);
		    	}
	}
}
