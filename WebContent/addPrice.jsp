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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增价格信息</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addPrice" namespace="/base" method="post"  id="form1" onsubmit="return checkSubmit()" name="addPrice" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			         	<s:hidden name="price.note" id="note"/>
			         	<s:hidden name="price.time" id="time"/>
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >城市</td>
					    <td width="35%" align="left" class="dataTd" >
					         <s:select list="dmb_citylist" listKey="id" listValue="mc" name ="price.cityid" id="cityid"  headerValue="请选择" headerKey="0" onchange="set(this);"></s:select>
					    </td>    
				        <td width="15%" align="center" class="dataTd" >时间段</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:radio label="时间段" name ="price.sort" id="sort"
					             list= "#{1:'07:00-21:59',2:'22:00-22:59',3:'23:00-23:59',4:'00:00-06:59'}"  
					             listKey="key" listValue="value" />
				    	</td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >价格（￥）</td>
				     	<td width="35%" align="left" class="dataTd" >
				     	      <s:textfield name="price.price" id="price"/>
					    </td>
					    <td width="15%" align="center" class="dataTd" ></td>
					    <td width="35%" align="left" class="dataTd" ></td>
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
	 var cityid = document.getElementById("cityid").value;
	 var price=document.getElementById("price").value;
	 if(!checkNull(price)){
	      showErrorMsg("价格不能为空");
	      return false;
	 } else{
		 var patrn=/^([+]?)\d*\.?\d+$/;
		 if (!patrn.test(price)){
			 showErrorMsg("价格输入格式不正确");
			 return false
		 }
	 }
	 if(cityid==0){
	      showErrorMsg("请选城市");
	      return false;
	 }
     return true;	
}
function set(obj){
	var checkText=$("#cityid").find("option:selected").text();  //获取Select选择的Text
	 document.getElementById("note").value = checkText;
}


</script>