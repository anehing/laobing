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
<script type="text/javascript">
function checkSubmit(){
	var groupName = $("#group_groupName").val();
	var groupType=$("input[name='groups.groupType']:checked").val();
	 if(!checkNull(groupName)){
	      showErrorMsg("请输入分组名称");
	      return false;
	 } 
	if(groupType==null){
		showErrorMsg("请选择分组类型");
		return false;
	}
	return ture;
	
}
</script>
<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span >编辑分组</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updateGroups" namespace="/base" onsubmit="return checkSubmit()" id="form1">
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="26" colspan="8" align="left" class="topTd" >&nbsp;</td>
				</tr>
				<tr>
					<td width="20%" align="center" class="dataTd" >分组名称</td>
					<td width="30%" align="left" class="dataTd" >
					<s:hidden name="groups.id"> </s:hidden>
					 <s:textfield name="groups.groupName" id="group_groupName"> </s:textfield> 
				    </td>
					
				    </tr>
				<tr>
				     <td width="20%" align="center" class="dataTd" >分组类型</td>
					<td width="30%" align="left" class="dataTd"  colspan="7">
						<s:radio label="分组类型" name ="groups.groupType" 
						list= "#{1:' 博物馆',2:' 展品质地类型',3:' 展品功用类型',4:' 展品辅助类型',5:' 展品分组类型'}"
						 listKey="key" listValue="value"  />
				    </td> 
				</tr>
			<tr>
						<td class="dataTd" align="center" >介&nbsp;&nbsp;&nbsp;绍</td>
						<td  width="25%"  class="dataTd" align="left" colspan="7"  >
						<s:textarea name="groups.note" rows="4" cols="100" ></s:textarea>
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