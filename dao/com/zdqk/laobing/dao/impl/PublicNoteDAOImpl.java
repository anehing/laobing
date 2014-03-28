package com.zdqk.laobing.dao.impl;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.PublicNoteDAO;
import com.zdqk.laobing.po.PublicNote;




@Component("publicnoteDAO")
public class PublicNoteDAOImpl extends BasicDaoImpl<PublicNote> implements PublicNoteDAO<PublicNote>{

	@Override
	public List<PublicNote> selectAllByDesc(Map<String, Object> map) {
		// TODO Auto-generated method stub
		PublicNote PublicNote = new PublicNote();
		List<PublicNote> list=null;
		try {
			list=getSqlMapClientTemplate().queryForList(PublicNote.getClass().getName()+".selectAllByDesc",map);
			
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	
	}

	@Override
	public PublicNote selectAllById(int id) {
		// TODO Auto-generated method stub
		PublicNote PublicNote = new PublicNote();
		List<PublicNote> list=null;
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id", id);
		try {
			list=getSqlMapClientTemplate().queryForList(PublicNote.getClass().getName()+".selectAllById",map);
			
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}


	
	
}