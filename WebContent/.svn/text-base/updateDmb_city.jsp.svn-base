<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑后台用户</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateDmb_city" namespace="/base" onsubmit="return checkSubmit()" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="dmb_city.id" id="id" />
				<tr>
				    <td width="15%" align="center" class="dataTd" >状态</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="状态" name ="dmb_city.status" id="status"
					             list= "#{0:'未开通',1:'已开通'}"  
					             listKey="key" listValue="value" value="dmb_city.status" />
					</td>
					<td width="15%" align="center" class="dataTd" >城市</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield name="dmb_city.mc"  id="mc" /> 
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
	
	 var mc=document.getElementById("mc").value;
	 if(!checkNull(mc)){
	      showErrorMsg("城市不能为空");
	      return false;
	 }
	 return true;	
}
</script>