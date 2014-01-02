package com.zdqk.laobing.dao;

import java.util.Map;



@SuppressWarnings({ "rawtypes"})
public interface GroupsDAO<Groups> extends BasicDao<Groups> {

	public boolean checkIsExits(Map collections);

}
