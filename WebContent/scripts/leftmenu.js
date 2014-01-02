var op = 0;

var tmpCount=0;

var tmpHeight=tmpCount*30;

function getBodyHeight(){

	var de=document.documentElement;
	
	var db=document.body;
	
	var viewW=de.clientWidth==0 ?  db.clientWidth : de.clientWidth;
	
	var viewH=de.clientHeight==0 ?  db.clientHeight : de.clientHeight;
	
	return viewH;

}


// ��� ʱʱ���µİ�ɫ���Ĵ�С
window.onresize=function(){

 /*
	var aa=getBodyHeight();	
	
	document.getElementById("iii").style.height=aa+"px";
			
	document.getElementById("r"+op).style.height=aa-tmpHeight+"px"; //105
//	document.getElementById("r"+op).style.height="140px"; //105
	
	//alert(document.getElementById("r"+op).style.height);
	
*/
	
}


/*
$(function(){

	menuResize();
	
	window.onresize=menuResize();

});
*/
function nos(n){  
    tmpHeight=tmpCount*47+37;
	var aa = getBodyHeight(); 

    var bnOp=document.getElementById('r'+n).style.display=='none';
    
    
    for(var i=0;i<9;i++){
    
    	$("#r"+i).slideUp('fast');	
    	
    	$("#z"+i).attr('src','images/x_1b.gif ');
    	
		$("#d"+i).attr('src','images/menu/dian01a.gif ');
    
    }
    
    if(bnOp){
    
    if(document.getElementById("r"+n).id == "r4"){
    
    	document.getElementById("r"+n).style.height=aa-(tmpHeight+58)+"px";
    	
    }else{
    	
    	document.getElementById("r"+n).style.height=aa-tmpHeight+"px";
    }
    	
//    	document.getElementById("r"+n).style.height="140px";
    
    	$("#r"+n).slideDown('fast');
    	
    	$("#z"+n).attr('src','images/x_1a.gif ');
    	
		$("#d"+n).attr('src','images/menu/dian01.gif ');
    
    }
        
}

/*------ �ڶ��ڵ� ��ѭ��------*/
 function nxx(n){  
 	var b = document.getElementById('q'+n).style.display=='none';
	
	for(var i=0;i<15;i++){
		if(n==i){
			if(!b){
				$("#q"+i).slideUp('fast');
			}else{
				$("#q"+i).slideDown('fast');
			}	
		}else{
			$("#q"+i).slideUp('fast');	
		}
	}
}

/*------ ��8Ŀѭ�� ------*/
function xxx(){
		return document.getElementsByTagName('li');
}

function g(o){return document.getElementById(o);} 
function Hover1(n){ 
	
	var liSet=xxx();
	
	for(var i=0;i<liSet.length;i++){
		liSet[i].getElementsByTagName("span")[0].className='normal_txt';
	
	}
	
	g('1b_'+n).className='hover_txt'; 
}
/*------ �ڶ��ڵ� ICP��������------*/



function Hover2(n){ 
for(var i=1;i<=9;i++){
	g('2b_'+i).className='normal_txt2';
	}
	g('2b_'+n).className='hover_txt2'; 
}

function goTarget(url){

	parent.mainFrame.location=url;

}
