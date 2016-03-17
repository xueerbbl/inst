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
						<h4>当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;产品展示
						</h4>
					</div>

					<div class="s_right_streng">
						<div class="blank10">&nbsp;</div>
						
						<c:forEach items="${pagination.entrys}" var="entry" varStatus="status">

						<ul class="prodBox">
							<li class="imgBox">
								<a href="<%= request.getContextPath() %>/portal/product/${entry.categoryId}/${entry.productId}">
									<p>${entry.name}</p>
								</a>
							
								<a href="<%= request.getContextPath() %>/portal/product/${entry.categoryId}/${entry.productId}">
									<img  width="215" height="221"src="<%= request.getContextPath() %>/resources/upload/${entry.micro}" />
								</a>
							</li>
						</ul>
						
						<c:if test="${status.count%3==0}">
							<br style="clear: both;"/>
						</c:if>

						</c:forEach>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="s_fanye">
						<c:if test='${categoryId != null }'>
							<div class="quotes">
								<a class="" href="<%= request.getContextPath() %>/portal/product/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}&pagination.pageSize=9">上一页</a>
								${pagination.pageNum}/${pagination.pageCount}页
								<a href="<%= request.getContextPath() %>/portal/product/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}&pagination.pageSize=9">下一页</a>
								<div class="clear"></div>
							</div>
						</c:if>

						<c:if test='${search != null }'>
							<div class="quotes">
								<a class="" href="<%= request.getContextPath() %>/portal/search?pagination.pageNum=${pagination.pageNum - 1}&pagination.pageSize=9&search=${search}">上一页</a>
								${pagination.pageNum}/${pagination.pageCount}页
								<a href="<%= request.getContextPath() %>/portal/search?pagination.pageNum=${pagination.pageNum + 1}&pagination.pageSize=9&search=${search}">下一页</a>
								<div class="clear"></div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="../footer.jsp" />

	</div>
<script type="text/javascript">
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
