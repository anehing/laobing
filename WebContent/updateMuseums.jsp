<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>
<style type="text/css">

</style>
<script type="text/javascript">
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
function setGroupProperty(obj){
	   var charArray = obj.value.split('-');	
       document.getElementById("museums.groupId").value = charArray[0];
       document.getElementById("museums.groupName").value = charArray[1];       
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
}
function checkSubmit(){
	var chineseName=$("#museums\\.chineseName").val();
    var englishName=$("#museums\\.englishName").val();
    var checkText=$("#select_id").find("option:selected").text();  
	 if(!checkNull(chineseName)){
	      showErrorMsg("请输入中文名称");
	      return false;
	 } 
	 if(!checkNull(englishName)){
	      showErrorMsg("请输入英文名称");
	      return false;
	 } 
	 if(checkText=="选择分组" ){
	    	showErrorMsg("请选择分组");
		      return false;
		 }
		var batchFileList = $("#batchFileName").val();
		if(! checkFileType(batchFileList) ){
			return false;
		}
		
     return true;	
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑博物馆</span>
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
					<input name="museums.chineseName" type="text" id="museums.chineseName" value="${m.chineseName}"/>
					<input type="hidden"  name="museums.id" id="museums.id" value="${m.id}">
				    </td>
				    <td width="15%" align="center" class="dataTd" >英文名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="museums.englishName" type="text" id="museums.englishName" value="${m.englishName}"/>
				    </td>
				</tr>
			    <tr>
			     <td width="15%"  class="dataTd" align="center">
					  分&nbsp;&nbsp;&nbsp;组				  
					</td>
					<td width="35%" class="dataTd" align="left">
						<select onchange="setGroupProperty(this);"  id="select_id">
							<option value="0-选择分组">选择分组</option>
							<c:forEach items="${listg}" var="t">
								<option value="${t.id}-${t.groupName}" <c:if test="${m.groupId eq t.id}">selected="selected"</c:if>>${t.groupName}</option>
							</c:forEach>						
						 </select>	
						  <input type="hidden" name="museums.groupId" id="museums.groupId" value="${m.groupId}"/>
						 <input type="hidden" name="museums.groupName" id="museums.groupName" value="${m.groupName}"/> 					
					</td>	
					<td width="15%" class="dataTd" align="center">
					  头&nbsp;&nbsp;&nbsp;像
					</td>
					<td width="35%"  class="dataTd" align="left">
					     <s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden"  name="batchFileName" id="batchFileName" value=""/> 
					     <input type="hidden" name="museums.photoUrl" id="museums.photoUrl" value="${m.photoUrl}"/> 
				</tr>
				  <tr>
					<td width="15%" align="center" class="dataTd" >地&nbsp;&nbsp;&nbsp;址</td>
					<td width="35%" align="left" class="dataTd" >
					<input  name="museums.address" type="text" id="museums.address" value="${m.address}">	
				    </td>
				 <td width="15%" align="center" class="dataTd"  ></td>
					<td width="35%" align="center" class="dataTd">
				    </td>
				</tr>
				<tr>
				  <td width="15%" align="center" class="dataTd"  >介&nbsp;&nbsp;&nbsp;绍</td>
					<td  align="left" class="dataTd" colspan="7"  >
					<textarea  name="museums.note"  id="museums.note" cols="100" rows="5" tabindex="0">${m.note}</textarea>
				    </td>
				</tr>
				<tr>
					<td bgcolor="#edf2f8" colspan="8" align="center">
						<input	type="submit" class="inputBtn"   value="确定" style="cursor: pointer" />
                        <input	type="button" class="inputBtn"   value="返回" onclick="javaScript:history.go(-1)" style="cursor: pointer" />
					</td>
				</tr>				
			</table>
		</div>
	</div>
</s:form>
</body>