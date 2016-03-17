<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Pagination<Message> pagination = (Pagination)request.getAttribute("pagination");

List<Message> messages = pagination.getEntrys();
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
		<td class="form-info-text">留言板列表</td>
	</tr>
	</table>
	<table>
	<tr class="form-table-title">
		<td width="20%">公司名称</td>
		<td width="10%">联系人名称</td>
		<td width="10%">联系电话</td>
		<td width="20%">联系邮箱</td>
		<td width="10%">发布时间</td>
		<td width="10%">状态</td>
		<td width="10%">操作</td>
	</tr>
	
		<%
		for (Message message : messages) {
		%>
			<tr class="form-table-body">
				<td><%= message.getCompanyName() %></td>
				<td><%= message.getUserName() %></td>
				<td><%= message.getPhone() %></td>
				<td><%= message.getEmail() %></td>
				<td><%= simpleDateFormat.format(new Date(message.getCreateDate())) %></td>
				<td><%= message.getStatusLabel() %></td>
				<td>
					<a href="<%= baseRoot %>/message/view/<%= message.getMessageId() %>" target="_self">查看</a>
					<a href="#" onclick="deleteMessage(<%= message.getMessageId() %>)" target="_self">删除</a>
				</td>
			</tr>
		<%
		}
		%>
	</table>

	<c:if test="${pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a class="" href="<%= baseRoot %>/message/view?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
				${pagination.pageNum}/${pagination.pageCount}页
				<a href="<%= baseRoot %>/message/view?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
	
				<div class="clear"></div>
			</div>
		</div>
	</c:if>
</div>
<script type="text/javascript">
	function deleteMessage(messageId) {
		if(confirm("您确定删除吗?此操作将不能恢复!")) {   
			window.location.href="delete/" + messageId;
		}
	};
</script>
</body>
</html>
