<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span>更新推送信息</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateTwitter" namespace="/base" onsubmit="return toSubmit()" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="price.id" id="id" />
				<tr>
					<td width="15%" align="center" class="dataTd" >标题</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield id="title" name="twitter.title"/>
					</td>    
					<td width="15%" align="center" class="dataTd" >正文</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield id="content" name="twitter.content"/>
					</td>    
				</tr>
				<tr>
				    <td width="15%" align="center" class="dataTd" >推送类型</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="推送类型" name ="twitter.sendtype" id="sendtype"
					             list= "#{0:'所有用户都收到',1:'按城市用户推送'}"  
					             listKey="key" listValue="value" value="twitter.sendtype" />
					</td>
					<td width="15%" align="center" class="dataTd" >手机类型</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="状态" name ="twitter.type" id="status"
					             list= "#{0:'司机端接受',1:'用户端接受'}"  
					             listKey="key" listValue="value" value="twitter.type" />
					</td>
				</tr>
				<tr>
				    <td width="15%" align="center" class="dataTd" >推送类型</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="推送类型" name ="twitter.sendtype" id="sendtype"
					             list= "#{0:'所有用户都收到',1:'按城市用户推送'}"  
					             listKey="key" listValue="value" value="twitter.sendtype" />
					</td>
				</tr>
				<tr>	
					<td width="15%" align="center" class="dataTd" >城市</td>
					<td width="35%" align="left" class="dataTd" >
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