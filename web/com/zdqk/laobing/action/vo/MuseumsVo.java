package com.zdqk.laobing.action.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class MuseumsVo extends ResultVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long pageIndex;
	private Long pageSize;
	private Long groupId;
    private List<Museums> museumsList;
    private List<Groups> groupsList;
	public MuseumsVo(Long pageIndex, Long pageSize, Long groupId) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.groupId = groupId;
	}
	public MuseumsVo() {
	}	
	public Long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public List<Museums> getMuseumsList() {
		return museumsList;
	}
	public void setMuseumsList(List<Museums> museumsList) {
		this.museumsList = museumsList;
	}
	public List<Groups> getGroupsList() {
		return groupsList;
	}
	public void setGroupsList(List<Groups> groupsList) {
		this.groupsList = groupsList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MuseumsVo museumsVo =new  MuseumsVo(1L,20L,null);	
		
		   List<Groups> groupsList = new ArrayList<Groups>();
		   Groups g = new Groups(1L,"�ۺ���",null);
		   groupsList.add(g);
		   g = new Groups(2L,"������",null);
		   groupsList.add(g);
		   g = new Groups(3L,"ר����",null);
		   groupsList.add(g);
		   g = new Groups(4L,"��ַ��",null);
		   groupsList.add(g);	
		   museumsVo.setGroupsList(groupsList);
		   
		   List<Museums> museumsList = new ArrayList<Museums>();
		   Museums m = new Museums(10L, "�й����", "chineseMuseums","�й���ݽ���", "http://www.baidu.com/a.jpg");
		   museumsList.add(m);
		   m = new Museums(11L, "�Ͼ������", "nanjingMuseums","�Ͼ�����ݽ���", "http://www.baidu.com/b.jpg");
		   museumsList.add(m);		   
		   
		   museumsVo.setMuseumsList(museumsList);
		   JSONObject json = JSONObject.fromObject(museumsVo);  
           System.out.println(json.toString());  
	} 
}