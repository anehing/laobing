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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>司机详情</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form  namespace="/base" method="post" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >司机姓名</td>
					    <td width="35%" align="left" class="dataTd">${driver.name}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >司机手机号</td>
					    <td width="35%" align="left" class="dataTd">${driver.telphone}
					    </td>  
				   </tr>
				    <tr>
				    	<td width="15%" align="center" class="dataTd" >司机年龄</td>
					    <td width="35%" align="left" class="dataTd">${driver.age}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >司机驾龄</td>
					    <td width="35%" align="left" class="dataTd">${driver.year}
					    </td>  
				   </tr>
				    <tr>
				    	<td width="15%" align="center" class="dataTd" >司机籍贯</td>
					    <td width="35%" align="left" class="dataTd">${driver.city}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >所在城市</td>
					    <td width="35%" align="left" class="dataTd">${driver.mc}
					    </td>  
				   </tr>
				    <tr>
				    	<td width="15%" align="center" class="dataTd" >身份证号</td>
					    <td width="35%" align="left" class="dataTd">${driver.ident_num}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >驾驶证号</td>
					    <td width="35%" align="left" class="dataTd">${driver.drive_card}
					    </td>  
				   </tr>
				    <tr>
				    	<td width="15%" align="center" class="dataTd" >司机分数</td>
					    <td width="35%" align="left" class="dataTd">${score}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >司机昨日收入</td>
					    <td width="35%" align="left" class="dataTd">${yesfee}
					    </td>  
				   </tr>
				   <tr>
				    	<td width="15%" align="center" class="dataTd" >司机上月收入</td>
					    <td width="35%" align="left" class="dataTd">${monthfee}
					    </td>  
					    <td width="15%" align="center" class="dataTd" >司机全部收入</td>
					    <td width="35%" align="left" class="dataTd">${allfee}
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
