package com.zdqk.laobing.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


import com.lfx.tools.Base64Utils;
import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.tools.ComStaticValue;
import com.zdqk.laobing.tools.DateConverter;




/**
 * @author ane
 *
 */
@Namespace("/base")
@ParentPackage("lfx-default")
@InterceptorRefs(value = { @InterceptorRef("annotationInterceptor"),
		@InterceptorRef("simpleStack") })
@Results({ @Result(name = "driverList", location = "/driverList.jsp"),
	       @Result(name = "updateDriver", location = "/updateDriver.jsp"),
	       @Result(name = "queryDriver", type = "chain", location = "queryDriver"),
	       @Result(name = "addDriver", location = "/addDriver.jsp"),
		})

public class DriverAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DriverDAO driverDAO;
	
	private Driver driver;
	private String batchFileName;
	private File myFile;
	
	

	
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getBatchFileName() {
		return batchFileName;
	}
	public void setBatchFileName(String batchFileName) {
		this.batchFileName = batchFileName;
	}

	@Autowired
	private Dmb_cityDAO dmb_cityDAO;
	
	
	private List<Dmb_city> dmb_citylist;
	
	
	 
	public List<Dmb_city> getDmb_citylist() {
		return dmb_citylist;
	}
	public void setDmb_citylist(List<Dmb_city> dmb_citylist) {
		this.dmb_citylist = dmb_citylist;
	}
	public Driver getdriver() {
		return driver;
	}
	public void setdriver(Driver driver) {
		this.driver = driver;
	}
	/**
	 * @author ane
	 *  查询司机信息
	 */
	@Action("queryDriver")
	public String querydriver() {
		this.dmb_citylist=getcity();
		Driver a = new Driver();
		Map<String, Object> map = this.getPmapNew();
		if(this.driver!=null){
			if(this.driver.getJob_status()!=3){
				map.put("job_status", this.driver.getJob_status());
			}
			if(!this.driver.getMc().equals("请选择")){
				map.put("mc", this.driver.getMc());
			}if(this.driver.getName()!=null&&!this.driver.getName().trim().equals("")){
				map.put("name", this.driver.getName());
			}if(this.driver.getTelphone()!=null&&!this.driver.getTelphone().trim().equals("")){
				map.put("telphone", this.driver.getTelphone());
			}
			if(this.driver.getSex()!=3){
				map.put("sex", this.driver.getSex());
			}
			if(this.driver.getIdent_num()!=null&&!this.driver.getIdent_num().trim().equals("")){
				map.put("ident_num", this.driver.getIdent_num());
			}
			if(this.driver.getDrive_card()!=null&&!this.driver.getDrive_card().trim().equals("")){
				map.put("drive_card", this.driver.getDrive_card());
			}
			if(this.driver.getServicefee()>0){
				map.put("drive_card", this.driver.getDrive_card());
			}if(this.driver.getDrive_card()!=null&&!this.driver.getDrive_card().trim().equals("")){
				map.put("drive_card", this.driver.getDrive_card());
			}	
			}
		List<Driver> list = publicQuery(map, a, driverDAO); 
		if (list != null && list.size() > 0) {
			for (Driver obj : list) {
			
					String host = ComStaticValue.init("host");
					obj.setPicture(host + "photo/" + obj.getPicture()  );
				
			}
		}
		return "driverList";
	}
	/**
	 * @author ane
	 *  根据账户ID修改司机信息totype==1表示修改，页面跳转到修改页面。
	 *  totype==2表示删除，删除后，自动调用querydriver().
	 *  
	 */
	@Action("queryDriverbyId")
	public String queryDriverbyId() {
		int id = 0;
		int totype = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
		Driver a=new Driver();
		this.driver = (Driver) driverDAO.findObjectById(id, a);
		
		if (totype == 1) {
			this.dmb_citylist=getcity();
			return "updateDriver";
		}
		if (totype == 2) {
			boolean flag;
		    flag=driverDAO.delete(this.driver);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryDriver";
		}
		
		return null;

	}
	/**
	 * @author ane
	 *  更新司机信息
	 */
	@Action("updateDriver")
	public String updatedriver() {
		this.dmb_citylist=getcity();
	
		if(this.driver!=null){
			if(!this.batchFileName.equals("000000.png")){
				this.driver.setPicture(this.getURL());
			}
			boolean  flag=driverDAO.update(this.driver);
		    if(flag)  this.addActionMessage("更新成功");
			else this.addActionError("更新失败");
		}
		
		return "updateDriver";
	}
	/**
	 * @author 
	 *  添加司机
	 */
	@Action("addDriver")
	public String addDriver() {
		this.dmb_citylist=getcity();
		if(this.driver!=null){
			if(!this.batchFileName.equals("000000.png")){
				this.driver.setPicture(this.getURL());
			}
			boolean  flag=driverDAO.insert(this.driver);
		    if(flag)  this.addActionMessage("新增成功");
			else this.addActionError("新增失败");
		}
			
			return "addDriver";
		
	}
	
	private List<Dmb_city> getcity(){
		Dmb_city a = new Dmb_city();
		Map<String, Object> map = this.getPmapNew();
		List<Dmb_city> list = publicQuery(map, a, dmb_cityDAO);
		return list;
	}
	private String getURL() {
		String saveFolder = ServletActionContext.getServletContext()
				.getRealPath("");
		String dstPath = saveFolder + "//photo//";
		File f = new File(saveFolder + "/photo");
		if (!f.exists()) {
			f.mkdirs();
		}
		if(batchFileName == null || batchFileName.lastIndexOf(".")==-1){
			return "";
		}
		String hzm = batchFileName
				.substring(batchFileName.lastIndexOf(".") + 1);
		String url = DateConverter.generateKeyId("") + "." + hzm;
		File file = new File(dstPath + url);
		Base64Utils.copy(this.myFile, file);
		return url;
	}
}
