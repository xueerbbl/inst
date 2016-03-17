<%@ include file="/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../header.jsp" %>

<%
Pagination<HireInfo> pagination = (Pagination)request.getAttribute("pagination");

List<HireInfo> hireInfos = pagination.getEntrys();
%>
<body>
	<div class="max">
		<jsp:include page="../navigation_bar.jsp" />

		<div class="s_max">
			<jsp:include page="../s_banner.jsp" />

			<div class="s_about_box">
				<div class="s_type">
					<div class="s_type_cokk">
						<h3>招聘信息</h3>
					</div>
					<div class="type_list">
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/recruitment">招聘信息</a></li>
						</ul>
					</div>
				</div>

				<div class="s_right">
					<div class="s_right_cokk">
						<h4>
							当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;招聘信息
						</h4>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="humbox">
						<table border="0" cellpadding="" cellspacing="0">
							<tr>
								<td class="human1">职位</td>
								<td class="human1">招聘人数</td>
								<td class="human2">工作地点</td>
								<td class="human3">状态</td>
							</tr>

							<%
							for (HireInfo hireInfo : hireInfos) {
							%>
								<tr>
									<td class="human4"><a href="<%= request.getContextPath() %>/portal/recruitment/<%= hireInfo.getHireInfoId() %>"><%= hireInfo.getTitle() %></a></td>
									<td class="human5"><%= hireInfo.getNumber() %></td>
									<td class="human5"><%= hireInfo.getLocation() %></td>
									<td class="human6"><%= hireInfo.getStatusLable() %></td>
								</tr>
							<%
							}
							%>
						</table>
					</div>
				</div>
			</div>

			<jsp:include page="../footer.jsp" />
			
		</div>
	</div>
</body>
</html>