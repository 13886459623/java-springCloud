<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>AI智能分选</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/img/ak.ico"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/ak.ico">
<link rel="icon" href="${pageContext.request.contextPath}/img/ak.ico"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/admin-all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/jquery.spritely-0.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/chur.min.js"></script>



<!-- <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 0.7, dir: 'right', depth: 10 });
            $('.login').click(function () {
                if ($('#uid').val() == "" || $('#pwd').val() == "" || $('#code').val() == "") { $('.tip').html('用户名或密码不可为空！') }
                else {
                    location.href = 'index.html';
                }
            })
        })
    </script> -->

<script type="text/javascript" language="javascript">
	function submitForm() {
		if ($('#uid').val() == "") {
			$('.tip').html("用户名不能为空！");
			return false;
		}
		if ($('#pwd').val() == "") {
			$('.tip').html("密码不能为空！");
			return false;
		}
		if ($('.code').val() == "") {
			$('.tip').html("验证码不能为空！");
			return false;
		}
		$
		.blockUI({
			message : '<img src="admin/busy.gif"/>&nbsp;&nbsp;正在登录中......'
		});
		document.getElementById("fm").submit();
		//$.unblockUI();
	}
</script>

<script type="text/javascript">
	function change() {
		var img = document.getElementById("ma");
		img.src = img.src + "?";
	}
	
	

	//回车提交事件
	$("html").die().live("keydown",function(event){      
        if(event.keyCode==13){  
           //这里添加要处理的逻辑  
        	submitForm();
        }      
    });
	
</script>

</head>

<body>
	<form action="${pageContext.request.contextPath }/permission_login.htm"
		method="post" id="fm">
		<div id="clouds" class="stage"></div>
		<div class="loginmain"></div>
		<div class="row-fluid">
			<h1>EL智能分选</h1>
			<p>
				<label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="uid"
					name="username" style="height: 30px" placeholder="请输入账号" /></label>
			</p>
			<p>
				<label>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="pwd"
					name="password" style="height: 30px" placeholder="请输入密码" /></label>
			</p>
			<p class="pcode">
				<label>验证码：<input type="text" name="codes" class="code"
					maxlength="5" style="height: 30px" placeholder="验证码" />
					&nbsp;&nbsp;<img src="rand.jsp" id="ma" />&nbsp;&nbsp;<a
					href="javascript:void(0);" onclick="change()">换一张</a>
				</label>
			</p>
			<p class="tip">
				&nbsp;
				<%
					if (request.getAttribute("message") == null
							|| request.getAttribute("message") == "") {
				%>
				<%
					} else {
				%>
				<%=request.getAttribute("message")%>
				<%
					}
				%>
			</p>
			<hr />
			<input type="button" value=" 登 录 " id="loginsub"
				class="btn btn-primary btn-large login" onclick="submitForm()" />
			&nbsp;&nbsp;&nbsp;<input type="reset" value=" 取 消 "
				class="btn btn-large" />
		</div>
	</form>

</body>
</html>




