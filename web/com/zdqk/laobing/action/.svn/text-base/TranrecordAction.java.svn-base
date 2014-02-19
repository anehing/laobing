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
		})

public class TranrecordAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TranrecordDAO tranrecordDAO;
	
	private Tranrecord tranrecord;
	

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
			if(this.createtime!=null&&!this.createtime.trim().equals("")&&this.tocreatetime!=null&&!this.tocreatetime.trim().equals("")){
				map.put("createtime", DateConverter.convertFromString(this.createtime));
				map.put("tocreatetime", DateConverter.convertFromString(this.tocreatetime));
			}
		List<Tranrecord> list = publicQuery(map, a, tranrecordDAO); 
		return "tranrecordList";
	}
	
	
}
