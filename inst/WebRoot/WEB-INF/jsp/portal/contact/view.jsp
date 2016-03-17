<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!--引用百度地图API-->
<style type="text/css">
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    .contact-table table{width: 100%;}
    .contact-table table td { border: '1px solid #ccc';}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=30af91dc6873a0c397b17586346563d0"></script>
<%@ include file="../header.jsp" %>

<body>
	<div class="max">
		<jsp:include page="../navigation_bar.jsp" />

		<div class="s_max">
			<jsp:include page="../s_banner.jsp" />

			<div class="s_about_box">
				<div class="s_type">
					<div class="s_type_cokk">
						<h3>关于我们</h3>
					</div>
					<div class="type_list">
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/contact">联系方式</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/message">留言</a></li>
						</ul>
					</div>
				</div>
				<div class="s_right">
					<div class="s_right_cokk">
						当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;联系我们
					</div>
					<div class="s_rig_conta">
					  <!--百度地图容器-->
				    <div style="width:697px;height:300px;border:#ccc solid 1px;font-size:12px" id="map"></div>

  					<br />

  					<div class="contact-table">
  						<table border="1" cellspacing="0" cellpadding="0" bordercolor="#000000" bordercolordark="#FFFFFF"  >
  							<tr>
  								<td width="20%" align="center">职能划分</td>
  								<td width="40%" align="center">所属区域</td>
  								<td width="20%" align="center">联系电话</td>
								<td width="20%" align="center">QQ</td>
  							</tr>
   							<tr>
  								<td rowspan="6" align="center">业务支持</td>
  								<td align="center"><strong>上海、江苏、浙江、湖北、海南</strong></td>
  								<td align="center">18141198631</td>
								<td align="center">18141198631</td>
  							</tr>
   							<tr>
  								<td align="center"><strong>福建、广东、广西、山东、内蒙古</strong></td>
  								<td align="center">18141198632</td>
								<td align="center">18141198632</td>
  							</tr>
   							<tr>
  								<td align="center"><strong>辽宁、黑龙江、吉林 、云南、贵州</strong></td>
  								<td align="center">18141198633</td>
								<td align="center">18141198633</td>
  							</tr>
   							<tr>
  								<td align="center"><strong>北京、天津、河南、山西、新疆</strong></td>
  								<td align="center">18141198634</td>
								<td align="center">18141198634</td>
  							</tr>
   							<tr>
  								<td align="center"><strong>河北、山西、 湖南 、江西 、陕西</strong></td>
  								<td align="center">15326160096</td>
								<td align="center">15326160096</td>
  							</tr>
  							<tr>
  								<td align="center"><strong>四川、重庆、宁夏、安徽、甘肃</strong></td>
  								<td align="center">15326160098</td>
								<td align="center">15326160098</td>
  							</tr>
  							<tr>
  								<td align="center">商务支持</td>
  								<td>&nbsp;</td>
  								<td align="center">15566891672</td>
								<td align="center">15566891672</td>
  							</tr>
  							<tr>
  								<td align="center">技术/售后支持</td>
  								<td>&nbsp;</td>
  								<td align="center">15940837686</td>
								<td align="center">15940837686</td>
  							</tr>
  						</table>
  					</div>

  					<br />

					<span>大连总公司</span><br />
						<p>
							<span>地址：辽宁大连市甘井子区中华路汇利街75号</span><br />
							<span>总机/传真：0411-39573150</span><br />
							<span>邮箱：admin@dlyinsite.com</span><br />
							<span>网址：www.dlyinsite.cn</span><br />
							<span>邮编：116000</span><br />
							<span>乘车路线：20路、38路、42路、45路、413路、704路、908路、姚家-兴工街、二十高中-建设街、泉水客运服务中心-长兴市场、华南国际商城-北海工业区、动力院景-蓝天山庄、华南国际商城-后关</span><br />
						</p>
					</div>
				</div>
			</div>
		<jsp:include page="../footer.jsp" />

		</div>
	</div>
</body>
 <script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
      createMap();//创建地图
      setMapEvent();//设置地图事件
      addMapControl();//向地图添加控件
      addMapOverlay();//向地图添加覆盖物
    }
    function createMap(){ 
      map = new BMap.Map("map"); 
      map.centerAndZoom(new BMap.Point(121.599476,38.997296),17);
    }
    function setMapEvent(){
      map.enableScrollWheelZoom();
      map.enableKeyboard();
      map.enableDragging();
      map.enableDoubleClickZoom()
    }
    function addClickHandler(target,window){
      target.addEventListener("click",function(){
        target.openInfoWindow(window);
      });
    }
    function addMapOverlay(){
      var markers = [
        {content:"大连因斯特科技有限公司",title:"大连因斯特科技有限公司",imageOffset: {width:0,height:3},position:{lat:38.997521,lng:121.599583}}
      ];
      for(var index = 0; index < markers.length; index++ ){
        var point = new BMap.Point(markers[index].position.lng,markers[index].position.lat);
        var marker = new BMap.Marker(point,{icon:new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",new BMap.Size(20,25),{
          imageOffset: new BMap.Size(markers[index].imageOffset.width,markers[index].imageOffset.height)
        })});
        var label = new BMap.Label(markers[index].title,{offset: new BMap.Size(25,5)});
        var opts = {
          width: 200,
          title: markers[index].title,
          enableMessage: false
        };
        var infoWindow = new BMap.InfoWindow(markers[index].content,opts);
        marker.setLabel(label);
        addClickHandler(marker,infoWindow);
        map.addOverlay(marker);
      };
    }
    //向地图添加控件
    function addMapControl(){
      var scaleControl = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
      scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
      map.addControl(scaleControl);
      var navControl = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
      map.addControl(navControl);
      var overviewControl = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:true});
      map.addControl(overviewControl);
    }
    var map;
      initMap();
  </script>
</html>