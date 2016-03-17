<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../init.jsp"%>

<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%=baseResource%>/css/common.css" rel="stylesheet" type="text/css">
	<script src="<%= baseResource %>/js/validation.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/resources/editor/ckeditor/ckeditor.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/resources/editor/ckfinder/ckfinder.js" type="text/javascript"></script>
	<script type="text/javascript">
		function update(id) {
			if (getValidati("hidValidation") == false) {
				return false;
			}

			if (id > 0) {
				document.fm.action="<%= baseRoot %>/article/update/" + id;
			}
		}
	</script>
</head>
<body>
<div class="view-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">编辑新闻</td>
	</tr>
	</table>

	<form action="<%= baseRoot %>/article/${category.categoryId}/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${article.articleId});">
		<input name="hidValidation" id="hid_name" type="hidden" value="${article.articleId eq 0 ? "1" : "0"}" />

		<table>
		<tr>
			<td width="10%">新闻标题</td>
			<td width="45%">
				<span class="input">
					<input type="text" name="title" id="title" class="text" value="${article.title}" size="70" />
				</span>
			</td>
			<td width="45%">
				<div id="msg_name"></div>
			</td>
		</tr>
		<tr>
			<td width="10%">新闻分类</td>
			<td width="45%">
				<span class="input">
					${category.name}
				</span>
			</td>
			<td width="45%">
				<div id="msg_name"></div>
			</td>
		</tr>
		<tr>
			<td width="10%">新闻内容</td>
			<td width="45%">
				<textarea class="ckeditor" cols="80" id="detail" name="detail" rows="10">${article.detail}</textarea>
			</td>
			<td width="45%">
			</td>
		</tr>
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
				<input type="submit" value="提交" >
			</td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>