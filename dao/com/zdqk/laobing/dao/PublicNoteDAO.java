package com.zdqk.laobing.dao;

import java.util.List;
import java.util.Map;




public interface PublicNoteDAO<PublicNote>  extends BasicDao<PublicNote>{
	
	public List<PublicNote> selectAllByDesc(Map<String, Object> map);
	public PublicNote selectAllById(int id);
}