package com.zdqk.laobing.dao.impl;


import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.MuseumsDAO;
import com.zdqk.laobing.po.Museums;

@Component("museumsDAO")
public class MuseumsDAOImpl extends BasicDaoImpl<Museums> implements MuseumsDAO<Museums> {
	
}