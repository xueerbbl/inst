<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Category category = (Category)request.getAttribute("category");
%>
<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%=baseResource%>/css/common.css" rel="stylesheet" type="text/css">

	<script src="<%= baseResource %>/js/validation.js" type="text/javascript"></script>
	<script type="text/javascript">
		function update(id) {
			if (id > 0) {
				document.fm.action="<%= baseRoot %>/group/update/" +id;
			}
		}
	</script>
</head>
<body>
<div class="view-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">${category.name}</td>
	</tr>
	</table>

	<c:choose>
		<c:when test="<%= WebKey.CATEGORY_ATTACHMENT == category.getType() %>">
			<form action="<%= baseRoot %>/group/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${group.groupId});">
				<input name="categoryId" type="hidden" value="<%= category.getCategoryId() %>" />

				<table>
				<tr>
					<td width="10%"  >资料次级分类</td>
					<td width="45%">
						<span class="input">
							<input type="text" name="name" id="name" class="text" value="${group.name}" size="30" />
						</span>
					</td>
				</tr>
		</c:when>
	</c:choose>

	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" align="center" >
			<label>
				<input type="submit" name="submit" value="提交"/>
			</label>
		</td>
	</tr>
	</table>
</form>
</div>
</body>
</html>