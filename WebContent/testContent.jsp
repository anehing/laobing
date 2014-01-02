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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>测试</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addJsonComments" namespace="/base" method="post"
		onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="26" colspan="4" align="left" class="topTd">&nbsp;</td>
					</tr>
					<tr>
					    <td width="15%" align="center" class="dataTd">内容测试</td>
						<td width="35%" align="left" class="dataTd">
							<textarea rows="2" cols="40" name="content"></textarea>
							
						</td>
					    <td width="15%" align="center" class="dataTd">用户ID</td>
						<td width="35%" align="left" class="dataTd">
							<input name="userId">
					     </td>
					</tr>	
					<tr>
					    <td width="15%" align="center" class="dataTd">展品ID</td>
						<td width="35%" align="left" class="dataTd">
							、<input name="exhibitId">
						</td>
					    <td width="15%" align="center" class="dataTd"></td>
						<td width="35%" align="left" class="dataTd">
					     </td>
					</tr>										
					<tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						<input type="button" class="inputBtn" value="返回"
							onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>