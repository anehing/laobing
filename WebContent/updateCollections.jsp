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
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑收藏</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateCollections" namespace="/base" onsubmit="return checkSubmit()" id="form1">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >用户名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input type="hidden" name="collections.id" id="collections.id" value="${e.id}">
					<input name="collections.userName" type="text" id="collections.userName" value="${e.userName}"/>
                    <td width="15%" align="center" class="dataTd" >展品名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input type="hidden" name="collections.exhibitId" id="collections.exhibitId" value="${e.exhibitId}">
					<input name="collections.exhibitName" type="text" id="collections.exhibitName" value="${e.exhibitName}"/>
				</tr>
			
				<tr>
					<td bgcolor="#edf2f8" colspan="8" align="center">
						<input	type="submit" class="inputBtn"   value="确定" style="cursor: pointer" />
                        <input	type="button" class="inputBtn"   value="返回" onclick="javaScript:history.go(-1)" style="cursor: pointer" />
					</td>
				</tr>				
			</table>
		</div>
	</div>
</s:form>
</body>