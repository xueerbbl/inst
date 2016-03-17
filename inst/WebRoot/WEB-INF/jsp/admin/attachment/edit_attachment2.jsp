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
	<script type="text/javascript">
		function update(id) {
			if (getValidati("hidValidation") == false) {
				return false;
			}
		}
	</script>
</head>
<body>
<div class="view-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">文件列表</td>
	</tr>
	</table>

	<form action="<%= baseRoot %>/attachment/${group.groupId}/add2" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${attachment.attachmentId});" enctype="multipart/form-data">
		<input name="hidValidation" id="hid_name" type="hidden" value="${attachment.attachmentId eq 0 ? "1" : "0"}" />

		<table>
		<tr>
			<td width="10%">文件分类</td>
			<td width="45%">
				<span class="input">
					${group.name}
				</span>
			</td>
			<td width="45%">
				<div id="msg_name"></div>
			</td>
		</tr>
		<tr>
			<td width="10%">文件名称</td>
			<td width="45%">
				<input type="text" name="fileName" size="40"/>
			</td>
			<td width="45%">
			</td>
		</tr>
		<tr>
			<td width="10%">文件大小</td>
			<td width="45%">
				<input type="text" name="fileSize" size="40"/>
			</td>
			<td width="45%">
			</td>
		</tr>
		<tr>
			<td width="10%">文件链接</td>
			<td width="45%">
				<input type="text" name="url" size="40"/>
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