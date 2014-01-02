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
	 var name = $("#musics\\.name").val();
	if(!checkNull(name)){
	      showErrorMsg("请输入音频名称");
	      return false;
	 }
		 
	 var select_name = $("#select_id").find("option:selected").text(); 
		if(select_name=="选择分组" ){
	    	showErrorMsg("请选择展品名称");
		      return false;
		 }
		var type=$("input[name='musics.type']:checked").val();
		if(type==null){
			showErrorMsg("请选择音频类型");
			return false;
		}
		var batchFileList = $("#batchFileName").val();
		if(! checkFileType(batchFileList) ){
			return false;
		}	  
	return ture;
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
    document.getElementById("musics.name").value =name.substring(name
			.lastIndexOf("\\") + 1);
}
function setGroupProperty(obj){
	   var charArray = obj.value.split('-');	
	   
    document.getElementById("musics.exhibitId").value = charArray[0];
    document.getElementById("musics.exhibitName").value = charArray[1];       
}
function checkFileType(filename){
	if(filename != ""){
		if(filename.indexOf(".")!=-1){
			var  tem = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
			if(tem == "mp3" || tem == "wav" || tem == "wma" || tem == "au"){
                 return  true;
			}else{
				showErrorMsg("只能上传格式为mp3,wav,wma,au的音频文件");
				return false;
			}
        }
	}return  true;
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑音频</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateMusics" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
				  <td width="15%" class="dataTd" align="center">
					  上传音频
					</td>
					<td width="35%"  class="dataTd" align="left">
					     <s:file  name ="myFile" id="myFile" label ="music File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden"  name="batchFileName" id="batchFileName" value=""/> 
					     <input type="hidden"  name="music.musicUrl" id="music.musicUrl" value="${m.musicUrl} "/> 					
					</td> 
					<td width="15%" align="center" class="dataTd" >音频名称</td>
					<td width="35%" align="left" class="dataTd" >
					<input type="hidden"  name="musics.id" id="musics.id" value="${m.id}">				
					<input name="musics.name" type="text" id="musics.name" value="${m.name}"/></td>
					
				</tr>
			    <tr>
				<td width="15%" align="center" class="dataTd" >展品名称</td>
					<td width="35%" class="dataTd" align="left">
						${m.exhibitName}
						 <input type="hidden" name="musics.exhibitId" id="musics.exhibitId" value="${m.exhibitId}" />	
						  <input type="hidden" name="musics.musicUrl" id="musics.musicUrl" value="${m.musicUrl}" />				
					</td>	
					<td width="15%" align="center" class="dataTd" >类型</td>
					<td width="35%" align="left" class="dataTd" >
					<s:radio list="#{1:' 中文音频',2:' 英文音频'}" name ="musics.type" listKey="key" listValue="value" ></s:radio>
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