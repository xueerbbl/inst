package cn.simpleray.base.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.simpleray.base.util.Constants;
import cn.simpleray.base.util.ParamUtil;

public class PageFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain chain)
		throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest)request;

		SystemContext.setPageNum(getPageNum(httpRequest));
		SystemContext.setPageSize(getPageSize(httpRequest));

		try {
			chain.doFilter(request, response);
		}
		finally{
			SystemContext.removePageNum();
			SystemContext.removePageSize();
		}		
	}
	private Integer getPageSize(HttpServletRequest request) {
		return ParamUtil.getInteger(
			request, "pagination.pageSize", Constants.DEFAULT_PAGE_SIZE);
	}

	private int getPageNum(HttpServletRequest request) {
		int pageNum =  ParamUtil.getInteger(request, "pagination.pageNum", 1);

		if (pageNum <= 0) {
			pageNum = 1;
		}

		 return pageNum;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
