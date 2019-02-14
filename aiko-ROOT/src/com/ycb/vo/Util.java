package com.ycb.vo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public  class Util {
	/***
	 * 写List
	 * @param request
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public static void WriteArray(HttpServletRequest request,HttpServletResponse response,Object obj) throws IOException{
		JSONArray json = JSONArray.fromObject(obj);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	/**
	 * 写Object
	 * @param request
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public static void WriteObject(HttpServletRequest request,HttpServletResponse response,Object obj) throws IOException{
		JSONObject json = JSONObject.fromObject(obj);
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	/**
	 * 写单参数
	 * @param request
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public static void WriteMath(HttpServletRequest request,HttpServletResponse response,Object obj) throws IOException{
		String json = "{\"success\":\""+obj+"\"}";
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fd = sdf.format(date);
		return fd;
	}
	/**
	 * 时间戳
	 * @return
	 */
	public static String getTime(){
		Date date = new Date();
		return date.getTime()+"";
	}
	/**
	 * yyyyMMddhhmmss
	 * @return
	 * @throws ParseException
	 */
	public static String getDateyyyyMMddhhmmss(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fd = sdf.format(date);
		return fd;
	}
	/**
	 * yyyyMMdd
	 * @return
	 * @throws ParseException
	 */
	public static String getDateyyyyMMdd(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String fd = sdf.format(date);
		return fd;
	}
	/**
	 * 当月第一天
	 * @return
	 */
	public static String getDayofMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		  c.set(Calendar.DATE, 1);
		  String bdate = sdf.format(c.getTime());
		  return bdate;
	}
	
	/**
	 * yyyyMMddhhmmss
	 * @return
	 * @throws ParseException
	 */
	public static String getDateHHmmss(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String fd = sdf.format(date);
		return fd;
	}
	/**
	 * 跳转-请求转发
	 * @param url
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void forward(String url,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher(url).forward(request, response);
		return;
	}
	/**
	 * 重定向跳转
	 * @param url
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void sendRedirect(String url,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.sendRedirect(url);
		return;
	}
	/**
	 * 获取session信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static String getSessionInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Object object = request.getSession().getAttribute("MEMBERID");
			if(object==null){
				return null;
			}else{
				return object.toString();
			}
	}
	/**
	 * 获取session信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static Object getAdminSession(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			Object object = request.getSession().getAttribute("LOGINUSER");
			if(object==null){
				return null;
			}else{
				return object;
			}
	}
	/**
	 * 获取session信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	/**
	 * 获取session信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	/**
	 * 创建银联订单号
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static String Create_Order_ID() throws ServletException, IOException{
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = new Date();
		String OrdId = null;
		OrdId = "00" + sf.format(dt);
		return OrdId;
	}
	
}
