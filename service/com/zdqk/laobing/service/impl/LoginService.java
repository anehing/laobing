package com.zdqk.laobing.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdqk.laobing.dao.AdminDAO;
import com.zdqk.laobing.po.Admin;
import com.zdqk.laobing.service.ILoginService;


@Service("iLoginService")
public class LoginService implements ILoginService {

	@Autowired
	private AdminDAO<Admin> adminDAO;
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
//		
//		if ("1".equals(admin.getUsertype()+"")) {
//			tree+="<div id='ss'><div id='ss_1' class='normal_txt1' onclick='nos(1)'>超级管理员</div></div>";
//			tree+="<!-- q0到q4 -->";
//			tree+="<div class='xt_r' id='r1' style='display:block'>";
//    		tree+="";
//			tree+="<div id='2b_9' class='normal_txt2' onclick='nxx(12);'><img class='jm_1' align='middle' src='images/ip _beianTJ.png' width='16' height='16' />&nbsp;&nbsp;&nbsp;系统管理</div>";
//			tree+="<ul style='display:none;' id='q12'>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_100' class='normal_txt' onclick='Hover1(100);'><a onclick=goTarget('base/queryUserbyId.action?id="+admin.getId()+"&totype=1');>修改密码</a></span></li>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_101' class='normal_txt' onclick='Hover1(101);'><a onclick=goTarget('base/queryUserbyId.action?id="+admin.getId()+"&totype=4');>账户信息</a></span></li>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_102' class='normal_txt' onclick='Hover1(102);'><a onclick=goTarget('base/queryUserbyId.action?id="+admin.getId()+"&totype=2');>编辑信息</a></span></li>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_102' class='normal_txt' onclick='Hover1(102);'><a onclick=goTarget('base/queryAccountManagement.action?id="+admin.getId()+"');>账户管理</a></span></li>";
//			tree+="</ul>";				
//			
//			tree+="";
//			tree+="<div id='2b_5' class='normal_txt2' onclick='nxx(1);'><img class='jm_1' align='middle' src='images/ip _beianTJ.png' width='16' height='16' />&nbsp;&nbsp;&nbsp;用户管理</div>";
//			tree+="<ul style='display:block;' id='q1'>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_120' class='normal_txt' onclick='Hover1(120);'><a onclick=goTarget('addUser.jsp');>用户注册</a></span></li>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_121' class='normal_txt' onclick='Hover1(121);'><a onclick=goTarget('base/queryUsers.action');>用户列表</a></span></li>";
//			tree+="</ul>";
//			tree+="";
//			tree+="<div id='2b_11' class='normal_txt2' onclick='nxx(2);'><img class='jm_1' align='middle' src='images/ip _beianTJ.png' width='16' height='16' />&nbsp;&nbsp;&nbsp;事件/日志</div>";
//			tree+="<ul style='display:none;' id='q2'>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_130' class='normal_txt' onclick='Hover1(130);'><a onclick=goTarget('base/queryUserLogs.action');>日志管理</a></span></li>";
//			tree+="<li id='xx'>&nbsp;&nbsp;&nbsp;<span id='1b_131' class='normal_txt' onclick='Hover1(131);'><a onclick=goTarget('base/queryComms.action');>设备管理</a></span></li>";
//			tree+="</ul>";	
//
//			
//			tree+="";
//			tree+="</div>";			
//		}

		return tree;
	}


	@Override
	public Boolean queryUserNameIsExist(String username) {
		boolean flag =false;
		Admin admin = new Admin();
		Map<String,String> map = new HashMap<String,String>();
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
