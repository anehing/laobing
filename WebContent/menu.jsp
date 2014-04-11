<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="sdmenu/sdmenu.css" />
<script type="text/javascript" src="sdmenu/sdmenu.js"></script>
<script type="text/javascript">
//<![CDATA[
var myMenu;
window.onload = function() {
myMenu = new SDMenu("my_menu");
myMenu.init();
};
// ]]>
</script>
<head>
<style type="text/css">

</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>九点代驾</title>

</head>

<body >

<div  id="my_menu" class="sdmenu" >
  <div> 
    <span>注册管理</span> 
    <%=session.getAttribute("tree0")%>
  </div>
   <div> 
    <span>用户统计</span> 
    <%=session.getAttribute("tree1")%>
  </div>
   <div> 
    <span>订单管理</span> 
    <%=session.getAttribute("tree2")%>
  </div>
   <div> 
    <span>信息管理</span> 
    <%=session.getAttribute("tree3")%>
  </div>
   <div> 
    <span>优惠券管理</span> 
    <%=session.getAttribute("tree4")%>
  </div>
   <div> 
    <span>司机管理</span> 
    <%=session.getAttribute("tree5")%>
  </div>
   <div> 
    <span>价格管理</span> 
    <%=session.getAttribute("tree6")%>
  </div>
   <div> 
    <span>客户管理 </span> 
    <%=session.getAttribute("tree7")%>
  </div>
  <div> 
    <span>投诉管理 </span> 
    <%=session.getAttribute("tree9")%>
  </div>
   <div> 
    <span>其它</span> 
    <%=session.getAttribute("tree8")%>
  </div>
</div>

</body>

