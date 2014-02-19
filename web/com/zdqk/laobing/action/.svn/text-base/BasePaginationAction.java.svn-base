package com.zdqk.laobing.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zdqk.laobing.service.CommonService;
import com.zdqk.laobing.tools.Page;

/**
 * 分页 Action
 * 
 * @author lfx
 * 
 */
@SuppressWarnings("unchecked")
public class BasePaginationAction extends BasicAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private Map pmap = new HashMap();

	protected Page page = new Page();

	private long pageNo = 1L;
	
	
	@Autowired
	protected CommonService commonService;		

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@SuppressWarnings("rawtypes")
	public Map getPmapNew() {
		pmap.put("startIndex", Page.getStartOfPage((int) pageNo, page.getPageSize()));
		
		pmap.put("endIndex", page.getPageSize());

		return pmap;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	// ///////////////////////////

	// 请求页面页数
	public Integer pageNum;

	// 页面容纳数量
	public Integer pageLimit;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	@SuppressWarnings("rawtypes")
	public Map getPmap() {

		pmap.put("startIndex", this.pageNum * this.pageLimit + 1);
		pmap.put("endIndex", this.pageNum * this.pageLimit + this.pageLimit);

		return pmap;
	}
	@SuppressWarnings("rawtypes")
	public List publicQuery(Object conditionMap,Object obj,Object daoObject)
	{
		if(conditionMap==null){
			conditionMap = this.getPmapNew();
		}
		List list=null;
		List newlist=null;
		Long count=0L;
		try {
			list = commonService.queryObjects(conditionMap, obj, daoObject);
			count = commonService.queryObjectsCount(conditionMap, obj, daoObject);			
		} catch (Exception e) {
			e.printStackTrace();  
		}
		if(list!=null){
			System.out.println("list:"+list.size());
			System.out.println("count:"+count);
			newlist=new ArrayList();
			for(int i=0;i<list.size();i++){
				obj =list.get(i);
				newlist.add(obj);
			}
		}
		this.getPage().setData(newlist);	
		this.getPage().setTotalCount(count);
		if(conditionMap==null){
			return null;
		}		
		return newlist;
	}
	@SuppressWarnings("rawtypes")
	public List publicQueryNoPage(Object conditionMap,Object obj,Object daoObject)
	{
		if(conditionMap==null){
			conditionMap = this.getPmapNew();
		}
		List list=null;
		List newlist=null;
		try {
			list = commonService.queryObjectsNoPage(conditionMap,obj,daoObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null){
			System.out.println("list:"+list.size());
			newlist=new ArrayList();
			for(int i=0;i<list.size();i++){
				obj =list.get(i);
				newlist.add(obj);
			}
		}
		this.getPage().setData(newlist);	
		if(conditionMap==null){
			return null;
		}		
		return newlist;
	}
	@SuppressWarnings("rawtypes")
	public List publicQueryNoPageTwo(Object conditionMap,Object obj,Object daoObject)
	{
		if(conditionMap==null){
			conditionMap = this.getPmapNew();
		}
		List list=null;
		List newlist=null;
		try {
			list = commonService.queryObjectsNoPage(conditionMap,obj,daoObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null){
			System.out.println("list:"+list.size());
			newlist=new ArrayList();
			for(int i=0;i<list.size();i++){
				obj =list.get(i);
				newlist.add(obj);
			}
		}	
		return newlist;
	}	
	public boolean insertOrUpdate(List<Object> list, Object daoObject)
	{
		boolean flag=true;
		try {
			
			commonService.doBaseInfoCheckIn(list, daoObject);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}	
}
