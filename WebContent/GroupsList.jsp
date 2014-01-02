<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<script type="text/javascript">
	
</script>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>分组管理</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle"
			src="${ctx }/images/nxx8.png" width="80" height="22" />
	</div>
	<center>
		<s:form action="queryGroups" method="post" id="form1"
			onsubmit="return toSubmit();">
			<div id="r0" align="center">
			<table class="dataTable" width="97%" border="0" align="center"
					cellpadding="0" cellspacing="1" bgcolor="#93b5d1">
					<tr >
						<td width="15%" align="center" bgcolor="#F3F8FE"
							class="dataTdText" >分组名称</td>
						<td width="25%" align="left" bgcolor="#FFFFFF" ><s:textfield
								name="groups.groupName"></s:textfield>
						</td>
						<td width="15%" align="center" bgcolor="#F3F8FE"
							class="dataTdText" >分组类型</td>
						<td width="25%" align="left" bgcolor="#FFFFFF" >
						<s:select list="#{1:'博物馆',2:'展品质地类型',3:'展品功用类型',4:'展品辅助类型',5:'展品分组类型'}" name="groups.groupType" listKey="key" listValue="value" headerValue="请选择" headerKey="0"></s:select>
						</td>
							<td rowspan="10" align="center" valign="middle" bgcolor="#FFFFFF" width="18%">
			<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer"  />
		    <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
					</tr>
					


				</table>
			</div>

			<br />
			<div align="center">
				<div class="data0">
					<div class="data1">
						<table class="dataTable" width="100%" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td class="topTd" align="center" width="14%">序号</td>
								<td class="topTd" align="center" >分组名称</td>
								<td class="topTd" align="center">分组类型</td>
								<td class="topTd" align="center"width="14%">操作</td>
							</tr>
							<s:if test="page.data.size > 0">
								<s:iterator value="page.data" var="t" status="s">
									<tr>
										<td class="dataTd" align="center">
											&nbsp;${s.index+1+page.pageSize*(PageNo-1)}</td>
										<td class="dataTd" align="center">${t.groupName}</td>
											 <td class="dataTd" align="center">
											 <s:if test="#t.groupType ==1"> 博物馆</s:if> 
											 <s:if test="#t.groupType ==2">展品质地类型</s:if>
											 <s:if test="#t.groupType ==3">展品功用类型</s:if>
											 <s:if test="#t.groupType ==4">展品辅助分类项</s:if>
											  <s:if test="#t.groupType ==5">展品分组类项</s:if>
											 <s:else></s:else>
											 </td>
										
										<td class="dataTd" align="center"><a
											href="queryGroupsbyId.action?totype=1&id=${t.id}">修改</a> <a
											href="queryGroupsbyId.action?totype=2&id=${t.id}">删除</a>
										</td>
									</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr>
									<td class="dataTd" align="center" colspan="10"><font
										color="red">暂无数据！</font></td>
								</tr>
							</s:else>

							<tr>
								<td height="26" colspan="10" bgcolor="#edf2f8" align="left">&nbsp;
								</td>
							</tr>
						</table>
					</div>
				</div>
				<br />
				<table class="pageTable" width="97%" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td><lfx:page formId="form1" currentPageNo="${PageNo}"
								pageSize="${page.pageSize}" totalCount="${page.totalCount}"
								totalPageCount="${page.totalPageCount}" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="hidden" id="exprotTag" name="exprotTag"
							value="${exprotTag}" /> <input type="hidden" name="exportType"
							id="eType" /> <input type="hidden"
							value="${fn:length(page.data) }" id="resultTag" />
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</center>
</body>
