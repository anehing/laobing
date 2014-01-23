package com.zdqk.laobing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdqk.laobing.dao.AdminDAO;
import com.zdqk.laobing.dao.PermissionDAO;
import com.zdqk.laobing.dao.UrlDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.po.Permission;
import com.zdqk.laobing.po.Url;
import com.zdqk.laobing.service.ILoginService;


@Service("iLoginService")
public class LoginService implements ILoginService {

	@Autowired
	private AdminDAO<Admin> adminDAO;
	@Autowired
	private UrlDAO<Url> urlDAO;
	@Autowired
	private PermissionDAO<Permission> permissionDAO;
	/**
	 * @author  验证用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public String loadPopedomTree(Admin admin) {
		String tree = "";
		Url u = new Url();
		Map<String, Object> map =new HashMap();
		if(admin!=null&&admin.getUsertype()==1){//管理员
			List<Url> li=urlDAO.findObjects(map, u);
			for(Url url :li){
				tree+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
			}
		}else{
			map.put("adminid", admin.getId());
			Permission p=new Permission();
			List<Permission> permissionli=permissionDAO.findObjects(map, p);
			for(Permission p1 :permissionli){
				Map<String, Object> map2 =new HashMap();
				map2.put("id", p1.getUrlid());
				u=null;
			    u=urlDAO.selectById(map2);
				tree+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
			}
		}
		return tree;
	}


	@Override
	public Boolean queryUserNameIsExist(String username) {
		boolean flag =false;
		Admin admin = new Admin();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", username);
		List<Admin> listAdmin = adminDAO.findObjects(map, admin);		
		if(listAdmin.size()==0){
			flag = true;
		}
		return flag;
	}





	@Override
	public Admin checkAdminByUsernameAndPassword(Map<String,Object> map, String hzm) {
		Admin admin =(Admin) adminDAO.findAdminByUsernameAndPassword(map, hzm);
		return admin;
	}
}
