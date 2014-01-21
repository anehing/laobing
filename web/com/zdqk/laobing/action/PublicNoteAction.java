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
import com.zdqk.laobing.dao.App_commentDAO;
import com.zdqk.laobing.dao.PublicNoteDAO;
import com.zdqk.laobing.po.App_comment;
import com.zdqk.laobing.po.PublicNote;
import com.zdqk.laobing.po.Twitter;
import com.zdqk.laobing.po.Version;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "addPublicNote", location = "/addPublicNote.jsp"),
	       @Result(name = "publicNoteList", location = "/publicNoteList.jsp"),
	       @Result(name = "queryPublicNote", type = "chain", location = "queryPublicNote"),
	       @Result(name = "publicNoteDetail", location = "/publicNoteDetail.jsp"),
	       @Result(name = "updatePublicNote", location = "/updatePublicNote.jsp"),
		})

public class PublicNoteAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PublicNoteDAO publicnoteDAO;
	
	private PublicNote publicnote;
	
    private String createtime;
	private String tocreatetime;

	
	public PublicNote getPublicnote() {
		return publicnote;
	}

	public void setPublicnote(PublicNote publicnote) {
		this.publicnote = publicnote;
	}

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

	/**
	 * @author ane
	 *  查询公告信息
	 * 
	 */
	
	@Action("queryPublicNote")
	public String queryPublicNote() throws ParseException {
		PublicNote p = new PublicNote();
		Map<String, Object> map = this.getPmapNew();
		if(publicnote!=null){
			if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
				map.put("createtime", DateConverter.convertFromString(this.createtime));
				map.put("tocreatetime", DateConverter.convertFromString(this.tocreatetime));
			}
		}
			List<PublicNote> list = publicQuery(map, p, publicnoteDAO); 
			return "publicNoteList";
		}
	/**
	 * @author ane
	 *  添加公告信息
	 */
	@Action("addPublicNote")
	public String addPublicNote() {
		if(this.publicnote!=null){
			SimpleDateFormat sdFormat = new SimpleDateFormat("MM-dd HH:mm");
			Date current = new Date();
			publicnote.setAppshowdate(sdFormat.format(current));
			publicnote.setCreatetime(current);
			boolean  flag=publicnoteDAO.insert(this.publicnote);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addPublicNote";
		
	}
	/**
	 * @author ane
	 *  根据账户ID修改推送信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用queryPublicNote().
	 *  totype==3表示详情
	 *  
	 */
	@Action("queryPublicNotebyId")
	public String queryPublicNotebyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		PublicNote a=new PublicNote();
		this.publicnote = (PublicNote) publicnoteDAO.findObjectById(id, a);

		if (totype == 1) {
			return "updatePublicNote";
		}
		if (totype == 3) {
			return "publicNoteDetail";
		}
		if (totype == 2) {
			boolean flag;
		    flag=publicnoteDAO.delete(this.publicnote);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryPublicNote";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新推送信息
	 */
	@Action("updatePublicNote")
	public String updatePublicNote() {
		if(this.publicnote!=null){
			SimpleDateFormat sdFormat = new SimpleDateFormat("MM-dd HH:mm");
			Date current = new Date();
			publicnote.setAppshowdate(sdFormat.format(current));
			this.publicnote.setCreatetime(current);
			boolean  flag=publicnoteDAO.update(this.publicnote);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updatePublicNote";
	}
}
