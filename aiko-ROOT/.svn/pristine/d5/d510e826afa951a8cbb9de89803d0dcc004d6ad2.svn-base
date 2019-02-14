package com.ycb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UrlFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httrequest=(HttpServletRequest) arg0;
		String url=httrequest.getRequestURI();
		String origin=httrequest.getHeader("Origin");
		String referer=httrequest.getHeader("Referer");
		
		System.out.println("referer"+referer);
		System.out.println("origin"+origin);
		System.out.println("url"+url);
		if(referer.length()>0){
			httrequest.getRequestDispatcher("").forward(arg0, arg1);
		}else{
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
