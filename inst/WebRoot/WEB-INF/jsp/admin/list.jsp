<%@ include file="init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>大连因斯特科技有限公司</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />

	<link href="<%= baseResource %>/css/common.css" rel="stylesheet" type="text/css">
</head>

<body class="list-body">
	<div class="list-body">
		<table class="menu">
			<tr>
				<td class="title"></td>
			</tr>
		
			<tr>
				<td class="sub-menu" align="center">
					<div>
						<table>
							<tr>
								<td align="center" height="20px" width="39px">
								</td>
								<td width="119" align="left">我的任务</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(1)">
					<span>用户管理</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu1' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">用户管理</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="user/add" target="welcome">用户添加</a>
								</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="user/view" target="welcome">用户管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		
		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(2)">
					<span>产品展示</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu2' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理产品</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="category/<%= WebKey.CATEGORY_PRODUCT %>" target="welcome">产品展示管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(3)">
					<span>新闻中心</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu3' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理新闻</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="category/<%= WebKey.CATEGORY_ARTICLE %>" target="welcome">新闻中心管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(4)">
					<span>技术支持</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu4' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理技术文章</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="category/<%= WebKey.CATEGORY_SUPPORT %>" target="welcome">技术支持管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(5)">
					<span>资料下载</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu5' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理资料下载</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="category/<%= WebKey.CATEGORY_ATTACHMENT %>" target="welcome">资料管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(6)">
					<span>加入我们</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu6' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理招聘信息</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="<%= baseRoot %>/hireInfo/view" target="welcome">招聘管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<table class="menu-collapse">
			<tr>
				<td class="title" onClick="showsubmenu(7)">
					<span>联系我们</span>
				</td>
			</tr>
			<tr>
				<td class="sub-menu" align="center"  id='submenu7' style="display:none">
					<div>
						<table>
							<tr>
								<td width="39" height=20 align="center">
									<img src="<%= baseResource %>/images/q.jpg" width="17" height="16">
								</td>
								<td width="119" align="left">管理留言</td>
							</tr>
							<tr>
								<td align="center" valign="top">
									<img src="<%= baseResource %>/images/qx.jpg" width="31" height="24">
								</td>
								<td align="left" valign="middle">
									<a href="<%= baseRoot %>/message/view" target="welcome">留言管理</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
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
</body>
</html>