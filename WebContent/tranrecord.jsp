<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>平台收入统计</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	<s:form action="querytranrecordmoney" method="post" id="form1" >
	    <div id="r0" align="center" >
             <table class="dataTable" width="97%" border="0" align="center" cellpadding="0" cellspacing="1"  bgcolor="#93b5d1">
	              <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">时间</td>
		            <td width="60%" align="left" class="dataTdText" bgcolor="#FFFFFF" >
		                   <input type="text" name="createtime" id="createtime" class="tcal" value="${createtime}" />
		            &nbsp;-<input type="text" name="tocreatetime" id="tocreatetime" class="tcal" value="${tocreatetime}" />
		            </td>
                  <td rowspan="3" align="center" valign="middle" bgcolor="#FFFFFF">
			            <input	type="submit" class="inputBtn"   value="查询" style="cursor: pointer"  />
		                <input	type="button" class="inputBtn"   value="清空" onClick="clearForm('form1')" style="cursor: pointer" />
		            </td>  
	            </tr>
	            <tr>
		            <td width="10%" align="center" bgcolor="#F3F8FE" class="dataTdText">平台总收入</td>
		            <td width="30%" align="left" bgcolor="#FFFFFF"> ￥${account}</td>
		         </tr>
             </table>
        </div>
    </s:form>		
</body>
<link rel="stylesheet" type="text/css" href="${ctx}/scripts/tcal.css" />
<script type="text/javascript" src="${ctx}/scripts/tcal.js"></script>  