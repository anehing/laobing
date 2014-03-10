<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>优惠券管理</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="queryCoupon" method="post" id="form1" enctype ="multipart/form-data" >
	    <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	             <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">优惠券号码</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                <s:textfield id="coupon_num" name="coupon.coupon_num" ></s:textfield>
		            </td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">是否是邀请码</td>
		            <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		                <s:select list="#{0:'邀请码',1:'优惠券'}" listKey="key" listValue="value" name ="coupon.is_invitation_code" id="is_invitation_code"  headerValue="请选择" headerKey="3" ></s:select>
		            </td>
		            <td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="查询" style="cursor: pointer"  />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>
	            </tr>
	            <tr>   
		            
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">录入时间</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                <input type="text" name="create_time" id="create_time" class="tcal" value="${create_time}"  />
		            &nbsp;-<input type="text" name="tocreate_time" id="tocreate_time" class="tcal" value="${tocreate_time}" />
		            </td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">使用时间</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
		                <input type="text" name="use_time" id="use_time" class="tcal" value="${use_time}" />
		             &nbsp;-<input type="text" name="touse_time" id="touse_time" class="tcal" value="${touse_time}" />
		            </td>
		        </tr> 
		        <tr>   
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">是否已使用</td>
		            <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		                <s:select list="#{0:'未使用',1:'已使用'}" listKey="key" listValue="value" name ="coupon.is_use" id="is_use"  headerValue="请选择" headerKey="3" ></s:select>
		            </td>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText"></td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> 
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
							<td class="topTd" align="center" width="8%">优惠券号</td>
							<td class="topTd" align="center" width="8%">优惠金额(￥)</td>
							<td class="topTd" align="center" width="8%">是否已使用</td>
							<td class="topTd" align="center" width="8%">使用时间</td>
							<td class="topTd" align="center" width="8%">使用手机号</td>
							<td class="topTd" align="center" width="8%">录入时间</td>
							<td class="topTd" align="center" width="8%">是否是邀请码</td>
						</tr>
						<s:if test="page.data.size > 0">
							<s:iterator value="page.data" var="t" status="s">
								<tr>
									<td class="dataTd" align="center">
										${s.index+1+page.pageSize*(PageNo-1)}
									</td>
									<td class="dataTd" align="center">${t.coupon_num}</td>
									<td class="dataTd" align="center">${t.discount_amount}</td>
									<td class="dataTd" align="center">
									   <c:if test="${t.is_use eq 0}">未使用 </c:if>
								       <c:if test="${t.is_use eq 1}">已使用 </c:if>							 
								    </td>
								    <td class="dataTd" align="center"><fmt:formatDate value="${t.use_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								    <td class="dataTd" align="center">${t.telphone}</td>
								    <td class="dataTd" align="center"><fmt:formatDate value="${t.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								    <td class="dataTd" align="center">
									   <c:if test="${t.is_invitation_code eq 0}">是邀请码 </c:if>
								       <c:if test="${t.is_invitation_code eq 1}">不是邀请码 </c:if>							 
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