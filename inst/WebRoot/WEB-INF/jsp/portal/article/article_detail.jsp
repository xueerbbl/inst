<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/init.jsp" %>

<%
Article article = (Article)request.getAttribute("article");;
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
						<h3>新闻列表</h3>
					</div>
					<div class="type_list">
						<ul>
							<c:forEach items="${categorys}" var="category">
								<li><a href="<%= request.getContextPath() %>/portal/articles/${category.categoryId}">${category.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="s_right">
					<div class="s_right_cokk">
						<h4>返回首页：<a href="<%= request.getContextPath() %>/index">首页</a></h4>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="s_list">
						<h3><%= article.getTitle() %></h3>
						<h4>发布时间：<%= simpleDateFormat.format(new Date(article.getCreateDate())) %></h4>
					</div>

					<div class="s_list_con">
						<p>
						<%= article.getDetail() %>
						</p>
						<div class="blank20">&nbsp;</div>
					</div>
				</div>
			</div>
					<jsp:include page="../footer.jsp" />
			
		</div>
	</div>
</body>
</html>
