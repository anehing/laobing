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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增优惠券</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addCoupon" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >优惠券号</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="coupon_num" name="coupon.coupon_num"/>
					    </td>    
				        <td width="15%" align="center" class="dataTd" >优惠券面值(￥)</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield name="coupon.discount_amount" id="discount_amount"/>
				    	</td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >是否用作邀请码</td>
				     	<td width="35%" align="left" class="dataTd" >
					        <s:radio label="状态" name ="coupon.is_invitation_code" id="is_invitation_code"
					             list= "#{0:'&nbsp;邀请码&nbsp;',1:' &nbsp;非邀请码&nbsp;'}"  
					             listKey="key" listValue="value" value="1" />
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
	
	 var coupon_num=document.getElementById("coupon_num").value;
	 var discount_amount=document.getElementById("discount_amount").value;
	 if(!checkNull(coupon_num)){
	      showErrorMsg("优惠卷码不能为空");
	      return false;
	 } 
	 if(!checkNull(discount_amount)){
	      showErrorMsg("面值不能为空");
	      return false;
	 } else{
		 var patrn=/^([+]?)\d*\.?\d+$/;
		 if (!patrn.test(discount_amount)){
			 showErrorMsg("面值输入格式不正确");
			 return false
		 }
	 }
     return true;	
}
</script>