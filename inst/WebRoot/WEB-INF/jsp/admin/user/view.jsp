<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<td class="form-info-text">员工列表</td>
	</tr>
	</table>
	<table>
	<tr class="form-table-title">
		<td width="10%">姓名</td>
		<td width="20%">职务</td>
		<td width="20%">邮箱</td>
		<td width="20%">电话</td>
		<td width="10%">操作</td>
	</tr>
	
		<c:forEach items="${Pagination.entrys}" var="user">
			<tr class="form-table-body">
				<td>${user.userName}</td>
				<td>
					<c:if test="${user.type eq 1 }">
						超级管理员
					</c:if>
					<c:if test="${user.type eq 2 }">
						文章管理员
					</c:if>
				</td>
				<td><a href="mailto:${user.email}">${user.email}</a></td>
				<td>${user.phone}</td>
				<td>
					<a href="update/${user.userId}" target="_self">修改</a> |
					<a href="#" onclick="deleteUser(${user.userId})" target="_self">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${Pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a class="" href="<%= baseRoot %>/user/view?pagination.pageNum=${Pagination.pageNum - 1}">上一页</a>
				${Pagination.pageNum}/${Pagination.pageCount}页
				<a href="<%= baseRoot %>/user/view?pagination.pageNum=${Pagination.pageNum + 1}">下一页</a>
				<div class="clear"></div>
			</div>
		</div>
	</c:if>
</div>
<script type="text/javascript">
	function deleteUser(userId) {
		if(confirm("您确定删除吗?此操作将不能恢复!")) {   
			window.location.href="delete/" + userId;
		}
	}
</script>
</body>
</html>
