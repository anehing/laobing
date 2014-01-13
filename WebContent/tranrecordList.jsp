<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>司机账户交易信息</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="queryTranrecord" method="post" id="form1" >
	    <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	             <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">司机姓名</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> <s:textfield id="username" name="tranrecord.username" ></s:textfield></td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">时间</td>
		            <td width="33%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		                    <input type="text" name="createtime" id="create_time" class="tcal"  />
		            &nbsp;-<input type="text" name="tocreatetime" id="tocreate_time" class="tcal"  />
		            </td>
                    <td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="查询" style="cursor: pointer"  />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>
	            </tr>
	            <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">交易类型</td>
		            <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		            <s:select list="#{0:'充值',1:'扣款'}" listKey="key" listValue="value" name ="tranrecord.status" id="status"  headerValue="请选择" headerKey="3" ></s:select>
	                <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText"></td>
		            <td width="33%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
	             </tr>
             </table>
        </div>
	
		<div align="center">
			<div class="data0">
				<div class="data1">
					<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="topTd" align="center" width="8%">序号</td>
							<td class="topTd" align="center" width="8%">司机姓名</td>
							<td class="topTd" align="center" width="8%">交易类型</td>
							<td class="topTd" align="center" width="8%">交易时间</td>
							<td class="topTd" align="center" width="8%">订单号</td>
						</tr>
						<s:if test="page.data.size > 0">
							<s:iterator value="page.data" var="t" status="s">
								<tr>
									<td class="dataTd" align="center">
										${s.index+1+page.pageSize*(PageNo-1)}
									</td>
									<td class="dataTd" align="center">
									${t.name}
								    </td>
									<td class="dataTd" align="center">
									  	<c:if test="${t.type eq 1}">司机充值</c:if>
								        <c:if test="${t.type eq 0}">平台扣费</c:if>				 
								    </td>
									<td class="dataTd" align="center"><fmt:formatDate value="${t.trans_datetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td class="dataTd" align="center">${t.order_num}
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
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/tcal.css" />
<script type="text/javascript" src="${ctx}/scripts/tcal.js"></script>  