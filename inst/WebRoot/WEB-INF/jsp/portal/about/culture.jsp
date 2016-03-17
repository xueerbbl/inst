<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<h3>走进因斯特</h3>
					</div>
					<div class="type_list">
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/company">企业介绍</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/organization">组织文化</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/culture">企业文化</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/qualification">企业资质</a></li>
						</ul>
					</div>
				</div>
				<div class="s_right">
					<div class="s_right_cokk">
						<h4>
							当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;企业文化
						</h4>
					</div>
					<div class="s_rig_abo">
						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;&nbsp;&nbsp;公司的战略目标是打造一支具备核心竞争力的团队，成为中国智慧环保的领航者。
							</span>
						</p>

						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;“优秀的团队，优异的产品，优质的服务”是公司的生存法宝
							</span>
						</p>

						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;“科技先导，管理至上，守信务实，坚持不懈”是公司的发展精神
							</span>
						</p>

						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;“以诚为本，以信为大，做表先做人”是公司的立足之本
							</span>
						</p>

						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;“以科技服务社会，以诚信回报社会”是公司的发展宗旨
							</span>
						</p>
					</div>
				</div>
			</div>	
		<jsp:include page="../footer.jsp" />
		</div>

	</div>
</body>
</html>
