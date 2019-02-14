<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<title>EL图片展示</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/img/ak.ico"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/ak.ico">
<link rel="icon" href="${pageContext.request.contextPath}/img/ak.ico"> 
<!--  <link rel="stylesheet" type="text/css" href="styles.css"> -->
 <link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.popbox.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.Sonline.js"></script>
<script src="${pageContext.request.contextPath }/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.popbox.js"></script> 

<%-- <script src="${pageContext.request.contextPath }/js/common.js"></script> --%>

<script type="text/javascript">

$(function() {
	getwindowWinth();
	onchangeAB();
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
var urlAB;
var logshow="";
/*
 * 切换 AB产线
 */
function onchangeAB() {
	logshow="";
	clearData();//清除现有图片
	 var AB = document.getElementById("selectedAB").value;
	 urlAB=AB;
	 getdata(urlAB);
	}
	function getdata(AB){
		var url="${pageContext.request.contextPath}/rest/showImage"+urlAB;
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
					 $('#error_dict').text("");
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
						 
						 $('#error_dict').text("暂无更新数据...");
						 $('#log_show').text("程序未运行/或暂无数据...");
						 
					 }
					 
				
				  }, 
				  complete:function(XMLHttpRequest,textStatus){ 
				    //HideLoading(); 
				  }, 
				  error:function(){ 
				    //请求出错处理 
					//alert('请求没有响应，请F5刷新重试！');
				  } 
			});
		 setTimeout("getdata()",400);
	}
	
	function clearData(){
		 $('#imgpath').attr("src","");
		 $('#show_imgpath').text("");
		 $('#imgpath_show').attr("src","");
		 $('#show_imgpath_show').text("");
		 $('#badnesssummary_dict').text("");
		 $('#log_show').text("");
		 var div = document.getElementById('showNG'); 
		 div.className = 'div1';
	}
	
	/**
		提交
	*/
	function submitForm() {
/* 		if ($('#uid').val() == "") {
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
		} */
 			//document.getElementById("fm").submit();
		var url="${pageContext.request.contextPath }/configuration/UpdateConfiguration";
		 $.ajax({ 
				  type:'post', 
				  url:url,
				  data:$(".pb_body").find('#fm').serialize(),
				  dataType: "json",
				  beforeSend:function(XMLHttpRequest){ 
				    //ShowLoading(); 
				  }, 
				  success:function(data,textStatus){
					if(data.sucees=="success"){
						alert("修改成功！")
					}else{
						
						alert("修改失败！")
					}
				  }, 
				  complete:function(XMLHttpRequest,textStatus){ 
				    //HideLoading(); 
				  }, 
				  error:function(){ 
				    //请求出错处理 
					alert('修改出错，请联系管理员');
				  } 
			});
	}	
	
	
	/**
	*	弹出层
	*/

function showMsgbox(){ 
	var AB = document.getElementById("selectedAB").value;
	$("#ABconfig").val(AB);
	$.popbox({
		width : '1600px', 
		maxHeight : '1800px',  //body区域的最大高度
		title : AB+'线配置参数',  //标题
		// content : tableObject,  //主体内容，支持HTML标签 
		contentSelector : '#msgBox',
		//contentUrl : '${pageContext.request.contextPath }/configuration.jsp',
		foot : '',  //底部内容
		showMask : true,  //是否显示遮罩层
		showCloseBtn : true,  //是否显示关闭按钮
		btns : [
			{
				type : 'ok',
				text : '确定修改',
				click : function(){
					//这里访问后台修改 配置
					submitForm();
				}
			},
			{
				type : 'cancel',
				text : '取消',
				click : ''
			}

		], //默认显示的按钮
		draggable : true,  //是否可拖动
		autoClose : 0, //是否自动关闭，否则设为0，是则设为大于0的数字，表示关闭时间，单位ms
		blurClose : false,  //点击窗口外部是否关闭窗口   $(".pb_body").find("#imagePath").val();  父窗口属性
		onOpen : function(){
			readConfig();
		}, //窗口加载完毕时的动作
		onClose : function(){
			//document.location.reload(); 为url时 需要重新加载当前 js css
		},  //窗口关闭前的动作，返回false可组织窗口关闭
		onOk : function(){
		
		},  //点击确定按钮
		onCancel : ''  //点击cancel按钮
	});
	
	
}	
	
/**
*读取文件配置到 页面
*/
function readConfig(){
	var url="${pageContext.request.contextPath }/configuration/readConfig";
	 $.ajax({ 
			  type:'post', 
			  url:url,
			  data:$(".pb_body").find('#fm').serialize(),
			  dataType: "json",
			  beforeSend:function(XMLHttpRequest){ 
			    //ShowLoading(); 
			  }, 
			  success:function(data,textStatus){
				//读取config赋值给弹层
					setInput(data);
			  }, 
			  complete:function(XMLHttpRequest,textStatus){ 
			    //HideLoading(); 
			  }, 
			  error:function(){ 
			    //请求出错处理 
				alert('读取配置文件出错！');
			  } 
		});
}

/*
 * 给文本框赋值
 */
function setInput(data){
	var t=0;
	var td;
	var showtd="";
	var showtr="";
	for (var i = 0; i < data.length; i++) {
		for (var key in data[i]) {
		td='<td class="label"><label class="Jleft" >'+key+':</label></td> <td class="field"><input id='+key+' name='+key+' type="text" value="'+data[i][key]+'" size="30" maxlength="200" /></td>';
		}
		if(t==4){
 			showtd='<tr>'+showtd+'</tr>';
 			$(".pb_body").find("#tableShow").append(showtd);
 			t=-1;
 			showtd="";
		}else{
		showtd=showtd+td;
		}
		t++;
	}
	showtd='<tr>'+showtd+'</tr>';
	$(".pb_body").find("#tableShow").append(showtd);
	
}	 
	
</script>


</head>

<body style="background-color: #4f4c4c;">
<!-- 图片 区域 -->

<!-- 导航栏 -->
<div class="in-top">
    <div class="center-width">
        <div class="div-inherit">
            <ul class="in-top-login">
            	<li class="entr-selected">AB线切换:
            	<select onchange="onchangeAB()" id="selectedAB">
            	<option selected="selected" value="A">A 线</option>
            	<option value="B">B 线</option>
            	</select>
				</li>
				<li><a onclick="showMsgbox()">配置页面</a></li>
                <li><a href="${pageContext.request.contextPath }/page/showList.jsp" title="根据选择的配置线，进行配置">分析数据</a></li>
            </ul>
        </div>
 </div>
</div>
<!-- end导航栏 -->

<!-- 主div margin:0 auto; -->
<div   id="showHeight">

<div class="div1" style="width: 97.8%;height: 10%;">
<p style="color: #ffd966;width: 97.8%; font-size: 20px;" id="badnesssummary_dict"></p>
<br>
<br>
<br>
<br>
<p style="color: #ffd966;width: 97.8%; font-size: 10px;" id="error_dict"></p>
</div>
<!-- imgdiv -->
<div class="div1" style="width: 40.8%;height: 86%;float: left; " id="showNG">
<p style="font-size: 14px;height: 4%;" id="show_imgpath"></p>
<img id="imgpath"  src="" style="width:100%;height:95%;"/>
</div>
<div class="div1"  style="width: 40.8%;height: 86%;float: left; ">
<p style="font-size: 14px;height: 4%;" id="show_imgpath_show"></p>
<img id="imgpath_show"  src="" style="width:100%;height:95%;"/>
</div>
<!-- 结果日志 -->
<div class="div1"  style="width: 15.6%;height: 86%;float: left; ">
<p style="font-size: 14px;height: 4%;color: yellow;" >日志输出：</p><textarea style="width: 100%;height: 95%;" rows="1" cols="6" id="log_show">
</textarea>
</div>
</div>
<!-- 图片区域 end -->


<!-- 隐藏 域弹层   -->
 <div id="msgBox" style="display: none;">
      		<form id="fm"  method="post" action="" enctype="multipart/form-data">
	  		  <table id="tableShow">
	  		<!--   <tr> 
	  		  	<td class="label"><label class="Jleft" >my_el:</label></td>
	  		  	<td class="field"><input id="my_el" name="my_el" type="text" value="" size="30" maxlength="200" /></td>
	  		  	<td class="label"><label class="Jleft" >processed_el_dir:</label></td>
	  		  	<td class="field"><input id="processed_el_dir" name="processed_el_dir" type="text" size="30" value="" maxlength="200" /></td>
	  		  	<td class="label"><label class="Jleft">uifilePath:</label></td>
	  		  	<td class="field"><input id="uifilePath" name="uifilePath" size="30" type="text" value="" maxlength="200" /></td>
	  		  	
	  		  </tr> -->
	  		  </table>
	  		   <input id="ABconfig" name="ABconfig" type="hidden" value="" />
          </form>
          
          	
      </div>
<!-- 隐藏 end -->

</body>
</html>




