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
<body >
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增司机</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addDriver" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1"  enctype ="multipart/form-data">
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<s:hidden name="driver.mc" id="mc"/>
                    <tr>
                        <td wenctype ="multipart/form-data"idth="15%" align="center" class="dataTd" >头像</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<%-- <s:textfield name="driver.picture"  id="picture" /></td>  --%> 
				        <s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="batchFileName" id="batchFileName" value="000000.png" /></td>
				    	<td width="15%" align="center" class="dataTd" >姓名</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="name" name="driver.name"/>
					    </td>    
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >性别</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:radio label="性别" name ="driver.sex" id="sex"
					             list= "#{0:'&nbsp;男&nbsp;',1:' &nbsp;女&nbsp;'}"  
					             listKey="key" listValue="value" value="0" />
					   </td>
				        <td width="15%" align="center" class="dataTd" >年龄</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="age" name="driver.age"/>
					    </td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >籍贯</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="city" name="driver.city"/>
					    </td> 
					    <td width="15%" align="center" class="dataTd" >所在城市</td>
					    <td width="35%" align="left" class="dataTd" >
					       <s:select list="dmb_citylist" listKey="id" listValue="mc" name ="driver.cityid" id="cityid"  headerValue="请选择" headerKey="0" onchange="set(this);"></s:select>
					    </td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >手机号码</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.telphone"  id="telphone" /></td>
				        <td width="15%" align="center" class="dataTd" >身份证号</td>
					    <td width="35%" align="left" class="dataTd" >
			        	    <s:textfield name="driver.ident_num"  id="ident_num" />
				        </td>
				   </tr>
			       <tr>
				    	<td width="15%" align="center" class="dataTd" >驾照号</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.drive_card"  id="drive_card" />
					    </td>
					    <td width="15%" align="center" class="dataTd" >驾龄(年)</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.year"  id="year" />
					    </td>
				   </tr>	
				   <tr>
				    	<td width="15%" align="center" class="dataTd" >代驾次数</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.times"  id="times" /></td>
				   </tr>	
				   <tr>
				    	<td width="15%" align="center" class="dataTd" >预付款金额</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="price"  id="price" /></td>
				   </tr>
				   <tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						    <input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						    <input  type="button" class="inputBtn" value="返回"
						        	onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
				   </tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
<script type="text/javascript">
function checkSubmit(){
	 var batchFileList = document.getElementsByName("batchFileName");
	
		for(var i=0; i<batchFileList.length; i++){
			 if(!checkFileType(batchFileList[i].value)){
			    return false;
			 }
		}			
	 var name=document.getElementById("name").value;
	 if(!checkNull(name)){
	      showErrorMsg("姓名不能为空");
	      return false;
	 }
	 var age=document.getElementById("age").value;
	 if(!checkNull(age)){
	      showErrorMsg("年龄不能为空");
	      return false;
	 }else{
		 if(age<=18||age>=60){
			  showErrorMsg("年龄应该为18到60岁");
		      return false;
		 }
	 }
	 var city=document.getElementById("city").value;
	 if(!checkNull(city)){
	      showErrorMsg("籍贯不能为空");
	      return false;
	 }
	 var telphone=document.getElementById("telphone").value;
	 if(!checkNull(telphone)){
	      showErrorMsg("手机号不能为空");
	      return false;
	 }else{
		 var pattern=/(^13\d{9}$)|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^18[0,2,5,6,7,8,9]\d{8}$)|(^147\d{8}$)/g;
		 if(!pattern.test(telphone)) {
			 showErrorMsg("手机号格式不正确");
		     return false; 
		 }
	 }
	 var ident_num=document.getElementById("ident_num").value;
	 if(!checkNull(ident_num)){
	      showErrorMsg("身份证号不能为空");
	      return false;
	 }else{
		 if(!/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(ident_num)){
			 showErrorMsg("身份证号格式不正确");
		      return false;
		 }
	 }
	 var drive_card=document.getElementById("drive_card").value;
	 if(!checkNull(drive_card)){
	      showErrorMsg("驾照号不能为空");
	      return false;
	 }
	 var year=document.getElementById("year").value;
	 if(!checkNull(year)){
	      showErrorMsg("驾龄不能为空");
	      return false;
	 }
	 var times = document.getElementById("times").value;
	 if(checkNull(times)){
		 var strP=/^\d+(\.\d+)?$/; 
		 if(!strP.test(times)){
			 showErrorMsg("代驾次数只能为数字");
		      return false;
		 } 
	 }
	 var price=document.getElementById("price").value;
	 if(!checkNull(price)){
	      showErrorMsg("预付款不能为空");
	      return false;
	 }else if(price<=0){
		 showErrorMsg("预付款必须大于0");
	      return false;
	 } 
	 else{
		 var patrn=/^([+]?)\d*\.?\d+$/;
		 if (!patrn.test(price)){
			 showErrorMsg("预付款输入格式不正确");
			 return false
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
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
}
function set(obj){
	var checkText=$("#cityid").find("option:selected").text();  //获取Select选择的Text
	 document.getElementById("mc").value = checkText;
}

</script>