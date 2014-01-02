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
var jSelectDate = {
	    yearClass: "jselectDate_year",

	    /**
	    * 开始年
	    */
	    yearBegin: 1960,

	    /**
	    * 终止年
	    */
	    yearEnd: 2005,
	    //maxDay:,

	    days: 31,
	    /**
	    
	    * 初始化对向
	    * @param {Object} el 用于存放日期结果的文本框 jQuery DOM
	    */
	    init: function (els, isDisabled) {

	        els.each(function () {

	            var maxDay = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

	            var el = $(this);

	            //取得旧的日期
	            var elValue = el.val();
	            elDate = new Date(elValue.split("-").join("/"));

	            var nYear = elDate.getFullYear();
	            var nMonth = jSelectDate.returnMonth(elDate.getMonth());
	            var nDay = elDate.getDate();


	            //隐藏给出的对向
	            el.hide();

	            //先算出当前共有多少个jSelectDate
	            var currentIdx = $(jSelectDate.yearClass).length + 1;

	            /**
	            * 创建年select
	            */
	            var selYear = document.createElement("select");
	            selYear.id = "selYear" + currentIdx
	            selYear.className = jSelectDate.yearClass;
	            selYear.disabled = isDisabled;

	            //加入选项
	            for (var i = jSelectDate.yearEnd; i >= jSelectDate.yearBegin; i--) {

	                var option = document.createElement("option");
	                option.value = i;
	                option.innerHTML = i;

	                //判断是否有旧的值，如果有就选中
	                if (!isNaN(nYear)) {
	                    if (i == nYear) {
	                        option.selected = true;
	                    }
	                }

	                selYear.appendChild(option);
	                option = null;

	            }

	            //加入控件到文本框的位置
	            el.after(selYear);

	            /**
	            * 创建月
	            */
	            var selMonth = document.createElement("select");
	            selMonth.id = "selMonth" + currentIdx
	            selMonth.disabled = isDisabled;
	            //加入选项
	            for (var i = 1; i <= 12; i++) {
	                var option = document.createElement("option");
	                option.value = i;
	                option.innerHTML = i;

	                //判断是否有旧的值，如果有就选中
	                if (!isNaN(nMonth)) {
	                    if (i == nMonth) {
	                        option.selected = true;
	                    }
	                }

	                selMonth.appendChild(option);
	                option = null;
	            }

	            $(selYear).after(selMonth);
	            $(selMonth).before(" ");

	            /**
	            * 创建日
	            */
	            var selDay = document.createElement("select");
	            selDay.id = "selDay" + currentIdx
	            selDay.disabled = isDisabled;
	            //加入选项
	            for (var i = 1; i <= jSelectDate.days; i++) {

	                var option = document.createElement("option");
	                option.value = i;
	                option.innerHTML = i;

	                //判断是否有旧的值，如果有就选中
	                if (!isNaN(nDay)) {
	                    if (i == nDay) {
	                        option.selected = true;
	                    }
	                }

	                selDay.appendChild(option);
	                option = null;
	            }

	            $(selMonth).after(selDay);
	            $(selDay).before(" ");

	            var getDate = function () {
	                var year = $(selYear).val();
	                var month = $(selMonth).val();
	                var day = $(selDay).val();
	                el.val(year + "-" + month + "-" + day);
	            }

	            var createDay = function () {
	                //先移除，然后重新创建
	                $("#selDay" + currentIdx).remove();
	                var selDay = document.createElement("select");
	                selDay.id = "selDay" + currentIdx
	                selDay.disabled = isDisabled;
	                for (var i = 1; i <= jSelectDate.days; i++) {
	                    var option = document.createElement("option");
	                    option.value = i;
	                    option.innerHTML = i;
	                    //判断是否有旧的值，如果有就选中
	                    if (!isNaN(nDay)) {
	                        if (i == nDay) {
	                            option.selected = true;
	                        }
	                    }
	                    selDay.appendChild(option);
	                    option = null;
	                }
	                $(selMonth).after(selDay);
	                $(selDay).before(" ");
	            }
	            /**
	            * 给几个下拉列表加入更改后的事件
	            */
	            $(selDay).change(function () {
	                return getDate();
	            });
	            $(selMonth).change(function () {

	                var month = $(selMonth).val();
	                var year = $(selYear).val();

	                //判断该月份的最大值与上次选择的最大值不相同，就重新创建日
	                if (jSelectDate.days != maxDay[month - 1]) {
	                    jSelectDate.days = maxDay[month - 1];
	                    if ((0 == year % 4 && (year % 100 != 0 || year % 400 == 0)) && month == 2) {
	                        jSelectDate.days++;
	                    }
	                    createDay();
	                }
	                return getDate();
	            });
	            $(selYear).change(function () {
	                var month = $(selMonth).val();
	                var year = $(selYear).val();
	                if (jSelectDate.days != maxDay[month - 1]) {
	                    jSelectDate.days = maxDay[month - 1];
	                    if ((0 == year % 4 && (year % 100 != 0 || year % 400 == 0)) && month == 2) {
	                        jSelectDate.days++;
	                    }
	                    createDay();
	                }
	                return getDate();
	            });

	        })


	    },

	    returnMonth: function (num) {
	        var arr = new Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
	        return arr[num];
	    }

	}

	jQuery.fn.jSelectDate = function(s){

	    var getNowYear = function(){
	        //得到现在的年
	        var date = new Date();
	        return date.getFullYear();
	    }
	    
	    defaults = {
	        css: "",
	        disabled: false,
	        yearBegin: 1960,
	        yearEnd: getNowYear()
	    }
	    
	    
	    $.extend(defaults, s);
	    
	    jSelectDate.yearBegin = defaults.yearBeign;
	    jSelectDate.yearEnd = defaults.yearEnd;
	    jSelectDate.init($(this), defaults.disabled);
	    
	    return $(this);
	    
	}
function checkSubmit(){
	 
	var userName=$("#user\\.userName").val();
	
	 if(!checkNull(userName)){
	      showErrorMsg("请输入注册名称");
	      return false;
	 } 
	
		var regex=/^[0-9A-Za-z_]{6,15}$/;
		if(!regex.exec(userName)){
			 showErrorMsg("用户名只包含大小写英文、数字和下划线。长度在6-15之间");
			 return false;
		}
	 var batchFileList = document.getElementsByName("batchFileName");
		for(var i=0; i<batchFileList.length; i++){
			 if(!checkFileType(batchFileList[i].value)){
			    return false;
			 }
		}	
		var nickName=$("#user\\.nickName").val();
		 if(!checkNull(nickName)){
		      showErrorMsg("请输入注册昵称");
		      return false;
		 } 
	 var name=$("#user\\.name").val();
	 if(!checkNull(name)){
	      showErrorMsg("请输入用户真实姓名");
	      return false;
	 } 
	 if(checkNull(name)){
		 if(!(/^[\u4e00-\u9fa5]+$/i).test(name)){  
			 showErrorMsg("请输入中文姓名");
		      return false;
	        }
	 } 
	 var pass=$("#user\\.pass").val();
	 if(!checkNull(pass)){
	      showErrorMsg("请输入用户密码");
	      return false;
	 }
	 if(!regex.exec(pass)){
		 showErrorMsg("密码只包含大小写英文、数字和下划线。长度在6-15之间");
		 return false;
	}
	 var sex=$("input[name='user.sex']:checked").val();
		if(sex==null){
			showErrorMsg("请选择用户性别");
			return false;
		}
	 var userType=$("input[name='user.userType']:checked").val();
	if(userType==null){
		showErrorMsg("请选择用户类型");
		return false;
	}
	   var mobile= $("#user\\.mobile").val();
	      if(checkNull(mobile)&&mobile.search(/^0?(130|131|132|133|134|135|136|137|138|139|147|150|151|152|153|155|156|157|158|159|180|181|182|183|184|185|186|187|188|189)[0-9]{8}$/)== -1){
	    	  showErrorMsg("手机号码不正确");
	  		return false; 
	      }
     var email=$("#user\\.email").val();
      if(checkNull(email)&&email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)== -1){
    	  showErrorMsg("邮箱地址不正确");
  		return false; 
      }
   
	var province=jQuery("#user\\.province").val()
	var city=jQuery("#user\\.city").val()
 if(province==0||city==0){
	 showErrorMsg("请输入具体城市");
	 return false;
 } 
	
	 return true;
}
function copyBatchFile(obj,n){
	var name=obj.value;
    document.getElementById("batchFileName").value=name.substring(name.lastIndexOf("\\")+1);
}
function checkFileType(filename){
	if(filename != ""){
		if(filename.indexOf(".")!=-1){
			var  tem = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
			if(tem == "png" || tem == "jpg" || tem == "jpeg" || tem == "gif" || tem == "bmp"){
                 return  true;
			}else{
				showErrorMsg("只能上传格式为png,jpg,gif,bmp,jpeg的图片文件");
				return false;
			}
        }
	}else{
		showErrorMsg("头像不可以为空！");
		return false;
	}
}

function validatename(obj){
	var username=obj.value;
	 if(checkNull(username)){
	var url='base/validateName.action';
	var params={username:username};
	$.ajax({
		url : 'validateName.action?username='+ username ,
		method : "get",
		dataType : "html",
		cache : false,
		ifModified : false,
		data : null,
		async:false,
		success : function(result) {
			if (result=="false") {
				$("#failure").show();
				$("#lab").show();
				$("#success").hide();
				obj.focus();
			} if(result=="true") {
				$("#success").show();
				$("#failure").hide();
				$("#lab").hide();
			}
		},
	});
}else{
	$("#failure").hide();
	$("#lab").hide();
	$("#success").hide();
}
	    
} 
 $().ready(function(){
	getCity_2('DmbCity','parentId','user.province',1);
		 for(var i=10;i<81;i++){
		 $("#age").append("<option>"+i+"</option>"); 
		} 
	  $("#tDate").jSelectDate({
	             yearBeign: 1960,
	             disabled: false
	         });		 
});  

</script>
<body >
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> <span>新增用户</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>
	<s:form action="addUser" namespace="/base" method="post"
		onsubmit="return checkSubmit()" id="form1" enctype ="multipart/form-data">
		<div class="data0">
			<div class="data1">
				<table class="dataTable" width="100%" border="0" cellspacing="0"
					cellpadding="0">
					 
					<tr>
						<td height="26" colspan="4" align="left" class="topTd">&nbsp;</td>
					</tr>
					 <tr>
						<td width="15%" align="center" class="dataTd" bgcolor="#F3F8FE" >注册名称</td>
						<td width="35%" align="left" class="dataTd" >
						
						<s:textfield name="user.userName" id="user.userName" onblur="validatename(this)"  >
						</s:textfield>
						<img   border="0"   style="vertical-align:left;display:none" src="${ctx}/images/pic_03.gif" id="success"  > 
						  <img  border="0"   style="vertical-align:left;display:none" src="${ctx}/images/pic_02.gif" id="failure">  
						  <label id="lab" style="color:red;display:none;vertical-align:left">名称已存在</label>
						<td width="15%" align="center" class="dataTd" bgcolor="#F3F8FE">用户头像</td>
						<td width="35%" align="left" class="dataTd">
						<s:file  name ="myFile" id="myFile" label ="Image File" onchange="copyBatchFile(this,1)"/>
					     <input type="hidden" name="batchFileName" id="batchFileName" /></td>
				    </tr>
				    	<tr>
						<td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">注册昵称</td>
						<td width="35%" align="left" class="dataTd" >
						<s:textfield name="user.nickName" id="user.nickName"   ></s:textfield>
						<td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">用户类型</td>
						<td width="35%" align="left" class="dataTd">
						<s:radio label="用户类型" name ="user.userType" id="user.userType" 
						list= "#{0:' 普通用户',1:' 管理员'}"  listKey="key" listValue="value" value="user.userType" /></td>
						
				    </tr>
					<tr>
					<td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">用户姓名</td>
						<td width="35%" align="left" class="dataTd">
						<s:textfield name="user.name" id="user.name"></s:textfield>
					    <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">用户密码</td>
						<td width="35%" align="left" class="dataTd">
						<s:textfield name="user.pass" id="user.pass"></s:textfield>
					</td>
					</tr>
					<tr>
					<td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">性&nbsp;&nbsp;&nbsp; 别</td>
						<td width="40%" align="left" class="dataTd"> 
						<s:radio label="性别" name ="user.sex" id="user.sex"
						list= "#{1:' 女 ',2:' 男 '}"
						 listKey="key" listValue="value" value="user.sex" />
					    <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">年&nbsp;&nbsp;&nbsp; 龄</td>
						<td width="35%" align="left" class="dataTd">
					<select id="age" name="user.age"></select>
					</tr>
					<tr>
					    <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">手机号码</td>
						<td width="35%" align="left" class="dataTd">
						<s:textfield name="user.mobile" id="user.mobile"></s:textfield>	</td>
						<td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">新浪微博</td>
						<td width="35%" align="left" class="dataTd">
				<input name="user.sinaToken" type="text" id="user.sinaToken"/></td>
							
					</tr> 
					<tr>
					
						
					    <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">电子邮件</td>
						<td width="35%" align="left" class="dataTd">
						<s:textfield name="user.email" id="user.email"></s:textfield>
						 <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE"></td>
						<td width="35%" align="left" class="dataTd">
						</td>
					</tr>
					 <tr>
					  <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">生&nbsp;&nbsp;&nbsp;日</td>
						<td width="35%" align="left" class="dataTd" colspan="7">
						 <input id="tDate" name="birthday" type="text" value="1990-7-15"  />
						</td>
					 </tr>
					 <tr>
					    <td width="15%" align="center" class="dataTd"  bgcolor="#F3F8FE">城&nbsp;&nbsp;&nbsp;&nbsp;市</td>
						<td width="35%" align="left" class="dataTd" colspan="7">
						<select  name="user.province" id="user.province" onchange="getCity_2('DmbCity','parentId','user.city',this.value)" >
							<option value="0" selected="selected">请选择省</option>
						 </select> 					
						<select name="user.city" id="user.city" onchange="getCity_2('DmbCity','parentId','user.country',this.value)" >
							<option value="0" selected="selected">请选择市</option>
						 </select> 					
						 <select name="user.country" id="user.country" >
							<option value="0" selected="selected">请选择区县</option>
						 </select> 	
						 				
							
					</tr> 
					
					
					<tr>
						<td bgcolor="#edf2f8" colspan="8" align="center">
						<input	type="submit" class="inputBtn"   value="提交" style="cursor: pointer" />
						<input type="button" class="inputBtn" value="返回"
							onclick="javaScript:history.go(-1)" style="cursor: pointer" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>