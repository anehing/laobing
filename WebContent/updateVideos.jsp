<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>
<style type="text/css">
<!--
body {
	background-image: url(images/new/bg05.gif) repeat-y;
	margin-top: 10px;
}

html {
	overflow-y: scroll;
}
-->
</style>
<script type="text/javascript">
function checkSubmit(){
	 var name = $("#videos\\.name").val();
	if(!checkNull(name)){
	      showErrorMsg("请输入视频名称");
	      return false;
	 }
		 
	 var select_name = $("#select_id").find("option:selected").text(); 
		if(select_name=="选择分组" ){
	    	showErrorMsg("请选择展品名称");
		      return false;
		 }
		var batchFileList = $("#batchFileName").val();
		if(! checkFileType(batchFileList) ){
			return false;
		}
		
	return ture;
}

function copyBatchFile(obj, n) {
	var name = obj.value;
	document.getElementById("batchFileName").value = name.substring(name
			.lastIndexOf("\\") + 1);
	document.getElementById("videos.name").value =name.substring(name
			.lastIndexOf("\\") + 1);
}
function setGroupProperty(obj){
	   var charArray = obj.value.split('-');		
document.getElementById("videos.exhibitId").value = charArray[0];
document.getElementById("videos.exhibitName").value = charArray[1];       
}	
function checkFileType(filename){
	if(filename != ""){
		if(filename.indexOf(".")!=-1){
			var  tem = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
			if(tem == "avi" || tem == "wmv" || tem == "3gp" || tem == "rmvb" || tem == "mkv" || tem == "swf"){
                 return  true;
			}else{
				showErrorMsg("只能上传格式为avi,wmv,3gp,rmvb,mkv,swf的视频文件");
				return false;
			}
        }
	}return  true;
}
</script>
<body id="model">
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑视频</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="EupdateVideos" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
				<td width="15%" class="dataTd" align="center">
					  上传视频
					</td>
					<td width="35%"  class="dataTd" align="left">
					     <s:file  name ="myFile" id="myFile" label ="video File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden"  name="batchFileName" id="batchFileName" value="" /> 	
					     <input type="hidden"  name="videos.videoUrl" id="videos.videoUrl" value="${m.videoUrl}" />				
					</td>
					
				    <td width="10%" align="center"  class="dataTd">展品名称</td>
		              <td width="35%" class="dataTd" align="left">
						${m.exhibitName}	
						 <input type="hidden" name="videos.exhibitId" id="videos.exhibitId" value="${m.exhibitId}"/>					
					</td>
				</tr>
				<tr>
				<td width="15%" align="center" class="dataTd" >视频名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input name="videos.name" type="text" id="videos.name" value="${m.name}"/>
						<input type="hidden"  name="videos.id" id="videos.id" value="${m.id}">
					<td width="15%" class="dataTd" align="center">
					<td width="35%" class="dataTd" align="center">
					 
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