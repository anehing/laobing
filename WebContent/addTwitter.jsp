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
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增推文</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addTwitter" namespace="/base" method="post" onsubmit="return checkSubmit()" id="form1" >
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
				    	<td width="15%" align="center" class="dataTd" >标题</td>
					    <td width="35%" align="left" class="dataTd" >
					        <s:textfield id="title" name="twitter.title"/>
					    </td>    
				        <td width="15%" align="center" class="dataTd" ></td>
					    <td width="35%" align="left" class="dataTd" >
				    	</td> 
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >正文</td>
					    <td colspan="3"  >
					        <s:textarea name="twitter.content" id="content" cols="130" rows="3"/>
				    	</td> 
				    	
				   </tr>
				   <tr>
				        <td width="15%" align="center" class="dataTd" >推送类型</td>
				     	<td width="35%" align="left" class="dataTd" >
					        <s:radio label="推送类型" name ="twitter.sendtype" id="sendtype"
					             list= "#{0:'&nbsp;所有用户都收到',1:'&nbsp;按城市用户推送'}"  
					             listKey="key" listValue="value" value="0"/>
					   </td>
					 <td width="15%" align="center" class="dataTd" >城市</td>
				     	<td width="35%" align="left" class="dataTd" >
					        <s:select list="dmb_citylist" listKey="mc" listValue="mc" name ="twitter.mc" id="mc"  headerValue="请选择" headerKey="0"  ></s:select>
					    </td>
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
	 var Radio2= $("input[name='twitter\\.sendtype']:checked").val() //选择被选中Radio的Value值
     var checkText=$("#mc").find("option:selected").text();  //获取Select选择的Text
     if(Radio2==0&&checkText!="请选择"){
    	 showErrorMsg("推送类型为所有用户时，不可选择城市");
    	 return false;
     }
     if(Radio2==1&&checkText=="请选择"){
    	 showErrorMsg("推送类型为按城市时，城市不可为空");
    	 return false;
     }
	 var title=document.getElementById("title").value;
	 if(!checkNull(title)){
	      showErrorMsg("标题不能为空");
	      return false;
	 }
	 var content=document.getElementById("content").value;
	 if(!checkNull(content)){
	      showErrorMsg("正文不能为空");
	      return false;
	 }
	
	 return true;	
}
function myfunction(obj){
	var radioValue = obj.value;
}

</script>