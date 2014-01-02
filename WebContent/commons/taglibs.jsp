<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/lfx" prefix="lfx"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href='${ctx}/styles/jquery-ui-1.7.1.custom.css' rel='stylesheet'
	type='text/css' />
<link href='${ctx}/styles/default.css' rel='stylesheet' type='text/css' />
<link href='${ctx}/styles/balckListTab.css' rel='stylesheet'
	type='text/css' />
<link href='${ctx}/styles/tablesorter.css' rel='stylesheet'
	type='text/css' />
<link href='${ctx}/styles/thickbox.css' rel="stylesheet" type="text/css"
	media="screen" />
<link rel=stylesheet type=text/css href="${ctx}/styles/red.css"> 
<!-- Contact Form CSS files -->
<link type='text/css' href='${ctx}/styles/basic.css' rel='stylesheet' media='screen' />
<style type="text/css">
.bodyWidth{
	width:1050px;
}
</style>
<!-- IE 6 "fixes" -->
<!--[if lt IE 7]>
<link type='text/css' href='${ctx}/styles/basic_ie.css' rel='stylesheet' media='screen' />
<![endif]-->



<script src="${ctx}/scripts/jquery-1.3.2.js" ></script>
<script src="${ctx}/scripts/jquery-ui-1.7.1.custom.min.js" charset="GBK"></script>
<script src="${ctx}/scripts/thickbox-compressed.js" ></script>
<script src="${ctx}/scripts/jquery.json.js" ></script>
<script src="${ctx}/scripts/jquery.form.js" ></script>
<script src="${ctx}/scripts/jquery.simplemodal-1.3.3.min.js" ></script>
<script src="${ctx}/scripts/tools.js" ></script>
<script src="${ctx}/scripts/tools2.js" ></script>
<!--<script src="${ctx}/scripts/company.js" ></script>-->
<script src="${ctx}/scripts/utilCode.js" ></script>
<script src="${ctx}/scripts/ValidateTools.js" charset="GBK"></script>
<script src="${ctx}/scripts/jquery.tablesorter.js" ></script>
<!--<script src="${ctx}/My97DatePicker/WdatePicker.js" ></script>-->
<noscript> <iframe   src="*.htm"> </iframe> </noscript>
<noscript> <iframe   src="*.jsp"> </iframe> </noscript>
<script type="text/javascript">
function getInfo(){   
	 var s = "";    
		s += " 网页可见区域宽："+ document.body.clientWidth+",";  
		s += " 网页可见区域高："+ document.body.clientHeight+",";  
		s += " 网页可见区域宽："+ document.body.offsetWidth + " (包括边线和滚动条的宽),";   
		s += " 网页可见区域高："+ document.body.offsetHeight + " (包括边线的宽),";   
		s += " 网页正文全文宽："+ document.body.scrollWidth+",";   
		s += " 网页正文全文高："+ document.body.scrollHeight+",";  
		s += " 网页被卷去的高(ff)："+ document.body.scrollTop+",";  
		s += " 网页被卷去的高(ie)："+ document.documentElement.scrollTop+",";   
		s += " 网页被卷去的左："+ document.body.scrollLeft+",";   
		s += " 网页正文部分上："+ window.screenTop+",";   
		s += " 网页正文部分左："+ window.screenLeft+",";   
		s += " 屏幕分辨率的高："+ window.screen.height+",";    
		s += " 屏幕分辨率的宽："+ window.screen.width+",";    
		s += " 屏幕可用工作区高度："+ window.screen.availHeight+",";   
		s += " 屏幕可用工作区宽度："+ window.screen.availWidth+",";   
		s += " 你的屏幕设置是 "+ window.screen.colorDepth +" 位彩色,";   
		s += " 你的屏幕设置 "+ window.screen.deviceXDPI +" 像素/英寸";   
		if(document.body.clientWidth<1000 && document.getElementsByTagName("body")[0].id != "model"){
			document.getElementsByTagName("body")[0].className="bodyWidth";
		}else{
			document.getElementsByTagName("body")[0].className="";
		};
     //  alert (s);
}

</script>  
</head>
<body oncontextmenu="window.status='';return false;" onload="getInfo();">
