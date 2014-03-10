<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑订单信息</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateCustomer_order" namespace="/base" onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="customer_order.id" id="id" />
			    <s:hidden  name="customer_order.ordernum" id="ordernum" />
			    <s:hidden  name="customer_order.customer_telphone" id="customer_telphone" />
			    <s:hidden  name="customer_order.start_place" id="start_place" />
			    <s:hidden  name="customer_order.start_time" id="start_time" />
			    <s:hidden  name="customer_order.driver" id="driver" />
			    <s:hidden  name="customer_order.create_time" id="create_time" />
			    <s:hidden  name="customer_order.latitude" id="latitude" />
			    <s:hidden  name="customer_order.longitude" id="longitude" />
			    <s:hidden  name="customer_order.return_time" id="return_time" />
			    <s:hidden  name="customer_order.source" id="source" />
			       <tr>
				    	<td width="15%" align="center" class="dataTd" >订单号</td>
				    	<td width="35%" align="left" class="dataTd" >
				    	    ${customer_order.ordernum}
					    </td>
					    <td width="15%" align="center" class="dataTd" >状态</td>
				    	<td width="35%" align="left" class="dataTd" >
				    		<s:radio label="状态" name ="customer_order.status" id="status"
					             list= "#{0:'&nbsp;接受',1:'&nbsp;服务中',2:'&nbsp;服务结束',3:'&nbsp;取消'}"  
					             listKey="key" listValue="value" value="customer_order.status" />
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
	
	 var ident_num=document.getElementById("ident_num").value;
	 if(!checkNull(ident_num)){
	      showErrorMsg("身份证号不能为空");
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