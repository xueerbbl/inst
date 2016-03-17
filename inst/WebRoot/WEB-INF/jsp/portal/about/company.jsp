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
							当前位置：<a href="<%= request.getContextPath() %>/index">首页</a>&nbsp;&gt;&nbsp;企业介绍
						</h4>
					</div>
					<div class="s_rig_abo">
						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;大连因斯特科技有限公司成立于美丽的海滨城市大连，
							位于繁华商圈甘井子区华南，以高科技研发为主导，专业致力于水质在线监测领域以及仪器仪表研发、销售。
							公司致力于研制国际领先的环境监测系列产品及监控平台；致力于开发环境污染治理及水体生态修复技术，承接污水处理厂、
							净水厂、自来水厂、工业污水处理等水处理过程在线监测仪表、仪器的供货、安装、维护工作；
							致力于开展环境污染治理设施研发；致力于开拓水利信息化管理业务；致力于研究节能减排技术，
							推广适应生态文明的经济增长模式.
							</span>
						</p>
						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;在环境监测领域，公司能够提供政府主管部门需要的全系列水质在线监测仪表及系统，
							专业生产销售相关检测仪器仪表，流量计、PH计、ORP仪、浊度计、污泥浓度计、泥水界面仪、超声波液位计、
							超声波液位差计、超声波明渠流量计、COD、氨氮、总磷、总氮等一系列高精度产品。
							</span>
						</p>
						<p style="text-indent:2em;">
							<span style="line-height:1.5;">&nbsp;我公司拥有专业的研发团队，高级工程师、建造师等具有丰富的实践与现场经验的技术人才，
							可根据用户的需求量身定做适合现场使用工况仪器。公司始终把完善的售前和售后服务作为立业之本，赢得了业界和客户的信赖与好评。
							同时公司与大连各大院校签订人才输送培养战略协议，
							保证了公司高技术高素质高水准人才储备，产品研发能力雄厚，以便满足客户的各项需求。
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