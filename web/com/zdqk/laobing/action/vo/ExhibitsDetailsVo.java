package com.zdqk.laobing.action.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

public class ExhibitsDetailsVo extends ResultVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long exhibitId;	
	private String chineseName;	
	private String englishName;	
	private String groupName;	
	private String specification;
	private String period;	
	private String qualityGroupName;		
	private String useGroupName;	
	private String assistantGroupName;		
	private String museumName;
	private String chineseIntroduction;	
	private String englishIntroduction;		
	private String exhibitPhtoUrl;
	
	private List<Photos> photoList;
	private List<Comments> commentsList;	
	
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}

	public String getQualityGroupName() {
		return qualityGroupName;
	}
	public void setQualityGroupName(String qualityGroupName) {
		this.qualityGroupName = qualityGroupName;
	}

	public String getUseGroupName() {
		return useGroupName;
	}
	public void setUseGroupName(String useGroupName) {
		this.useGroupName = useGroupName;
	}

	public String getAssistantGroupName() {
		return assistantGroupName;
	}
	public void setAssistantGroupName(String assistantGroupName) {
		this.assistantGroupName = assistantGroupName;
	}

	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public String getChineseIntroduction() {
		return chineseIntroduction;
	}
	public void setChineseIntroduction(String chineseIntroduction) {
		this.chineseIntroduction = chineseIntroduction;
	}
	public String getEnglishIntroduction() {
		return englishIntroduction;
	}
	public void setEnglishIntroduction(String englishIntroduction) {
		this.englishIntroduction = englishIntroduction;
	}
	public List<Photos> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<Photos> photoList) {
		this.photoList = photoList;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {	
		
		ExhibitsDetailsVo exhibitsDetailsVo =new  ExhibitsDetailsVo("��ͭ��","qing tong dun");	
		exhibitsDetailsVo.setExhibitId(2L);
		exhibitsDetailsVo.setGroupName("��ͭ��");
		exhibitsDetailsVo.setSpecification("��100���ף���200����");
		exhibitsDetailsVo.setPeriod("ս��");
		exhibitsDetailsVo.setQualityGroupName("ͭ��");
		exhibitsDetailsVo.setUseGroupName("��ʳ��");
		exhibitsDetailsVo.setAssistantGroupName("��ʳ��");
		exhibitsDetailsVo.setMuseumName("�й����");
		exhibitsDetailsVo.setEnglishIntroduction("english  dfdfdsfdfdsfdsffdsfds");
		exhibitsDetailsVo.setChineseIntroduction("���Ľ���");
	   List<Photos> photoList = new ArrayList<Photos>();
	   Photos photos = new Photos(1L,"www.baidu.com/1.jpg");
	   photoList.add(photos);		
	   photos = new Photos(2L,"www.baidu.com/2.jpg");
	   photoList.add(photos);		   
	   photos = new Photos(3L,"www.baidu.com/3.jpg");
	   photoList.add(photos);		   
	   photos = new Photos(4L,"www.baidu.com/4.jpg");
	   photoList.add(photos);		   
	   exhibitsDetailsVo.setPhotoList(photoList);
	   List<Comments> commentsList = new ArrayList<Comments>();		
	   Comments c = new Comments(1L, 6L, "����", "www.baidu.com/4.jpg","����1",new Date().toLocaleString()); 
	   commentsList.add(c);
	   c = new Comments(2L, 3L, "����", "www.baidu.com/1.jpg","����2",new Date().toLocaleString()); 
	   commentsList.add(c);
	   c = new Comments(3L, 4L, "����", "www.baidu.com/4.jpg","����3",new Date().toLocaleString()); 
	   commentsList.add(c);
	   c = new Comments(4L, 5L, "����", "www.baidu.com/6.jpg","����4",new Date().toLocaleString()); 
	   commentsList.add(c);	   
	   exhibitsDetailsVo.setCommentsList(commentsList);
	   
	   JSONObject json = JSONObject.fromObject(exhibitsDetailsVo);  
       System.out.println(json.toString());  
}
	public ExhibitsDetailsVo() {
	}  	
	public ExhibitsDetailsVo(String chineseName, String englishName) {
		this.chineseName = chineseName;
		this.englishName = englishName;
	}
	public Long getExhibitId() {
		return exhibitId;
	}
	public void setExhibitId(Long exhibitId) {
		this.exhibitId = exhibitId;
	}
	public String getExhibitPhtoUrl() {
		return exhibitPhtoUrl;
	}
	public void setExhibitPhtoUrl(String exhibitPhtoUrl) {
		this.exhibitPhtoUrl = exhibitPhtoUrl;
	}  	
}