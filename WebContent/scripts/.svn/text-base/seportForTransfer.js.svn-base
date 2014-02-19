var xmlHttpRequest;

function createXMLHttpRequest(){
    var request = false;
    try {
        request = new XMLHttpRequest();
    } 
    catch (e) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } 
        catch (e) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } 
            catch (e) {
                request = false;
            }
        }
    }
    return request;
}

function request(id,type){
    xmlHttpRequest = createXMLHttpRequest();
    var url ="";
      
    if(type==1){
	    url = "/IcpProject_ISP/ip/loadSecondChildUnit.action?twoExportOutUnitId=" + id+"&threeSelectType="+type;
	}else if(type==2){
	    url = "/IcpProject_ISP/ip/loadSecondChildUnit.action?twoExportInputUnitId=" + id+"&threeSelectType="+type;
	}else if(type==0){
		if(id==-1){
			var selectThree = document.getElementById("threeExportInputUnitId");  
			 while(true) {
				if (selectThree.options.length == 1) {
					break;
				}
				selectThree.remove(1);
			}
		}
    	url = "/IcpProject_ISP/ip/loadSecondChildUnit.action?oneExportInputUnitId=" + id+"&threeSelectType="+type;
    }else if(type==4){
		if(id==-1){
			var selectThree = document.getElementById("threeExportOutUnitId");  
			 while(true) {
				if (selectThree.options.length == 1) {
					break;
				}
				selectThree.remove(1);
			}
		}
    	url = "/IcpProject_ISP/ip/loadSecondChildUnit.action?oneExportOutUnitId=" + id+"&threeSelectType="+type;
    }
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.onreadystatechange = function(){
        if (xmlHttpRequest.readyState == 4) {
        	 if (xmlHttpRequest.status == 200) {
                var xml = xmlHttpRequest.responseXML;
                if (xml) {
                    var select = "";                    
	                if(type==1){
	                   select = document.getElementById("threeExportOutUnitId");                    	
	                }else if(type==2){
	                   select = document.getElementById("threeExportInputUnitId");     
	                }else if(type==0){
	                   select = document.getElementById("twoExportInputUnitId");    
	                }else if(type==4){
	                   select = document.getElementById("twoExportOutUnitId");    
	                }
                    while(true) {
						if (select.options.length == 1) {
							break;
						}
						select.remove(1);
					}
                    var units = xml.getElementsByTagName("unit");
           				for (i = 0; i < units.length; i++) {
						var id = units[i].getElementsByTagName("id")[0].firstChild.data;
						var name = units[i].getElementsByTagName("name")[0].firstChild.data;
						var option = document.createElement("option");
						option.appendChild(document.createTextNode(name));
						option.setAttribute("value", id);
						select.appendChild(option);
					}
                }
            }
        }
    }
	//document.getElementById("allocateUnit").value=id;
    xmlHttpRequest.send(null);
}