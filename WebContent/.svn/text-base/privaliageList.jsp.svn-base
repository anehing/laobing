<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>添加权限</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="addprivaliage" method="post" id="form1" namespace="/base"  onsubmit="return checkSubmit();" >
	    <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	             <s:hidden name="value" id="value"></s:hidden>
	             <tr>
	                <td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText">选择用户</td>
				    <td width="30%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
				        <s:select list="adminlist" listKey="id" listValue="username" name ="permission.adminid" id="adminid"  headerValue="请选择" headerKey="0"></s:select>
				    </td>
				    <td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText"></td>
				    <td width="30%" align="left"  bgcolor="#FFFFFF" >
				     
				  </tr>
				  
				   <tr>
				   <td width="15%" align="center" bgcolor="#F3F8FE" class="dataTdText">选择权限</td>
				    <td colspan="3"  align="left" class="dataTdText" bgcolor="#FFFFFF" >
				       <s:checkboxlist list="urllist" listKey="id" listValue="url_name" name="url_name" label="url"/>
				    </td>
				  </tr>
				   <tr>
				    <td  colspan="4"align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="添加" style="cursor: pointer" />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>
		            </tr>
             </table>
        </div>
    </s:form>		
</body>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/tcal.css" />
<script type="text/javascript" src="${ctx}/scripts/tcal.js"></script>  
<script type="text/javascript">
function checkSubmit()
{
	 var url_name = document.getElementsByName("url_name");
	 var adminid = document.getElementById("adminid");
	 var value = new Array();
	 for(var i = 0; i<url_name.length; i++){
	   if(url_name[i].checked)
	     value.push(url_name[i].value);
	 }  
	 if(adminid==0){
	      showErrorMsg("请选用户");
	      return false;
	 }
	 if(value.length==0){
	      showErrorMsg("请选择权限");
	      return false;
	 }
	 document.getElementById("value").value=value;
	 return true;
	}
</script>