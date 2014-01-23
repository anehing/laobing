package com.zdqk.laobing.po;

import java.io.Serializable;

import com.zdqk.laobing.tools.ibatis.PK;
import com.zdqk.laobing.tools.ibatis.TODO;

@TODO("url")	
public class Url implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PK		
	@TODO("id")		
    private int id;
	@TODO("parent_url_id")		
    private int parent_url_id;
	@TODO("url_name")		
    private String url_name;
	@TODO("url")		
    private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_url_id() {
		return parent_url_id;
	}
	public void setParent_url_id(int parent_url_id) {
		this.parent_url_id = parent_url_id;
	}
	public String getUrl_name() {
		return url_name;
	}
	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

	
	
	
}