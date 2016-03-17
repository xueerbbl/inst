<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--kefu-->
<div id="floatTools" class="rides-cs" style="height:400px;">
  <div class="floatL">
  	<a style="display:block" id="aFloatTools_Show" class="btnOpen" title="查看在线客服" style="top:20px" href="javascript:void(0);">展开</a>
  	<a style="display:none" id="aFloatTools_Hide" class="btnCtn" title="关闭在线客服" style="top:20px" href="javascript:void(0);">收缩</a>
  </div>
  <div id="divFloatToolsView" class="floatR" style="display: none;height:400px;width: 140px;">
    <div class="cn">
      <h3 class="titZx">因斯特在线客服</h3>
      <ul>
        <li><span>销售1</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3241845343&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:3241845343:51" alt="联系销售" title="联系销售"/></a> </li>
        <li><span>销售2</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3240372534&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:3240372534:51" alt="联系销售" title="联系销售"/></a> </li>
        <li><span>销售3</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3234285781&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:3234285781:41" alt="联系销售" title="联系销售"/></a> </li>
		<li><span>销售4</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3088098754&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:3088098754:41" alt="联系销售" title="联系销售"/></a></li>
        <li><span>销售5</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3112963586&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:3112963586:41" alt="联系销售" title="联系销售"/></a></li>
        <li><span>销售6</span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2978850640&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:2978850640:41" alt="联系销售" title="联系销售"/></a> </li>
        <li><span>商务 </span>  <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1534513049&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1534513049:41" alt="联系商务" title="联系商务"/></a></li>
        <li><span>技术 </span>  <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2595666495&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:2595666495:41" alt="联系技术" title="联系技术"/></a></li>
        
        <li style="border:none;"><span>电话：0411-39573150</span> </li>
      </ul>
    </div>
  </div>
</div>
<!--kefu-->

<div class="blank10">&nbsp;</div>

<div class="footer">
	<div class="footer-container">
		<div class="footer-text">
			<p>
				<span>PH/ORP</span> | 
				<span>荧光法溶解氧仪</span> | 
				<span>浊度计</span> | 
				<span>余氯</span> | 
				<span>电磁流量计</span> | 
				<span>光电污泥浓度计</span> | 
				<span>超声波液位计</span> | 
				<span>COD在线监测仪</span> | 
				<span>氨氮在线监测仪</span> | 
				<span>重金属在线监测仪</span>
			</p>
			<p>
				<span>销售：18141198631</span>
				<span>18141198632</span>
				<span>18141198633</span>
				<span>18141198634</span>
				<span>15326160096</span>
				<span>15326160098</span>
				<span style="padding-left: 5px">商务：15566891672</span>
				<span style="padding-left: 5px">技术：15940837686</span>
			</p>
			<p>
				<span>传真/电话：0411-39573150</span>
				<span style="padding-left: 10px">邮箱：admin@dlyinsite.com</span>
			</p>
			<p>
				<span>地址：辽宁省大连市甘井子区中华路汇利街75号</span>
			</p>
			<p>
				<span><a href="http://www.miitbeian.gov.cn" style="color: #FFF">辽ICP备15008052号</a></span>
			</p>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$("#aFloatTools_Show").click(function(){
			$('#divFloatToolsView').animate({width:'show',opacity:'show'},100,function(){$('#divFloatToolsView').show();});
			$('#aFloatTools_Show').hide();
			$('#aFloatTools_Hide').show();				
		});

		$("#aFloatTools_Hide").click(function(){
			$('#divFloatToolsView').animate({width:'hide', opacity:'hide'},100,function(){$('#divFloatToolsView').hide();});
			$('#aFloatTools_Show').show();
			$('#aFloatTools_Hide').hide();	
		});
	});
</script>