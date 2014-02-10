<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑后台用户</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateAdmin" namespace="/base" onsubmit="return checkSubmit();" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="admin.id" id="id" />
				<tr>
					<td width="15%" align="center" class="dataTd" >用户名称</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield id="username" name="admin.username"/>
					</td>    
				    <td width="15%" align="center" class="dataTd" >密码</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield name="admin.password" id="password"/>
					</td> 
				</tr>
				<tr>
				    <td width="15%" align="center" class="dataTd" >状&nbsp;&nbsp;态</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="状态" name ="admin.status" id="status"
					             list= "#{0:'&nbsp;可用&nbsp;',1:' &nbsp;不可用&nbsp;'}"  
					             listKey="key" listValue="value" value="admin.status" />
					</td>
					<td width="15%" align="center" class="dataTd" >用户类型</td>
					<td width="35%" align="left" class="dataTd" >
				        <s:radio label="用户类型" name ="admin.usertype" id="usertype"
						         list= "#{0:'&nbsp;普通用户&nbsp;',1:' &nbsp;管理员&nbsp;'}"
                                 listKey="key" listValue="value" value="admin.usertype" />
					</td>
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
<script type="text/javascript">
function checkSubmit(){
	
	 var username=document.getElementById("username").value;
	 var password=document.getElementById("password").value;
	 if(!checkNull(username)){
	      showErrorMsg("用户名称不能为空");
	      return false;
	 } else{
		 var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; 
		 if (!patrn.exec(username)){
			 showErrorMsg("用户名只能是5-20个以字母开头、可带数字、“_”、“.”的字串");
			 return false
		 }
	 } 
 	 if(!checkNull(password)){
	      showErrorMsg("密码不能为空");
	      return false;
	 } else{
		 var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; 
		 if (!patrn.exec(password)){
			 showErrorMsg("密码只能是5-20个以字母开头、可带数字、“_”、“.”的字串");
			 return false
		 }
	 } 
    return true;	
}
</script>