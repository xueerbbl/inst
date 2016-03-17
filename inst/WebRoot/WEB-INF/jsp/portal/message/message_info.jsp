<%@ include file="/init.jsp" %>

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
                            <h4>${tip}</h4>
                        </div>
                    </div>
				</div>
			</div>

			<jsp:include page="../footer.jsp" />
			
		</div>
	</div>
</body>
</html>