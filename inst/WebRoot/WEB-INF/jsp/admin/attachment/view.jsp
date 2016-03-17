<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Pagination<Attachment> pagination = (Pagination<Attachment>)request.getAttribute("pagination");
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
		<td class="form-info-text">文件列表</td>
	</tr>
</table>
<table>
<tr>
	<td width="18%" height="30" align="center" bgcolor="#D1E9FC"><strong>类别</strong></td>
	<td width="25%" align="center" bgcolor="#D1E9FC"><strong>文件名称</strong></td>
	<td width="25%" align="center" bgcolor="#D1E9FC"><strong>文件大小</strong></td>
	<td width="18%" align="center" bgcolor="#D1E9FC"><strong>发布时间</strong></td>
	<td width="14%" align="center" bgcolor="#D1E9FC"><strong>操作</strong></td>
</tr>

	<%
	for(Attachment attachment : pagination.getEntrys()) {
	%>
		<tr>
			<td height="30" align="center" bgcolor="#eef7fe">${group.name}</td>
			<td align="center" bgcolor="#eef7fe"><%= attachment.getFileName() %></td>
			<td align="center" bgcolor="#eef7fe"><%= attachment.getFileSize() %> KB</td>
			<td align="center" bgcolor="#eef7fe"><%= simpleDateFormat.format(new Date(attachment.getCreateDate())) %></td>
			<td align="center" bgcolor="#eef7fe" >
				<a href="#" onclick="doDelete(<%= attachment.getAttachmentId() %>)" target="_self" >删除</a>
			</td>
		</tr>
	<%
	}
	%>
</table>

	<c:if test="${pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a href="<%= baseRoot %>/attachment/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
	
				<span>${pagination.pageNum}/${pagination.pageCount}页</span>
	
				<a href="<%= baseRoot %>/attachment/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
	
				<div class="clear"></div>
			</div>
		</div>
	</c:if>

	<hr>

	<div class="tool-bar">
		<a href="<%= baseRoot %>/attachment/${categoryId}/add" target="_self">添加文件</a> | 
		<a href="<%= baseRoot %>/attachment/${categoryId}/add2" target="_self">添加外网链接</a> | 
		<a href="javascript:history.back();" target="_self" >返回</a>
	</div>
</div>

<script type="text/javascript">
	function doDelete(id) {
		if (confirm("您确定删除吗?此操作将不能恢复!")) {   
			window.location.href="delete/${group.groupId}/" + id;
		}
	};
</script>
</body>
</html>