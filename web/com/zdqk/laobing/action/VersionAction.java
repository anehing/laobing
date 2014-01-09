package com.zdqk.laobing.action;

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


import com.zdqk.laobing.dao.VersionDAO;
import com.zdqk.laobing.po.Price;
import com.zdqk.laobing.po.Version;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "versionList", location = "/versionList.jsp"),
	       @Result(name = "updateVersion", location = "/updateVersion.jsp"),
	       @Result(name = "queryVersion", type = "chain", location = "queryVersion"),
	       @Result(name = "addVersion", location = "/addVersion.jsp"),
		})

public class VersionAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private VersionDAO  versionDAO;
	
	private Version version;
	
	
	 

	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	/**
	 * @author ane
	 *  后台查询版本
	 */
	@Action("queryVersion")
	public String queryVersion() {
		Version a = new Version();
		Map<String, Object> map = this.getPmapNew();
		if(this.version!=null){
			if(version.getVersion()!=null&& !version.getVersion().trim().equals("")){
				map.put("version",version.getVersion());
				}
			if(version.getType()!=3){
				map.put("type", version.getType());
				}
			}
		List<Price> list = publicQuery(map, a, versionDAO); 
		return "versionList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改客户端信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用queryPrice().
	 *  
	 */
	@Action("queryVersionbyId")
	public String queryVersionbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Version a=new Version();
		this.version = (Version) versionDAO.findObjectById(id, a);
		
		if (totype == 1) return "updateVersion";
		if (totype == 2) {
			boolean flag;
		    flag=versionDAO.delete(this.version);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryVersion";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新版本信息
	 */
	@Action("updateVersion")
	public String updateVersion() {
		if(this.version!=null){
			this.version.setCreatetime(new Date());
			boolean  flag=versionDAO.update(this.version);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateVersion";
	}
	/**
	 * @author ane
	 *  添加后台价格
	 */
	@Action("addVersion")
	public String addVersion() {
		if(this.version!=null){
			this.version.setCreatetime(new Date());
			boolean  flag=versionDAO.insert(this.version);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addVersion";
		
	}
}
