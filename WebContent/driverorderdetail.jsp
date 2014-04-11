<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>
<style type="text/css">
<!--
body {
	background-image: url(images/new/bg05.gif) repeat-y;
	margin-top: 10px;
}

html {
	overflow-y: scroll;
}
-->
</style>
<body >
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>订单详情</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form  namespace="/base" method="post" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >司机手机号</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.drivertelphone}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >用户手机号</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.customertelphone}
					    </td>   
				   </tr>
				     <tr>
				        <td width="15%" align="center" class="dataTd" >订单号</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.ordernum}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >代驾时间</td>
					    <td width="35%" align="left" class="dataTd"><fmt:formatDate value="${driver_order.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					    </td>   
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >代驾开始地点</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.start_place}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >代驾结束地点</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.end_place}
					    </td>   
				   </tr>
				   	 <tr>
				        <td width="15%" align="center" class="dataTd" >代驾距离(公里)</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.distance}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >代驾费用(元)</td>
					    <td width="35%" align="left" class="dataTd">${driver_order.fee}
					    </td>   
				   </tr>
				   <tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						    <input  type="button" class="inputBtn" value="返回"
						        	onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
				   </tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
