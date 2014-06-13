package com.zdqk.laobing.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

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
import com.zdqk.laobing.dao.Customer_judge_driverDAO;
import com.zdqk.laobing.dao.Dmb_cityDAO;
import com.zdqk.laobing.dao.DriverDAO;
import com.zdqk.laobing.dao.Driver_orderDAO;
import com.zdqk.laobing.dao.Pre_priceDAO;
import com.zdqk.laobing.po.Customer_judge_driver;
import com.zdqk.laobing.po.Dmb_city;
import com.zdqk.laobing.po.Driver;
import com.zdqk.laobing.po.Pre_price;
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
	       @Result(name = "Driverdetil", location = "/driverDetil.jsp"),
	       @Result(name = "driverMap", location = "/driverMap.jsp"),
		})

public class DriverAction extends BasePaginationAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DriverDAO driverDAO;
	@Autowired
	private Pre_priceDAO pre_priceDAO;
	@Autowired
	private Driver_orderDAO driver_orderDAO;
	@Autowired
	private Customer_judge_driverDAO customer_judge_driverDAO;
	private Customer_judge_driver customer_judge_driver;
	private Pre_price pre_price;
	private Driver driver;
	private String batchFileName;
	private File myFile;
	private float price;
	private float yesfee;
	private float monthfee;
	private float allfee;
    private int score=0;
    private JSON driverlist;
    
    
	
	
	public JSON getDriverlist() {
		return driverlist;
	}
	public void setDriverlist(JSON driverlist) {
		this.driverlist = driverlist;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public float getYesfee() {
		return yesfee;
	}
	public void setYesfee(float yesfee) {
		this.yesfee = yesfee;
	}
	public float getMonthfee() {
		return monthfee;
	}
	public void setMonthfee(float monthfee) {
		this.monthfee = monthfee;
	}
	public float getAllfee() {
		return allfee;
	}
	public void setAllfee(float allfee) {
		this.allfee = allfee;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
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
			}
			if(this.driver.getName()!=null&&!this.driver.getName().trim().equals("")){
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
		Driver a=new Driver();
		try {
			id = Integer.parseInt(request.getParameter("id"));
			totype = Integer.parseInt(request.getParameter("totype"));
		} catch (Exception e) {
			System.out.print("数据异常");
		} 
	
		this.driver = (Driver) driverDAO.findObjectById(id, a);
		
		if (totype == 1) {
			this.dmb_citylist=getcity();
			return "updateDriver";
		}
		if (totype == 2) {
			boolean flag;
		    flag=driverDAO.delete(this.driver);
		    Map map = new HashMap();
		    map.put("drivername", driver.getName());
		    map.put("drivertelphone", driver.getTelphone());
		    Pre_price p = (Pre_price) pre_priceDAO.seletcbytel(map, "selectAll");
		    pre_priceDAO.delete(p);
		    if(flag)  this.addActionMessage("删除成功");
		    else this.addActionError("删除失败");
		    return "queryDriver";
		}if (totype == 3) {
			Map conditionMap =new HashMap();
			conditionMap.put("drivertelphone", this.driver.getTelphone());
			conditionMap.put("status", 1);
		
			this.yesfee = driver_orderDAO.selectyesincome(conditionMap, "selectyesincome");
			this.monthfee = driver_orderDAO.selectmonthincome(conditionMap, "selectmonthincome");
			this.allfee = driver_orderDAO.selectallincome(conditionMap,"selectallincome");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("drivertelphone", this.driver.getTelphone());
			Customer_judge_driver c =new Customer_judge_driver();
			long count = customer_judge_driverDAO.findObjectsPageCount(map, c);
			long sum = customer_judge_driverDAO.getscore(map);
			if(sum>0&&count>0){
				this.score = (int) (sum/count);
			}
			this.driver.setStars(this.score);
			driverDAO.update(this.driver);
		    return "Driverdetil";
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
			}else{
				this.driver.setPicture("000000.png");
			}
			if(this.price>0){
				Pre_price p =new Pre_price();
				p.setDrivername(this.driver.getName());
				p.setDrivertelphone(this.driver.getTelphone());
				p.setPre_price(this.price);
				pre_priceDAO.insert(p);//给司机添加预付款
			}
			this.driver.setStars(5);
			this.driver.setJob_status(1);
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
	/**
	 * @author ane
	 *  查询司机信息
	 */
	@Action("querydrivermap")
	public String querydrivermap() {
		Map<String, Object> map = new HashMap<String, Object>();
		List <Driver> list= driverDAO.selectByjobstatus(map, "selectByjobstatus2");
		driverlist = JSONSerializer.toJSON(list);  
		return "driverMap";
	}
}
