package com.zdqk.laobing.tools.ibatis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
@SuppressWarnings({ "rawtypes", "unused","unchecked" })
public class PoToWriteXml {
	/**
	 * @param args
	 */
	private static String ORACLEDATABASE="oracle";//oracle鏁版嵁搴撶増锟�
	private static String MYSQLDATABASE="mysql";//mysql鏁版嵁搴撶増锟�
	private static String databaseType;
	public static <T>  void sqlMap(T t,String folderPath) {	
		databaseType=MYSQLDATABASE;		
		String pk="";
		String pkValue="";
		Class class1 = t.getClass();
		System.out.println(class1.getName());//娴嬭瘯鎵撳嵃绫诲悕
		//寰楀埌琛ㄦ槑
		TODO tableTodo=(TODO) class1.getAnnotation(TODO.class);
		String table=tableTodo.value();
		Field[] declaredFields = class1.getDeclaredFields();
		String type=class1.getName();	
		String simpleName = class1.getSimpleName();
		char charAt = (char)(simpleName.charAt(0)+32); 
		String alias=charAt+simpleName.substring(1);
		Document doc = org.dom4j.DocumentHelper.createDocument();   
		Document addDocType = doc.addDocType("sqlMap", "-//ibatis.apache.org//DTD SQL Map 2.0//EN", "http://ibatis.apache.org/dtd/sql-map-2.dtd");
        System.out.println(addDocType+"lllllllllll");
		Element rootElement = doc.addElement("sqlMap");//鍒涘缓鏍硅妭锟�    
        rootElement.addAttribute("namespace",type); //鏍硅妭鐐规坊鍔犲睘锟� 
        typeAliasElement(rootElement,alias,type);
        resultMapElement(rootElement,alias,pk,table,declaredFields);
        insertElement(rootElement,alias,pk,pkValue,table,declaredFields,databaseType);//娣诲姞鎻掑叆鑺傜偣
        deleteByIdElement(rootElement,alias,pk,table,pkValue,declaredFields);///娣诲姞鍒犻櫎鑺傜偣閫氳繃涓婚敭
        updateElement(rootElement,alias,pk,table,pkValue,declaredFields);//娣诲姞鍔拷?鏇存柊鑺傜偣
        findByIdElement(rootElement,alias,pk,table,pkValue,declaredFields);///娣诲姞鎸変富閿煡鎵捐妭锟�
        findNameByIdElement(rootElement,alias,pk,table,pkValue,declaredFields);
        findAllElement(rootElement,alias,table,declaredFields,databaseType);///娣诲姞鏌ユ壘鍏ㄩ儴瀵硅薄鑺傜偣锛堜笉鍒嗛〉锟�
        selectPageElement(rootElement,alias,table,declaredFields,databaseType);///娣诲姞鍔拷?鍒嗛〉鏌ヨ鑺傜偣
        countRecordElement(rootElement,alias,table,declaredFields);///娣诲姞鍔拷?鍒嗛〉缁熻鑺傜偣
        writeXml(folderPath+simpleName+".xml",doc);//鐢熸垚xml鏂囦欢
	}
	public static Element typeAliasElement(Element rootElement,String alias,String type){
        //typeAlias鑺傜偣
        Element typeAlias = rootElement.addElement("typeAlias"); 
        typeAlias.addAttribute("alias",alias); 
        typeAlias.addAttribute("type",type); 
        return typeAlias;
	}
	public static Element resultMapElement(Element rootElement,String alias,String pk,String table,Field[] declaredFields){
        //resultMap鑺傜偣 
        Element resultMap = rootElement.addElement("resultMap");   
        resultMap.addAttribute("id",alias+"Result"); 
        resultMap.addAttribute("class",alias); 
		for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value().toUpperCase();
				String javaType = field.getType().getCanonicalName();
//				String jdbcType="";
//				if(javaType.equals("java.lang.Long")){
//					jdbcType="NUMERIC";
//				}
//				if(javaType.equals("java.util.Date")){
//					jdbcType="DATE";
//				}
//				else if(javaType.equals("java.lang.String")){
//					jdbcType="VARCHAR";
//				}
				//濡傛灉杩樻湁鍏朵粬鏁版嵁绫诲瀷锛岀户缁坊锟�
				//鍚憆esultMap涓嬪姞result
				Element result = resultMap.addElement("result");
				result.addAttribute("property", fieldName);
				result.addAttribute("column", column);
//				result.addAttribute("javaType", javaType);
//				result.addAttribute("jdbcType", jdbcType);
			}
		}
		return resultMap;
	}
	public static Element insertElement(Element rootElement,String alias,String pk,String pkValue,String table,Field[] declaredFields,String datatabasType){
		Element insert = rootElement.addElement("insert");
        insert.addAttribute("id", "insert");
        insert.addAttribute("parameterClass", alias);     
//        Element selectKey = insert.addElement("selectKey");//oracle闇�selectKey鑺傜偣,  mysql涓嶉渶瑕乻electKey鑺傜偣
//        selectKey.addAttribute("resultClass", "java.lang.Long");
//        if(datatabasType.toLowerCase().equals("oracle")){// 鍒ゆ柇鏁版嵁搴撶殑绫诲瀷
//        	selectKey.addText("SELECT SEQ_"+table.toUpperCase()+"_ID.NEXTVAL FROM DUAL");
//        }else if(datatabasType.toLowerCase().equals("mysql")){
//        	selectKey.addText("SELECT LAST_INSERT_ID() as "+pkValue);        	
//        }
        ////////
		StringBuffer insertText=new StringBuffer();
		insertText.append("insert into "+table.toUpperCase()+"( ");
		StringBuffer insertText2=new StringBuffer();
		StringBuffer insertText3=new StringBuffer();
		for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				//寰楀埌鍒楁槑
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				
				if(!field.isAnnotationPresent(PK.class)){
					insertText2.append(column.toUpperCase()+",");
					insertText3.append("#"+fieldName+"#,");
				}else{
					insertText2.append(column.toUpperCase()+",");
					insertText3.append("#"+fieldName+"#,");
					pk=column;
					pkValue=fieldName;
				}
			}
		}
		insertText2.deleteCharAt(insertText2.lastIndexOf(","));
		insertText3.deleteCharAt(insertText3.lastIndexOf(","));
//        selectKey.addAttribute("keyProperty", pkValue);
		insertText.append(insertText2);
		insertText.append(" ) values ( ");
		insertText.append(insertText3);
		insertText.append(" )");
//        selectKey.addText("select LAST_INSERT_ID() as "+pkValue);//msyql绫诲瀷        
       // selectKey.addText("SELECT SEQ_CNNIC_DOMAIN_BASIC_REG_ID.NEXTVAL FROM DUAL ");
       //oracle绫诲瀷.璇存槑锛歋EQ_CNNIC_DOMAIN_BASIC_REG_ID鏄痮racle鐨勫簭鍒楋紝涓嶅悓鐨勮〃鏈変笉鍚岀殑搴忓垪
        insert.addText(insertText.toString());
        return insert;
	}
	public static Element updateElement(Element rootElement,String alias,String pk,String table,String pkValue,Field[] declaredFields){
        //update鑺傜偣
        Element update = rootElement.addElement("update");
        update.addAttribute("id", "update");
        update.addAttribute("parameterClass", alias);
        update.addText("update "+table.toUpperCase()+" ");
        //dynamic 鑺傜偣
        Element dynamicUpdate = update.addElement("dynamic");
        dynamicUpdate.addAttribute("prepend", "set");
        //----------------------//////////////
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
					Element isNotNull = dynamicUpdate.addElement("isNotNull");
					isNotNull.addAttribute("prepend", ",");
					isNotNull.addAttribute("property", fieldName);
					isNotNull.addText(column.toUpperCase()+" = #"+fieldName+"#");
				}else{
					pk=column;
					pkValue=fieldName;
				}
			}
		}
        //----------------------//////////////
        update.addText("where "+pk+" = #"+pkValue+"#");
        return update;
	}
	public static String selectStr(Field[] declaredFields){
		String str="";
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value().toUpperCase();
				str+=column+",";
			}
		}		
       str=str.substring(0,str.lastIndexOf(",")) ;
		return str;
	}
	public static Element findByIdElement(Element rootElement,String alias,String pk,String table,String pkValue,Field[] declaredFields){
        //涓婚敭鏌ヨ鑺傜偣
        Element queryAllById = rootElement.addElement("select");
        queryAllById.addAttribute("id", "findById");
        queryAllById.addAttribute("parameterClass", "java.lang.Integer");
        queryAllById.addAttribute("resultMap", alias+"Result");
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
				}else{
					pk=column;
					pkValue=fieldName;
				}
			}
		}
        queryAllById.addText("select * from "+table.toUpperCase()+" where "+pk+" = #"+pkValue+"#"); 
        return queryAllById;
	}
	public static Element findNameByIdElement(Element rootElement,String alias,String pk,String table,String pkValue,Field[] declaredFields){
		//涓婚敭鏌ヨ鑺傜偣锛屾煡璇㈢粨鏋滆繑鍥炵殑鍊煎彧鏈塏ame瀛楁锛屽叾浠栧瓧娈靛�閮戒负绌�
		Element queryAllById = rootElement.addElement("select");
		queryAllById.addAttribute("id", "findNameById");
		queryAllById.addAttribute("parameterClass", "java.lang.Integer");
		queryAllById.addAttribute("resultMap", alias+"Result");
		for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
				}else{
					pk=column;
					pkValue=fieldName;
				}
			}
		}
		queryAllById.addText("select * from "+table.toUpperCase()+" where "+pk+" = #"+pkValue+"#"); 
		return queryAllById;
	}
	public static Element findAllElement(Element rootElement,String alias,String table,Field[] declaredFields,String datatabasType){
        Element queryAll = rootElement.addElement("select");  
        queryAll.addAttribute("id","selectAll");
        queryAll.addAttribute("parameterClass","java.util.Map");
        queryAll.addAttribute("resultMap",alias+"Result");
        String selectStr=selectStr(declaredFields);
        String selectPageHead2="select "+selectStr+" from "+table.toUpperCase();
        queryAll.addText(selectPageHead2);	
        Element selectPageDynamic = queryAll.addElement("dynamic"); 
        selectPageDynamic.addAttribute("prepend", "where");
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
					Element isNotNulldanamic=selectPageDynamic.addElement("isNotNull");
					isNotNulldanamic.addAttribute("prepend", " and ");
					isNotNulldanamic.addAttribute("property", fieldName);
					isNotNulldanamic.addText(column.toUpperCase()+" = #"+fieldName+"#");
				}
			}
		}     
        return queryAll;
	}
	public static Element deleteByIdElement(Element rootElement,String alias,String pk,String table,String pkValue,Field[] declaredFields){
        //delete鑺傜偣
        Element delete = rootElement.addElement("delete");
        delete.addAttribute("id", "delete");
        delete.addAttribute("parameterClass", alias);
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
				}else{
					pk=column;
					pkValue=fieldName;
				}
			}
		}
        delete.addText("delete from "+table.toUpperCase()+" where "+pk+" = #"+pkValue+"#");
        return delete;
	}
	public static Element selectPageElement(Element rootElement,String alias,String table,Field[] declaredFields,String datatabasType){
        //鍒嗛〉鑺傜偣鍔拷?鏌ヨ
        Element selectPage = rootElement.addElement("select");  
        selectPage.addAttribute("id","selectPage");
        selectPage.addAttribute("parameterClass","java.util.Map");
        selectPage.addAttribute("resultMap",alias+"Result");
        String selectPageHead1="select * from ( select row_.*, rownum rownum_ from (";
        String selectStr=selectStr(declaredFields);
        String selectPageHead2="select "+selectStr+" from "+table.toUpperCase();
        String selectPagetail=") row_ where rownum &lt;=#endIndex#) where rownum_ &gt;= #startIndex#";
        if(datatabasType.toLowerCase().equals("oracle")){// 鍒ゆ柇鏁版嵁搴撶殑绫诲瀷
        	selectPage.addText(selectPageHead1+selectPageHead2);
        }else if(datatabasType.toLowerCase().equals("mysql")){
        	selectPage.addText(selectPageHead2);	
        }        
        //鍒嗛〉鑺傜偣鍔拷?鏌ヨdynamic瀛愯妭锟�
        Element selectPageDynamic = selectPage.addElement("dynamic"); 
        selectPageDynamic.addAttribute("prepend", "where");
        //------------------
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
					Element isNotNulldanamic=selectPageDynamic.addElement("isNotNull");
					isNotNulldanamic.addAttribute("prepend", " and ");
					isNotNulldanamic.addAttribute("property", fieldName);
					isNotNulldanamic.addText(column.toUpperCase()+" = #"+fieldName+"#");
				}
			}
		}     
        if(datatabasType.toLowerCase().equals("oracle")){// 鍒ゆ柇鏁版嵁搴撶殑绫诲瀷
        	selectPage.addText(selectPagetail);
        }else if(datatabasType.toLowerCase().equals("mysql")){
        	selectPage.addText("order by id desc limit #startIndex#,#endIndex#");
        }            
		return selectPage;
	}
	//count鑺傜偣缁熻鏁版嵁
	public static Element countRecordElement(Element rootElement,String alias,String table,Field[] declaredFields){
      
        Element count = rootElement.addElement("select");
        count.addAttribute("id", "selectCount");
        count.addAttribute("parameterClass", "java.util.Map");
        count.addAttribute("resultClass", "java.lang.Long");
        String strcount = countStr(declaredFields);
        count.addText("select  count("+strcount+") from "+table.toUpperCase()+" ");
        //dynamic 鑺傜偣
        Element dynamicCount = count.addElement("dynamic");
        dynamicCount.addAttribute("prepend", "where");
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(!field.isAnnotationPresent(PK.class)){
					Element isNotNull = dynamicCount.addElement("isNotNull");
					isNotNull.addAttribute("prepend", " and ");
					isNotNull.addAttribute("property", fieldName);
					isNotNull.addText(column.toUpperCase()+" = #"+fieldName+"#");
				}
			}
		}
        return count;	  
	}
	public static String countStr(Field[] declaredFields){
		String str="";
        for (Field field : declaredFields) {			
			String fieldName = field.getName();
			if((!fieldName.equals("serialVersionUID"))&&(!field.getType().getSimpleName().equals("List"))&&(!(field.getModifiers()==25))){
				TODO columnTodo = field.getAnnotation(TODO.class);
				String column=columnTodo.value();
				if(field.isAnnotationPresent(PK.class)){
					str=column;
				}
			}
		}	
        if(str.equals("") || str==null){
        	str="*";
        }
		return str;
	}	
	public static void writeXml(String str,Document doc){
        try {   
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            FileOutputStream fos = new FileOutputStream(new File(str));
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            XMLWriter writer = new XMLWriter(osw, format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
	}
	public static void main(String[] args) {
		 String rootstr="/Users/ane/workspace/laobing/dao/com/zdqk/laobing/po/";		
		 String rootdes="/Users/ane//workspace/laobing/resource/sqlmapxml/";	
		 Map<String ,String> pathMap=new HashMap<String ,String>();
		 pathMap.put(rootstr,rootdes);
		 for(String obj : pathMap.keySet()) {        
			    String key = obj;        
			    String value = pathMap.get(obj);  
			    listfile2(key,value);
		}  
		 long a = System.currentTimeMillis();
		 System.out.println(System.currentTimeMillis() - a);
	}
		public static void listfile2(String strPath,String folderPath)
		{	
		    File dir = new File(strPath);
	        File[] files = dir.listFiles();
	        if (files == null)
	            return ;
	        for (int i = 0; i < files.length; i++) {
	            if (files[i].isDirectory()) {
	            	//listfile2(files[i].getAbsolutePath());
	            } else {
	                String strFileName = files[i].getAbsolutePath();
	                if(strFileName.indexOf(".svn")<0){
	                	 //System.out.println("-" + strFileName);
	                	 //System.out.println(strFileName.lastIndexOf("\\"));
	                	 String fileNameWithExtension=strFileName.substring(strFileName.lastIndexOf("/")+1);
	                	 //System.out.println(fileNameWithExtension);
	                	 if(fileNameWithExtension.lastIndexOf(".java")>0){
	                		 String fileNameNoExtension=fileNameWithExtension.substring(0,fileNameWithExtension.lastIndexOf(".java"));
		                	// System.out.println(fileNameNoExtension); 
		                	// Object o= (Object)fileNameNoExtension;
		                	// PoToSqlMap map=new PoToSqlMap();
		                	// String folderPath="E://workspace_icp//TestOpts//src//main//resources//ibatis//icp//audit//";
		                	 Map<String,Object> hashmap=PoMap.putObject();
		                	 Object o=hashmap.get(fileNameNoExtension);
		                	 if(o!=null){
		                		 sqlMap(hashmap.get(fileNameNoExtension),folderPath);
		                	 }else{
		                		 System.out.println(fileNameNoExtension+" is NULL");
		                	 }
		                	
	                	 }	                	 
	                }               
	            }
	        }
	 }
	
}
