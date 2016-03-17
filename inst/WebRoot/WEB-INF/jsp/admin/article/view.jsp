<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
Pagination<Article> pagination = (Pagination<Article>)request.getAttribute("pagination");

List<Article> articles = pagination.getEntrys();
%>
<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%=baseResource%>/css/common.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="view-form">
	<table class="form-info">
		<tr>
			<td class="form-info-img"></td>
			<td class="form-info-text">编辑新闻</td>
		</tr>
	</table>
	
	<table>
	<tr>
		<td width="18%" height="30" align="center" bgcolor="#D1E9FC"><strong>类别</strong></td>
		<td width="50%" align="center" bgcolor="#D1E9FC"><strong>标题</strong></td>
		<td width="18%" align="center" bgcolor="#D1E9FC"><strong>发布时间</strong></td>
		<td width="14%" align="center" bgcolor="#D1E9FC"><strong>操作</strong></td>
	</tr>
		<%
		for (Article article : articles) {
		%>
			<tr>
				<td height="30" align="center" bgcolor="#eef7fe"><a href="update/<%= article.getArticleId() %>">${category.name}</a></td>
				<td align="center" bgcolor="#eef7fe">
					<a href="update/<%= article.getArticleId() %>"><%= article.getTitle() %></a>
				</td>
				<td align="center" bgcolor="#eef7fe"><%= simpleDateFormat.format(new Date(article.getCreateDate())) %></td>
				<td align="center" bgcolor="#eef7fe" >
					<a href="update/<%= article.getArticleId() %>" target="_self" >修改</a> | 
					<a href="#" onclick="doDelete(<%= article.getArticleId() %>)" target="_self" >删除</a>
				</td>
			</tr>
		<%
		}
		%>
	</table>

	<c:if test="${pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a href="<%= baseRoot %>/article/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
	
				<span>${pagination.pageNum}/${pagination.pageCount}页</span>
	
				<a href="<%= baseRoot %>/article/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
	
				<div class="clear"></div>
			</div>
		</div>
	</c:if>

	<hr>
	
	<div class="tool-bar">
		<a href="<%= baseRoot %>/article/${categoryId}/add" target="_self">发表新闻</a> | 
		<a href="javascript:history.back();" target="_self" >返回</a>
	</div>
</div>

	<script type="text/javascript">
		function doDelete(id) {
			if(confirm("您确定删除吗?此操作将不能恢复!")) {   
				window.location.href="delete/${category.categoryId}/" + id;
			}
		}
	</script>
</body>
</html>