<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >调整预付款</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updatePre_account" namespace="/base" onsubmit="return toSubmit()" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="pre_price.id" id="id" />
			     <s:hidden  name="pre_price.pre_price" id="pre_price" />
			      <s:hidden  name="pre_price.drivername" id="drivername" />
			       <s:hidden  name="pre_price.drivertelphone" id="drivername" />
				<tr>
					<td width="15%" align="center" class="dataTd" >设置预付款金额底线</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield name="pre_price.pre_account" id="pre_account"/>
					</td>    
				    <td width="15%" align="center" class="dataTd" ></td>
					<td width="35%" align="left" class="dataTd" ></td> 
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
function toSubmit(){

	var price=document.getElementById("pre_account").value;
	 if(!checkNull(price)){
	      showErrorMsg("预付款不能为空");
	      return false;
	 }else if(price<0){
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

	return ture;
}
</script>