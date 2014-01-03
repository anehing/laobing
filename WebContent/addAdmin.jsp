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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增用户</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addAdmin" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="26" colspan="4" align="left" class="topTd">&nbsp;</td>
					</tr>
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
				        <td width="15%" align="center" class="dataTd" >手机号码</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="admin.mobile"  id="mobile" /></td>
				        <td width="15%" align="center" class="dataTd" >电子邮件</td>
					    <td width="35%" align="left" class="dataTd" >
			        	    <s:textfield name="admin.email"  id="email" />
				        </td>
				   </tr>
			       <tr>
				    	<td width="15%" align="center" class="dataTd" >姓&nbsp;&nbsp;名</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="admin.name"  id="name" />
					    </td>
				     	<td width="15%" align="center" class="dataTd" >座机号码</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="admin.telphone"  id="telphone" /></td>  
				  </tr>	
				  <tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						    <input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						    <input  adminList.jsptype="button" class="inputBtn" value="返回"
						        	onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
				  </tr>
				</table>
			</div>
		</div>
	</s:form>
</body>