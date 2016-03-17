<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
int type = (Integer)request.getAttribute("type");
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
			if (getValidati("hidValidation") == false) {
				return false;
			}

			if (id > 0) {
				document.fm.action="<%= baseRoot %>/category/update/" +id;
			}
		}
	</script>
</head>
<body>
<div class="view-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">编辑分类</td>
	</tr>
	</table>

	<c:choose>
		<c:when test="<%= WebKey.CATEGORY_ARTICLE == type %>">
			<form action="<%= baseRoot %>/category/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${category.categoryId});">
				<input name="type" type="hidden" value="${type}" />
				<input name="hidValidation" id="hid_name" type="hidden" value="${category.categoryId eq 0 ? "1" : "0"}" />
		
				<table>
				<tr>
					<td width="10%"  >新闻类型</td>
					<td width="45%">
						<span class="input">
							<input type="text" name="name" id="name" class="text" value="${category.name}" size="30" onchange = "validati('name','name')" />
						</span>
					</td>
					<td width="45%">
						<div id="msg_name"></div>
					</td>
				</tr>
		</c:when>
		<c:when test="<%= WebKey.CATEGORY_SUPPORT == type %>">
			<form action="<%= baseRoot %>/category/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${category.categoryId});">
				<input name="type" type="hidden" value="${type}" />
				<input name="hidValidation" id="hid_name" type="hidden" value="${category.categoryId eq 0 ? "1" : "0"}" />
		
				<table>
				<tr>
					<td width="10%">产品类型</td>
					<td width="45%">
						<span class="input">
							<input type="text" name="name" id="name" class="text" value="${category.name}" size="30" onchange = "validati('name','name')" />
						</span>
					</td>
					<td width="45%">
						<div id="msg_name"></div>
					</td>
				</tr>
		</c:when>
		<c:when test="<%= WebKey.CATEGORY_ATTACHMENT == type%>">
			<form action="<%= baseRoot %>/category/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${category.categoryId});">
				<input name="type" type="hidden" value="${type}" />
				<input name="hidValidation" id="hid_name" type="hidden" value="${category.categoryId eq 0 ? "1" : "0"}" />
		
				<table>
				<tr>
					<td width="10%"  >文件类型</td>
					<td width="45%">
						<span class="input">
							<input type="text" name="name" id="name" class="text" value="${category.name}" size="30" onchange = "validati('name','name')" />
						</span>
					</td>
					<td width="45%">
						<div id="msg_name"></div>
					</td>
				</tr>
		</c:when>
		<c:when test="<%= WebKey.CATEGORY_PRODUCT == type%>">
			<form action="<%= baseRoot %>/category/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${category.categoryId});">
				<input name="type" type="hidden" value="${type}" />
				<input name="hidValidation" id="hid_name" type="hidden" value="${category.categoryId eq 0 ? "1" : "0"}" />

				<table>
				<tr>
					<td width="10%"  >商品型号</td>
					<td width="45%">
						<span class="input">
							<input type="text" name="name" id="name" class="text" value="${category.name}" size="30" onchange = "validati('name','name')" />
						</span>
					</td>
					<td width="45%">
						<div id="msg_name"></div>
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