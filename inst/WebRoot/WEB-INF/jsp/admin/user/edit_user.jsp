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
	<script type="text/javascript">
		function update(userId) {
			if (getValidati("hidValidation") == false) {
				return false;
			}

			if (userId > 0) {
				document.fm.action=userId;
			}
		}
	</script>
</head>
<body>
	<div class="edit-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">员工列表</td>
	</tr>
	</table>
	<form action="add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${user.userId});">
		<input name="hidValidation" id="hid_email" type="hidden" value="${user.userId eq 0 ? "1" : "0"}" />
		<input name="hidValidation" id="hid_password" type="hidden" value="${user.userId eq 0 ? "1" : "0"}" />
		<input name="hidValidation" id="hid_userName" type="hidden" value="${user.userId eq 0 ? "1" : "0"}" />
		<input name="hidValidation" id="hid_phone" type="hidden" value="${user.userId eq 0 ? "1" : "0"}" />

		<table>
		<tr>
			<td width="10%"  >邮箱</td>
			<td width="45%">
				<span class="input">
					<input type="text" name="email" id="email"  class="text" value="${user.email}" size="30" onchange = "validati('email','email')" />
				</span>
			</td>
			<td width="45%">
				<div id="msg_email"></div>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<span class="input">
					<input size="30" id="password" name="password" type="text" class="text" value="${user.password}" onchange = "validati('pass','password')" />
				</span>
			</td>
			<td>
				<div id="msg_password"></div>
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<span class="input">
					<input size="30" id="userName" name="userName" type="text" class="text" value="${user.userName}" onchange = "validati('name','userName')" />
				</span>
			</td>
			<td>
				<div id="msg_userName"></div>
			</td>
		</tr>
		<tr>
			<td>职务</td>
			<td>
				<select id="type" name="type">
					<option value="1" ${user.type eq 1 ? "selected" : ""} >超级管理员</option>
					<option value="2" ${user.type eq 2 ? "selected" : ""} >文章管理员</option>
				</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<span class="input">
					<input size="30" id="phone" name="phone" type="text" class="text" value="${user.phone}" onchange = "validati('tel','phone')"  />
				</span>
			</td>
			<td>
				<div id="msg_phone" />
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