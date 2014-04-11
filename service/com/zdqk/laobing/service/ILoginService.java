package com.zdqk.laobing.service;

import java.util.Map;

import com.zdqk.laobing.po.Admin;



/**
 * 登录 业务
 *
 */
public interface ILoginService {
	
	/**
	 * 检查用户
	 * @param Map(username,email,mobile)  
	 * @param password  用户密码
	 * @return
	 */

	public Admin checkAdminByUsernameAndPassword(Map<String, Object> map,String hzm);	

	/**
	 * 加载权限树
	 * @param 级别
	 * @return
	 */
	public Map loadPopedomTree(Admin admin);
	/**
	 * 检查用户名是否已存在
	 * @param 级别
	 * @return
	 */
	public Boolean queryUserNameIsExist(String username);
	
	
}
