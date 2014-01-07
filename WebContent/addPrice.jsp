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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增价格信息</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addPrice" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="26" colspan="4" align="left" class="topTd">&nbsp;</td>
					</tr>
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >城市</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="city" name="price.city"/>
					    </td>    
				        <td width="15%" align="center" class="dataTd" >时间段</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield name="price.time" id="time"/>
				    	</td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >价&nbsp;&nbsp;格</td>
				     	<td width="35%" align="left" class="dataTd" >
				     	      <s:textfield name="price.price" id="price"/>
					    </td>
					    <td width="15%" align="center" class="dataTd" ></td>
					    <td width="35%" align="left" class="dataTd" ></td>
				   </tr>
				   <tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						    <input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						    <input  type="button" class="inputBtn" value="返回"
						        	onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
				   </tr>
				</table>
			</div>
		</div>
	</s:form>
</body>