<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<script type="text/javascript">
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >用户管理</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div>   

<%@ include file="commons/messages.jsp"%>
<div  align="right" onClick="nxx(0)"
	style="width: 97%; margin: auto"><img id="z0"
	style="cursor: pointer" align="middle" src="${ctx }/images/nxx8.png"
	width="80" height="22" /></div>
<center>
<s:form action="queryUsers" method="post" id="form1" onsubmit="return toSubmit();" enctype ="multipart/form-data">
<div id="r0" align="center" >
<table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	<tr >
		<td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">用户名称</td>
		<td width="25%" align="left" bgcolor="#FFFFFF"> <s:textfield name="user.userName" ></s:textfield></td>
		<td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">用户类型</td>
		<td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		<s:select list="#{0:'普通用户',1:'管理员'}" listKey="key" listValue="value" name ="user.userType" id="user.userType"  headerValue="请选择" headerKey="3" ></s:select>
		<td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer"  />
		    <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		</td>
	</tr>
	

</table>
</div>

<br />
<div align="center">
		<div class="data0">
		   <div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="topTd" align="center" width="8%">序号</td>
						<td class="topTd" align="center" width="10%">头&nbsp;像</td>
						<td class="topTd" align="center"  width="8%">用户类型</td>
						<td class="topTd" align="center"  width="12%">用户名称</td>
						<td class="topTd" align="center"  width="12%">用户昵称</td>
						<td class="topTd" align="center"  width="10%">姓&nbsp;名</td>
						<td class="topTd" align="center" width="20%">注册时间</td>
						<td class="topTd" align="center" width="8%">操作</td>
					</tr>
					  <s:if test="page.data.size > 0">
						<s:iterator value="page.data" var="t" status="s">
							<tr>
								<td class="dataTd" align="center" >
								   ${s.index+1+page.pageSize*(PageNo-1)}
								</td>
								<td class="dataTd" align="center" >
										 <img  width="40" height="40" src="${t.photoUrl}"></img>					
								</td>
								<td class="dataTd" align="center" >
								 <c:if test="${t.userType eq 0}">普通用户
								 </c:if>
								 <c:if test="${t.userType eq 1}">
								 管理员
								 </c:if>
								</td>
								<td class="dataTd" align="center" >
								     ${t.userName}
								   </td>
								   <td class="dataTd" align="center" >
								     ${t.nickName}
								   </td>
								<td class="dataTd" align="center" >
								 	  ${t.name}
								</td>
								<td class="dataTd" align="center" >
								${t.regDateStr}
								</td>
								
									<td class="dataTd" align="center" >
									<a href="queryUserbyId.action?totype=1&id=${t.id}">修改</a>
									<a href="queryUserbyId.action?totype=2&id=${t.id}">删除</a>
								</td>
							</tr>
							
						</s:iterator>
					</s:if>
					<s:else> 
					   <tr>
						   <td class="dataTd" align="center"  colspan="8"><font color="red">暂无数据！</font></td>
					   </tr>
					</s:else>	
						 
					<tr>
						<td height="26" colspan="8" bgcolor="#edf2f8" 	align="left">&nbsp;
						</td>
					</tr>
				</table>
		</div>
	</div>
<br />
<table class="pageTable" width="97%" border="0" align="center" cellpadding="0"
	cellspacing="0" >
	<tr>
		<td><lfx:page formId="form1" currentPageNo="${PageNo}"
			pageSize="${page.pageSize}" totalCount="${page.totalCount}"
			totalPageCount="${page.totalPageCount}" />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="hidden" id="exprotTag" name="exprotTag" value="${exprotTag}" />
				<input type="hidden" name="exportType" id="eType" />
				<input type="hidden" value="${fn:length(page.data) }" id="resultTag" />
			</td>

	</tr>
</table>
</div>
</s:form>
</center>
</body>
