package com.wy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginIntercepor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		String uri = request.getRequestURI();
		if(uri.indexOf("/index.jsp")>=0 || uri.indexOf("login")>=0) {
		return true;
		}
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username != null)
		{
			return true;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return false;
	}
}
