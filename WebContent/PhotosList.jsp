<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<script type="text/javascript">
$().ready(function() {
	var type= $("#photos\\.type").find('option:selected').text();
	if(type=="请选择"){
	 	$("#emtList").show();
    	$("#museumList").hide();
    	$("#exhibitsList").hide();
	}
	if(type=="展品类型"){
		$("#emtList").hide();
    	$("#museumList").hide();
    	$("#exhibitsList").show();
	}
	if(type=="博物馆类型"){
		$("#emtList").hide();
    	$("#museumList").show();
    	$("#exhibitsList").hide();
	}
});
function settype(obj){
	var type= $("#photos\\.type").find('option:selected').text();
	if(type=="请选择"){
	 	$("#emtList").show();
    	$("#museumList").hide();
    	$("#exhibitsList").hide();
	}
	if(type=="展品类型"){
		$("#emtList").hide();
    	$("#museumList").hide();
    	$("#exhibitsList").show();
	}
	if(type=="博物馆类型"){
		$("#emtList").hide();
    	$("#museumList").show();
    	$("#exhibitsList").hide();
	}
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >图片管理</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div>   

<%@ include file="commons/messages.jsp"%>
<div  align="right" onClick="nxx(0)"
	style="width: 97%; margin: auto"><img id="z0"
	style="cursor: pointer" align="middle" src="${ctx }/images/nxx8.png"
	width="80" height="22" /></div>
<center>
<s:form action="queryPhotos" method="post" id="form1" onsubmit="return toSubmit();" enctype ="multipart/form-data">
<div id="r0" align="center" >
<table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1" >
	<tr>
		<td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText">图片名称</td>
		<td width="20%" align="left" bgcolor="#FFFFFF"> <s:textfield name="photos.photoName" ></s:textfield></td>
		<td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText">图片类型</td>
		<td width="20%" align="left" bgcolor="#FFFFFF">
						<s:select label="分组类型" name ="photos.type" id="photos.type" onchange="settype(this);"
						list= "#{1:'展品类型',2:'博物馆类型'}"
						 listKey="key" listValue="value" headerKey="0" headerValue="请选择" /></td>
		
		<td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
		    <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		</td>
	</tr>
	<tr>
		<td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText">图片细分</td>
		<td bgcolor="#FFFFFF" align="left" style="display:none;" id="emtList">
		    <s:select  list="#{0:'请选择分组'}" listKey="id" listValue="value" headerKey="0" headerValue="请选择分组"></s:select>
		</td>
		<td bgcolor="#FFFFFF" align="left" style="display:none;" id="museumList">
		    <s:select name="photos.museumId" list="museumList" listKey="id" listValue="chineseName" headerKey="0" headerValue="请选择分组"></s:select>
		</td>
		<td width="20%" align="left" bgcolor="#FFFFFF" style="display:none;" id="exhibitsList">
		    <s:select name="photos.exhibitId" list="exhibitsList" listKey="id" listValue="chineseName" headerKey="0" headerValue="请选择分组"></s:select>
		</td>
							<td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText"></td>
		<td width="25%" align="center" bgcolor="#FFFFFF"></td>
	</tr>
</table>
</div>

<br />
<div align="center">
		<div class="data0">
		   <div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="topTd" align="center" >序号</td>
						<td class="topTd" align="center" >图片名称</td>
						<td class="topTd" align="center" >图片类型</td>
						<td class="topTd" align="center" >展品或博物馆</td>
						<td class="topTd" align="center" >图片</td>
						<td class="topTd" align="center" >操作</td>
					</tr>
					<s:if test="page.data.size > 0">
						<s:iterator value="page.data" var="t" status="s">
							<tr>
								<td class="dataTd" align="center" >
								   &nbsp;${s.index+1+page.pageSize*(PageNo-1)}
								</td>
								<td class="dataTd" align="center" >
 									 ${t.photoName} 
 							
								</td>
								<td class="dataTd" align="center" >
										 <s:if test="#t.type ==1"> 展品类型</s:if> 
											 <s:if test="#t.type ==2">博物馆类型</s:if>
											 <s:else></s:else>		
								</td>
								<td class="dataTd" align="center" >
 									 ${t.exhibitName} 
 							
								</td>
								<td class="dataTd" align="center" >
							<img  width="40" height="50" src="${t.photoUrl}"></img>
								</td>
							
								<td class="dataTd" align="center" >
									<a href="queryPhotosbyId.action?totype=1&id=${t.id}">修改</a>
									<a href="queryPhotosbyId.action?totype=2&id=${t.id}">删除</a>
								</td>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
					   <tr>
						   <td class="dataTd" align="center"  colspan="10"><font color="red">暂无数据！</font></td>
					   </tr>
					</s:else>	
								
					<tr>
						<td height="26" colspan="10" bgcolor="#edf2f8" 	align="left">&nbsp;
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
