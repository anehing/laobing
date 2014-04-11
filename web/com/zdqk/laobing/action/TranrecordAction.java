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
import com.zdqk.laobing.dao.TranrecordDAO;
import com.zdqk.laobing.po.Tranrecord;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "tranrecordList", location = "/tranrecordList.jsp"),
	@Result(name = "tranrecord", location = "/tranrecord.jsp"),
		})

public class TranrecordAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TranrecordDAO tranrecordDAO;
	
	private Tranrecord tranrecord;
	private float account;
	

	private String createtime;
	private String tocreatetime;
	private Date create_time;
	private Date tocreate_time;
	
	
	
	
	 
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getTocreate_time() {
		return tocreate_time;
	}
	public void setTocreate_time(Date tocreate_time) {
		this.tocreate_time = tocreate_time;
	}
	public float getAccount() {
		return account;
	}
	public void setAccount(float account) {
		this.account = account;
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
	public Tranrecord gettranrecord() {
		return tranrecord;
	}
	public void settranrecord(Tranrecord tranrecord) {
		this.tranrecord = tranrecord;
	}
	/**
	 * @author ane
	 *  查询交易信息
	 * @throws ParseException 
	 */
	@Action("queryTranrecord")
	public String querytranrecord() throws ParseException {
		Tranrecord a = new Tranrecord();
		Map<String, Object> map = this.getPmapNew();
		if(this.tranrecord!=null){
			if(this.tranrecord.getTelphone()!=null&&!this.tranrecord.getTelphone().trim().equals("")){
				map.put("telphone",this.tranrecord.getTelphone());
			}if(this.tranrecord.getType()!=3){
				map.put("type",this.tranrecord.getType());
			}
		}
			if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
				map.put("trans_datetime", df.parse(this.createtime));
				map.put("totrans_datetime", df.parse(this.tocreatetime));
			}
		List<Tranrecord> list = publicQuery(map, a, tranrecordDAO); 
		return "tranrecordList";
	}
	/**
	 * @author ane
	 *  平台收入
	 * @throws ParseException 
	 */
	@Action("querytranrecordmoney")
	public String querytranrecordmoney() throws ParseException {
		Tranrecord a = new Tranrecord();
		Map<String, Object> map = this.getPmapNew();
			if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
				map.put("trans_datetime", df.parse(this.createtime));
				map.put("totrans_datetime", df.parse(this.tocreatetime));
			}
			map.put("type", 0);
		 this.account=	tranrecordDAO.selectmoney(map, "selectmoney");
		return "tranrecord";
	}
	
	
}
