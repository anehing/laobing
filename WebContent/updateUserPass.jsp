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
				showErrorMsg("只能上传格式为png,jpg,gif,bmp,jpeg的图片文件");
				return false;
			}
        }
	}
	return true;
}
function checkSubmit(){
	/* var userName=$("#user\\.userName").val();
		var regex=/^[0-9A-Za-z_]{6,15}$/;
		if(!regex.exec(userName)){
			 showErrorMsg("用户名只包含大小写英文、数字和下划线。长度在6-15之间");
		      return false;
		}
	 if(!checkNull(userName)){
	      showErrorMsg("请输入注册昵称");
	      return false;
	 }  */
	 var nickName=$("#user\\.nickName").val();
	 if(!checkNull(nickName)){
	      showErrorMsg("请输入注册昵称");
	      return false;
	 } 
	 var pass=$("#user\\.pass").val();
	 if(!checkNull(pass)){
	      showErrorMsg("请输入用户密码");
	      return false;
	 }
	 var regex=/^[0-9A-Za-z_]{6,15}$/;
	 if(!regex.exec(pass)){
		 showErrorMsg("密码只包含大小写英文、数字和下划线。长度在6-15之间");
		 return false;
	}
	 var sex=$("input[name='user.sex']:checked").val();
		if(sex==null){
			showErrorMsg("请选择用户性别");
			return false;
		}
	 var userType=$("input[name='user.userType']:checked").val();
	if(userType==null){
		showErrorMsg("请选择用户类型");
		return false;
	}
	

	var batchFileList = $("#batchFileName").val();
	if(! checkFileType(batchFileList) ){
		return false;
	}
	
	 var mobile= $("#user\\.mobile").val();
     if(checkNull(mobile)&&mobile.search(/^0?(130|131|132|133|134|135|136|137|138|139|147|150|151|152|153|155|156|157|158|159|180|181|182|183|184|185|186|187|188|189)[0-9]{8}$/)== -1){
   	  showErrorMsg("手机号码不正确");
 		return false; 
     }
var email=$("#user\\.email").val();
 if(checkNull(email)&&email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)== -1){
	  showErrorMsg("邮箱地址不正确");
		return false; 
 }
	 return true;
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
}

/* $().ready(function(){
	getCity_2('DmbCity','parentId','user.province',1);
});  */
function agelist(){
	 for(var i=10;i<81;i++){
		 $("#age").append("<option>"+i+"</option>"); 
		} 
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
<s:form action="updateUser" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >用户名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input type="hidden"  name="user.id" id="user.id" value="${user.id}">
					<input type="hidden"  name="user.parentId" id="user.parentId" value="${user.parentId}">
					<input type="hidden"  name="user.parentName" id="user.parentName" value="${user.parentName}">
				    	&nbsp;&nbsp;${user.userName}
					<!-- <input name="user.userName" type="text" id="user.userName" value=""/></td> -->
				    <td width="15%" align="center" class="dataTd" >用户姓名</td>
					<td width="35%" align="left" class="dataTd" >
					&nbsp;&nbsp;${user.name}
					<!-- <input name="user.name" type="text" id="user.name" value=""/></td> -->
				</tr>
			<tr>
					<td width="15%" align="center" class="dataTd" >用户昵称</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.nickName" type="text" id="user.nickName" value="${user.nickName}"/></td>
				    	<td width="15%" align="center" class="dataTd">用户头像</td>
						<td width="35%" align="left" class="dataTd">
						<s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="batchFileName" id="batchFileName" />
					      <input type="hidden" name="user.photoUrl" id="user.photoUrl" value="${user.photoUrl}"/> </td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >用户密码</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.pass" type="text" id="user.pass" value="${user.pass}"/></td>
				   <td width="15%" align="center" class="dataTd" >用户类型</td>
					<td width="35%" align="left" class="dataTd" >
					<s:radio label="用户类型" name ="user.userType" id="user.userType"
						list= "#{0:'&nbsp;普通用户&nbsp;',1:' &nbsp;管理员&nbsp;'}"  listKey="key" listValue="value"  /></td>
				</tr>
				<tr>
				 <td width="15%" align="center" class="dataTd" >性 &nbsp;&nbsp;&nbsp;别</td>
					<td width="35%" align="left" class="dataTd" >
					<s:radio label="性别" name ="user.sex" id="user.sex"
						list= "#{1:' 女 ',2:' 男 '}"
						 listKey="key" listValue="value"  /></td>
					<td width="15%" align="center" class="dataTd" >年  &nbsp;&nbsp;&nbsp;    龄</td>
					<td width="35%" align="left" class="dataTd" >
					<select id="age" name="user.age"  onfocus="agelist()"> <option>${user.age}</option> </select>
				    
				</tr>
					<tr>
					<td width="15%" align="center" class="dataTd" >手机号码</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.mobile" type="text" id="user.mobile" value="${user.mobile}"/></td>
				    <td width="15%" align="center" class="dataTd" >电子邮件</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.email" type="text" id="user.email" value="${user.email}"/>
				    </td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >说&nbsp;&nbsp;&nbsp; 明</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.note" type="text" id="user.note" value="${user.note}"/></td>
					<td width="15%" align="center" class="dataTd" >新浪微博</td>
					<td width="35%" align="left" class="dataTd" >
			<input name="user.sinaToken" type="text" id="user.sinaToken" value="${user.sinaToken}"/></td>  
				</tr>	
				<tr>
					 <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">城&nbsp;&nbsp;&nbsp; 市</td>
						<td width="35%" align="left" class="dataTd">
						<select name="user.province" id="user.province" onchange="getCity_2('DmbCity','parentId','user.city',this.value)" style="width:100px;">
					 	    <c:if test="${provinceList eq null}">
					 	  	 	 <option value="0" selected="selected" >请选择省</option>
					 	    </c:if>
					 	    <c:if test="${provinceList ne null}">
						 	    <c:forEach items="${provinceList}" var="obj">
									<option value="${obj.id}" <c:if test="${user.province eq obj.id}">selected="selected"</c:if>>${obj.name}</option> 
						 	    </c:forEach>							
					 	    </c:if>					 	    
						 </select> 					
						<select name="user.city" id="user.city" onchange="getCity_2('DmbCity','parentId','user.country',this.value)" style="width:100px;">
					 	    <c:if test="${cityList eq null}">
					 	  	 	 <option value="0" selected="selected" >请选择市</option>
					 	    </c:if>
					 	    <c:if test="${cityList ne null}">
						 	    <c:forEach items="${cityList}" var="obj">
									<option value="${obj.id}" <c:if test="${user.city eq obj.id}">selected="selected"</c:if>>${obj.name}</option> 
						 	    </c:forEach>							
					 	    </c:if>							
						 </select> 					
						 <select name="user.country" id="user.country" style="width:100px;">
					 	    <c:if test="${countryList eq null}">
					 	  	 	 <option value="0" selected="selected" >请选择区县</option>
					 	    </c:if>
					 	    <c:if test="${countryList ne null}">
						 	    <c:forEach items="${countryList}" var="obj">
									<option value="${obj.id}" <c:if test="${user.country eq obj.id}">selected="selected"</c:if>>${obj.name}</option> 
						 	    </c:forEach>							
					 	    </c:if>							 
						 </select> 	
					</td>
				    <td width="15%" align="center" class="dataTd" >地&nbsp;&nbsp;&nbsp;  址</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="user.address" type="text" id="user.address" value="${user.address}"/>
				    </td>
				</tr> 		
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