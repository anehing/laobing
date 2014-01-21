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
import com.zdqk.laobing.dao.UserDAO;
import com.zdqk.laobing.dao.VersionDAO;
import com.zdqk.laobing.po.Price;
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
public class JsonVersionAction extends JsonBaseAction {
	
	private static final long serialVersionUID = 1L;
	private static String resutUrl = "UserJsonList";	
	
	@Autowired
	private VersionDAO versionDAO;
	
    private int type;//0：用户，1：司机
    private String version;
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


	/**
	 * 检查版本信息
	 * */
	@Action("updateApp")
	public String updateAppAction(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		ResultVo rv = null;
		if(this.version==null){
			rv = new ResultVo(3,"缺少参数:version");
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);	
		}
		map.put("type",this.type);
	    Version version=(Version) versionDAO.updateApp(map, this.version);
	    if(version==null){
	    	if(this.type==1){
	    		rv = new ResultVo(1,"没有最新的司机版本");
	    	}else{
		    	rv = new ResultVo(1,"没有最新的用户版本");
	    	}
			return FxJsonUtil.jsonHandle(rv,resutUrl,request);
	    }else{
	    	com.zdqk.laobing.action.vo.Version vevo = new com.zdqk.laobing.action.vo.Version();	
	    	BeanUtils.copyProperties(version,vevo);
	    	vevo.setReusltNumber(0);
	    	vevo.setReusltMessage("有最新的版本可更新");
	    	return FxJsonUtil.jsonListHandle(vevo,resutUrl,request);
	    }
	}
}
