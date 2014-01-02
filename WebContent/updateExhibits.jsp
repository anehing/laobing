<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<script type="text/javascript">
function checkSubmit(){
	
	var chineseName=$("#exhibits\\.chineseName").val();
    var englishName=$("#exhibits\\.englishName").val();
    var specification=$("#exhibits\\.specification").val();
    var period=$("#exhibits\\.period").val();
    var setQualityGroupName=$("#setQualityGroupName_id").find("option:selected").text();  
    var setUseGroupNameGroup=$("#setUseGroupNameGroup_id").find("option:selected").text();  
    var setAssistantGroupName=$("#setAssistantGroupName_id").find("option:selected").text();  
    var setMuseumGroup=$("#setMuseumGroup_id").find("option:selected").text();  
    var setGroupName=$("#groupName_id").find("option:selected").text();  
    
	 if(!checkNull(chineseName)){
	      showErrorMsg("请输入中文名称");
	      return false;
	 } 
	 if(!checkNull(englishName)){
	      showErrorMsg("请输入英文名称");
	      return false;
	 } 
	 if(!checkNull(specification)){
	      showErrorMsg("请输入规格");
	      return false;
	 } 
	 if(!checkNull(period)){
	      showErrorMsg("请输入年代");
	      return false;
	 } 
	 if(setQualityGroupName=="选择分组" ){
	    	showErrorMsg("请选择展品质地类型");
		      return false;
		 }
	 if(setUseGroupNameGroup=="选择分组" ){
	    	showErrorMsg("请选择功用类型");
		      return false;
		 }
	 if(setAssistantGroupName=="选择分组" ){
	    	showErrorMsg("请选择辅助类型");
		      return false;
		 }
	 if(setMuseumGroup=="选择分组" ){
	    	showErrorMsg("请选择收藏地");
		      return false;
		 }
	 if(setGroupName=="选择分组" ){
	    	showErrorMsg("请选择展品分组类型");
		      return false;
		 }
	 var batchFileList = document.getElementsByName("batchFileName");
		for(var i=0; i<batchFileList.length; i++){
			 if(!checkFileType(batchFileList[i].value)){
			    return false;
			 }
		}	       
     return true;	
}
function checkFileType(filename){
	if(filename != ""){
		if(filename.indexOf(".")!=-1){
			var  tem = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
			if(tem == "png" || tem == "jpg" || tem == "jpeg" || tem == "gif" || tem == "bmp"){
                 return  true;
			}else{
				showErrorMsg("只能上传格式为png,jpg,gif,bmp,jpeg的图片文件");
				return false;
			}
        }
	}	
	return true;
}
function setgroupNameGroupProperty(obj){
	   var charArray = obj.value.split('-');		
document.getElementById("exhibits.groupId").value = charArray[0];
document.getElementById("exhibits.groupName").value = charArray[1];       
}
	function setMuseumGroupProperty(obj) {
		var charArray = obj.value.split('-');
		document.getElementById("exhibits.museumId").value = charArray[0];
		document.getElementById("exhibits.museumName").value = charArray[1];
		
	}
	function setAssistantGroupNameGroupProperty(obj) {
		var charArray = obj.value.split('-');
		document.getElementById("exhibits.assistantGroupId").value = charArray[0];
		document.getElementById("exhibits.assistantGroupName").value = charArray[1];
	}
	function setUseGroupNameGroupProperty(obj) {
		var charArray = obj.value.split('-');
		document.getElementById("exhibits.useGroupId").value = charArray[0];
		document.getElementById("exhibits.useGroupName").value = charArray[1];
	}
	function setQualityGroupNameGroupProperty(obj) {
		var charArray = obj.value.split('-');
		document.getElementById("exhibits.qualityGroupId").value = charArray[0];
		document.getElementById("exhibits.qualityGroupName").value = charArray[1];
	}
	function setgroupNameGroupProperty(obj){
		   var charArray = obj.value.split('-');		
	 document.getElementById("exhibits.groupId").value = charArray[0];
	 document.getElementById("exhibits.groupName").value = charArray[1];       
	}
	function copyBatchFile(obj, n) {
		var name = obj.value;
		document.getElementById("batchFileName").value = name.substring(name
				.lastIndexOf("\\") + 1);
	}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑展品</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateExhibits" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="15%" align="center" class="dataTd" >中文名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input type="hidden" name="exhibits.id" id="exhibits.id" value="${e.id}">
					<input name="exhibits.chineseName" type="text" id="exhibits.chineseName" value="${e.chineseName}"/>
				    </td>
				    <td width="15%" align="center" class="dataTd" >英文名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="exhibits.englishName" type="text" id="exhibits.englishName" value="${e.englishName}"/>
				    </td>
				</tr>
			<tr>
						<td width="15%" class="dataTd" align="center">规&nbsp;&nbsp;&nbsp;格</td>
						<td width="35%" align="left" class="dataTd">
						<input
							name="exhibits.specification" type="text"
							id="exhibits.specification" value="${e.specification}"/>
						</td>

						<td width="15%" class="dataTd" align="center">年&nbsp;&nbsp;&nbsp;代</td>
						<td width="35%" align="left" class="dataTd"><input
							name="exhibits.period" type="text" id="exhibits.period" value="${e.period}" />
						</td>
					</tr>
					 <tr>
					 	<td width="15%" class="dataTd" align="center">
					  头&nbsp;&nbsp;&nbsp;像
					</td>
					<td width="35%"  class="dataTd" align="left">
					     <s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="batchFileName" id="batchFileName" value=""/> 	
					      <input type="hidden" name="exhibits.photoUrl" id="exhibits.photoUrl" value="${e.photoUrl}"/> 				
					</td> 
						
						<td class="dataTd" align="center">收藏地</td>
						<td class="dataTd" align="left">
							<select  onchange="setMuseumGroupProperty(this);">
								<option value="0-选择分组">选择分组</option>
								<c:forEach items="${museumList}" var="t">
									<option value="${t.id}-${t.chineseName}" <c:if test="${e.museumId eq t.id}">selected="selected"</c:if>>${t.chineseName}</option>
								</c:forEach>						
							 </select>							
						 	<input type="hidden" name="exhibits.museumId" id="exhibits.museumId" value="${e.museumId}"/> 
						 	<input type="hidden" name="exhibits.museumName" id="exhibits.museumName" value="${e.museumName}"/>
						 </td>						
					</tr> 
					<tr>
						<td width="15%" align="center" class="dataTd">质地类型</td>
						<td width="35%" align="left" class="dataTd">
						<select  onchange="setQualityGroupNameGroupProperty(this);">
							<option value="0-选择分组">选择分组</option>
							<c:forEach items="${groupZhiDiList}" var="t">
								<option value="${t.id}-${t.groupName}" <c:if test="${e.qualityGroupId eq t.id}">selected="selected"</c:if>>${t.groupName}</option>
							</c:forEach>						
						 </select>	                              
							 	<input type="hidden" name="exhibits.qualityGroupId" id="exhibits.qualityGroupId" value="${e.qualityGroupId}"/> 
							 	<input type="hidden" name="exhibits.qualityGroupName" id="exhibits.qualityGroupName" value="${e.qualityGroupName}" />
						</td>
						<td class="dataTd" align="center">功用类型</td>
						<td width="35%" align="left" class="dataTd">
                            
						<select  onchange="setUseGroupNameGroupProperty(this);">
							<option value="0-选择分组">选择分组</option>
							<c:forEach items="${groupGongYongList}" var="t">
								<option value="${t.id}-${t.groupName}"<c:if test="${e.useGroupId eq t.id}">selected="selected"</c:if>>${t.groupName}</option>
							</c:forEach>						
						 </select>	                             
						 	<input type="hidden" name="exhibits.useGroupId" id="exhibits.useGroupId" value="${e.useGroupId}"/> 
						 	<input type="hidden" name="exhibits.useGroupName" id="exhibits.useGroupName" value="${e.useGroupName}"/>
					</tr>
					
					<tr>
					<td width="10%" align="center" class="dataTd">展品分组</td>
						<td width="25%" align="left" class="dataTd">
						<select  onchange="setgroupNameGroupProperty(this);" id="groupName_id" >
							<option value="0-选择分组">选择分组</option>
							<c:forEach items="${groupNameList}" var="t">
								<option value="${t.id}-${t.groupName}" <c:if test="${e.groupId eq t.id}">selected="selected"</c:if>>${t.groupName}</option>
							</c:forEach>						
						 </select>								
						 	<input type="hidden" name="exhibits.groupName" id="exhibits.groupName" value="${e.groupName}" /> 
						 	<input type="hidden" name="exhibits.groupId" id="exhibits.groupId" value="${e.groupId}"/>
						</td>
						
						<td class="dataTd" align="center">辅助类型</td>
						<td class="dataTd" align="left">
						<select  onchange="setAssistantGroupNameGroupProperty(this);">
							<option value="0-选择分组">选择分组</option>
							<c:forEach items="${groupFuZhuList}" var="t">
								<option value="${t.id}-${t.groupName}" <c:if test="${e.assistantGroupId eq t.id}">selected="selected"</c:if>>${t.groupName}</option>
							</c:forEach>						
						 </select>								
						 	<input type="hidden" name="exhibits.assistantGroupId" id="exhibits.assistantGroupId"  value="${e.assistantGroupId}"/> 
						 	<input type="hidden" name="exhibits.assistantGroupName" id="exhibits.assistantGroupName" value="${e.assistantGroupName}" />
						</td>
					</tr>
					<tr>
					<td width="15%" align="center" class="dataTd">中文介绍</td>
						<td width="35%" align="left" class="dataTd" colspan="7"><textarea
							name="exhibits.chineseIntroduction" cols="100" rows="5"
							id="exhibits.chineseIntroduction"  >${e.chineseIntroduction}</textarea>
						</td>
					</tr>	
					<tr>
						<td width="15%" align="center" class="dataTd">英文介绍</td>
						<td width="35%" align="left" class="dataTd" colspan="7"><textarea
							name="exhibits.englishIntroduction" cols="100" rows="5"
							id="exhibits.englishIntroduction" >${e.englishIntroduction}</textarea>
						</td>
					</tr>
				<tr>
					<td bgcolor="#edf2f8" colspan="8" align="center"  >
						<input	type="submit" class="inputBtn"  value="确定" style="cursor: pointer" />
                        <input	type="button" class="inputBtn"   value="返回" onclick="javaScript:history.go(-1)" style="cursor: pointer" />
					</td>
				</tr>				
			</table>
		</div>
	</div>
</s:form>
</body>