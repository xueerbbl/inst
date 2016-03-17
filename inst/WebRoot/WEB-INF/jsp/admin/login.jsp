<%@ include file="init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>大连因斯特科技有限公司</title>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="大连因斯特科技有限公司 " />
	<meta name="description" content="大连因斯特科技有限公司 " />
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<style type="text/css">
<!--
body{
	margin: 0 0 0 0; 
	font-size:12px;
	line-height:18px;
	word-break:break-all;
	background-color:#95D1FF;
}
td{font-size:12px;
color:#416178;}

-->
</style>
</head>

<body>
<form action="" method="post" name="fm">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="220" bgcolor="#CDEBFF">&nbsp;</td>
  </tr>
  <tr>
    <td height="338" align="center" background="<%= baseResource %>/images/login_04.gif"><table width="592" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="272" colspan="6" align="center" background="<%= baseResource %>/images/login_05.gif"><table width="30%" border="0" cellspacing="0" cellpadding="0" style="margin-top:189px">
            <tr>
              <td width="16%">用户</td>
              <td width="84%" align="center">
                <input type="text" name="userName" id="userName" width="120">
              </td>
            </tr>
            <tr>
              <td>密码</td>
              <td align="center"><input type="password" name="password" id="password" width="120"></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td><img src="<%= baseResource %>/images/login_07.gif" width="145" height="34" alt=""></td>
          <td><img src="<%= baseResource %>/images/login_08.gif" width="109" height="34" alt=""></td>
          <td><a href="javascript:document.fm.submit()"><img src="<%= baseResource %>/images/login_09.gif" alt="" width="50" height="34" border="0"></a></td>
          <td><a href="javascript:document.fm.reset();"><img src="<%= baseResource %>/images/login_10.gif" alt="" width="45" height="34" border="0"></a></td>
          <td><img src="<%= baseResource %>/images/login_11.gif" width="99" height="34" alt=""></td>
          <td><img src="<%= baseResource %>/images/login_12.gif" width="144" height="34" alt=""></td>
        </tr>
        <tr>
          <td height="32" colspan="6"><img src="<%= baseResource %>/images/login_13.gif" width="592" height="32" alt=""></td>
        </tr>
        </table></td>
  </tr>
  <tr>
    <td bgcolor="#95D1FF">&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>