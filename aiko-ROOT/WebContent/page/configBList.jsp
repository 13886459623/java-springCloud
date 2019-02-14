<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>B线参数配置</title>
<link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath}/img/ak.ico"/>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/ak.ico">
<link rel="icon" href="${pageContext.request.contextPath}/img/ak.ico"> 
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
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
<link href="${pageContext.request.contextPath }/js/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<%--<script src="${pageContext.request.contextPath }/css/jquery.min.js"></script>--%>
<script src="${pageContext.request.contextPath }/js/jquery.popbox.js"></script> 
<script src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
			height: 24px;
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
		input{
			border: 1px solid #ccc;
			padding: 7px 0px;
			border-radius: 3px;
			padding-left:5px;
			-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
			box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
			-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
			-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
			transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
		}
		input:focus{
			border-color: #66afe9;
			outline: 0;
			-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
			box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
		}
    </style>
</head>

<script type="text/javascript">



$(function() {
	//表格插件
	TableInti();
	
	//绑定搜索事件
	/*$('#search').click(function() {
		var _query = {
				elid:$('#elid').val(),
				el_badtype:$('#el_badtype').val()
			};
		var table =document.getElementById("showTable");
			table.GM('setQuery', _query, function () {
				//console.log('搜索成功...');
			});
	});*/
});
//清楚表格记忆
//$('table').GM('clear');

//初始化表格
function TableInti(){
	//var table = document.querySelector('table');
	var table =document.getElementById("showTable");
	var TGM = table.GM({
		supportRemind: true
		,gridManagerName: 'test'
		,isCombSorting: true
		,height: '600px'
		,supportAjaxPage:true
		,supportSorting: true
		,ajax_url: '${pageContext.request.contextPath }/configB/configBList'
		,ajax_type: 'POST'
		,query: {}   //参数
		,pageSize:20
/* 		// ajax请求返回的列表数据key键值,默认为data
		,dataKey: 'data'
		// ajax请求返回的数据总条数key键值,默认为totals
		,totalsKey: 'totals' */
		,columnData: [{
				key: 'remark',
				remind: '',
				align: 'center',// 三种值: 'left', 'center', 'right'
				isShow: true, //是否显示
				width: '30px',
				text: '描述',
				template: function(nodeData, rowData){
					if(rowData.remark == null){
				        return '';
					}else{
						return '<span>' + rowData.remark + '</span>'
					}
			    }
			},{
				key: 'variables',
				remind: '',
				align: 'center',// 三种值: 'left', 'center', 'right'
				isShow: true, //是否显示
				width: '30px',
				text: '参数名',
				template: function(nodeData, rowData){
					if(rowData.variables == null){
				        return '';
					}else{
						return '<span>' + rowData.variables + '</span>'
					}
			    }
			},{
				key: 'parameters',
				remind: '',
				align: 'center',// 三种值: 'left', 'center', 'right'
				isShow: true, //是否显示
				width: '30px',
				text: '参数值',
				template: function(nodeData, rowData){
					if(rowData.variables == null){
				        return '';
					}else{
						return '<span>' + rowData.parameters + '</span>'
					}
			    }
			},{
				key: '',
				remind: '',
				width: '10px',
				align: 'center',// 三种值: 'left', 'center', 'right'
				text: '操作',
				template: function(elId, rowObject){
					return '<span class="plugin-action edit-action" onclick="showMsgbox(this)"  learnLink-id="'+rowObject.id+'">编辑</span>';
				}
			}
		]
		// 分页前事件
		,pagingBefore: function(query){
			console.log('pagingBefore', query);
		}
		// 分页后事件
		,pagingAfter: function(data){
			console.log('pagingAfter', data);
		}
		// 排序前事件
		,sortingBefore: function (data) {
			console.log('sortBefore', data);
		}
		// 排序后事件
		,sortingAfter: function (data) {
			console.log('sortAfter', data);
		}
		// 宽度调整前事件
		,adjustBefore: function (event) {
			console.log('adjustBefore', event);
		}
		// 宽度调整后事件
		,adjustAfter: function (event) {
			console.log('adjustAfter', event);
		}
		// 拖拽前事件
		,dragBefore: function (event) {
			console.log('dragBefore', event);
		}
		// 拖拽后事件
		,dragAfter: function (event) {
			console.log('dragAfter', event);
		}
	}, function(query){
		// 渲染完成后的回调函数
		//console.log(query);
	});
}

/**
*	弹出层
*/
function showMsgbox(node){ 
	$.popbox({
		width : '800px', 
		maxHeight : '800px',  //body区域的最大高度
		title :'参数编辑',  //标题
		// content : tableObject,  //主体内容，支持HTML标签 
	 	contentSelector : '#msgBox',
		<%--contentUrl : '${pageContext.request.contextPath }/page/show.jsp',--%>
		foot : '',  //底部内容
		showMask : true,  //是否显示遮罩层
		showCloseBtn : true,  //是否显示关闭按钮
		btns : [
			{
				type : 'ok',
				text : '确定修改',
				click : function(){
					//这里访问后台修改配置
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
			readConfig(node);
		}, //窗口加载完毕时的动作
		onClose : function(){
			//document.location.reload(); 为url时 需要重新加载当前 js css
		},  //窗口关闭前的动作，返回false可组织窗口关闭
		onOk : function(){
		
		},  //点击确定按钮
		onCancel : ''  //点击cancel按钮
	});
	
	
}

function showRestartBox() {
	$.popbox({
		width : '300px',
		maxHeight : '200px',  //body区域的最大高度
		title :'确认',  //标题
		// content : tableObject,  //主体内容，支持HTML标签
		contentSelector : '#restartBox',
		foot : '',  //底部内容
		showMask : true,  //是否显示遮罩层
		showCloseBtn : true,  //是否显示关闭按钮
		btns : [
			{
				type : 'ok',
				text : '确定',
				click : function(){
					restart();
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
*加载要修改的内容
*/
function readConfig(node){
	// 获取到当前的tr node
	var tr = node.parentNode.parentNode;
	var rowData = document.getElementById("showTable").GM('getRowData', tr);
	$(".pb_body").find("#id").val(rowData.id);
	$(".pb_body").find("#remark").val(rowData.remark);
	$(".pb_body").find("#variables").val(rowData.variables);
	$(".pb_body").find("#parameters").val(rowData.parameters);
}
	
/**
提交
*/
function submitForm() {
	var url="${pageContext.request.contextPath }/configB/updateCondigB";
 	$.ajax({
		  type:'post',
		  url:url,
		  data:$(".pb_body").find('#fm').serialize(),
		  dataType: "json",
		  beforeSend:function(XMLHttpRequest){
		    //ShowLoading();
		  },
		  success:function(data,textStatus){
			if(data.success=="success"){
				alert("修改成功！重启后生效")
				window.location.reload();
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

function restart() {
	var url="${pageContext.request.contextPath }/configB/restartB";
	$.ajax({
		type:'post',
		url:url,
		data:'',
		dataType: "json",
		beforeSend:function(XMLHttpRequest){
			//ShowLoading();
		},
		success:function(data,textStatus){
			var table =document.getElementById("showTable");
			if(data.message=="success"){
				alert("重启成功");
			}else{
				alert(data.message);
			}
		},
		complete:function(XMLHttpRequest,textStatus){
			//HideLoading();
		},
		error:function(){
			//请求重启处理
			alert('重启出错，请联系管理员');
		}
	});
}
	
</script>

<body>
	<%--<div class="search-area">
		<!-- 日期 start-->
		<div class="sa-ele">

			<label class="se-title">开始时间:</label>
			<div class="c-datepicker-date-editor c-datepicker-single-editor J-datepickerTime-single mt10">
			  <i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
			  <input type="text" autocomplete="off" name="" placeholder="选择日期" class=" c-datepicker-data-input" value="">
			</div>
		</div>

       <!-- 日期end --> 
	
		<div class="sa-ele">
			<label class="se-title">ID:</label>
			<input class="se-con" type="text"  value="" id="elid"/>
		</div>
		<div class="sa-ele">
			<label class="se-title">不良类型:</label>
			<input class="se-con" name="info" id="el_badtype" type="text"  value=""/>
		</div>
		<div class="sa-ele">
			<button class="search-action" id="search">搜索</button>
			<button class="reset-action">重置</button>
			<button class="search-action" id="delete">删除选中</button>
		</div>
	</div>--%>
	<div style="padding-top: 10px;width: 100%;padding-right: 80px">
		<div class="row" style="float: right">
			<button class="btn btn-outline btn-warning" onclick="showRestartBox()">重启</button>
		</div>
	</div>
	<div style="width: 100%;padding-top: 50px">
		<table id="showTable"></table>
	</div>

	
	<!-- 隐藏 域 弹层   -->
	<div id="msgBox" style="display: none;">
		<form id="fm"  method="post" action="" enctype="multipart/form-data">
			<table id="tableShow">
			  <tr>
				<td style="text-align: right">描述:</td>
				<td><input id="remark" class="form-control" name="remark" type="text" value="" size="30" maxlength="200" /></td>
				<td style="text-align: right">参数名:</td>
				<td><input id="variables" name="variables" type="text" size="30" value="" maxlength="200" /></td>
			  </tr>
			  <tr>
				<td style="text-align: right">参数值:</td>
				<td><input id="parameters" name="parameters" size="30" type="text" value="" maxlength="200" /></td>
				<td><input id="id" name="id" size="30" type="text" value="" maxlength="200" hidden/></td>
			  </tr>
			</table>
		</form>
	</div>
	<!-- 隐藏 end -->
	<div id="restartBox" style="display: none;">
		<span>确认重启？</span>
	</div>
</body>
</html>