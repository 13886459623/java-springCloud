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

<title>B产线页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/img/ak.ico"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/ak.ico">
<link rel="icon" href="${pageContext.request.contextPath}/img/ak.ico"> 
 <link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.popbox.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.Sonline.js"></script>
<script src="${pageContext.request.contextPath }/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.popbox.js"></script> 

<script type="text/javascript">

$(function() {

	 //加载时,根据屏幕大小适应
	getwindowWinth();
	getdata();
	getExestate();
});

function getwindowWinth(){
	  //初始化高度   
	  $("#showHeight").height(($(window).height()*0.843));
		//是否根据 缩放自动调整高度
		$(window).resize(function(){   
	    $("#showHeight").height(($(window).height()*0.843));
	})  
	  $("#showHeight").width($(window).width());
		//是否根据 缩放自动调整高度
		$(window).resize(function(){   
	    $("#showHeight").width($(window).width());
	})  
}

var logshow="";

	function getdata(){
		var url="${pageContext.request.contextPath}/rest/showImageB";
		 $.ajax({ 
				  type:'post', 
				  url:url,
				  data:{},
				  dataType: "json",
				  beforeSend:function(XMLHttpRequest){ 
				    //ShowLoading(); 
				  }, 
				  success:function(data,textStatus){
					/* var data=JSON.parse(JSON.stringify(data.data)) */
					var Img_base64=data.Img_base64;
					var Img_base64_show=data.Img_base64_show;
					var badnesssummary_dict=data.badnesssummary_dict;
					var Img_src=data.Img_src;
					var Img_src_show=data.Img_src_show;
					var showtime=data.showtime;
					 if(Img_base64!='' && typeof(Img_base64) != 'undefined' && Img_base64!='null'){
						 $('#imgpath').attr("src","data:image/png;base64,"+Img_base64);
						 $('#show_imgpath').text(Img_src);

					 }
					 if(Img_base64_show!='' && typeof(Img_base64_show) != 'undefined' && Img_base64_show!='null'){
						 $('#imgpath_show').attr("src","data:image/png;base64,"+Img_base64_show);
						 $('#show_imgpath_show').text(Img_src_show);
					 }
					 if(badnesssummary_dict!='' && typeof(badnesssummary_dict) != 'undefined' && badnesssummary_dict!='null'){
						 $('#badnesssummary_dict').text(badnesssummary_dict);
						 var div = document.getElementById('showNG'); 
						 if(badnesssummary_dict!="正常片"){
							 div.className = 'NG';
						 }else{
							 div.className = 'div1';
						 }
						 //模拟python输出日志
						  var log="<br/>    预测图片："+Img_src+"  "+"完整用时："+showtime+"   "+"不良类型："+badnesssummary_dict+"    ";
						 if(logshow!=log){
						 $('#log_show').append(log);
						 logshow=log;
						 }
						 
					 }else{
						 
						 $('#log_show').text("暂无数据....");
					 }
				
				  }, 
				  complete:function(XMLHttpRequest,textStatus){ 
				    //HideLoading(); 
				  }, 
				  error:function(){ 
				    //请求出错处理 
					console.log('程序未响应...请确认程序是否异常');
				  } 
			});
		 setTimeout("getdata()",500);
	}
		
	
	
	function getExestate(){
		var url="${pageContext.request.contextPath}/configuration/exeState";
		 $.ajax({ 
				  type:'post', 
				  url:url,
				  data:{AB:"B"},
				  dataType: "json",
				  beforeSend:function(XMLHttpRequest){ 
				    //ShowLoading(); 
				  }, 
				  success:function(data,textStatus){
					if(data.state){
						$('#exeState').text("正在运行...");
					}else{
						$('#exeState').text("未运行,请检查AI是否异常...");
					}
				  }, 
				  complete:function(XMLHttpRequest,textStatus){ 
				    //HideLoading(); 
				  }, 
				  error:function(){ 
				    //请求出错处理 
					console.log('程序未响应...');
				  } 
			});
		 setTimeout("getExestate()",1000);
	}	
	

</script>


</head>

<body style="background-color: #4f4c4c;">
<!-- 导航栏 -->
<div class="in-top">
 <p style="color: white;font-size: 15px;width: 60%;height: 5%">当前位置：前端页面>AB产线>B线页面 </p>
 <p style="color: white;width: 40%;margin-left: 30%;height: 8%;font-size: 25px;">B线算法运行状态:  
 <span style="color: yellow;width: 10%;height: 5%;font-size: 20px;" id="exeState">正在检测</span>
 </p>
</div>
<!-- end导航栏 -->
<!-- 图片 区域 -->
<!-- 主div margin:0 auto;  style="width: 1700px;height: 700px;"-->
<div  id="showHeight" >
<div class="div1" style="width: 97.8%;height: 10%;padding: 0px;">
<p style="color: #ffd966; font-size: 20px;" id="badnesssummary_dict"></p>
</div>
<!-- imgdiv -->
<div class="div1" style="width: 40.8%;height: 86%;float: left; " id="showNG">
<p style="font-size: 14px;width: 40.8%;height: 4%;" id="show_imgpath"></p>
<img id="imgpath"  src="" style="width:100%;height:95%;"/>
</div>
<div class="div1"  style="width: 40.8%;height: 86%;float: left; ">
<p style="font-size: 14px;width: 40.8%;height: 4%;"  id="show_imgpath_show"></p>
<img id="imgpath_show"  src="" style="width:100%;height:95%;"/>
</div>
<!-- 结果日志 -->
<div class="div1"  style="width: 15.6%;height: 86%;float: left; ">
<p style="font-size: 14px;height: 4%;color: yellow;" >日志输出：</p><textarea style="width: 100%;height: 95%;" rows="1" cols="6" id="log_show">
</textarea>
</div>
</div>
<!-- 图片区域 end -->

</body>
</html>