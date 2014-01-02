<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<script type="text/javascript">
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >详细信息</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div>
	
	 
<s:form action="updateUserlog" namespace="/base"  id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >用户名称</td>
					<td width="35%" align="left" class="dataTd" >
					${u.userName}
				    </td>
				    <td width="15%" align="center" class="dataTd" >操作日期</td>
					<td width="35%" align="left" class="dataTd" >
					${u.showDate}
				    </td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >操作类型</td>
					<td width="35%" align="left" class="dataTd" >
						  <c:if test="${u.operatype ==0}"> 删除</c:if> 
								 <c:if test="${u.operatype==1}"> 添加</c:if> 
											 <c:if test="${u.operatype ==2 }">修改</c:if> 
											 <c:if test="${u.operatype ==3}">查询</c:if>
											 <c:if test="${u.operatype==4}">登录</c:if>
											  <c:if test="${u.operatype ==5}">导出</c:if>
											  <c:if test="${u.operatype ==6}">导入</c:if>
											  <c:if test="${u.operatype ==7}">退出</c:if>
											  <c:if test="${u.operatype ==8}">执行定时</c:if>
				    </td>
				    <td width="15%" align="center" class="dataTd" >操作 IP</td>
					<td width="35%" align="left" class="dataTd" >
					${u.ip}
				    </td>
				</tr>
			<tr>
			<td width="15%" align="center" class="dataTd" >操作描述</td>
					<td width="35%" align="left" class="dataTd" colspan="7">
						${u.operadesc}
				    </td>
				</tr>	
				 <tr>
					<td bgcolor="#edf2f8" colspan="8" align="center"  >
                        <input	type="button" class="inputBtn"   value="返回" onclick="javaScript:history.go(-1)" style="cursor: pointer" />
					</td>
				</tr>	 			
			</table>
		</div>
	</div>
</s:form>
</body>