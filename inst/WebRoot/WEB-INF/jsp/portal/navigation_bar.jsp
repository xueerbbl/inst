<%@page import="cn.simpleray.base.util.WebKey"%>
<%@ include file="/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="head">
	<div class="m_header">
		<div class="m_logo">
			<h1>
				<a href="<%= request.getContextPath() %>/index">
					<img src="<%= request.getContextPath() %>/resources/templates/default/images/logo_large.png" alt="大连因斯特科技有限公司" title="大连因斯特科技有限公司" />
				</a>
			</h1>
		</div>

		<div class="m_tel">
			0411-<span style="color:#181818;">39573150</span>
		</div>

		<div style="clear:right; float: right; margin-top: 10px; margin-right: 35px; width: 200px;">
			<form action="<%= request.getContextPath() %>/portal/search">
				<input style="color: gray;  height: 16;"  name="search" type="text" value="请输入产品名称" onfocus="this.value='';" size="15" /> <input type="submit" value="搜索" />
			</form>
		</div>
	</div>
	<div class="m_menu">
		<div class="navbg">
			<div class="col960">
				<ul id="navul" class="cl">
					<li><a href="<%= request.getContextPath() %>/index">网站首页</a></li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/company">走进因斯特</a>
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/company">企业介绍</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/organization">组织文化</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/culture">企业文化</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/qualification">企业资质</a></li>
						</ul>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/product">产品展示</a>
						<ul>
							<c:forEach items="${productCategorys}" var="productCategory">
								<li><a href="<%= request.getContextPath() %>/portal/product/${productCategory.categoryId}" >${productCategory.name}</a></li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/article">新闻中心</a>
						<ul>
							<c:forEach items="${articleCategorys}" var="articleCategory">
								<li><a href="<%= request.getContextPath() %>/portal/articles/${articleCategory.categoryId}">${articleCategory.name}</a></li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/support">技术支持</a>
						<ul>
							<c:forEach items="${supportCategorys}" var="supportCategory">
								<li><a href="<%= request.getContextPath() %>/portal/supports/${supportCategory.categoryId}">${supportCategory.name}</a></li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/attachment">资料下载</a>
						<ul>
							<c:forEach items="${attachmentCategorys}" var="attachmentCategory">
								<li><a href="<%= request.getContextPath() %>/portal/attachments/category/${attachmentCategory.categoryId}" >${attachmentCategory.name}</a></li>
							</c:forEach>
						</ul>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/portal/recruitment">加入我们</a>
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/recruitment">招聘信息</a></li>
						</ul>
					</li>
					<li style="border-right :0px;">
						<a href="<%= request.getContextPath() %>/portal/contact">联系我们</a>
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/contact">联系方式</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/message">留言</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>