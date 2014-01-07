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
<s:form action="updateDriver" namespace="/base" onsubmit="return toSubmit()" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="driver.id" id="id" />
				  <tr>
                        <td width="15%" align="center" class="dataTd" >头像</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.picture"  id="picture" /></td>  
				    	<td width="15%" align="center" class="dataTd" >姓名</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="name" name="driver.name"/>
					    </td>    
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >性别</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:radio label="性别" name ="driver.sex" id="sex"
					             list= "#{0:'&nbsp;男&nbsp;',1:' &nbsp;女&nbsp;'}"  
					             listKey="key" listValue="value" value="driver.sex" />
					   </td>
				        <td width="15%" align="center" class="dataTd" >年龄</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="age" name="driver.age"/>
					    </td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >籍贯</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="city" name="driver.city"/>
					    </td> 
					    <td width="15%" align="center" class="dataTd" >所在城市</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="city" name="driver.city"/>
					    </td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >手机号码</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.telphone"  id="telphone" /></td>
				        <td width="15%" align="center" class="dataTd" >身份证号</td>
					    <td width="35%" align="left" class="dataTd" >
			        	    <s:textfield name="driver.ident_num"  id="ident_num" />
				        </td>
				   </tr>
			       <tr>
				    	<td width="15%" align="center" class="dataTd" >驾照号</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.drive_card"  id="drive_card" />
					    </td>
					    <td width="15%" align="center" class="dataTd" >驾龄</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.year"  id="year" />
					    </td>
				   </tr>	
				   <tr>
				    	<td width="15%" align="center" class="dataTd" >代驾次数</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.times"  id="times" /></td>
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
function toSubmit(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;

	if(!checkNull(username)){
	      showErrorMsg("请输入用户名称");
	      return false;
	 }
	if(!checkNull(password)){
	      showErrorMsg("请输入密码");
	      return false;
	 }

	return ture;
}
</script>