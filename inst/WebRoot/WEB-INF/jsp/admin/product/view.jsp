<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
			<td class="form-info-text">产品列表</td>
		</tr>
		</table>
		<table>
		<tr>
			<td> 
			<c:forEach items="${pagination.entrys}" var="product" varStatus="status">
				<div style="float: left; width: 120px; margin: 10px;">
					<table width="120" cellpadding="0" cellspacing="1" bgcolor="#0A5C8E" align=left style="margin-top:20px" >
					<tr>
						<td colspan="2" height="60" align="center" valign="middle" bgcolor="#eef7fe" >
							<a href="<%= baseRoot %>/product/update/${product.productId}" target="_self" >${product.name}</a>
						</td>
					</tr>
					<tr bgcolor="#eef7fe">
						<td align="center" bgcolor="#eef7fe" >
						</td>
					</tr>
					<tr bgcolor="#eef7fe">
						<td align="center" bgcolor="#eef7fe" >
							<a href="<%= baseRoot %>/product/update/${product.productId}" target="_self" >修改</a> |
							<a href="#" onclick="doDelete(${product.productId});" target="_self">删除</a>
						</td>
					</tr>
					</table>
				</div>
			</c:forEach>
			</td>
		</tr>
	</table>

	<c:if test="${pagination.pageCount > 1}">
		<div class="s_fanye">
			<div class="quotes">
				<a href="<%= baseRoot %>/product/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
	
				<span>${pagination.pageNum}/${pagination.pageCount}页</span>
	
				<a href="<%= baseRoot %>/product/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
	
				<div class="clear"></div>
			</div>
		</div>
	</c:if>

	<hr>

	<div class="tool-bar">
		<a href="<%= baseRoot %>/product/${categoryId}/add" target="_self">添加产品</a> | 
		<a href="javascript:history.back();" target="_self" >返回</a>
	</div>
</div>

<script type="text/javascript">
	function doDelete(id) {
		if(confirm("您确定删除吗?此操作将不能恢复!")) {
			window.location.href='<%= baseRoot %>/product/delete/${categoryId}/' + id;
		}
	}
</script>
</body>
</html>
