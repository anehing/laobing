<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ include file="commons/messages.jsp"%>

<body>
	 <div class="titleDiv">
	 	<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png"  align="absmiddle" />
			<span>更新价格信息</span>
	    </div>
	    <div class="titleDiv_b"></div>
	 </div> 
<s:form action="updatePrice" namespace="/base" onsubmit="return toSubmit()" id="form1" >
	<div class="data0">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			    <s:hidden  name="price.id" id="id" />
				<tr>
					<td width="15%" align="center" class="dataTd" >城市</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:select list="dmb_citylist" listKey="mc" listValue="mc" name ="price.note" id="note"  headerValue="请选择" headerKey="0" ></s:select>
					</td>    
				    <td width="15%" align="center" class="dataTd" >时间段</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:radio label="时间段" name ="price.time" id="time"
					             list= "#{'07:00-21:59':'&nbsp;07:00-21:59','22:00-22:59':'&nbsp;22:00-22:59','23:00-23:59':'&nbsp;23:00-23:59','00:00-06:59':'&nbsp;00:00-06:59'}"  
					             listKey="key" listValue="value" value="price.time" />
					</td> 
				</tr>
				<tr>
				    <td width="15%" align="center" class="dataTd" >价格（￥）</td>
					<td width="35%" align="left" class="dataTd" >
					    <s:textfield name="price.price" id="price"/>
					</td>
					<td width="15%" align="center" class="dataTd" ></td>
					<td width="35%" align="left" class="dataTd" >
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
function toSubmit(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;

	if(!checkNull(username)){
	      showErrorMsg("请输入用户名称");
	      return false;
	 }
	if(!checkNull(password)){
	      showErrorMsg("请输入密码");
	      return false;
	 }

	return ture;
}
</script>