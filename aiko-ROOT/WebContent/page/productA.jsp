<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
 response.addHeader("Pragma", "no-cache");
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 response.addHeader("Cache-Control", "pre-check=0, post-check=0");
 response.setDateHeader("Expires", 0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style>
/* css 代码 */
.div1{ width:100%; height:97.5%; margin-top:5px} 
.div1{ border:3px solid #7a7675} 
.NG { 
border:3px solid red 
}
.NG { 
width:100%; height:97.5%; margin-top:5px 
}
.Jleft{
margin-left: 8px;
}
</style> 
<head>
<%-- <base href="<%=basePath%>"> --%>

<title>产品切换A线</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
 <link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/img/ak.ico"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/ak.ico">
<link rel="icon" href="${pageContext.request.contextPath}/img/ak.ico"> 
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.Sonline.js"></script>
 <!-- 分页插件 --> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/aiko/css/GridManager.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/aiko/js/GridManager.js"></script>
<!-- 日期插件 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/aiko/css/datepicker.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/aiko/js/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/aiko/js/datepicker.all.js"></script>

<!-- 弹层 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.popbox.css" />
<script src="${pageContext.request.contextPath }/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.popbox.js"></script> 
<script src="${pageContext.request.contextPath }/js/common.js"></script> 
    <style>
	html, body{
			width: 100%;
			height: 100%;
			overflow-x:hidden;
			margin: 0;
			padding: 0;
		}
        .plugin-action{
            display: inline-block;
            color: steelblue;
            margin-right: 10px;
            cursor: pointer;
        }
        .plugin-action:hover{
            text-decoration:underline;
        }
		.search-area{
			padding: 10px 20px;
			border: 1px solid #ccc;
			background: #efefef;
		}
		.search-area .sa-ele{
			display: inline-block;
			margin-right: 20px;
			font-size: 12px;
		}
		.search-area .sa-ele .se-title{
			display: inline-block;
			margin-right: 10px;
		}
		.search-area .sa-ele .se-con{
			display: inline-block;
			width:180px;
			height: 180px;
			border: 1px solid #ccc;
			padding: 0px 4px;
			line-height: 24px;
		}
		.search-area .sa-ele .search-action, .search-area .sa-ele .reset-action{
			display: inline-block;
			width:80px;
			height: 26px;
			border: 1px solid #ccc;
			background: #e8e8e8;
			padding: 0px 4px;
			line-height: 26px;
			text-align: center;
			cursor: pointer;
			margin-right: 10px;
		}
		.search-area .sa-ele .search-action:hover, .search-area .sa-ele .reset-action:hover{
			opacity: 0.7;
		}
    </style>
<script type="text/javascript">

$(function() {
	getProduct();
});

function getProduct() {
	var url="${pageContext.request.contextPath }/configA/getConfigAproduct";
	$.ajax({
		type:'post',
		url:url,
		data:"",
		dataType: "json",
		beforeSend:function(XMLHttpRequest){
			//ShowLoading();
		},
		success:function(data,textStatus){
			if(data.data != null && data.data.length >0){
				if(data.data[0].parameters.indexOf("4bb") > -1){
					$('#showProduct').html("4bb");
				}else{
					$('#showProduct').html("5bb");
				}
			}
		},
		complete:function(XMLHttpRequest,textStatus){
			//HideLoading();
		},
		error:function(){
			//请求出错处理
			alert('操作异常，请联系管理员');
		}
	});
}

function submitData() {
    var url="${pageContext.request.contextPath }/configA/updateAProductSwitch";
    var product = $('#productAB').val();
    $.ajax({
        type:'post',
        url:url,
        data:{"parameters" : product},
        dataType: "json",
        beforeSend:function(XMLHttpRequest){
            //ShowLoading();
        },
        success:function(data,textStatus){
            if(data.message == 'success'){
            	alert("操作成功");
			}else{
				alert(data.message);
			}
			window.location.reload();
		},
        complete:function(XMLHttpRequest,textStatus){
            //HideLoading();
        },
        error:function(){
            //请求出错处理
            alert('操作异常，请联系管理员');
        }
    });
}


</script>


</head>

<body >
<p style="font-size: 15px;">当前位置：参数配置>产品切换>A线产品切换 </p>
<!-- 导航栏 -->

	<div class="search-area">
	
		<div class="sa-ele">
			当前应用产品：<p style="font-size: 18px;"><span id="showProduct"></span></p>
		</div>
		</br>
		<div class="sa-ele">
		  可切换产品:
     		<select  id="productAB">
            	<option selected="selected" value="config_4bb_a">4BB</option>
            	<option value="config_5bb_a">5BB</option>
            </select>
		</div>
		<div class="sa-ele">
			<button class="search-action" id="search" onclick="submitData()">切换</button>
		</div>
	</div>

</body>
</html>




