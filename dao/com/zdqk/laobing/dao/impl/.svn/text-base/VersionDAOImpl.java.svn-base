package com.zdqk.laobing.dao.impl;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.VersionDAO;
import com.zdqk.laobing.po.Version;




@Component("versionDAO")
public class VersionDAOImpl extends BasicDaoImpl<Version> implements VersionDAO<Version>{

	@Override
	public Version updateApp(Map<String, String> map,String version) {
		// TODO Auto-generated method stub
		 Version v= new Version();
		 int id = 0;
		 Version ver=null;
		   List<Version> list=null;
		try{
			
			list=getSqlMapClientTemplate().queryForList(v.getClass().getName()+"."+"selectByType",map);
		}catch(Exception e){
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){ 
	      	 for(Version ve :list){
	       		if(id<ve.getId()){
	       			id=ve.getId();
	       			ver=ve;
	       		}
	       	 }
	       }	
	    if(ver!=null&&!ver.getVersion().equals(version)){
				  return ver;
		  }
		return null;//没有最新的
	}


	
	
}