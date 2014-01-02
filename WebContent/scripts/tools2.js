//È·ï¿½ï¿½ï¿½ï¿½×ª
function goURL(url) {
	if (deltrue()) {
		window.location.href = url;
	}
}

//ï¿½ï¿½ï¿½ï¿½
function clearForm(formName) {     
	var formObj = document.forms[formName];     
	var formEl = formObj.elements;     
	for (var i=0; i<formEl.length; i++)     {         
		var element = formEl[i];         
		if (element.type == 'submit') { continue; }         
		if (element.type == 'reset') { continue; }         
		if (element.type == 'button') { continue; }         
		if (element.type == 'hidden') { continue; }          
		if (element.type == 'text'&& element.id!='reportUnitName') { element.value = ''; }     
		if (element.type == 'password') { element.value = ''; }          
//		if (element.type == 'textarea') { element.value = ''; }        
		if (element.type == 'checkbox') { element.checked = false; }         
		if (element.type == 'radio') { 
			
			if(element.value=='0'){
				element.checked=true;
			}else{
				element.checked=false;
			}
			
		}         
		if (element.type == 'select-multiple'&&element.id!='pageSize') { element.selectedIndex = 0; }         
		if (element.type == 'select-one'&&element.id!='pageSize') { element.selectedIndex = 0; }      
	} 
} 
function clearSmsForm(formName,obj) {     
	var formObj = document.forms[formName];     
	var formEl = formObj.elements;     
	for (var i=0; i<formEl.length; i++)     {         
		var element = formEl[i];         
		  if(obj == 1){
				if (element.type == 'textarea' && element.id == 'mobile') { element.value = ''; }        
		  }
          if(obj == 2){
				if (element.type == 'textarea' && element.id == 'content') { element.value = ''; }        
		  }
	} 
} 
//È·ï¿½ï¿½
function deltrue(){
	 var r=confirm("æ¨ç¡®è®¤åï¼");
     if (r==true)
     {
	   return true;
     }
     else
     {
	     return false;
     }
}
function childWndClose(){

	self.parent.tb_remove();

}
function openthickbox(obj,hre){
	
 	var heig="";
	
	var widt="";
	
	var iframeDoc = $('mainFrame').contents().get(0);
 
	if(myBrowser()=="IE6"){
		heig=$(iframeDoc).height()*0.9;
		widt=$(iframeDoc).width()*0.9
	}
	if(myBrowser()=="IE7"){
		heig=$(iframeDoc).height()*0.9;
		widt=$(iframeDoc).width()*0.9
	}
	if(myBrowser()=="IE8"){
		heig=$(iframeDoc).height()*0.9;
		widt=$(iframeDoc).width()*0.9
	}
	if(myBrowser()=="FF"){
		heig=$(iframeDoc).height()*0.9;
		widt=$(iframeDoc).width()*0.9
	}
	
	hre=hre.replace(/hei1/, heig);
		
	hre=hre.replace(/wid1/, widt);
		
	obj.href=hre;
		
	obj.click();
}
function getCity_2(obj,key,element,num){

	var objs=utilCode.loadAllByKey(obj,key,num);
		
	var cityObj=document.getElementById(element);
	
	cityObj.innerHTML="";
	
	var opt = document.createElement('option');
	
	cityObj.options.add(opt);
	
	opt.value=0;
	
	opt.innerHTML="请选择"
	
	opt.selected=true; 	
	
	for(i=0;i<objs.length;i++){
	
		var option = document.createElement('option');
		
		cityObj.options.add(option);
		
		option.value=objs[i].id;
		
		option.innerHTML=objs[i].name;
					
	}
}