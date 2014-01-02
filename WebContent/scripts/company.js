
//根据二级单位id查找三级单位列表

function getThirdBySecond(id, objId){
	
	if(id == 0){
		
		return ;
	}

    var actionUrl = "/IcpProject_ISP/ip/loadSecondUnit.action?secondUnitId=" + id;
    
    var json = $.ajax({
        url: actionUrl,
        async: false
    }).responseText;
    
    var rq = eval("(" + json + ")");
    
    var select = document.getElementById(objId);
    
    select.innerHTML = "";
    
    for (i = 0; i < rq.length; i++) {
    
        var option = document.createElement('option');
        
        select.options.add(option);
        
        option.value = rq[i].id;
        
        option.innerHTML = rq[i].unitsName;
        
        if (rq[i].id == 0) {
		
            option.selected = true;
        }
        
        
        
        
    }
    
}
