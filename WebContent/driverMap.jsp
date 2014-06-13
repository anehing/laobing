<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<style type="text/css">
    html,body{margin:0;padding:0;}
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<body>
	<div class="titleDiv">
		<div class="titleDiv_a">
			<img src="${ctx}/images/tb_1.png" align="absmiddle" /> 
			<span>司机地图</span>
		</div>
		<div class="titleDiv_b"></div>
	</div>

	<%@ include file="commons/messages.jsp"%>
	<div align="right" onClick="nxx(0)" style="width: 97%; margin: auto">
		<img id="z0" style="cursor: pointer" align="middle" src="${ctx}/images/nxx8.png" width="80" height="22" />
	</div>

	 <div align="center">
			<div class="data0">
			<s:hidden  name="driverlist" id="driverlist" />     
				  <div style="width:1007px;height:500px;border:#ccc solid 1px;" id="dituContent"></div>
			</div>
		</div>
</body>
<script type="text/javascript">
var SAMPLE_ADVANCED_POST = 'http://api.map.baidu.com/geocoder/v2/?ak=mLN5AUgjYK5l0kTqUReCYHGk&callback=renderOption&output=json';

var advancedOptions = '';
var address
function showOptionsURL(type) {
    advancedOptions = SAMPLE_ADVANCED_POST;   
	address = document.getElementById('location').value; 
	advancedOptions+="&address="+address;


    
    var safe = advancedOptions;
    document.getElementById('optionsSampleUrl').innerHTML = safe.replace(/</g, '&lt;').replace(/>/g, '&gt;');
};

function renderOption(response) {
    var html = '';

		if (response.status ) {
			var text = "无正确的返回结果:\n";
			document.getElementById('optionsNarrative').innerHTML = text;
			return;
		}
		var location = response.result.location;
		var uri = 'http://api.map.baidu.com/marker?location='+ location.lat+','+location.lng +'&title='+response.result.level+'&content='+address+'&output=html';
		var staticimageUrl = "http://api.map.baidu.com/staticimage?center=" + location.lng+','+location.lat + "&markers=" + location.lng+','+location.lat;
		html = '<p>坐标：纬度: ' + location.lat + "  经度: " + location.lng+'<br/>';
		html += '精度: '+response.result.precise+'<br/>' ;
		html += '可信度: '+response.result.confidence +'<br/>';
		html += '地址类型: '+response.result.level+'</p>' ;
		html += '<p><img src="' + staticimageUrl + '"/></p>' ;
		html += '<p>分享该点: <a href="' + uri + '" target="_blank">' + uri + '</a></p>'; //将该链接设置成可单击
		document.getElementById('optionsNarrative').innerHTML = html;
		return;
    
    document.getElementById('optionsNarrative').innerHTML = html;
}

function doOptions() {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    showOptionsURL('buttonClick');
    var newURL = advancedOptions.replace('mLN5AUgjYK5l0kTqUReCYHGk','E4805d16520de693a3fe707cdc962045');
    script.src = newURL;
    document.body.appendChild(script);
};
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(116.303227,39.881279);//定义一个中心点坐标
        map.centerAndZoom(point,11);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var driverlist = document.getElementById("driverlist").value;
    var markerArr = JSON.parse(driverlist);
  //  var markerArr = [{title:"我的标记",content:"我的备注",point:"116.288423|39.996348",isOpen:0,icon:{w:23,h:25,l:0,t:21,x:9,lb:12}} ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.longitude;
            var p1 = json.latitude;
            var point = new BMap.Point(p0,p1);
            if (json.job_status == 2){//空闲
            	var iconImg = createIcon({w:23,h:25,l:46,t:21,x:9,lb:12});
            }else {
            	var iconImg = createIcon({w:23,h:25,l:0,t:21,x:9,lb:12});
            }
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.name,{"offset":new BMap.Size(13,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				
			})()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.name + "'>" + json.name + "</b><div class='iw_poi_content'>"+json.telphone+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
    
</script>
