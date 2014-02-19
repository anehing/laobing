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
function checkFileType(filename){
	if(filename != ""){
		if(filename.indexOf(".")!=-1){
			var  tem = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
			if(tem == "png" || tem == "jpg" || tem == "jpeg" || tem == "gif" || tem == "bmp"){
                 return  true;
			}else{
				showErrorMsg("只能上传图片，只能是png,jpg,gif,bmp,jpeg");
				return false;
			}
        }
	}
	return true;
}
function checkSubmit(){
	var userName=$("#user\\.userName").val();
	 if(!checkNull(userName)){
	      showErrorMsg("请输入注册昵称");
	      return false;
	 } 
	 var name=$("#user\\.name").val();
	 if(!checkNull(name)){
	      showErrorMsg("请输入用户名");
	      return false;
	 } 
	var batchFileList = document.getElementsByName("photoFileName");
	if(checkNull(batchFileList)){
	for(var i=0; i<batchFileList.length; i++){
		 if(!checkFileType(batchFileList[i].value)){
		    return false;
		 }
	}	 
	}
	 return true;
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("photoFileName").value=name.substring(name.lastIndexOf("\\")+1);
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑用户</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateUserJson" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >用户名称</td>
					<td width="35%" align="center" class="dataTd" >
					<input type="hidden"  name="user.userIdStr" id="user.userIdStr" value="${user.userIdStr}">
					<input name="user.userName" type="text" id="user.userName" value="${user.userName}"/></td>
				    <td width="15%" align="center" class="dataTd" >用户姓名</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.name" type="text" id="user.name" value="${user.name}"/></td>
				</tr>
			<tr>
					<td width="15%" align="center" class="dataTd" >用户昵称</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.nickName" type="text" id="user.nickName" value="${user.nickName}"/></td>
				    	<td width="15%" align="center" class="dataTd">用户头像</td>
						<td width="35%" align="center" class="dataTd">
						<s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="photoFileName" id="photoFileName" />
					     <input type="hidden" name="user.photoUrl" id="user.photoUrl" value="${user.photoUrl}"/> </td>
				</tr>
				<tr>
				 <td width="15%" align="center" class="dataTd" >性 &nbsp;&nbsp;&nbsp;   别</td>
					<td width="35%" align="center" class="dataTd" >
					<s:radio label="性别" name ="user.sex" id="user.sex"
						list= "#{0:' 男 ',1:' 女 '}"
						 listKey="key" listValue="value"  /></td>
					<td width="15%" align="center" class="dataTd" >年  &nbsp;&nbsp;&nbsp;    龄</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.age" type="text" id="user.age" value="${user.age}"/></td>
				    
				</tr>
					<tr>
					<td width="15%" align="center" class="dataTd" >手机号码</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.mobile" type="text" id="user.mobile" value="${user.mobile}"/></td>
				    <td width="15%" align="center" class="dataTd" >电子邮件</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.email" type="text" id="user.email" value="${user.email}"/>
				    </td>
				</tr>

				<tr>
					<td width="15%" align="center" class="dataTd" >说&nbsp;&nbsp;&nbsp; 明</td>
					<td width="35%" align="center" class="dataTd" >
					<input name="user.note" type="text" id="user.note" value="${user.note}"/></td>
					<td width="15%" align="center" class="dataTd" >新浪微博</td>
					<td width="35%" align="center" class="dataTd" >
			<input name="user.sinaToken" type="text" id="user.sinaToken" value="${user.sinaToken}"/></td>  
				
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >生日</td>
					<td width="35%" align="center" class="dataTd" >
						<input name="user.birthdayStr" type="text" value="${user.birthdayStr}"/></td>
					<td width="15%" align="center" class="dataTd" ></td>
					<td width="35%" align="center" class="dataTd" >
				
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