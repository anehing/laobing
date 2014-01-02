function myBrowser(){   
var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串   
var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器   
var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera ; //判断是否IE浏览器   
var isFF = userAgent.indexOf("Firefox") > -1 ; //判断是否Firefox浏览器   
var isSafari = userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") < 1 ; //判断是否Safari浏览器   
var isChrome = userAgent.indexOf("Chrome") > -1 ; //判断是否Chrome浏览器   
if(isIE){   
   var IE5 = IE55 = IE6 = IE7 = IE8 = IE9 = IE10 = false;   
   var reIE = new RegExp("MSIE (\\d+\\.\\d+);");   
   reIE.test(userAgent);   
   var fIEVersion = parseFloat(RegExp["$1"]);   
   IE55 = fIEVersion == 5.5 ;   
   IE6 = fIEVersion == 6.0 ;   
   IE7 = fIEVersion == 7.0 ;   
   IE8 = fIEVersion == 8.0 ;   
   IE9 = fIEVersion == 9.0 ;
   IE10 = fIEVersion == 10.0 ;      
   if(IE55){ return "IE55"; }   
   if(IE6){ return "IE6"; }   
   if(IE7){ return "IE7"; }   
   if(IE8){ return "IE8"; }   
   if(IE9){ return "IE9"; }  
   if(IE10){ return "IE10"; }        
}   
if(isFF){ return "FF"; }   
if(isOpera){ return "Opera"; }   
if(isSafari){ return "Safari"; }   
if(isChrome){ return "Chrome"; }   
} //myBrowser() end   
 


//事件绑定通用事件

var oEventUtil = new Object();

oEventUtil.AddEventHandler = function(oTarget,sEventType,fnHandler)
{

	//IE和FF的兼容性处理
	 
	//如果是FF
	if(oTarget.addEventListener){
		
		oTarget.addEventListener(sEventType,fnHandler,false);
	
	}
	//如果是IE
	else if(oTarget.attachEvent){
	
		oTarget.attachEvent('on'+sEventType,fnHandler);
	
	} else{
	
		oTarget['on'+sEventType] = fnHandler;
	
	}

};

//判断浏览器类型

function exploreType(){

	var Sys = {};
        var ua = navigator.userAgent.toLowerCase();
        var s;
        (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
        (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
        (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

	return Sys;

}

function getBodyHeight(){

	var de=document.documentElement;
	
	var db=document.body;
	
	var viewW=de.clientWidth==0 ?  db.clientWidth : de.clientWidth;
	
	var viewH=de.clientHeight==0 ?  db.clientHeight : de.clientHeight;
	
	return viewH;

}

function getBodyWidth(){

	var de=document.documentElement;
	
	var db=document.body;
	
	var viewW=de.clientWidth==0 ?  db.clientWidth : de.clientWidth;
	
	var viewH=de.clientHeight==0 ?  db.clientHeight : de.clientHeight;
	
	return viewW;

}

//切换显示查询面板

 function nxx(n){  
 	var b = document.getElementById('r'+n).style.display=='none';
	for(var i=0;i<2;i++){
		if(n==i){
	if(!b){
			$("#r"+i).slideUp('fast');
			$("#z"+i).attr('src','../images/nxx7.png ');
		}else{
			$("#r"+i).slideDown('fast');
			$("#z"+i).attr('src','../images/nxx8.png  ');
		}	
		}
	}
}


/**
 *
 * 绑定表格全选等
 * 
 * @ 全选按钮id
 * @ 反选按钮id
 * @ 删除按钮id
 *
 * @ 选择按钮集合的名称
 *  
 */

function bindTable(allBtnId,inverseBtnId,delBtnId,btnSetName){

	var allBtn=document.getElementById(allBtnId);
	var inverseBtn=document.getElementById(inverseBtnId);
	var delBtn=document.getElementById(delBtnId);
	var btnSet=document.getElementsByName(btnSetName);
	//2010-1-21 黄志鲁修改
	$('#allBtnId').click(function(){
		for(i=0;i<btnSet.length;i++){
			btnSet[i].checked=true;
		}
	});
	
	$('#inverseBtnId').click(function(){
		for(var i=0;i<btnSet.length;i++){
		    if(btnSet[i].checked==true){
				btnSet[i].checked=false;
			}else{
				btnSet[i].checked=true;
			}	
		}
	});
	/*				
	oEventUtil.AddEventHandler(allBtn,"click",function(evt){
		
		for(i=0;i<btnSet.length;i++){
		
			btnSet[i].checked=true;
		
		}
		
	});

	oEventUtil.AddEventHandler(inverseBtn,"click",function(evt){
	
		var tmpNum=0;
	
		for(i=0;i<btnSet.length;i++){
		
			btnSet[i].checked=!btnSet[i].checked;
			
			if(btnSet[i].checked==true){
			
				tmpNum++;
			
			}
		
		}

	});
	*/
}

//获得网址参数

function getUrlParam(name){  

	var   reg   =   new   RegExp("(^|&)"+   name   +"=([^&]*)(&|$)");  
	var   r   =   window.location.search.substr(1).match(reg);  
	if (r!=null)
		return   unescape(r[2]);
	return   null;  
	
}

//动态构建form域

function makeForm(data){

	var submitForm = document.createElement("FORM");

	submitForm.method = "POST";
	
	if(data.indexOf("&")==-1){
	
		var spStr=data.split("=");
		
		var newElement= document.createElement("INPUT");
			
		newElement.name=spStr[0];
		
		newElement.value=spStr[1];
		
		submitForm.appendChild(newElement);
		
	
	}else{
	
		var tmpStr=data.split("&");
			
		for(var i=0;i<tmpStr.length;i++){
		
			var spStr=tmpStr[i].split("=");
					
			var newElement= document.createElement("INPUT");
			
			newElement.name=spStr[0];
		
			newElement.value=spStr[1];
		
			submitForm.appendChild(newElement);
		
		}
	
	
	}
	
	
	return submitForm;

}

//----设置Cookie------

function setCookie(name,value)
{

	var domain="zte.so";
	
	var value = escape(value);

	var nameString	= "Smartly_Pistil_"+name + "=" + value; //给cookie变量增加前缀

	var extime	= new Date();

	extime.setTime	(extime.getTime	() + 315360000);

	var expiryString =	";expires="	+ extime.toGMTString();

	var domainString =	"";

	var pathString	= ";path=/";

	var setvalue =	nameString + expiryString;

	document.cookie = setvalue;
}

//----设置Cookie 结束------

//---读取Cookie-------

function getCookie(name)
{
	var CookieFound = false;
	var start = 0;
	var end = 0;
	var CookieString =	document.cookie;

	var i = 0;
	name="Smartly_Pistil_"+name;	//增加前缀
	while (i <= CookieString.length)
	{
		start = i;
		end = start + name.length;
		if	(CookieString.substring(start, end)	== name)
		{
			CookieFound = true;
			break;
		}
		i++;
	}

	if	(CookieFound)
	{
		start = end + 1;
		end = CookieString.indexOf(";",start);
		if (end < start)
			end = CookieString.length;
		var getvalue =	CookieString.substring(start, end);
		return	unescape(getvalue);
	}
	return	"";
}

//---读取Cookie 结束-------

//检测是否禁用了cookie
function isEnableCookie() {
	try {
		var cookie_helper = new CookieHelper("");
		var test_cookie_name =	"test_cookie_name";
		var test_cookie_value = "test_cookie_value";
		var test_cookie_value_ret = "";

		cookie_helper.writeCookie(test_cookie_name,test_cookie_value);
		test_cookie_value_ret = cookie_helper.getCookieValue(test_cookie_name);

		if	( test_cookie_value_ret	!= null	) {
			cookie_helper.removeCookie(test_cookie_name);
			return	true;
		} else	{
			return	false;
		}
	} catch (error) {
		return	false;
	}
}

// 清空表单的文本框，复选框

function clearInput() {
	var inputs = document.getElementsByTagName("input");
	
	var ses = document.getElementsByTagName("select");
		
	for (i = 0; i < inputs.length; i++) {
		
		if (inputs[i].type == "text") {
						
			if (inputs[i].id != "jumpPageNo") {
				inputs[i].value = "";
			}
		} 
	}
	
	for (i = 0; i < ses.length; i++) {
		if (ses[i].id != "pageSize") {
			ses[i].value = 0;
		}
	}	
	
}



$(function(){
var tds= document.getElementsByTagName("td");
for(var i=0;i<tds.length;i++){
if(tds[i].innerHTML==""){
tds[i].innerHTML="&nbsp;";
}
}
/*
var tables=document.getElementsByTagName("table");
for(var i=0;i<tables.length;i++){
	if(tables[i].className=="bodyTable"){
	    var datatables= tables[i].getElementsByTagName("table");
	    for(var i=0;i<datatables.length;i++){
	     if(datatables[i].className=="dataTable"){
	           var tds=datatables[i].getElementsByTagName("td");
			    for(var i=0;i<tds.length;i++){
		        if(tds[i].innerHTML==""){
		            tds[i].innerHTML='<font color="red">&nbsp;</font>';
		          }
		       }
	      }
	    }
	   
	
	   
	}
}
*/


        var   olink   =   document.links;   
        for(var   i=0;i<olink.length;i++)   
        {   
                olink[i].onmouseover=function(){window.status='';return   true;}   
        }  

	try{
		var formObj = document.getElementsByTagName('form');
		if(formObj.length!=0){
			for(j=0;j<formObj.length;j++){
				var formEl = formObj[j].elements;     
				for (var i=0; i<formEl.length; i++){         
					var element = formEl[i];            
					if (element.type=='text') {
						element.maxLength=130;
					}
					/*if (element.type == 'textarea') {
						
						element.onkeydown=function(){
							
							if(this.value.length>50){
								return false;
							}
							
						}
						
					}*/             
				}
			} 
		}
		
	}catch(e){
		
	}
});

