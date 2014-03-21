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
				    	<td width="15%" align="center" class="dataTd" >司机手机号</td>
					    <td colspan="3" align="left" class="dataTd" >
					    	<c:if test="${customer_order.driver eq 1}">
					    		<s:textfield name="customer_order.drivernum1" id="drivernum1"/>
					    	</c:if>
						 	<c:if test="${customer_order.driver eq 2}">
						 		<s:textfield name="customer_order.drivernum1" id="drivernum1"/>
						 		<s:textfield name="customer_order.drivernum2" id="drivernum2"/>
						 	</c:if>	
						 	<c:if test="${customer_order.driver eq 3}">
						 		<s:textfield name="customer_order.drivernum1" id="drivernum1"/>
						 		<s:textfield name="customer_order.drivernum2" id="drivernum2"/>
						 		<s:textfield name="customer_order.drivernum3" id="drivernum3"/>
						 	</c:if>
							<c:if test="${customer_order.driver eq 4}">
								<s:textfield name="customer_order.drivernum1" id="drivernum1"/>
								<s:textfield name="customer_order.drivernum2" id="drivernum2"/>
								<s:textfield name="customer_order.drivernum3" id="drivernum3"/>
								<s:textfield name="customer_order.drivernum4" id="drivernum4"/>
							</c:if>
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
	/*  var driver = document.getElementById("driver").value;
	 var telphone1=document.getElementById("drivernum1").value;
	 var telphone2=document.getElementById("drivernum2").value;
	 var telphone3=document.getElementById("drivernum3").value;
	 var telphone4=document.getElementById("drivernum4").value;
	 if (driver = 1){
		 if(!checkNull(telphone1)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
	 }else if (driver = 2){
		 if(!checkNull(telphone1)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
		 if(!checkNull(telphone2)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
	 }else if (driver = 3){
		 if(!checkNull(telphone1)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
		 if(!checkNull(telphone2)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
		 if(!checkNull(telphone3)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
	 }else{
		 if(!checkNull(telphone1)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
		 if(!checkNull(telphone2)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 }  
		 if(!checkNull(telphone3)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 } 
		 if(!checkNull(telphone4)){
		      showErrorMsg("司机手机号不能为空");
		      return false;
		 } 
	 } */
	
	 
	 return true;	
}
	
</script>