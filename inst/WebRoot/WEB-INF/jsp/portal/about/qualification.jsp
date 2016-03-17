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
							当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;企业资质
						</h4>
					</div>
					<div class="s_right_streng">
						<div class="blank10">&nbsp;</div>
						<ul class="prodStr">
							<li class="imgStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_1">
									<img  title="" src="<%= request.getContextPath() %>/resources/templates/default/images/about/kaihuxukezheng.jpg" width="224" height="172" />
								</a>
							 </li>
							<li class="txtStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_1">开户许可</a>
							</li>
						</ul>

						<ul class="prodStr">
							<li class="imgStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_2"><img  title="" src="<%= request.getContextPath() %>/resources/templates/default/images/about/yingyezhizhao.jpg" width="224" height="172" /></a>
							 </li>
							<li class="txtStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_2">营业执照</a>
							</li>
						</ul>

						<ul class="prodStr">
							<li class="imgStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_3">
									<img  title="" src="<%= request.getContextPath() %>/resources/templates/default/images/about/zuzidaimazheng.jpg" width="224" height="172" />
								</a>
							 </li>
							<li class="txtStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_3">组织机构代码证</a>
							</li>
						</ul>
						
						<ul class="prodStr">
							<li class="imgStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_4">
									<img  title="" src="<%= request.getContextPath() %>/resources/templates/default/images/about/suiwudengji.jpg" width="224" height="172" />
								</a>
							 </li>
							<li class="txtStr">
								<a href="<%= request.getContextPath() %>/portal/qualification_4">税务登记证</a>
							</li>
						</ul>	
					</div>
				</div>
			</div>	
				<jsp:include page="../footer.jsp" />
		
		</div>

	</div>
</body>
</html>