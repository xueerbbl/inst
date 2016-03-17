<%@ include file="/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../header.jsp" %>

<body>
<script type="text/javascript">
function isEmail(mail){
	var rule_mail= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return(rule_mail.test(mail));
}

function doSubmit(){
    if (document.myform.userName.value.length>5 || document.myform.userName.value.length<1 ){
  		alert("请填写正确的姓名");
        document.myform.userName.focus();

        return false;
    }
    

    if (document.myform.email.value=="" && document.myform.phone.value==""){
 		 alert("请填写正确的邮箱地址或者电话");
 		 document.myform.email.focus();
        	return false;
    }
  
    if (document.myform.email.value!="" && !isEmail(document.myform.email.value)){
		alert("亲,请输入正确的邮箱地址！");
  		 document.myform.email.value="";
  		 document.myform.email.focus();
  		 return false;
     }
    }

</script>
	<div class="max">
		<jsp:include page="../navigation_bar.jsp" />

		<div class="s_max">
			<jsp:include page="../s_banner.jsp" />

			<div class="s_about_box">
				<div class="s_type">
					<div class="s_type_cokk">
						<h3>联系我们</h3>
					</div>
					<div class="type_list">
						<ul>
							<li><a href="<%= request.getContextPath() %>/portal/contact">联系方式</a></li>
							<li><a href="<%= request.getContextPath() %>/portal/message">留言</a></li>
						</ul>
					</div>
				</div>

				<div class="s_right">
					<div class="s_right_cokk">
						<h4>
							当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;联系我们
						</h4>
					</div>

					<div class="blank20">&nbsp;</div>

					<div class="s_rig_mess">
                        <div class="s_rig_mess_cokk">
                            <h4>如果客户你想对我们的产品有更多的了解，请联系在线客服或者给我们留言！</h4>
                        </div>

       					<div class="blank20">&nbsp;</div>

     				   <form action="<%= request.getContextPath() %>/portal/message/add" method="post" name="myform" onsubmit="return doSubmit();" >
                        <table border="0" cellpadding="0" cellspacing="" class="tabm1">
                        <tr>
                        <td class="s_tab1">公司名称:</td>
                        <td class="s_tab2"><input name="companyName" id="companyName" type="text" class="tbox1" /></td>
                        </tr>
                        <tr>
                        <td class="s_tab1">联&nbsp;系&nbsp;人:</td>
                        <td class="s_tab2"><input name="userName" id="userName" type="text" class="tbox1" /><font>*</font></td>
                        </tr>
                        <tr>
                        <td class="s_tab1">联系电话:</td>
                        <td class="s_tab2"><input name="phone"  id="phone" type="text" class="tbox1" /></td>
                        </tr>
                        <tr>
                        <td class="s_tab1">E&nbsp;-&nbsp;mail:</td>
                        <td class="s_tab2"><input name="email" id="email" type="text" class="tbox1" /><font>*</font></td>
                        </tr>
                        <tr>
                        <td class="s_tab1">留&nbsp;&nbsp;&nbsp;&nbsp;言:</td>
                        <td class="s_tab2"><textarea name="detail" class="tbox2"></textarea></td>
                        </tr>
                        <tr>
                        <td class="s_tab1">&nbsp;</td>
                        <td class="s_tab2">
                            <div class="blank20">&nbsp;</div>
                      	    <input type="submit" value="提交" />
			                <input type="reset" value="重置" />
                        </td>
                        </tr>
                        </table>
                        </form>
                    </div>
				</div>
			</div>

			<jsp:include page="../footer.jsp" />
			
		</div>
	</div>
</body>
</html>