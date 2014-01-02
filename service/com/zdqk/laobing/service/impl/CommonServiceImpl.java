package com.zdqk.laobing.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zdqk.laobing.service.CommonService;

@Service("commonService")
@SuppressWarnings("unchecked")
public class CommonServiceImpl implements CommonService{
	
	private static final Log logger = LogFactory.getLog(CommonServiceImpl.class);

	/**
	 * 基础代码入库操作
	 * @param list
	 * @param daoObject
	 * @throws Exception
	 */
	public void doBaseInfoCheckIn(List list, Object daoObject) throws Exception{

		Iterator listIt = list.iterator();

		while (listIt.hasNext()) {//遍历List 取出相应对象

			Object operateObject = listIt.next();

			Object selectObject = null;
			   try{
				   	selectObject = dataBaseOperation("findById", daoObject, operateObject);
			
			   }catch(NoSuchMethodException e){
				  e.printStackTrace();
			   }
			if (selectObject == null) {//如果没有相对应数据 插入一条新数据
				
				dataBaseOperation("insert", daoObject, operateObject);

			} else {//如果有相对应数据 更新当条数据
				
				dataBaseOperation("update", daoObject, operateObject);

			}

		}

	}

	/**
	 * 执行数据库操作处理反射类
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	public Object dataBaseOperation(String methodName, Object operateObject, Object parametersObject) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		Object returnObject = null;

		if (methodName.equals("findById")) {

			parametersObject = getField(parametersObject, "getId");

		}

		returnObject = invokeField(operateObject, parametersObject, methodName);

		return returnObject;
	}

	/**
	 * 获取指定方法属性内容(get属性内容)
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public Object getField(Object operateObject, String fieldName) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Object returnObject = null;

		Method getMethod = operateObject.getClass().getMethod(fieldName, new Class[] {});

		returnObject = getMethod.invoke(operateObject, new Object[] {});
		if (logger.isDebugEnabled()){
		
			logger.debug(returnObject.getClass().getName());
		
		}
		
		return returnObject;
	}

	/**
	 * 执行指定方法 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public Object invokeField(Object operationObject, Object parametersObject, String methodName) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Object returnObject = null;

		Method invokeMethod = operationObject.getClass().getMethod(methodName, parametersObject.getClass());

		if (logger.isDebugEnabled()){
			
			logger.debug(operationObject.getClass().getName());
			
		}

		returnObject = invokeMethod.invoke(operationObject, parametersObject);

		return returnObject;
	}

	@Override	
	public Long queryObjectsCount(Object mapObject,
			Object object,Object daoObject) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		
		Long count = 0L;
			
		Object returnObject = null;
		
		Method invokeMethod = daoObject.getClass().getMethod("findObjectsPageCount", new Class[]{Map.class,Object.class});
		
		invokeMethod.setAccessible(true);

		if (logger.isDebugEnabled()) {
			
			logger.debug(daoObject.getClass().getName());
			
		}		
		returnObject = invokeMethod.invoke(daoObject,mapObject,object);	
		
		count = (Long)returnObject;
		
		return count;
	}
	@Override
	public List<Object> queryObjects(Object mapObject,
			Object object,Object daoObject) throws Exception {
		
		Object returnObject = null;
		
		Method invokeMethod = daoObject.getClass().getMethod("findObjectsPage", new Class[]{Map.class,Object.class});
		
		invokeMethod.setAccessible(true);

		if (logger.isDebugEnabled()) {
			
			logger.debug(daoObject.getClass().getName());
			
		}		
		returnObject = invokeMethod.invoke(daoObject,mapObject,object);		
		
		List<Object> list= (List<Object>)returnObject;
		
		return list;
	}

	@Override
	public List<Object> queryObjectsNoPage(Object mapObject,
			Object object,Object daoObject) throws Exception{
		Object returnObject = null;
		
		Method invokeMethod = daoObject.getClass().getMethod("findObjects", new Class[]{Map.class,Object.class});
		
		invokeMethod.setAccessible(true);

		if (logger.isDebugEnabled()) {
			
			logger.debug(daoObject.getClass().getName());
			
		}		
		returnObject = invokeMethod.invoke(daoObject,mapObject,object);		
		
		List<Object> list= (List<Object>)returnObject;
		
		return list;
	}
	
}
