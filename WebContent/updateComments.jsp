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
<script type="text/javascript">
function checkSubmit(){
	var content= document.getElementById("comments.content").value
	if(!checkNull(content)){
	      showErrorMsg("评论内容不能为空");
	      return false;
	 }
     return true;	
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑评论</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateComments" namespace="/base" onsubmit="return checkSubmit()" id="form1">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >评论内容</td>
					<td width="35%" align="left" class="dataTd" colspan="7">
					<input type="hidden" name="comments.id" id="comments.id" value="${e.id}">
					<textarea name="comments.content"  id="comments.content" rows="5" cols="100"
				>${e.content}</textarea>

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