package com.zdqk.laobing.dao;

import java.util.Map;



public interface VersionDAO<Version>  extends BasicDao<Version>{
	
	public Version updateApp(Map<String,String> map,String version);
}