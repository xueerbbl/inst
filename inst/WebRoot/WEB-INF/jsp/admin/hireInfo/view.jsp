<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Pagination<HireInfo> pagination = (Pagination)request.getAttribute("pagination");

List<HireInfo> hireInfos = pagination.getEntrys();
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
		<td class="form-info-text">招聘信息列表</td>
	</tr>
	</table>
	<table>
	<tr class="form-table-title">
		<td width="20%">职位</td>
		<td width="10%">人数</td>
		<td width="10%">工作地点</td>
		<td width="20%">发布时间</td>
		<td width="10%">状态</td>
		<td width="10%">操作</td>
	</tr>
	
		<%
		for (HireInfo hireInfo : hireInfos) {
		%>
			<tr class="form-table-body">
				<td><%= hireInfo.getTitle() %></td>
				<td><%= hireInfo.getNumber() %></td>
				<td><%= hireInfo.getLocation() %></td>
				<td><%= simpleDateFormat.format(new Date(hireInfo.getCreateDate())) %></td>
				<td><%= hireInfo.getStatusLable() %></td>
				<td>
					<a href="<%= baseRoot %>/hireInfo/update/<%= hireInfo.getHireInfoId() %>" target="_self">修改</a> |
					<a href="#" onclick="deleteHireInfo(<%= hireInfo.getHireInfoId() %>)" target="_self">删除</a>
				</td>
			</tr>
		<%
		}
		%>
	</table>

	<c:if test="${pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a class="" href="<%= baseRoot %>/hireInfo/view?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
				${pagination.pageNum}/${pagination.pageCount}页
				<a href="<%= baseRoot %>/hireInfo/view?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
	
				<div class="clear"></div>
			</div>
		</div>
	</c:if>

	<hr>
	
	<div class="tool-bar">
		<a href="<%= baseRoot %>/hireInfo/add" target="_self">添加招聘信息</a> | 
		<a href="javascript:history.back();" target="_self" >返回</a>
	</div>
</div>
<script type="text/javascript">
	function deleteHireInfo(hireInfoId) {
		if(confirm("您确定删除吗?此操作将不能恢复!")) {   
			window.location.href="delete/" + hireInfoId;
		}
	};
</script>
</body>
</html>
