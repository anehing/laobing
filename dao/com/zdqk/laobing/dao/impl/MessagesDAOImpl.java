package com.zdqk.laobing.dao.impl;


import org.springframework.stereotype.Component;


import com.zdqk.laobing.dao.MessagesDAO;
import com.zdqk.laobing.po.Messages;



@Component("messagesDAO")
public class MessagesDAOImpl extends BasicDaoImpl<Messages> implements MessagesDAO<Messages>{
	
	
}