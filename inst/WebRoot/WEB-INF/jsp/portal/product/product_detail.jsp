<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../header.jsp" %>

<body>
	<div class="max">
		<jsp:include page="../navigation_bar.jsp" />
        <div class="s_max">
			<jsp:include page="../s_banner.jsp" />

			<div class="s_about_box">
				<div class="s_type">
					<div class="s_type_cokk">
						<h3>产品展示</h3>
					</div>
					<div class="product_list">
						<c:forEach items="${productGroups}" var="productGroup">
						<table class="menu-collapse">
							<tr>
								<td class="title">
									<span onClick="showsubmenu(${productGroup.id})" style="padding-left: 25px">&nbsp;</span>
									<span><a href="<%= request.getContextPath() %>/portal/product/${productGroup.id}" >${productGroup.name}</a></span>
								</td>
							</tr>
							<tr>
								<td class="menu">
								<table id='submenu${productGroup.id}' style="display:none">
									<c:forEach items="${productGroup.products}" var="product">
										<tr>
											<td class="sub-menu" align="center">
												<span><a href="<%= request.getContextPath() %>/portal/product/${product.categoryId}/${product.productId}" >${product.name}</a></span>
											</td>
										</tr>
									</c:forEach>
								</table>
								</td>
							</tr>
						</table>
						</c:forEach>
					</div>
				</div>
                <div class="s_right">
                    <div class="s_right_cokk">
						<h4>当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;产品展示</h4>
                    </div>
                    <div class="s_rig_abo">
                        <div class="prod_title">
                            <div class="prod_title_pic">
                                <img src="<%= request.getContextPath() %>/resources/upload/${product.micro}"  width="278" height="273" />
                            </div>
                            <div class="prod_title_txt">
                                <h3>${product.name}</h3>
                                <div class="blank10">&nbsp;</div>
                                <div class="prod-detail">
                               		 <pre>${product.detail}<pre>
                               	</div>
                                <div class="blank10">&nbsp;</div>
                                                                                                                           </div>
                        </div>
                        <div class="blank20">&nbsp;</div>
                        <div class="ncillo">
                            <div class="cilloTitle">
                                <ul id="mycillo">
                                    <li class="active" onmouseover="ncillos(this,0);">详细介绍</li>
                                    <li class="normal" onmouseover="ncillos(this,1);">详细参数</li>
                                </ul>
                            </div>
                             <div class="cilloContent">
                                <div id="mycillo_Content0">
                                	<div class="detail-content"><pre>${product.detail1}</pre></div>
                                </div>
                                <div id="mycillo_Content1" class="none">
                               		 <p>${product.detail2}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
			</div>
		</div>
		<jsp:include page="../footer.jsp" />

	</div>
<script type="text/javascript">
        function ncillos(thisObj, Num) {
            if (thisObj.className == "active") return;
            var cilloObj = thisObj.parentNode.id;
            var cilloList = document.getElementById(cilloObj).getElementsByTagName("li");
            for (var i = 0; i < cilloList.length; i++) {
                if (i == Num) {
                    thisObj.className = "active";
                    document.getElementById(cilloObj + "_Content" + i).style.display = "block";
                } else {
                    cilloList[i].className = "normal";
                    document.getElementById(cilloObj + "_Content" + i).style.display = "none";
                }
            }
        }

    	function showsubmenu(sid) {
    		whichEl = eval("submenu" + sid);
    		if (whichEl.style.display == "none")
    		{
    			eval("submenu" + sid + ".style.display=\"\";");
    		}
    		else
    		{
    			eval("submenu" + sid + ".style.display=\"none\";");
    		}
    	}
    </script>
   </body>
</html>
