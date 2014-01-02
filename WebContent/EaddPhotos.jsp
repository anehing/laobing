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
$().ready(function() {
	$("#museumList").hide();
	$("#exhibitsList").show();
});

function setProperty(obj){
	   var charArray = obj.value.split('-');		
document.getElementById("photos.exhibitId").value = charArray[0];
document.getElementById("photos.exhibitName").value = charArray[1];       
}
function copyBatchFile(obj, n) {
	var name = obj.value;
	document.getElementById("batchFileName").value = name.substring(name
			.lastIndexOf("\\") + 1);
	 document.getElementById("photos.photoName").value=name.substring(name.lastIndexOf("\\")+1);
}
function checkSubmit(){
	var photoName=$("#photos\\.photoName").val();
	 if(!checkNull(photoName)){
	      showErrorMsg("请输入图片名称");
	      return false;
	 } 
		var batchFileList = document.getElementsByName("batchFileName");
		for(var i=0; i<batchFileList.length; i++){
			 if(!checkFileType(batchFileList[i].value)){
			    return false;
			 }
		}	 
		 var museumList1=$("#museumList1").find("option:selected").text(); 
		 var exhibitsList1=$("#exhibitsList1").find("option:selected").text(); 
		 if(museumList1=="选择分组"&& exhibitsList1=="选择分组"){
		    	showErrorMsg("请选择展品或博物馆");
			      return false;
			 }

	return true;
	
}
function settype(obj){
    var value=obj.value;
    if(value==2){
    	$("#museumList").show();
    	$("#exhibitsList").hide();
    }
    else{
    	$("#museumList").hide();
    	$("#exhibitsList").show();
    }
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
	}else{
		showErrorMsg("图片不可以为空！");
		return false;
	}
}
</script>
<body id="model">
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增图片</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="EaddPhotos" namespace="/base" method="post"
		onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="26" colspan="4" align="left" class="topTd">&nbsp;</td>
					</tr>
					<tr>
						<td width="15%" class="dataTd" align="center">
					  图&nbsp;&nbsp;&nbsp;片
					</td>
					<td width="35%"  class="dataTd" align="left">
					     <s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="batchFileName" id="batchFileName" /> 	
					</td>  
					</tr>
					<tr>
					<td width="10%" align="center" class="dataTd">图片名称
						</td>
						<td width="25%" align="left" class="dataTd">
						<s:textfield id="photos.photoName" name="photos.photoName" ></s:textfield></td>
					</tr>
					<tr>	
                      	<td width="10%" align="center" class="dataTd">默认头像</td>
						<td width="40%" align="left" class="dataTd" > 
						<s:radio label="分组类型" name ="photos.priority" id="photos.priority" 
						list= "#{1:'   默认头像',2:'   非默认头像'}"
						 listKey="key" listValue="value" value="1" /></td>
					</tr>
					<tr>
				 <td width="15%" align="center" class="dataTd" >名&nbsp;&nbsp;&nbsp;称</td>
					<td width="35%" class="dataTd" align="left">${ename}
                      <input type="hidden" name="photos.exhibitName" id="photos.exhibitName" value="${ename}"/> 
                      <input type="hidden" name="photos.exhibitId" id="photos.exhibitId" value="${Eid}"/> 
                      <input type="hidden"name="photos.type" id="photos.type" value="${type}" /> 
					</td>	
					</tr>
					<tr>
						<td bgcolor="#edf2f8" colspan="4" align="center">
						<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						<input type="button" class="inputBtn" value="关闭" onclick="childWndClose();" style="cursor: pointer" />
						</td>
					</tr>
				</table>
				
			</div>
		</div>
	</s:form>
</body>