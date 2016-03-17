<%@ include file="init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>大连因斯特科技有限公司</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="大连因斯特科技有限公司 " />
<meta name="description" content="大连因斯特科技有限公司 " />

<link href="<%= baseResource %>/css/yh.css" rel="stylesheet" type="text/css">
<link href="<%= baseResource %>/css/common.css" rel="stylesheet" type="text/css">
</head>

<frameset rows="83,*" cols="*" frameborder="no" framespacing="0">
	<frame src="<%= baseRoot %>/header" marginwidth="0" marginheight="0" noresize="noresize" name="header" scrolling="no" id="header" title="header">
	<frameset cols="170,*" name="topwin" framespacing="0" frameborder="0">
		<frameset rows="*,23" frameborder="no" framespacing="0">
			<frame src="<%= baseRoot %>/list" marginwidth="0" marginheight="0" noresize="noresize" name="list" id="list" title="list" scrolling="no" />
			<frame src="<%= baseRoot %>/listBtn" marginwidth="0" marginheight="0" noresize="noresize" name="bottomFrame" title="bottomFrame" scrolling="no" />
		</frameset>
		<frameset cols="9,*" frameborder="no" framespacing="0" >
			<frame src="<%= baseRoot %>/middle" marginwidth="0" marginheight="0" noresize="noresize" name="middle" id="middle" title="middle" scrolling="no">
			<frame src="<%= baseRoot %>/main" marginwidth="0" marginheight="0" noresize="noresize" name="welcome" id="main" title="welcome" scrolling="auto" />
		</frameset>
	</frameset>
</frameset>
</html>
