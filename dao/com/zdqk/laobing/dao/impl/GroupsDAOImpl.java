package com.zdqk.laobing.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.GroupsDAO;
import com.zdqk.laobing.po.Groups;
import com.zdqk.laobing.po.User;

@Component("groupsDAO")
public class GroupsDAOImpl extends BasicDaoImpl<Groups> implements GroupsDAO<Groups>{

	@Override
	public boolean checkIsExits(Map collections) {
		try {
			
			Groups gu = new Groups();
			List<Groups> list=(List<Groups>)getSqlMapClientTemplate().queryForList(gu.getClass().getName()+".findIsExits",collections);
			if(list!=null && list.size()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("�������ʧ�ܣ�������ݷ����Ƿ���");
			throw new RuntimeException(e.getMessage());
		}
	}

}