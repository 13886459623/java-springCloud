var layerIndex = null;
/*
 * AJAX统一控制
 */
$(function() {
	$.ajaxSetup({
		type : 'POST',
		complete : function(xhr, status) {
			var win = (window.self == window.top ? window : window.top);
			if (xhr.status == 911) {
				layer.alert("\u7531\u4E8E\u60A8\u957F\u65F6\u95F4\u6CA1\u6709\u64CD\u4F5C,\u8BF7\u91CD\u65B0\u767B\u5F55\uFF01", function(index){
					layer.close(index);
					win.location.href = "/";
				});
			} else if(xhr.status == 401 || xhr.status == 403){
				layer.alert("\u60A8\u7684\u8BBF\u95EE\u672A\u88AB\u6388\u6743,\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458\uFF01", function(index){
					layer.close(index);
				});
			}  else if(xhr.status == 404){
				layer.alert("\u60A8\u8BBF\u95EE\u7684\u9875\u9762\u4E0D\u5B58\u5728,\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458\uFF01", function(index){
					layer.close(index);
				});
			} else if(xhr.status == 500 || status == "error"){
				layer.alert("\u7CFB\u7EDF\u9519\u8BEF\uFF0C\u8BF7\u68C0\u67E5\u7F51\u7EDC\u6216\u8054\u7CFB\u7BA1\u7406\u5458\uFF01", function(index){
					layer.close(index);
				});
			}
		}
	});
});

function request(paramName) {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
	var paraObj = {}
	for (i = 0; j = paraString[i]; i++) {
		paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
	}
	var returnValue = paraObj[paramName.toLowerCase()];
	if (typeof (returnValue) == "undefined") {
		return "";
	} else {
		return returnValue;
	}
}  

function doTemplate(templateId, targetId, data){
	var templateData = {};
	if(data){
		templateData = data;
	}
	$("#" + targetId).setTemplateElement(templateId);
	$("#" + targetId).processTemplate(templateData);
}

function doTemplate4Element(elementId, data){
	var templateData = {};
	if(data){
		templateData = data;
	}
	$('#' + elementId).find('.jstemplate').each(function(){
		var templateId = $(this).attr("id");
		var targetId = templateId.replace("-tpl", "");
		doTemplate(templateId, targetId, templateData);
	});
}

/*
 *  异步加载
 *  url:请求地址
 *  params：请求参数(JSON对象)
 *  callback:回调方法function callback(data){...}
 *  showLoading:是否显示正在加载的信息
 */
function loadData(url, params, callback, showLoading, loadingMsg) {
	var returnVal = null;
	if(showLoading && showLoading == true){
		if(!loadingMsg){
			loadingMsg = "\u6B63\u5728\u52A0\u8F7D\u6570\u636E,\u8BF7\u7A0D\u5019...";
		}
		layerIndex = layer.msg(loadingMsg, {icon : 16,time : 0, shade : 0.3});
	}

	$.post(url, params, function(data) {
		if (data.status == "1") {
			layer.close(layerIndex);
			if (typeof callback === "function"){
	            callback(data.data); 
	        } else {
	        	try{
	        		window[callback](data.data);
	        	} catch(e){
	        		
	        	}
	        }
		} else {
			layer.alert(data.message, function(index){
				layer.close(index);
				layer.close(layerIndex);
			});
		}
	}).error(function() {
		layer.close(layerIndex);
	});
}
/*
 *  同步加载
 *  url:请求地址
 *  params：请求参数(JSON对象)
 *  callback:回调方法function callback(data){...}
 *  showLoading:是否显示正在加载的信息
 */
function loadData4TB(url, params, callback, showLoading, loadingMsg) {
	var returnVal = null;
	if(showLoading && showLoading == true){
		if(!loadingMsg){
			loadingMsg = "\u6B63\u5728\u52A0\u8F7D\u6570\u636E,\u8BF7\u7A0D\u5019...";
		}
		layerIndex = layer.msg(loadingMsg, {icon : 16,time : 0, shade : 0.3});
	}
	
	$.ajax({  
       type:"POST", 
       url:url, 
       async:false,
       dataType:"JSON", 
       data: params,
       success:function(data){
	   		if (data.status == "1") {
				layer.close(layerIndex);
				if (typeof callback === "function"){
		            callback(data.data); 
		        } else {
		        	try{
		        		window[callback](data.data);
		        	} catch(e){
		        		
		        	}
		        }
			} else {
				layer.alert(data.message, function(index){
					layer.close(index);
					layer.close(layerIndex);
				});
			}
       }, 
       failure:function (data) {  
    	   layer.close(layerIndex);
       }
	}); 
}


function initialize4Element(elementId, url, params) {
	layerIndex = layer.msg('\u6B63\u5728\u52A0\u8F7D\u6570\u636E,\u8BF7\u7A0D\u5019...', {icon : 16,time : 0, shade : 0.3});
	
	$.post(url, params, function(data) {
		if (data.status == "1") {
			layer.close(layerIndex);
			doTemplate4Element(elementId, data.data);
			layui.use('form', function(){layui.form().render();});
		} else {
			layer.alert(data.message, function(index){
				layer.close(index);
				layer.close(layerIndex);
				doTemplate4Element(elementId);
			});
		}
	}).error(function() {
		layer.close(layerIndex);
		doTemplate4Element(elementId);
	});
}

function listenForm(formId, load){
	// building hidden input for currentPage
	if(!document.getElementById("AIKO-CURRENT-PAGE")){
		$('#' + formId).append('<input type="hidden" id="AIKO-CURRENT-PAGE" name="currentPage"/>');
	}
	var url=$('#' + formId).attr("action");
	$('#' + formId).attr("action",url);
	
	$('#' + formId).ajaxForm({
    	success : function(data) {
    		if (data.status == "1") {
    			layer.close(layerIndex);
				doTemplate4Element(formId, data.data);
				$(".table-page").each(function(){
				    var pgDiv = $(this);
					var pgSize = pgDiv.attr("pg-size");
					var pgTotal = pgDiv.attr("pg-total");
					var pgPages = pgDiv.attr("pg-pages");
					var pgPageNum = pgDiv.attr("pg-pageNum");
					$('#AIKO-CURRENT-PAGE').val(pgPageNum);
					pgDiv.hide();
					layui.use('laypage', function() {
						layui.laypage({
							cont: 'table-page', 
							curr: pgPageNum, 
							pages: pgPages,
							skip: true,
						    jump: function(obj, first){
						    	var currentPage = $('#AIKO-CURRENT-PAGE').val();
						    	if(currentPage != obj.curr){
						    		$('#AIKO-CURRENT-PAGE').val(obj.curr);
						    		$('#' + formId).submit();
						    	}
						    }
						});
					});
			    });
				layui.use('form', function(){
					//部分刷新
					//layui.form().render('checkbox');
					// 全部刷新
					layui.form().render();
				});
			} else {
				layer.alert(data.message, function(index){
    				layer.close(index);
    				layer.close(layerIndex);
    				doTemplate4Element(formId);
    			}); 
			}
		},
		error : function(data) {
			layer.close(layerIndex);
			doTemplate4Element(formId);
		}
    });
	
	if(load && load == true){
		layerIndex = layer.msg('\u6B63\u5728\u52A0\u8F7D\u6570\u636E,\u8BF7\u7A0D\u5019...', {icon: 16, time: 0, shade: 0.3});
		$('#' + formId).submit();
	} else {
		doTemplate4Element(formId);
	}
}

layui.use('form', function(){
	var layform = layui.form();
	layform.on('checkbox(allChoose)', function(data){
	   $(data.elem).parents('table').find('tbody input[type="checkbox"]').each(function(index, item){
		   	if($(this).attr("lay-skin") == "primary"){
		   		item.checked = data.elem.checked;
		   	}
	   });
	   layform.render('checkbox');
	});
	layform.on('submit(submit-btn)', function(data) {
		$('#AIKO-CURRENT-PAGE').val("1");
		return true;
	});
});

function openView(url, title, width, height){
	layer.open({
		type: 2,
		title: '<strong style="font-size:16px;font-style:italic;letter-spacing:6px;">'+title+'</strong>',
		shade: 0.3,
		shadeClose: false,
		maxmin: true, 
		area: [width, height],
		content: url    
	});
}

function windowOpen(url, width, height) {
	var screenWidth = window.screen.width;
	var screenHeight = window.screen.height;
	if (!width || width > screenWidth) {
		width = screenWidth;
	}
	if (!height || height > screenHeight) {
		height = screenHeight;
	}
	var left = (screenWidth - width) / 2;
	var top = (screenHeight - height) / 2;
	window.open(
		url,
		"_blank",
		"width=" + width+ ",height=" + height + ",left=" + left + ",top=" + top + ",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,toolbar=no",
		false
	);
}

function addView(url, title, width, height){
	if (typeof (title) == "undefined") {
		title = "\u6DFB\u52A0\u4FE1\u606F";
	}
	if (typeof (width) == "undefined") {
		width = "800px";
	}
	if (typeof (height) == "undefined") {
		height = "500px";
	}
	openView(url, title, width, height);
}

function updateView(url, paramName, title, width, height){
	if (typeof (paramName) == "undefined") {
		paramName = "id";
	}
	if (typeof (title) == "undefined") {
		title = "\u7F16\u8F91\u4FE1\u606F";
	}
	if (typeof (width) == "undefined") {
		width = "800px";
	}
	if (typeof (height) == "undefined") {
		height = "500px";
	}
	var ids=[]; 
	$('input[name="' + paramName + '"]:checked').each(function() {
		ids.push($(this).val());
	});
	if(ids.length <= 0){
		layer.alert('\u8BF7\u9009\u62E9\u9700\u8981\u7F16\u8F91\u7684\u4FE1\u606F', function(index){
			layer.close(index);
		}); 
	} else if(ids.length > 1){
		layer.alert('\u53EA\u80FD\u9009\u62E9\u4E00\u4E2A\u4FE1\u606F\u8FDB\u884C\u7F16\u8F91', function(index){
			layer.close(index);
		}); 
	} else {
		if (typeof (url) == "undefined") {
			url = "";
		}
		if (url.indexOf("?") == -1) {
			url += "?" + paramName + "=" + ids[0];
		} else {
			url += "&" + paramName + "=" + ids[0];
		}
		openView(url, title, width, height);
	}
}

function roleSelectView(url,userid,width, height){
	var title = "\u89d2\u8272\u9009\u62e9";

	if (typeof (width) == "undefined") {
		width = "700px";
	}
	if (typeof (height) == "undefined") {
		height = "500px";
	}
	url=url+"?userid=" + userid;
	openView(url, title, width, height);
}

function menuSelectView(url,roleid,rolename){
	if (typeof (rolename) == "undefined") {
		title = "\u83dc\u5355\u9009\u62e9";
	}else{
		title=rolename+'-\u83dc\u5355\u9009\u62e9';
	}
	width = "700px",height = "500px",
	url=url+"?roleid=" + roleid;
	openView(url, title, width, height);
}

function deleteBatch(url, paramName){
	if (typeof (paramName) == "undefined") {
		paramName = "id";
	}
	layer.confirm('\u786E\u5B9A\u8981\u5220\u9664\u6240\u9009\u7684\u4FE1\u606F\u5417\uFF1F', {
		btn: ['\u786E\u5B9A','\u53D6\u6D88'], closeBtn: 0
	}, function(){
		var ids =[]; 
		$('input[name="' + paramName + '"]:checked').each(function() {
			ids.push($(this).val());
		}); 
		layerIndex = layer.msg('\u6B63\u5728\u5220\u9664\u4FE1\u606F,\u8BF7\u7A0D\u5019...', {icon: 16, time: 0, shade: 0.3});
		$.post(url, {"ids":ids}, function(data){
			if (data.status == "1") {
    			layer.alert(data.message, function(index){
    				layer.close(index);
    				layer.close(layerIndex);
    				$("#submit-btn").click();
    			}); 
			} else {
				layer.alert(data.message, function(index){
    				layer.close(index);
    				layer.close(layerIndex);
    			}); 
			}
		}).error(function() { 
			layer.close(layerIndex);
		});
		layer.closeAll('dialog');
	}, function(){
		layer.closeAll('dialog');
	});
}

function listenQueryForm(){
	$('form.common-query').each(function(index, element) {
		var id = $(this).attr("id"); 
		var initLoad = $(this).attr("init-load"); 
		if (typeof (id) == "undefined" || id == "") {
			id = "submit-form-" + index;
			$(this).attr("id", id); 
		}
		if (typeof (initLoad) == "undefined" || initLoad == "" || initLoad == "true") {
			initLoad = true;
		} else {
			initLoad = false;
		}
		
		listenForm(id, initLoad);
	});
}

function listenAJAXForm(){
	$('form.common-ajax').each(function() {
		var listenBtn = $(this).attr("listen-btn"); 
		var clickBtn = $(this).attr("click-btn"); 
		var callback = $(this).attr("callback"); 
		if (typeof (listenBtn) == "undefined" || listenBtn == "") {
			listenBtn = "submit-btn";
		}
		if (typeof (clickBtn) == "undefined" || clickBtn == "") {
			clickBtn = "submit-btn";
		}
		var url=$(this).attr("action");
		$(this).attr("action",url);
		
		$(this).ajaxForm({
	    	success : function(data) {
	    		if (typeof (callback) != "undefined" && callback != "") {
	    			window[callback](data);
	    		} else {
	    			if (data.status == "1") {
		    			layer.alert(data.message, function(index){
		    				layer.close(index);
		    				layer.close(layerIndex);
		    				window.parent.$("#" + clickBtn).click();
		        			window.parent.layer.closeAll(); 
		    			}); 
					} else {
						layer.confirm(data.message, {
							btn : [ '\u786E\u5B9A' ],
							closeBtn : 0
						}, function() {
							layer.closeAll();
						});
					}
	    		}
			},
			error : function(data) {
				layer.confirm('\u7CFB\u7EDF\u9519\u8BEF,\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458\uFF01', {
					btn : [ '\u786E\u5B9A' ],
					closeBtn : 0
				}, function() {
					layer.closeAll();
				});
			}
	    });
		
		layui.use('form', function() {
			layui.form().on('submit(' + listenBtn + ')', function(data) {
				layerIndex = layer.msg('\u6B63\u5728\u63D0\u4EA4\u6570\u636E,\u8BF7\u7A0D\u5019...', {icon: 16, time: 0, shade: 0.3});
				return true;
			});
		});
	});
}


$(function() {
	listenQueryForm();
	listenAJAXForm();
});
