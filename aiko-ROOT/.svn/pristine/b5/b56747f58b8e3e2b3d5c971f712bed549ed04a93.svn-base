var common_ajax=function(){
	
	var ajaxFunc=	function(url,text,data,successPopUp,callback){
		var layerIndex = layer.msg(text, {icon: 16, time: 0, shade: 0.3});
		url=url;
		$.post(url,data,function(data){
			if (data.status == "1") {
				if(true==successPopUp){
					layer.alert(data.message, function(index){
						layer.close(index);
						layer.close(layerIndex);
						if(typeof(callback) != "undefined" ){
							callback();
						}
					}); 
				}else{
					layer.close(layerIndex);
					if( typeof(callback) != "undefined" ){
						callback();
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
	};
	
	return{
		ajaxFunc : ajaxFunc
	};
	
}();