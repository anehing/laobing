<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>司机管理</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="queryDriver" method="post" id="form1" enctype ="multipart/form-data" >
	    <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	             <tr>
	                <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">工作状态</td>
	                <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                <s:select list="#{0:'空闲',1:'繁忙',2:'结束工作'}" listKey="key" listValue="value" name ="driver.job_status" id="job_status"  headerValue="请选择" headerKey="3" ></s:select>
		            </td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">城市</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                      <s:select list="dmb_citylist" listKey="mc" listValue="mc" name ="driver.mc" id="mc"  headerValue="请选择" headerKey="请选择" ></s:select>
		            </td>
                    <td rowspan="4" align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="查询" style="cursor: pointer"  />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>
	            </tr>
	            <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">姓&nbsp;&nbsp;&nbsp;名</td>
		            <td width="25%" align="left" bgcolor="#FFFFFF"> <s:textfield name="driver.name" id="name"></s:textfield></td>
                    <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">手机号</td>
		            <td width="25%" align="left" bgcolor="#FFFFFF"> <s:textfield name="driver.telphone" id="telphone"></s:textfield></td>
	            </tr>
	            <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">性&nbsp;&nbsp;&nbsp;别</td>
		            <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		               <s:select list="#{0:'男',1:'女'}" listKey="key" listValue="value" name ="driver.sex" id="sex"  headerValue="请选择" headerKey="3" ></s:select>
		            </td>
                    <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">身份证号</td>
		            <td width="25%" align="left" bgcolor="#FFFFFF"> <s:textfield name="driver.ident_num" id="ident_num"></s:textfield></td>
	            </tr>
	            <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">驾照号</td>
		            <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		               <s:textfield name="driver.drive_card" id="drive_card"></s:textfield>
		            </td>
                    <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">账户费用(￥)</td>
		            <td width="25%" align="left" bgcolor="#FFFFFF"> <s:textfield name="driver.servicefee" id="servicefee" value=""></s:textfield></td>
	            </tr>
             </table>
        </div>
	
		<div align="center">
			<div class="data0">
				<div class="data1">
					<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="topTd" align="center" width="4%">序号</td>
							<td class="topTd" align="center" width="4%">状态</td>
							<td class="topTd" align="center" width="6%">头像</td>
							<td class="topTd" align="center" width="3%">姓名</td>
							<td class="topTd" align="center" width="3%">年龄</td>
							<td class="topTd" align="center" width="3%">籍贯</td>
							<td class="topTd" align="center" width="6%">身份证号</td>
							<td class="topTd" align="center" width="4%">手机号</td>
							<td class="topTd" align="center" width="4%">驾照号</td>
							<td class="topTd" align="center" width="3%">驾龄(年)</td>
							<td class="topTd" align="center" width="3%">星好评级</td>
							<td class="topTd" align="center" width="3%">代驾次数</td>
							<td class="topTd" align="center" width="3%">所在城市</td>
							<td class="topTd" align="center" width="3%">账户费用</td>
							<td class="topTd" align="center" width="4%">操作</td>
						</tr>
						<s:if test="page.data.size > 0">
							<s:iterator value="page.data" var="t" status="s">
								<tr>
									<td class="dataTd" align="center">
										${s.index+1+page.pageSize*(PageNo-1)}
									</td>
									<td class="dataTd" align="center">
									   <c:if test="${t.job_status eq 2}">结束工作</c:if>
								       <c:if test="${t.job_status eq 1}">繁忙</c:if>	
								       <c:if test="${t.job_status eq 0}">空闲</c:if>							 
								    </td>
								    <td class="dataTd" align="center"> <img  width="40" height="40" src="${t.picture}"></img></td>
									<td class="dataTd" align="center">${t.name}</td>
									
									<td class="dataTd" align="center">${t.age}</td>
									<td class="dataTd" align="center">${t.city}</td>
									<td class="dataTd" align="center">${t.ident_num}</td>
									<td class="dataTd" align="center">${t.telphone}</td>
									<td class="dataTd" align="center">${t.drive_card}</td>
									<td class="dataTd" align="center">${t.year}</td>
									<td class="dataTd" align="center">${t.stars}</td>
									<td class="dataTd" align="center">${t.times}</td>
									<td class="dataTd" align="center">${t.mc}</td>
									<td class="dataTd" align="center">${t.servicefee}</td>
									<td class="dataTd" align="center">
									  <a href="queryDriverbyId.action?totype=1&id=${t.id}">修改</a> 
									  <a href="queryDriverbyId.action?totype=2&id=${t.id}">删除</a>
									</td>
								</tr>
							</s:iterator>
						</s:if>
						<s:else>
							<tr>
								<td class="dataTd" align="center" colspan="8">
								    <font color="red">暂无数据！</font>
								</td>
							</tr>
						</s:else>
					</table>
				</div>
			</div>
			<br />
			<table class="pageTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="0" >
	            <tr>
		           <td>
		               <lfx:page formId="form1" currentPageNo="${PageNo}"
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
</body>
