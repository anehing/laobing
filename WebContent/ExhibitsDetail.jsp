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
	
	 
<s:form action="updateExhibits" namespace="/base"  id="form1"  >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >中文名称</td>
					<td width="35%" align="left" class="dataTd" >
					${e.chineseName}
				    </td>
				    <td width="15%" align="center" class="dataTd" >英文名称</td>
					<td width="35%" align="left" class="dataTd" >
					${e.englishName}
				    </td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >视频名称</td>
					<td width="35%" align="left" class="dataTd" >
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						     <c:if test="${!empty v}">
						       <c:forEach items="${v}" var="video">
						         <tr>
								    <td height="26" align="left">
						             ${video.name}<a href="EqueryVideosbyId.action?id=${video.id}&&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">修改</a> 
						             </td>
						         </tr>
							    </c:forEach>		
							 </c:if>
							 <tr>
							     <td>
									 <a id="thick" href="EVideoAction.action?Eid=${e.id}&ename=${e.chineseName}&totype=1&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">
									 	添加视频
									 </a>						 
							    </td>
						    </tr>
						</table>
					</td>
				    <td width="15%" align="center" class="dataTd" >音频名称</td>
					<td width="35%" align="left" class="dataTd" >
						<table  width="100%" border="0" cellspacing="0" cellpadding="0">
							 <c:if test="${!empty m}">
							       <c:forEach items="${m}" var="music">
									<tr>
										<td height="26" align="left">
									        <c:if test="${music.type==1}">${music.name}【中文音频】<a href="EqueryMusicsbyId.action?id=${music.id}&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">修改</a>
									        </c:if>
									         <c:if test="${music.type==2}">${music.name}【英文音频】<a href="EqueryMusicsbyId.action?id=${music.id}&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">修改</a>
									         </c:if>
										</td>
									</tr>
							       </c:forEach> 						
					       </c:if>
							<tr>
								<td height="26" align="left">
									 <a id="thick" href="EmusicAction.action?Eid=${e.id}&ename=${e.chineseName}&totype=1&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">
									 	添加音频
									 </a>							       
								</td>
							</tr>							       
						</table>				       
				    </td>
				</tr>
			<tr>
						<td width="15%" class="dataTd" align="center">规&nbsp;&nbsp;&nbsp;&nbsp;格</td>
						<td width="35%" align="left" class="dataTd">
							${e.specification}
						</td>

						<td width="15%" class="dataTd" align="center">年&nbsp;&nbsp;&nbsp;&nbsp;代</td>
						<td width="35%" align="left" class="dataTd">
						${e.period}
						</td>
					</tr>
					<tr>
						<td width="15%" align="center" class="dataTd">质地类型</td>
						<td width="35%" align="left" class="dataTd">
						${e.qualityGroupName}
						</td>
						<td class="dataTd" align="center">功用类型</td>
						<td width="35%" align="left" class="dataTd">
                          ${e.useGroupName}
		            </tr>
					 <tr>
						<td class="dataTd" align="center">辅助类型</td>
						<td class="dataTd" align="left">
					${e.assistantGroupName}
						</td>
						<td class="dataTd" align="center">收藏地</td>
						<td class="dataTd" align="left">
					${e.museumName}
					  </td>						
					</tr> 
					<tr>
					<td width="10%" align="center" class="dataTd">展品分组</td>
						<td width="25%" align="left" class="dataTd">
						${e.groupName}
				  	</td>
						<td width="15%" align="center" class="dataTd"></td>
						<td width="35%" align="left" class="dataTd">
						</td>
					</tr>
					
					<tr>
						<td class="dataTd"  align="center"  >
			          	中文介绍
			          	</td>
				<td colspan="7" class="dataTd" align="left"  >
					${e.chineseIntroduction}
					</td>
				</tr>	
				<tr>
					<td class="dataTd"  align="center"  >
			          	英文介绍
			          	</td>
				<td colspan="7" class="dataTd" align="left" >
						${e.englishIntroduction}
					</td>
					</tr>
				<tr>
					 	<td class="dataTd"  align="center"  >
			          	图&nbsp;&nbsp;&nbsp;&nbsp;片
			          	</td>
				<td colspan="1" class="dataTd"  align="left" >
					 <img  width="200" height="400" src="${e.photoUrl}"></img>
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
								    <a id="thick" href="EphotoAction.action?Eid=${e.id}&ename=${e.chineseName}&type=1&placeValuesBeforeTB_=savedValues&TB_iframe=false&height=300&width=500&modal=true" class="thickbox">
						 	                                添加图片
						            </a>							       
								</td>
							</tr>							       
						</table>	
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