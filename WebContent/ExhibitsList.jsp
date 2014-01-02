<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<script type="text/javascript">

</script>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>展品管理</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle"
			src="${ctx }/images/nxx8.png" width="80" height="22" />
	</div>
	<center>
		<s:form action="queryExhibits" method="post" id="form1"
			onsubmit="return toSubmit();">
			<div id="r0" align="center">
				<table class="dataTable" width="100%" border="0" align="center"
					cellpadding="0" cellspacing="1" bgcolor="#93b5d1">
					<tr>
						<td width="10%" align="center" bgcolor="#F3F8FE"
							class="dataTdText">中文名称</td>
						<td width="25%" align="left" bgcolor="#FFFFFF"><s:textfield
								name="exhibits.chineseName"></s:textfield></td>
						<td width="10%" align="center" bgcolor="#F3F8FE"
							class="dataTdText">英文名称</td>
						<td width="25%" align="left" bgcolor="#FFFFFF"><s:textfield
								name="exhibits.englishName"></s:textfield></td>
						<td rowspan="10" align="center" valign="middle" bgcolor="#FFFFFF" width="18%">
			<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer"  />
		    <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		</td>
					<tr>
						<td width="10%" align="center" bgcolor="#F3F8FE"
							class="dataTdText">质地类型</td>
						<td width="25%" align="left" bgcolor="#FFFFFF">
							<s:select name="exhibits.qualityGroupId" list="groupZhiDiList" listKey="id" listValue="groupName" headerKey="0" headerValue="请选择分组"></s:select>	
						</td>
						<td class="dataTdText" align="center" bgcolor="#F3F8FE">功用类型</td>
						<td width="25%" align="left" bgcolor="#FFFFFF" >
							<s:select name="exhibits.useGroupId" list="groupGongYongList" listKey="id" listValue="groupName" headerKey="0" headerValue="请选择分组"></s:select>	
						</td>
					</tr>
					<tr>
						<td class="dataTdText" align="center" bgcolor="#F3F8FE">辅助类型</td>
						<td align="left" bgcolor="#FFFFFF">
							<s:select name="exhibits.assistantGroupId" list="groupFuZhuList" listKey="id" listValue="groupName" headerKey="0" headerValue="请选择分组"></s:select>	
						</td>
						<td class="dataTdText" align="center" bgcolor="#F3F8FE">收藏地</td>
						<td align="left" bgcolor="#FFFFFF">
							<s:select name="exhibits.museumId" list="museumList" listKey="id" listValue="chineseName" headerKey="0" headerValue="请选择分组"></s:select>	
						</td>
					</tr>
					<tr>
						<td width="10%" align="center" class="dataTdText" bgcolor="#F3F8FE">展品分组</td>
						<td width="25%" align="left"  bgcolor="#FFFFFF" >
							<s:select name="exhibits.groupId" list="groupNameList" listKey="id" listValue="groupName" headerKey="0" headerValue="请选择分组"></s:select>	
						</td>
						<td width="10%" class="dataTdText" align="center" bgcolor="#F3F8FE"></td>
						<td  width="25%"  align="center" bgcolor="#FFFFFF"></td>
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
								<td class="topTd" align="center" width="7%">序号</td>
								<td class="topTd" align="center" width="8%">图片</td>
								<td class="topTd" align="center">展品中文名称</td>
								<td class="topTd" align="center">展品英文名称</td>
								<td class="topTd" align="center" width="9%">规格</td>
								<td class="topTd" align="center" width="9%">年代</td>
							<!-- 	<td class="topTd" align="center">展品中文介绍</td>
								<td class="topTd" align="center">展品英文介绍</td> -->
								<td class="topTd" align="center">操作</td>
							</tr>
							<s:if test="page.data.size > 0">
								<s:iterator value="page.data" var="t" status="s">
									<tr>
										<td class="dataTd" align="center">
											&nbsp;${s.index+1+page.pageSize*(PageNo-1)}</td>
										<td class="dataTd" align="center" >
								            <img  width="40" height="50" src="${t.photoUrl}"></img>
								        </td>
										<td class="dataTd" align="center">${t.chineseName}</td>
										<td class="dataTd" align="center">${t.englishName}</td>
										<td class="dataTd" align="center">${t.specification}</td>
										<td class="dataTd" align="center">${t.period}</td>
									<%-- 	<td class="dataTd" align="center">
											${t.chineseIntroduction}</td>
										<td class="dataTd" align="center">
											${t.englishIntroduction}</td> --%>

										<td class="dataTd" align="center">
											<a href="queryExhibitsbyId.action?totype=1&id=${t.id}">修改</a> 
											<a href="queryExhibitsbyId.action?totype=2&id=${t.id}">删除</a>
											<a href="queryExhibitsbyId.action?totype=3&id=${t.id}">详细</a>
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
								<td height="26" colspan="10" bgcolor="#edf2f8" align="center">&nbsp;
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
