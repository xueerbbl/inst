<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/init.jsp" %>

<%
Pagination<Attachment> pagination = (Pagination)request.getAttribute("pagination");

List<Attachment> attachments = pagination.getEntrys();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../header.jsp" %>

<body>
	<div class="max">
		<jsp:include page="../navigation_bar.jsp" />

		<div class="s_max">
			<jsp:include page="../s_banner.jsp" />
		
			<div class="s_about_box">
				<div class="s_type">
					<div class="s_type_cokk">
						<h3>文件分类</h3>
					</div>
					<div class="product_list">
						<c:forEach items="${categoryGroups}" var="categoryGroup">
						<table class="menu-collapse">
							<tr>
								<td class="title">
									<span onClick="showsubmenu(${categoryGroup.id})" style="padding-left: 25px">&nbsp;</span>
									<span><a href="<%= request.getContextPath() %>/portal/attachments/category/${categoryGroup.id}" >${categoryGroup.name}</a></span>
								</td>
							</tr>
							<tr>
								<td class="menu">
								<table id='submenu${categoryGroup.id}' style="display:none">
									<c:forEach items="${categoryGroup.subCategorys}" var="group">
										<tr>
											<td class="sub-menu" align="center">
												<span><a href="<%= request.getContextPath() %>/portal/attachments/${group.groupId}" >${group.name}</a></span>
											</td>
										</tr>
									</c:forEach>
								</table>
								</td>
							</tr>
						</table>
						</c:forEach>
					</div>
				</div>
				<div class="s_right">
					<div class="s_right_cokk">
						<h4>当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;文件下载</h4>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="s_data">
						<table border="0" cellpadding="0" cellspacing="0">
							<%
							for (Attachment attachment : attachments) {
							%>
								<tr class="datbox">
									<td class="data1">
										<input id="Button1" type="image" src="<%= request.getContextPath() %>/resources/templates/default/images/down1.png" class="data1_btn1" />
	
										<div>
											<h3><%= attachment.getFileName() %></h3>
											<h4><%= simpleDateFormat.format(new Date(attachment.getCreateDate())) %></h4>
										</div>
									</td>
									<td class="data2">
										<c:if test='<%= attachment.getUrl() != null %>'>
											<a href="<%= attachment.getUrl() %>"><img class="data2_btn2" src="<%= request.getContextPath() %>/resources/templates/default/images/down2.png" alt="" /></a>
										</c:if>
										<c:if test='<%= attachment.getUrl() == null %>'>
											<a href="<%= request.getContextPath() %>/portal/download/<%= attachment.getAttachmentId() %>"><img class="data2_btn2" src="<%= request.getContextPath() %>/resources/templates/default/images/down2.png" alt="" /></a>
										</c:if>
									</td>
								</tr>
							<%
							}
							%>
						</table>
					</div>
					<div class="blank20">&nbsp;</div>
					<c:if test='${categoryId == null }'>
							<div class="s_fanye">
								<div class="quotes">
									<a class="" href="<%= request.getContextPath() %>/portal/attachments/${groupId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
									${pagination.pageNum}/${pagination.pageCount}页
									<a href="<%= request.getContextPath() %>/portal/attachments/${groupId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
									<div class="clear"></div>
								</div>
						</div>
					</c:if>

					<c:if test='${categoryId != null }'>
						<div class="s_fanye">
							<div class="quotes">
								<a class="" href="<%= request.getContextPath() %>/portal/attachments/category/${categoryId}?pagination.pageNum=${pagination.pageNum - 1}">上一页</a>
								${pagination.pageNum}/${pagination.pageCount}页
								<a href="<%= request.getContextPath() %>/portal/attachments/category/${categoryId}?pagination.pageNum=${pagination.pageNum + 1}">下一页</a>
								<div class="clear"></div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
					<jsp:include page="../footer.jsp" />
			
		</div>

	</div>
</body>
<script type="text/javascript">
	function showsubmenu(sid) {
		whichEl = eval("submenu" + sid);
		if (whichEl.style.display == "none")
		{
			eval("submenu" + sid + ".style.display=\"\";");
		}
		else
		{
			eval("submenu" + sid + ".style.display=\"none\";");
		}
	}
</script>
</html>
