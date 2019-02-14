package com.yy.pwd;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;  
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor{
	
	private Logger log = Logger.getLogger(CommonInterceptor.class); 
	/*public CommonInterceptor() {  
    }
  
    private String mappingURL; // 利用正则映射到需要拦截的路径  
    
    public void setMappingURL(String mappingURL) {    
        this.mappingURL = mappingURL;    
    }*/
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
    		Object handler) throws Exception {
    	
    	/*log.info("==============执行顺序: 1、preHandle================");
    	String url = request.getRequestURL().toString();
    	
    	System.out.println(url + "  ++++++++++++++++++++++++++++++++++++++++++++++++ ");
    	
    	if(mappingURL==null || url.matches(mappingURL)){   
    		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);  
    		return false;   
    	}
    	return true; */
    	
    	String path=request.getRequestURI().toString();
    	
		/*if(path.indexOf("/toLogin")!=-1 || path.indexOf("/toRegPage")!=-1|| path.indexOf("/login")!=-1)*/
    	if(path.indexOf("/permission_login.htm")!= -1)
		{
			return true;
		}
		else {
			HttpSession session = request.getSession(true);
			String user = (String)session.getAttribute("username");
			
			// 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
			if (user != null)
			{
				return true;
			}
			// response.sendRedirect(WebConstants.LOGIN_URL);
			response.sendRedirect("admin/index.jsp");
			return false;
		}
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
    		Object arg2, ModelAndView arg3) throws Exception {
    	// log.info("==============执行顺序: 2、postHandle================");  
    }
    
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// log.info("==============执行顺序: 3、afterCompletion================");  
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}


