<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%= baseResource %>/css/common.css" rel="stylesheet" type="text/css">
	<script src="<%= baseResource %>/js/validation.js" type="text/javascript"></script>
</head>
<body>
	<div class="edit-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">留言信息</td>
	</tr>
	</table>
	<form action="<%= baseRoot %>/message/update/${message.messageId}" class="edit_form" id="fm"  name="fm" method="post">
		<table>
		<tr>
			<td width="10%">公司名称：</td>
			<td width="45%">
				<span class="input">
					${message.companyName}
				</span>
			</td>
		</tr>
		<tr>
			<td>联系人：</td>
			<td>
				<span class="input">
					${message.userName}
				</span>
			</td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td>
				<span class="input">
					${message.phone}
				</span>
			</td>
		</tr>
		<tr>
			<td>联系邮箱：</td>
			<td>
				<span class="input">
					${message.email}
				</span>
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<select id="status" name="status">
					<option value="0" ${message.status eq 0 ? "selected" : ""} >未读</option>
					<option value="1" ${message.status eq 1 ? "selected" : ""} >已阅</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>留言</td>
			<td>
			<pre>${message.detail}</pre>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="center" >
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