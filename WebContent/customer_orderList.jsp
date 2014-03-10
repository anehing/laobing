<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>订单管理</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="querycustomer_order" method="post" id="form1" enctype ="multipart/form-data" >
         <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	            <tr>   
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">下单时间</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                <input type="text" name="create_time" id="create_time" class="tcal" value="${create_time}"  />
		            &nbsp;-<input type="text" name="tocreate_time" id="tocreate_time" class="tcal" value="${tocreate_time}" />
		            </td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">订单状态</td>
				    <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
					    <s:select label="用户端接受状态" name ="customer_order.status" id="status"
					             list= "#{0:'接受',1:'服务中',2:'服务结束',3:'取消'}"  
					             listKey="key" listValue="value" value="customer_order.status" headerValue="请选择" headerKey="4" />
				    </td>
                    <td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="查询" style="cursor: pointer"  />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>
		        </tr> 
             </table>
        </div>
		<div align="center">
			<div class="data0">
				<div class="data1">
					<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="topTd" align="center" width="8%">序号</td>
							<td class="topTd" align="center" width="8%">订单号</td>
							<td class="topTd" align="center" width="8%">客户电话</td>
							<td class="topTd" align="center" width="8%">代驾地点</td>
							<td class="topTd" align="center" width="8%">下单时间</td>
							<td class="topTd" align="center" width="8%">出发时间</td>
							<td class="topTd" align="center" width="8%">司机人数</td>
							<td class="topTd" align="center" width="8%">订单状态</td>
							<td class="topTd" align="center" width="8%">操作</td>
						</tr>
						<s:if test="page.data.size > 0">
							<s:iterator value="page.data" var="t" status="s">
								<tr>
									<td class="dataTd" align="center">
										${s.index+1+page.pageSize*(PageNo-1)}
									</td>
									<td class="dataTd" align="center">
									   ${t.ordernum}				 
								    </td>
									<td class="dataTd" align="center">
									   ${t.customer_telphone}				 
								    </td>
									<td class="dataTd" align="center">${t.start_place}</td>
									<td class="dataTd" align="center">
									 <fmt:formatDate value="${t.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td class="dataTd" align="center">
									   <c:if test="${t.start_time eq 0}">半小时后</c:if>
								       <c:if test="${t.start_time eq 1}">1小时后</c:if>	
								       <c:if test="${t.start_time eq 2}">2小时后</c:if>
								       <c:if test="${t.start_time eq 3}">3小时后</c:if>	
									</td>
									<td class="dataTd" align="center">
									 ${t.driver}
									</td>
									<td class="dataTd" align="center">
									   <c:if test="${t.status eq 0}">接受</c:if>
								       <c:if test="${t.status eq 1}">服务中</c:if>	
								       <c:if test="${t.status eq 2}">服务结束</c:if>
								       <c:if test="${t.status eq 3}">取消</c:if>	
									</td>
									<td class="dataTd" align="center">
									  <a href="queryCustomer_orderbyId.action?totype=1&id=${t.id}">修改</a> 
									  <a href="queryCustomer_orderbyId.action?totype=2&id=${t.id}">删除</a>
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