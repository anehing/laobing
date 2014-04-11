package com.zdqk.laobing.action;

import java.text.ParseException;
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


import cn.jpush.api.JPushClient;
import cn.jpush.api.MessageResult;

import com.lfx.tools.DateConverter;
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
	       @Result(name = "twitterDetail", location = "/twitterDetail.jsp"),
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
	
    private String createtime;
	private String tocreatetime;
    
	private String masterSecret = "0777d1b54666a10bd10d7b2f";
	private String appKey= "69ea07bcd736023af6ed3b3c";
	private String masterSecret2 = "16179aea482826a58dd889db";
	private String appKey2= "4ab161c79f28a9f58834e8eb";
	private  JPushClient jpush = null;

    public static final int MAX = Integer.MAX_VALUE;
    public static final int MIN = MAX/2;
	
	
	 
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
	 * @throws ParseException 
	 */
	@Action("queryTwitter")
	public String queryTwitter() throws ParseException {
		this.dmb_citylist=getcity();
		Twitter a = new Twitter();
		Map<String, Object> map = this.getPmapNew();
		if(twitter!=null){
			if(!twitter.getMc().equals("mc")){
				map.put("mc", twitter.getMc());
				map.put("sendtype", 1);
				}
			}
		
		if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
			map.put("createtime", DateConverter.convertFromString(this.createtime));
			map.put("tocreatetime", DateConverter.convertFromString(this.tocreatetime));
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
			return "twitterDetail";
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
			Jpush(twitter);
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
	private void Jpush(Twitter twitter){

		// 对android和ios设备发送
		if(twitter.getSource()==0){
			 jpush = new JPushClient(masterSecret, appKey);
		}else{
			jpush = new JPushClient(masterSecret2, appKey2);
		}
		
		 int sendNo = getRandomSendNo();// 在实际业务中，建议 sendNo 是一个你自己的业务可以处理的一个自增数字。
		 String tag = twitter.getMc();
		 String msgTitle = "";
		 String msgContent = twitter.getContent();
		 MessageResult result =null;
		 if (tag.equals("0")){
			  result = jpush.sendNotificationWithAppKey(sendNo, msgTitle, msgContent);
		 }else{
			  result = jpush.sendNotificationWithTag(sendNo, tag, msgTitle, msgContent);
		 }
		
	}
	/**
	 * 保持 sendNo 的唯一性是有必要的
	 * It is very important to keep sendNo unique.
	 * @return sendNo
	 */
	public static int getRandomSendNo() {
	    return (int) (MIN + Math.random() * (MAX - MIN));
	}
	 
}
