package com.zdqk.laobing.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zdqk.laobing.dao.BasicDao;

/**
 * @说明:通用接口实现
 * @author lfx
 *
 * @param <T>
 */
public class BasicDaoImpl<T> extends SqlMapClientDaoSupport implements BasicDao<T> {




	@Override
	public boolean insert(T t) {
		try{
			getSqlMapClientTemplate().insert(t.getClass().getName()+".insert", t);
			return true;
		}catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		 
	}

	@Override
	public boolean update(T t) {
		try {
			getSqlMapClientTemplate().update(t.getClass().getName()+".update", t);
			return true;
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean delete(T t) {
		try {
			getSqlMapClientTemplate().delete(t.getClass().getName()+".delete", t);
			return true;
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}

	}


	
	@Override
	public List<T> findObjectsPage(Map<String, Object> mapConditions,T t) {
		try {
			List<T> list=(List<T>)getSqlMapClientTemplate().queryForList(t.getClass().getName()+".selectPage",mapConditions);
			return list;
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Long findObjectsPageCount(Map<String, Object> mapConditions, T t) {
		try {	
			return (Long)getSqlMapClientTemplate().queryForObject(t.getClass().getName()+".selectCount",mapConditions);
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		
	}


	@Override
	public T findObjectById(int id,T t) {
		try {
			return (T)getSqlMapClientTemplate().queryForObject(t.getClass().getName()+".findById",id);
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<T> findObjects(Map<String, Object> mapConditions, T t) {
		try {
			List<T> list=(List<T>)getSqlMapClientTemplate().queryForList(t.getClass().getName()+".selectAll",mapConditions);
			return list;
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public T findObjectNameById(int id, T t) {
		try{
			return (T)getSqlMapClientTemplate().queryForObject(t.getClass().getName()+".findNameById",id);
		} catch (Exception e) {
			System.out.println("数据连接失败，请检查数据服务是否开启");
			throw new RuntimeException(e.getMessage());
		}
	}

}
