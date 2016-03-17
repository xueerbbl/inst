<%@ include file="/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />

<%@ include file="header.jsp" %>

<%
List<Article> articles = (List<Article>)request.getAttribute("articles");
List<Article> supportArticles = (List<Article>)request.getAttribute("supportArticles");
List<Product> products = (List<Product>)request.getAttribute("products");
%>

<body>
	<div class="max">
		<jsp:include page="navigation_bar.jsp" />

		<div class="m_banner" style="margin-top: 158px">
			<!-- 代码 开始 -->
			<div class="header">
				<div class="gg" id="gg">
					<div class="ggs">
						<div class="ggBox" id="ggBox">
							<a href="index" title="" style="z-index: 3; opacity: 4;">
								<img src="<%= request.getContextPath() %>/resources/templates/default/images/banner/banner1.jpg" alt="首页banner" />
							</a>
							<a href="index" title="">
								<img src="<%= request.getContextPath() %>/resources/templates/default/images/banner/banner2.jpg" alt="首页banner" />
							</a>
							<a href="index" title="">
								<img src="<%= request.getContextPath() %>/resources/templates/default/images/banner/banner3.jpg" alt="首页banner" />
							</a>
						</div>
					</div>
					<div class="ggb">
						<div class="ggBtns" id="ggBtns">
						</div>
					</div>
				</div>
			</div>
			<!-- 代码 结束 -->
		</div>

		<div class="m_max">
		<div class="info">

        <!--行业资讯-->

        <div class="info_1 fl">
		    <div class="info_top">
		        <h3 class="fl"><a href="<%= request.getContextPath() %>/portal/article">新闻中心</a></h3>
		        <div class="clear"></div>
		    </div>
		
		    <div class="info_ct">
		        <ul>
		        	<%
		        	for (Article article : articles) {
		        	%>
						<li><span>【<%= simpleDateFormat.format(new Date(article.getCreateDate())) %>】</span><a title='<%= article.getTitle() %>' href='<%= request.getContextPath() %>/portal/article/<%= article.getArticleId() %>' target="_self"><%= article.getTitle() %></a></li>
					<%
		        	}
					%>
				</ul>
		    </div>
		</div>

  <!--行业资讯-->

        <div class="info_1 fl">
			<div class="info_top">
        		<h3 class="fl"><a href="<%= request.getContextPath() %>/portal/support">技术支持</a></h3>
			<div class="clear"></div>
	    </div>

    	<div class="info_ct">
	        <ul>
	        	<%
	        	for (Article article : supportArticles) {
	        	%>
					<li><span>【<%= simpleDateFormat.format(new Date(article.getCreateDate())) %>】</span><a title='<%= article.getTitle() %>' href='<%= request.getContextPath() %>/portal/support/<%= article.getArticleId() %>' target="_self"><%= article.getTitle() %></a></li>
				<%
	        	}
				%>
			</ul>
   		 </div>

</div>     

</div>

<div class="clear"></div>

<div class="m_pro_con">
	<div class="rollprod">
		<div onmouseup="ISL_StopUp()" class="LeftBotton" onmousedown="ISL_GoUp()" onmouseover="ISL_StopAuto()" onmouseout="ISL_StartAuto()">
		</div>
		<div class="Cont" id="ISL_Cont">
			<div class="ScrCont">
				<div id="List3">
					<%
					for (Product product : products) {
					%>
						<!-- 图片列表 end -->
						<div class="pic">
							<div>
								<a href="<%= request.getContextPath() %>/portal/product/<%= product.getCategoryId() %>/<%= product.getProductId() %>" target="_parent">
									<img src="<%= request.getContextPath() %>/resources/upload/<%= product.getMicro() %>" width="161" height="158" />
								</a>
							</div>

							<div class="pic-text">
								<a href="<%= request.getContextPath() %>/portal/product/<%= product.getCategoryId() %>/<%= product.getProductId() %>" target="_parent"><%= product.getName() %></a>
							</div>
						</div>
						<!-- 图片列表 end -->
					<%
					}
					%>
				</div>
				<div id="List4"></div>
			</div>
		</div>
		<div onmouseup="ISL_StopDown()" class="RightBotton" onmousedown="ISL_GoDown()" onmouseover="ISL_StopAuto()" onmouseout="ISL_StartAuto()"></div>
	</div>
	<div></div>
	
	<script language="javascript" type="text/javascript">
		var Speed = 8; //速度(毫秒)
		var Space = 6; //每次移动(px)
		var PageWidth = 132; //翻页宽度
		var fill = 0; //整体移位
		var MoveLock = false;
		var MoveTimeObj;
		var Comp = 0;
		var AutoPlayObj = null;
		GetObj("List4").innerHTML = GetObj("List3").innerHTML;
		GetObj('ISL_Cont').scrollLeft = fill;
	
		//GetObj("ISL_Cont").onmouseover = function(){clearInterval(AutoPlayObj);}
		//GetObj("ISL_Cont").onmouseout = function(){AutoPlay();}
	
		//默认图片自动滚动
		var tab = document.getElementById("ISL_Cont");
		var tab1 = document.getElementById("List3");
		var tab2 = document.getElementById("List4");
		tab2.innerHTML = tab1.innerHTML;

		function Marquee() {
			if (tab2.offsetWidth - tab.scrollLeft <= 0){
				tab.scrollLeft -= tab1.offsetWidth;
			}
			else {
				var temp = tab.scrollLeft;

				tab.scrollLeft=tab.scrollLeft + 1;

				if (temp == tab.scrollLeft) {
					tab.scrollLeft -= tab1.offsetWidth;
				}
			}
		}
		var MyMar = setInterval(Marquee, Speed);

		tab.onmouseover = function() {
			clearInterval(MyMar);
		};
		tab.onmouseout = function() {
			MyMar = setInterval(Marquee, Speed);
		};
	
		function GetObj(objName) {
			if (document.getElementById) {
				return eval('document.getElementById("'
						+ objName + '")');
			} else {
				return eval('document.all.' + objName);
			}
		}
	
		function AutoPlay() { //自动滚动
			clearInterval(AutoPlayObj);
			AutoPlayObj = setInterval(
					'ISL_GoDown();ISL_StopDown();', 3000); //间隔时间
		}
	
		function ISL_StartAuto() { //开始自动滚动
			MyMar = setInterval(Marquee, Speed);
		}
	
		function ISL_StopAuto() { //暂停自动滚动
			clearInterval(MyMar);
		}
	
		function ISL_GoUp() { //上翻开始
			if (MoveLock)
				return;
			clearInterval(AutoPlayObj);
			MoveLock = true;
			MoveTimeObj = setInterval('ISL_ScrUp();', Speed);
		}
	
		function ISL_StopUp() { //上翻停止
			clearInterval(MoveTimeObj);
			if (GetObj('ISL_Cont').scrollLeft % PageWidth
					- fill != 0) {
				Comp = fill
						- (GetObj('ISL_Cont').scrollLeft % PageWidth);
				CompScr();
			} else {
				MoveLock = false;
			}
		}
	
		function ISL_ScrUp() { //上翻动作
			if (GetObj('ISL_Cont').scrollLeft <= 0) {
				GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft
						+ GetObj('List3').offsetWidth;
			}
			GetObj('ISL_Cont').scrollLeft -= Space;
		}
		function ISL_GoDown() { //下翻
			clearInterval(MoveTimeObj);
			if (MoveLock)
				return;
			clearInterval(AutoPlayObj);
			MoveLock = true;
			ISL_ScrDown();
			MoveTimeObj = setInterval('ISL_ScrDown()', Speed);
			tab.onmouseover = function() {
				clearInterval(MyMar);
			};
		}
		function ISL_StopDown() { //下翻停止
			clearInterval(MoveTimeObj);
			if (GetObj('ISL_Cont').scrollLeft % PageWidth
					- fill != 0) {
				Comp = PageWidth
						- GetObj('ISL_Cont').scrollLeft
						% PageWidth + fill;
				CompScr();
			} else {
				MoveLock = false;
			}
	
		}
		function ISL_ScrDown() { //下翻动作
			if (GetObj('ISL_Cont').scrollLeft >= GetObj('List3').scrollWidth) {
				GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft
						- GetObj('List3').scrollWidth;
			}
			GetObj('ISL_Cont').scrollLeft += Space;
		}
		function CompScr() {
			var num;
			if (Comp == 0) {
				MoveLock = false;
				return;
			}
			if (Comp < 0) { //上翻
				if (Comp < -Space) {
					Comp += Space;
					num = Space;
				} else {
					num = -Comp;
					Comp = 0;
				}
				GetObj('ISL_Cont').scrollLeft -= num;
				setTimeout('CompScr()', Speed);
			} else { //下翻
				if (Comp > Space) {
					Comp -= Space;
					num = Space;
				} else {
					num = Comp;
					Comp = 0;
				}
				GetObj('ISL_Cont').scrollLeft += num;
				setTimeout('CompScr()', Speed);
			}
		}
	</script>
	</div>
    </div>
		</div>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>