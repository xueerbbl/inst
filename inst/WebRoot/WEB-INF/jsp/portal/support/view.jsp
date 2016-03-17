<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/init.jsp" %>

<%
Pagination<Article> pagination = (Pagination)request.getAttribute("pagination");

List<Article> articles = pagination.getEntrys();
%>
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
						<h3>技术支持</h3>
					</div>
					<div class="type_list">
						<ul>
							<c:forEach items="${categorys}" var="category">
								<li><a href="<%= request.getContextPath() %>/portal/supports/${category.categoryId}">${category.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="s_right">
					<div class="s_right_cokk">
						<h4>当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;技术支持</h4>
					</div>

					<div class="news_list">
						<ul>
							<%
							for (Article article : articles) {
							%>
								<li><a href="<%= request.getContextPath() %>/portal/support/<%= article.getArticleId() %>"><%= article.getTitle() %></a><span>[<%= simpleDateFormat.format(new Date(article.getCreateDate())) %>]</span></li>
							<%
							}
							%>
						 </ul>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="s_fanye">
						<div class="quotes">
							<a class="" href="<%= request.getContextPath() %>/portal/supports/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
							${pagination.pageNum}/${pagination.pageCount}页
							<a href="<%= request.getContextPath() %>/portal/supports/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		<jsp:include page="../footer.jsp" />
		</div>
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
