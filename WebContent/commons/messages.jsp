<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <div id="errorMsg" class="data0" style="display: none;">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			
			        <td class="topTd" colspan="2" align="left" class="topTd" ></td>
			
			      </tr>
			      <tr style="height: 100px;">
			        <td class="dataTd" align="left"">
			        	
			        	<div style="float: left;width: 80px; height: 57px;"></div>
						<div style="float: left;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../images/error.png');background-image:url(../images/error.png)!important;background-image:url();width: 56px; height:57px;"></div>
						<div style="float: left;width: 20px; height: 57px;"></div>
						<div style="float: left;height: 57px;">
							<div style="overflow: hidden; width: 150px; height: 30px;"></div>
							<div id="errorMsgValue" style="width: 230px; "></div>
						</div>
						<div style="float: left;width: 30px; height: 57px;">
								<div style="overflow: hidden; width: 10px; height: 30px;"></div>
								<div style="overflow: hidden; width: 90px; "><input type="button" class="inputBtn"  id="b1" name="msgBtns" value="返回" onclick="timerClose('2')" style="cursor:pointer"/><input id="msgTimer1" type="hidden"  value="5"></div>
						</div>
			        </td>
			      </tr>
			      
			      <tr>
			        <td class="dataTd" height="26" colspan="2" align="center" bgcolor="#edf2f8">
			        </td>
			      </tr>
			    </table>
    	</div>
  </div>
  
   <div id="tipMsg" class="data0"  style="display: none;">
		<div class="data1">
			<table class="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			
			        <td class="topTd" colspan="2" align="left" class="topTd" ></td>
			
			      </tr>
			      <tr style="height: 100px;">
			        <td class="dataTd" align="left"">
			        	
			        	<div style="float: left;width: 80px; height: 57px;"></div>
						<div style="float: left;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../images/true.png');background-image:url(../images/true.png)!important;background-image:url();width: 56px; height:57px;"></div>
						<div style="float: left;width: 20px; height: 57px;"></div>
						<div style="float: left;height: 57px;">
							<div style="overflow: hidden; width: 150px; height: 30px;"></div>
							<div id="tipMsgValue" style="width: 230px;"></div>
						</div>
						<div style="float: left;width: 30px; height: 57px;">
								<div style="overflow: hidden; width: 10px; height: 30px;"></div>
								<div style="overflow: hidden; width: 90px; "><input type="button" class="inputBtn" id="b2" name="msgBtns" value="返回" onclick="timerClose('2')" style="cursor:pointer"/><input id="msgTimer2" type="hidden"  value="5"></div>
						</div>
						
			        </td>
			      </tr>
			      
			      <tr>
			        <td class="dataTd" height="26" colspan="2" align="center" bgcolor="#edf2f8">
			        </td>
			      </tr>
			    </table>
    	</div>
  </div>
  
  <script type="text/javascript">
  $(function(){
	  alert("a");
  	 <s:if test="hasActionErrors()">
             var err="";
	  		<s:iterator value="actionErrors" status="ae">
	  			<s:if test="#ae.count== 1">
	  		       err+="<s:property/>";
	  		    </s:if>
			</s:iterator>
				    showMsg(err,'1');
	  		
	  	</s:if>
	  	
	  	<s:if test="hasActionMessages()">
	  	    var mess="";
	  		<s:iterator value="actionMessages" status="am">
	  			<s:if test="#am.count== 1">
	  		      mess+="<s:property/>";
	  		     </s:if>
			</s:iterator>
				    showMsg(mess,'0');
	  	</s:if>
	  	
  });
  

function showErrorMsg(str){

  	      showMsg(str,'1') 
  	
}
  	
function showTipMsg(str){
  	   showMsg(str,'0')
  	
}

//window.alert=showErrorMsg;

function showMsg(str,type){ 
	
	if(type=='0'){
	
			document.getElementById("tipMsgValue").innerHTML=str;
			
			var tmpTimer=document.getElementById("msgTimer2");
	
			tmpTimer.value="5";
			
	try{

		$("#tipMsg").modal();
	
	}catch(e){
	
		//alert(e);
		
		alert(str);
	
	}
	
	}else{
	

	
		document.getElementById("errorMsgValue").innerHTML=str;
		
		var tmpTimer=document.getElementById("msgTimer1");

		tmpTimer.value="5";
		
		try{
		
		$("#errorMsg").modal();
	
		}catch(e){
		
			alert(str);
	
		//alert(e);
	
		}
	
	}

	
	
	
}


function timerClose(type){

	if(type=='2'){
		$.modal.close();

		document.getElementById("msgTimer2").value='5';
		document.getElementById("msgTimer1").value='5';
	}	

}
</script>


