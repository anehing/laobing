//通用代码表读取

//代码表缓存采用uc_开头的js制作的vo

function UtilCode(){

    this.version="uc v1.0";

	//*****************************************
	//                代码表缓存区
	//*****************************************
	
	this.manageBureauCode=null;
	
	//地域代码表（DMB_CITY）
	this.regionCode=null;

	//根据索引查找代码表信息

    //@codeName 代码表名称

    //@索引

	this.findId=function(codeName,id){
		    
	    return this.findKey(codeName,"id",id);
	}
	
	//根据任意字段查找代码表信息
	
	this.findKey=function(codeName,key,value){

	    var rq=eval("this."+codeName);
	    
	    if(rq==null || rq==undefined){

	    	rq=this.load(codeName);
	    	    
	    }	   
	    
	    eval("this."+codeName+"=rq;");
			
		for(var i=0;i<rq.length;i++){
		
			var tmpValue=eval("rq[i]."+key);
		
			if(tmpValue==value){
			
				return rq[i];
			
			}
	
		}
	
		return "";
	}
	
	//获得指定代码表全部数据
	
	this.findAll=function(codeName){
		
	    var rq=eval("this."+codeName);
	    
	    if(rq==null || rq==undefined){

	    	rq=this.load(codeName);
	    	    
	    }
	    
		try{
		
	    eval("this."+codeName+"=rq;");
		
		}catch(e){
			
		}
	    
	    return rq;		
	
	}
	
	//*****************************************
	
	//                内部机制处理区域
	
	//*****************************************
	
	//加载所有为空的代码表仓库
	
	this.load=function(codeName){
	
		var rq=null;
	
		//判断cookies是否含有
			
			var actionUrl="/Ewm/sys/load"+codeName+".action";
			
			var json = $.ajax({
							url: actionUrl,
							async: false
						}).responseText;
			
			rq=eval("("+json+")");
				
		return rq;
	}
	this.loadAllByKey=function(codeName,key,value){
	
		var rq=null;
		
		var actionUrl="/Ewm/sys/load"+codeName+"ByKey.action?"+key+"="+value;
		
		var json = $.ajax({
						url: actionUrl,
						async: false
					}).responseText;
		
		rq=eval("("+json+")");
			
		return rq;
	}	
}

window.utilCode=new UtilCode();
