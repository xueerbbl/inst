<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%=baseResource%>/css/common.css" rel="stylesheet" type="text/css">

	<script src="<%= request.getContextPath() %>/resources/editor/ckeditor/ckeditor.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/resources/editor/ckfinder/ckfinder.js" type="text/javascript"></script>

	<script type="text/javascript">
		function update(id) {
			if (id > 0) {
				document.fm.action="<%= baseRoot %>/product/update/" + id;
			}
		}
	</script>
</head>
<body>
<div class="view-form">
	<table class="form-info">
	<tr>
		<td class="form-info-img"></td>
		<td class="form-info-text">编辑产品</td>
	</tr>
	</table>

	<form action="<%= baseRoot %>/product/${categoryId}/add" class="edit_form" id="fm"  name="fm" method="post" onsubmit="update(${product.productId});" enctype="multipart/form-data">
		<table>
		<tr>
			<td width="20%">商品名称</td>
			<td width="45%">
				<span class="input">
					<input type="text" name="name" id="name" class="text" value="${product.name}" size="70" onchange = "validati('name','name')" />
				</span>
			</td>
			<td width="35%">
				<div id="msg_name"></div>
			</td>
		</tr>
		<tr>
			<td width="20%">首页是否显示</td>
			<td width="45%">
				<select name="status">
					<option value="0" ${product.status eq 0 ? "selected" : ""} >不显示</option>
					<option value="1" ${product.status eq 1 ? "selected" : ""} >显示</option>
				</select>
			</td>
			<td width="35%">
				<div id="msg_name"></div>
			</td>
		</tr>
		<tr>
			<td>缩略图</td>
			<td>
			<c:choose>
				<c:when test="${product.productId eq 0}">
					<span class="input">
						<input size="30" id="micro" name="micro" type="file" value="上传"/>
					</span>
				</c:when>
				<c:otherwise>
					<div id="microDisplay">
						<img  width="215" height="221" src="<%= request.getContextPath() %>/resources/upload/${product.micro}">
					</div>

					<input size="30" id="micro" name="micro" type="file" value="上传"/>
				</c:otherwise>
			</c:choose>
			</td>
			<td>
			</td>
		</tr>
		<tr>
			<td width="20%">商品介绍</td>
			<td width="45%">
				<textarea cols="80" id="detail" name="detail" rows="10">${product.detail}</textarea>
			</td>
			<td width="35%">
			</td>
		</tr>
		<tr>
			<td width="20%">详细介绍</td>
			<td width="45%">
				<textarea cols="80" id="detail1" name="detail1" rows="10">${product.detail1}</textarea>
			</td>
			<td width="35%">
			</td>
		</tr>
		<tr>
			<td width="20%">参数介绍</td>
			<td width="45%">
				<textarea class="ckeditor" cols="80" id="detail2" name="detail2" rows="10">${product.detail2}</textarea>
			</td>
			<td width="35%">
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