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
		function update(hireInfoId) {
			if (hireInfoId > 0) {
				document.fm.action=hireInfoId;
			}
		}
	</script>
</head>
<body>
	<div class="edit-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">编辑招聘信息</td>
	</tr>
	</table>
	<form action="add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${hireInfo.hireInfoId});">
		<table>
		<tr>
			<td width="10%"  >职位</td>
			<td width="45%">
				<span class="input">
					<input type="text" name="title" id="title"  class="text" value="${hireInfo.title}" size="30" />
				</span>
			</td>
			<td width="45%">
				<div id="msg_title"></div>
			</td>
		</tr>
		<tr>
			<td>招聘人数</td>
			<td>
				<span class="input">
					<input size="30" id="number" name="number" type="text" class="text" value="${hireInfo.number}" />
				</span>
			</td>
			<td>
				<div id="msg_number"></div>
			</td>
		</tr>
		<tr>
			<td>工作地点</td>
			<td>
				<span class="input">
					<input size="30" id="location" name="location" type="text" class="text" value="${hireInfo.location}" />
				</span>
			</td>
			<td>
				<div id="msg_location"></div>
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<select id="status" name="status">
					<option value="0" ${hireInfo.status eq 0 ? "selected" : ""} >正常</option>
					<option value="1" ${hireInfo.status eq 1 ? "selected" : ""} >过期</option>
				</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>具体描述</td>
			<td>
				<textarea class="ckeditor" cols="80" id="description" name="description" rows="10">${hireInfo.description}</textarea>
			</td>
			<td>
				<div id="msg_hireInfo" />
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