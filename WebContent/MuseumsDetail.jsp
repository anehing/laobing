<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>
<style type="text/css">

</style>
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
<s:form action="updateMuseums" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >中文名称</td>
					<td width="35%" align="left" class="dataTd" >
					${m.chineseName}
				    </td>
				    <td width="15%" align="center" class="dataTd" >英文名称</td>
					<td width="35%" align="left" class="dataTd" >
					${m.englishName}
				    </td>
				</tr>
			    <tr>
					<td width="15%" align="center" class="dataTd" >地&nbsp;&nbsp;&nbsp;址</td>
					<td width="35%" align="left" class="dataTd" >
					${m.address}
				    </td>
				    <td width="15%" align="center" class="dataTd" >介&nbsp;&nbsp;&nbsp;绍</td>
					<td width="35%" align="left" class="dataTd" >
					${m.note}
				    </td>
				</tr>
				  <tr>
				  <td width="15%"  class="dataTd" align="center">
					  分&nbsp;&nbsp;&nbsp;组				  
					</td>
					<td width="35%" class="dataTd" align="center">
					${m.groupName}
					</td>					
					<td width="15%" class="dataTd" align="center">
					
					</td>
					<td width="35%"  class="dataTd" align="center">
					  	
				
					</td> 		
				</tr>
				<tr>
					 	<td class="dataTd"  align="center"  >
			          	图&nbsp;&nbsp;&nbsp;&nbsp;片
			          	</td>
				<td colspan="1" class="dataTd"  align="left" >
					 <img  width="200" height="400" src="${m.photoUrl}"></img>
					</td>
						<td class="dataTd"  align="center"  >
			          	图片列表
			          	</td>
				<td colspan="1" class="dataTd"  align="left" >
				          <table  width="100%" border="0" cellspacing="0" cellpadding="0">
							 <c:if test="${! empty p}">
							       <c:forEach items="${p}" var="photo">
									 <tr>
									    <td>
									      <img  width="200" height="100" src="${photo.photoUrl}"></img>
										  <a href="EqueryPhotosbyId.action?id=${photo.id}&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">修改</a>
										</td>
									</tr>
							       </c:forEach> 						
					        </c:if>
							<tr>
								<td height="26" align="left">
								    <a id="thick" href="EphotoAction.action?Eid=${m.id}&ename=${m.chineseName}&type=2&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">
						 	                                添加图片
						            </a>							       
								</td>
							</tr>							       
						</table>	
					</td> 
				</tr>	
				<tr>
					<td bgcolor="#edf2f8" colspan="8" align="center">
                        <input	type="button" class="inputBtn"   value="返回" onclick="javaScript:history.go(-1)" style="cursor: pointer" />
					</td>
				</tr>				
			</table>
		</div>
	</div>
</s:form>
</body>