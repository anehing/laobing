package com.zdqk.laobing.dao.impl;


import org.springframework.stereotype.Component;




import com.zdqk.laobing.dao.VersionsDAO;
import com.zdqk.laobing.po.Versions;


@Component("versionsDAO")

public class VersionsDAOImpl extends BasicDaoImpl<Versions> implements VersionsDAO<Versions> {
	
}