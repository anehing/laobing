package com.zdqk.laobing.po;

import java.io.Serializable;
import java.util.Date;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;
@TODO("exhibits")
public class Exhibits implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PK	
	@TODO("id")		
	private Long id;
	@TODO("chinesename")	
	private String chineseName;	
	@TODO("englishname")
	private String englishName;	
	@TODO("groupid")
	private Long groupId;
	@TODO("groupname")
	private String groupName;	
	@TODO("specification")
	private String specification;
	@TODO("period")
	private String period;	
	@TODO("qualitygroupid")
	private Long qualityGroupId;
	@TODO("qualitygroupname")
	private String qualityGroupName;	
	@TODO("usegroupid")
	private Long useGroupId;
	@TODO("usegroupname")
	private String useGroupName;
	@TODO("assistantgroupid")
	private Long assistantGroupId;	
	@TODO("assistantgroupname")
	private String assistantGroupName;
	
	@TODO("museumid")
	private Long museumId;
	@TODO("museumname")
	private String museumName;
	@TODO("chineseintroduction")
	private String chineseIntroduction;	
	@TODO("englishintroduction")
	private String englishIntroduction;	
	@TODO("photourl")
	private String photoUrl;
	@TODO("inputdate")
	private Date inputDate;
	@TODO("inputdatetime")
	private Date inputDateTime;
	@TODO("status")
	private Long status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
	public Long getQualityGroupId() {
		return qualityGroupId;
	}
	public void setQualityGroupId(Long qualityGroupId) {
		this.qualityGroupId = qualityGroupId;
	}
	public String getQualityGroupName() {
		return qualityGroupName;
	}
	public void setQualityGroupName(String qualityGroupName) {
		this.qualityGroupName = qualityGroupName;
	}
	public Long getUseGroupId() {
		return useGroupId;
	}
	public void setUseGroupId(Long useGroupId) {
		this.useGroupId = useGroupId;
	}
	public String getUseGroupName() {
		return useGroupName;
	}
	public void setUseGroupName(String useGroupName) {
		this.useGroupName = useGroupName;
	}
	public Long getAssistantGroupId() {
		return assistantGroupId;
	}
	public void setAssistantGroupId(Long assistantGroupId) {
		this.assistantGroupId = assistantGroupId;
	}
	public String getAssistantGroupName() {
		return assistantGroupName;
	}
	public void setAssistantGroupName(String assistantGroupName) {
		this.assistantGroupName = assistantGroupName;
	}


	public Long getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Long museumId) {
		this.museumId = museumId;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Date getInputDateTime() {
		return inputDateTime;
	}
	public void setInputDateTime(Date inputDateTime) {
		this.inputDateTime = inputDateTime;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}