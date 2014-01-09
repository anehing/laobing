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


import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.TwitterDAO;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Twitter;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "twitterList", location = "/twitterList.jsp"),
	       @Result(name = "updateTwitter", location = "/twitterList.jsp"),
	       @Result(name = "queryTwitter", type = "chain", location = "queryTwitter"),
	       @Result(name = "addTwitter", location = "/addTwitter.jsp"),
		})

public class TwitterAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TwitterDAO twitterDAO;
	@Autowired
	private Dmb_cityDAO dmb_cityDAO;
	
	private Twitter twitter;
	
	private List<Dmb_city> dmb_citylist;
	
	
	
	
	 
	public List<Dmb_city> getDmb_citylist() {
		return dmb_citylist;
	}
	public void setDmb_citylist(List<Dmb_city> dmb_citylist) {
		this.dmb_citylist = dmb_citylist;
	}
	public Twitter getTwitter() {
		return twitter;
	}
	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}
	/**
	 * @author ane
	 *  查询推送信息
	 */
	@Action("queryTwitter")
	public String queryTwitter() {
		this.dmb_citylist=getcity();
		Twitter a = new Twitter();
		Map<String, Object> map = this.getPmapNew();
		if(twitter!=null){
			if(twitter.getType()!=3){
				map.put("type", twitter.getType());
				}
			if(twitter.getSendtype()!=3){
				map.put("sendtype", twitter.getSendtype());
				}
			if(twitter.getCreatetime()!=null){
				map.put("createtime", twitter.getCreatetime());
				}
			if(!twitter.getMc().equals("mc")){
				map.put("mc", twitter.getMc());
				}
			}
		List<Twitter> list = publicQuery(map, a, twitterDAO); 
		return "twitterList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改推送信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用queryTwitter().
	 *  
	 */
	@Action("queryTwitterbyId")
	public String queryTwitterbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Twitter a=new Twitter();
		this.twitter = (Twitter) twitterDAO.findObjectById(id, a);
		
		if (totype == 1) {
			this.dmb_citylist=getcity();
			return "updateTwitter";
		}
		if (totype == 2) {
			boolean flag;
		    flag=twitterDAO.delete(this.twitter);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryTwitter";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新推送信息
	 */
	@Action("updateTwitter")
	public String updateTwitter() {
		this.dmb_citylist=getcity();
		if(this.twitter!=null){
			this.twitter.setCreatetime(new Date());
			boolean  flag=twitterDAO.update(this.twitter);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateTwitter";
	}
	/**
	 * @author ane
	 *  添加推文
	 */
	@Action("addTwitter")
	public String addTwitter() {
		this.dmb_citylist=getcity();
		if(this.twitter!=null){
			this.twitter.setCreatetime(new Date());
			boolean  flag=twitterDAO.insert(this.twitter);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addTwitter";
		
	}
	
	private List<Dmb_city> getcity(){
		Dmb_city a = new Dmb_city();
		Map<String, Object> map = this.getPmapNew();
		List<Dmb_city> list = publicQuery(map, a, dmb_cityDAO);
		return list;
	}
}
