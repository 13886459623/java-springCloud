<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>未能找到指定的页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body{
	text-align:center;
	margin-top:200px;
}
</style>	

  </head>
  
  <body>
  		
    	<h3>您操作错误,未能找到指定的页面,请重新尝试
    	<a href="<%=basePath%>/system/main.html">点此返回首页</a></h3>
	
  </body>
</html>
