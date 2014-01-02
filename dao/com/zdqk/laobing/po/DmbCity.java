package com.zdqk.laobing.po;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("DMB_CITY")
public class DmbCity {
	
	@TODO("ID")
	@PK	
    private Long id;
	@TODO("parentid")
	private Long parentId;
	@TODO("MC")	
    private String name;
	@TODO("SSX")		
    private Long property;// ʡ����
	@TODO("type")		
	private Long type;// ����������
	@TODO("BZ")	
    private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getProperty() {
		return property;
	}
	public void setProperty(Long property) {
		this.property = property;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}


}