package com.zdqk.laobing.tools.ibatis;

import java.util.HashMap;
import java.util.Map;

import com.zdqk.laobing.po.Collections;
import com.zdqk.laobing.po.Comments;
import com.zdqk.laobing.po.DmbCity;
import com.zdqk.laobing.po.Exhibits;
import com.zdqk.laobing.po.Groups;
import com.zdqk.laobing.po.Museums;
import com.zdqk.laobing.po.Musics;
import com.zdqk.laobing.po.Photos;
import com.zdqk.laobing.po.User;
import com.zdqk.laobing.po.UserLog;
import com.zdqk.laobing.po.Videos;



public class PoMap {

	/**
	 * @param args
	 */
	public static Map<String,Object>  putObject()
	{
		Map<String,Object> hashmap=new HashMap<String,Object>();
		DmbCity DmbCity=new DmbCity();
		hashmap.put("DmbCity",DmbCity);
		UserLog UserLog=new UserLog();
		hashmap.put("UserLog",UserLog);		
		User User=new User();
		hashmap.put("User",User);	
		
		Collections Collections =new Collections();
		hashmap.put("Collections",Collections);		
		Comments Comments =new Comments();
		hashmap.put("Comments",Comments);			
		Exhibits Exhibits =new Exhibits();
		hashmap.put("Exhibits",Exhibits);			
		Museums Museums=new Museums();
		hashmap.put("Museums",Museums);	
		Musics Musics=new Musics();
		hashmap.put("Musics",Musics);	
		Photos Photos =new Photos();
		hashmap.put("Photos",Photos);		
		Groups Groups =new Groups();
		hashmap.put("Groups",Groups);			
		Videos Videos =new Videos();
		hashmap.put("Videos",Videos);			
		return hashmap; 
	}
}
