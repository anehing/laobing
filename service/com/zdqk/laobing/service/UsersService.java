package com.zdqk.laobing.service;

import com.zdqk.laobing.po.User;
import com.zdqk.laobing.po.UserLog;



public interface UsersService {
	
////////////////////////////////用户日志//////////////////////////////////////////
	
	
	public Boolean deleteUserLog(Long id) throws Exception;
	
	public UserLog queryUserLogById(UserLog userLog);
	
	public Boolean updateUserLog(UserLog userLog);	
	
	public Boolean addUserLog(UserLog userLog) throws Exception;	
////////////////////////////////用户//////////////////////////////////////////
	
	public Boolean deleteUser(Long id) throws Exception;
	
	public User queryUserById(User User);
	
	public String queryUserNameById(User User);
	
	public Boolean updateUser(User User);
	
}