package cn.simpleray.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.simpleray.inst.model.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object handler)
		throws Exception {

		HttpSession session = request.getSession();

		String requestUrl = request.getRequestURI().replace(
			request.getContextPath(), "");

		if (null != allowUrls && allowUrls.length >= 1) {
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					return true;
				}
			}
		}

		User user = (User) session.getAttribute("user");

		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
		}

		return super.preHandle(request, response, handler);
	}
}
