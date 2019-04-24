package com.bh.beauty.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.bh.beauty.common.Constant;


@WebFilter(filterName="myFilter", urlPatterns="/api/*")
public class LoginWebFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		if (req.getRequestURI().indexOf("/api/user/login") > -1) {
			chain.doFilter(request, response);
			return;
		}
		if (StringUtils.isEmpty(req.getSession().getAttribute(Constant.USER_NAME))) {
			res.setStatus(403);
			return;
		}

        chain.doFilter(request, response);
	}


}
