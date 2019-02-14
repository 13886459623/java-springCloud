package com.yy.pwd;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;


public class Guolv implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@RequestMapping("permission_login.htm")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String redirectPath = httpRequest.getContextPath()+"/index.jsp";
		
		String contextPath = httpRequest.getContextPath();
		httpRequest.setAttribute("ctx", contextPath);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("textml;charset=UTF-8");
		
		String user = (String)httpRequest.getSession().getAttribute("username");
		
		String url = httpRequest.getRequestURI();  // 获取登录的url 
		
		if (url != null && url.contains("/ycb/permission_login.htm")) {
			chain.doFilter(request, response);
		}
		else if(url != null && !url.contains("/ycb/permission_login.htm")){
			if(user != null){
				// permissionService.userLog(1,user, "192.168.0.0.1", "2014-1-1");  // userid,username,ip,operdate
				chain.doFilter(request, response);
			}
			else{
				((HttpServletResponse) response).sendRedirect(redirectPath);				
			}	
		}
		else {
			 ((HttpServletResponse) response).sendRedirect(redirectPath);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
}
