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
	public Map loadPopedomTree(Admin admin) {
		Map tree = new HashMap();
		String tree0 ="";//注册管理
		String tree1 ="";//用户统计
		String tree2 ="";//订单管理
		String tree3 ="";//信息管理
		String tree4 ="";//优惠券管理
		String tree5 ="";//司机管理
		String tree6 ="";//价格管理
		String tree7 ="";//客户管理
		String tree8 ="";//其它
		String tree9 ="";//投诉
		Url u = new Url();
		Map<String, Object> map =new HashMap();
		if(admin!=null&&admin.getUsertype()==1){//管理员
			List<Url> li=urlDAO.findObjects(map, u);
			for(Url url :li){
				if(url.getParent_url_id()==0){
					tree0+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==1){
					tree1+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==2){
					tree2+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==3){
					tree3+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==4){
					tree4+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==5){
					tree5+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==6){
					tree6+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==7){
					tree7+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}else if (url.getParent_url_id()==9){
					tree9+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}
				else {
					tree8+="<a href=\""+url.getUrl()+"\" target=\"main\">"+url.getUrl_name()+"</a>";
				}
				
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
				if(u.getParent_url_id()==0){
					tree0+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==1){
					tree1+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==2){
					tree2+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==3){
					tree3+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==4){
					tree4+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==5){
					tree5+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==6){
					tree6+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==7){
					tree7+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else if (u.getParent_url_id()==9){
					tree9+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}else{
					tree8+="<a href=\""+u.getUrl()+"\" target=\"main\">"+u.getUrl_name()+"</a>";
				}
			}
		}
		tree.put("tree0", tree0);
		tree.put("tree1", tree1);
		tree.put("tree2", tree2);
		tree.put("tree3", tree3);
		tree.put("tree4", tree4);
		tree.put("tree5", tree5);
		tree.put("tree6", tree6);
		tree.put("tree7", tree7);
		tree.put("tree8", tree8);
		tree.put("tree9", tree9);
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
