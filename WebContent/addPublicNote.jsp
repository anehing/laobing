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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增公告</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addPublicNote" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >标题</td>
					    <td colspan="3" class="dataTd" >
					        <s:textfield id="title" name="publicnote.title" cols="130" rows="3"/>
					    </td>    
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >正文</td>
					    <td colspan="3" class="dataTd" >
					        <s:textarea name="publicnote.content" id="content" cols="130" rows="3"/>
				    	</td> 
				    	
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
<script type="text/javascript">
function checkSubmit(){
	 var title=document.getElementById("title").value;
	 if(!checkNull(title)){
	      showErrorMsg("标题不能为空");
	      return false;
	 }
	 var content=document.getElementById("content").value;
	 if(!checkNull(content)){
	      showErrorMsg("正文不能为空");
	      return false;
	 }
	
	 return true;	
}
</script>