/****************************
*IP报信备信息验证文件
*黄志鲁
****************************/
function validateAllocateAndUse(){
	var i = 0;
	if(!checkIp($('#startIp').val())){
		showErrorMsg('起始IP格式不正确');
		i++;
	}
	if(!checkIp($('#endIp').val())){
		showErrorMsg('终止IP格式不正确');
		i++;
	}
	
	if(!compareIp($('#startIp').val(),$('#endIp').val())){
		showErrorMsg('终止IP小于起始IP');
		i++;
	}
	
	if($('#useType option:selected').val() == '0'){
		showErrorMsg('没有选择使用方式');
		i++;
	}
	
	if(!checkDate($('#useDate').val())){
		showErrorMsg('分配使用时间为空或者格式不正确');
		i++;
	}
	
	if(!checkNull($('#unitName').val())){
		showErrorMsg('单位名称为空');
		i++;
	}else{
		if(!checkIllegalChar($('#unitName').val())){
			showErrorMsg('单位名称中存在非法字符');
			i++;
		}		
	}
	
	if(!checkNull($('#unitAddress').val())){
		showErrorMsg('单位详细地址不能为空');
		i++;
	}else{
		if(!checkIllegalChar($('#unitAddress').val())){
			showErrorMsg('单位详细地址中存在非法字符');
			i++;
		}
	}
	
	if($('#unitsNature option:selected').val() == '0'){
		showErrorMsg('没有选择单位性质');
		i++;
	}
	
	if($('#unitsProvince option:selected').val() == '0'){
		showErrorMsg('没有选择单位所在省');
		i++;
	}
	
	if($('#unitsCity option:selected').val() == '0'){
		showErrorMsg('没有选择单位所在市');
		i++;
	}
	
	if(!checkNull($('#contactName').val())){
		showErrorMsg('联系人姓名为空');
		i++;
	}else{
		if(!checkIllegalChar($('#contactName').val())){
			showErrorMsg('联系人姓名中存在非法字符');
			i++;
		}
       if(!compStrLength($('#contactName').val(),20))
       {
          showErrorMsg("联系人姓名的长度不能大于20");
            i++;
       }		
	}
	var mobileFlag = checkMobile($('#telephone').val());
	var telephoneFlag = checkTelephone($('#telephone').val());
	if(!(mobileFlag || telephoneFlag)){
		showErrorMsg('联系人电话为空或格式不正确');
		i++;
	}
	
	if(!checkEmail($('#email').val())){
		showErrorMsg('电子邮件格式不正确');
		i++;
	}
	
	if(checkNull($('#notes').val())){
		if(!checkIllegalChar($('#notes').val())){
			showErrorMsg('备注信息中存在非法字符');
			i++;
		}
	}
	
	if( i == 0){
		return true;
	}else{
		return false;
	}

}

function validateAllocateAgain(){
	var i = 0;
	if(!checkIp($('#startIp').val())){
		showErrorMsg('起始IP格式不正确');
		i++;
	}
	if(!checkIp($('#endIp').val())){
		showErrorMsg('终止IP格式不正确');
		i++;
	}
	if(!compareIp($('#startIp').val(),$('#endIp').val())){
		showErrorMsg('终止IP小于起始IP');
		i++;
	}
	
	if(!checkNull($('#strAllocationObject').val())){
		showErrorMsg('没有选择再分配单位');
		i++;
	}
	
	if(checkNull($('#notes').val())){
		if(!checkIllegalChar($('#notes').val())){
			showErrorMsg('备注信息中存在非法字符');
			i++;
		}
	}
	
	if( i == 0){
		return true;
	}else{
		return false;
	}
}

function validateSelfUse(){
	var i = 0;
		if(!checkIp($('#startIp').val())){
		showErrorMsg('起始IP格式不正确');
		i++;
	}
	if(!checkIp($('#endIp').val())){
		showErrorMsg('终止IP格式不正确');
		i++;
	}
	
	if(!compareIp($('#startIp').val(),$('#endIp').val())){
		showErrorMsg('终止IP小于起始IP');
		i++;
	}
	
	if($('#useType option:selected').val() == '0'){
		showErrorMsg('没有选择使用方式');
		i++;
	}
	
	if(!checkDate($('#useDate').val())){
		showErrorMsg('分配使用时间为空或者格式不正确');
		i++;
	}
	
	if(checkNull($('#notes').val())){
		if(!checkIllegalChar($('#notes').val())){
			showErrorMsg('备注信息中存在非法字符');
			i++;
		}
	}
	
	if( i == 0){
		return true;
	}else{
		return false;
	}
	
}

function validateReservation(){
	var i = 0;
	if(!checkIp($('#startIp').val())){
		showErrorMsg('起始IP格式不正确');
		i++;
	}
	if(!checkIp($('#endIp').val())){
		showErrorMsg('终止IP格式不正确');
		i++;
	}
	if(!compareIp($('#startIp').val(),$('#endIp').val())){
		showErrorMsg('终止IP小于起始IP');
		i++;
	}
	if(checkNull($('#notes').val())){
		if(!checkIllegalChar($('#notes').val())){
			showErrorMsg('备注信息中存在非法字符');
			i++;
		}
	}
	
	if( i == 0){
		return true;
	}else{
		return false;
	}
}

function validateSelfTake(){
	var i = 0;
	
	if(!checkIp($('#startIp').val())){
		showErrorMsg('起始IP格式不正确');
		i++;
	}
	if(!checkIp($('#endIp').val())){
		showErrorMsg('终止IP格式不正确');
		i++;
	}
	
	if(!compareIp($('#startIp').val(),$('#endIp').val())){
		showErrorMsg('终止IP小于起始IP');
		i++;
	}
	
	if($('#useType option:selected').val() == '0'){
		showErrorMsg('没有选择使用方式');
		i++;
	}
	
	if(!checkDate($('#useDate').val())){
		showErrorMsg('分配使用时间为空或者格式不正确');
		i++;
	}
	
	if(!checkNull($('#gatewayIp').val())){
		showErrorMsg('网关IP不能为空');
		i++;
	}
	if(!checkIp($('#gatewayIp').val())){
		showErrorMsg('网关IP格式不正确');
		i++;
	}
	
	if(!checkNull($('#gatewayAddress').val())){
		showErrorMsg('网关物理位置不能为空');
		i++;
	}else{
		if(!checkIllegalChar($('#gatewayAddress').val())){
			showErrorMsg('网关物理位置中存在非法字符');
			i++;
		}
	}
	
	if(!checkNull($('#unitName').val())){
		showErrorMsg('单位名称为空');
		i++;
	}else{
		if(!checkIllegalChar($('#unitName').val())){
			showErrorMsg('单位名称中存在非法字符');
			i++;
		}
	}
	
	if(!checkNull($('#unitAddress').val())){
		showErrorMsg('单位详细地址不能为空');
		i++;
	}else{
		if(!checkIllegalChar($('#unitAddress').val())){
			showErrorMsg('单位详细地址中存在非法字符');
			i++;
		}
	}
	
	if($('#unitsNature option:selected').val() == '0'){
		showErrorMsg('没有选择单位性质');
		i++;
	}
	
	if($('#unitsProvince option:selected').val() == '0'){
		showErrorMsg('没有选择单位所在省');
		i++;
	}
	
	if($('#unitsCity option:selected').val() == '0'){
		showErrorMsg('没有选择单位所在市');
		i++;
	}
	
	if(!checkNull($('#contactName').val())){
		showErrorMsg('联系人姓名为空');
		i++;
	}else{
		if(!checkIllegalChar($('#contactName').val())){
			showErrorMsg('联系人姓名中存在非法字符');
			i++;
		}
	}
	
	var mobileFlag = checkMobile($('#telephone').val());
	var telephoneFlag = checkTelephone($('#telephone').val());
	if(!(mobileFlag || telephoneFlag)){
		showErrorMsg('联系人电话为空或格式不正确');
		i++;
	}

	
	if(!checkEmail($('#email').val())){
		showErrorMsg('电子邮件格式不正确');
		i++;
	}
	if($('#isDomainJump option:selected').val() == '3'){
		showErrorMsg('没有选择域名跳转服务');
		i++;
	}
	
	if($('.sourceType:checked').val() == '0'){
		if(!checkNull($('#sourceUnitName').val())){
			showErrorMsg('来源报备单位名称不能为空');
			i++;
		}else{
			if(!checkIllegalChar($('#sourceUnitName').val())){
				showErrorMsg('来源报备单位名称中存在非法字符');
				i++;
			}
	}
	}else{
		if(!checkNull($('#sourceUnitId').val())){
			showErrorMsg('来源报备单位没有选择');
			i++;
		}
	}
	if(checkNull($('#notes').val())){
		if(!checkIllegalChar($('#notes').val())){
			showErrorMsg('备注信息中存在非法字符');
			i++;
		}
	}
	
	if( i == 0){
		return true;
	}else{
		return false;
	}
	

}

