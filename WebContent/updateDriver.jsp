<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑司机信息</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateDriver" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="driver.id" id="id" />
			    <s:hidden name="driver.mc" id="mc"/>
				  <tr>
                        <td width="15%" align="center" class="dataTd" >头像</td>
				    	<td width="35%" align="left" class="dataTd" >
				    	 <s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					      <input type="hidden" name="batchFileName" id="batchFileName" value="000000.png" /> 
					    
				        	<s:hidden name="driver.picture"  id="picture" /></td>  
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
					             listKey="key" listValue="value" value="driver.sex" />
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
				        <td width="15%" align="center" class="dataTd" >工号</td>
					    <td width="35%" align="left" class="dataTd" >
			        	    <s:textfield name="driver.ident_num"  id="ident_num" />
				        </td>
				   </tr>
			       <tr>
				    	<td width="15%" align="center" class="dataTd" >驾照号</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.drive_card"  id="drive_card" />
					    </td>
					    <td width="15%" align="center" class="dataTd" >驾龄</td>
				    	<td width="35%" align="left" class="dataTd" >
					        <s:textfield name="driver.year"  id="year" />
					    </td>
				   </tr>	
				   <tr>
				    	<td width="15%" align="center" class="dataTd" >代驾次数</td>
				    	<td width="35%" align="left" class="dataTd" >
				        	<s:textfield name="driver.times"  id="times" /></td>
				       <td width="15%" align="center" class="dataTd" >司机状态</td>
					<td width="35%" align="left" class="dataTd" >
				        <s:radio label="类型" name ="driver.job_status" id="job_status"
						         list= "#{0:'&nbsp;空闲&nbsp;',1:' &nbsp;结束代驾&nbsp;',2:' &nbsp;忙碌&nbsp;',3:' &nbsp;等待结伴返程&nbsp;'}"
                                 listKey="key" listValue="value" value="driver.job_status" />
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
<script type="text/javascript">
function checkSubmit(){

	 var batchFileName = document.getElementById("batchFileName").value;
	 if(!checkFileType(batchFileName) ){
			return false;
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
	 }else{
	 var strP=/^\d+(\.\d+)?$/; 
	 if(!strP.test(year)){
		 showErrorMsg("驾龄只能为数字");
	      return false;
	 } 
	 }
	  
	 return true;	
}
	function copyBatchFile(obj, n) {
		var name=obj.value;
	    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
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
	function set(obj){
		var checkText=$("#cityid").find("option:selected").text();  //获取Select选择的Text
		 document.getElementById("mc").value = checkText;
	}
</script>