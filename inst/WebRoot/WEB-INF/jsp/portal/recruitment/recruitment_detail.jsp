<%@ include file="/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../header.jsp" %>

<%
HireInfo hireInfo = (HireInfo)request.getAttribute("hireInfo");
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

					<div class="s_hum">
						<div class="s_hum_text">
							<h3><%= hireInfo.getTitle() %></h3>
							<div id="jobcontent">
								<div class="jobitem">
									职位名称：<%= hireInfo.getTitle() %><br />
									招聘状态：<%= hireInfo.getStatusLable() %><br />
									招聘人数：<%= hireInfo.getNumber() %> <br />
									发布时间：<%= simpleDateFormat.format(new Date(hireInfo.getCreateDate())) %><br />
								</div>
								<div class="jobtit">
									&nbsp;
								</div>
								<div class="jobtit">
									<strong>职位描述</strong>
								</div>
								<div class="jobintro">
									<pre><%= hireInfo.getDescription() %></pre>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<jsp:include page="../footer.jsp" />
			
		</div>
	</div>
</body>
</html>