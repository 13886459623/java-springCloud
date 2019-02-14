var OsObject = function ()   
{   
  var ua = navigator.userAgent.toLowerCase();   
  var isIE = !!window.ActiveXObject, isIE6 = isIE && !window.XMLHttpRequest;
  return {   
   isIE : isIE,   
   isIE6 : isIE6,   
   isFirefox : ua.indexOf("firefox")>0,   
   isSafari : ua.indexOf("safari")>0,   
   isCamino : ua.indexOf("camino")>0,   
   isGecko : ua.indexOf("gecko/")>0   
  };   
}();   
function disWheel(evt)   
{   
  if(!evt) evt=window.event;   
  var delta=0;   
  
  if(OsObject.isFirefox)   
  {   
    delta = -evt.detail/2;   
    if(evt.preventDefault)   
      evt.preventDefault();   
    evt.returnValue = false;   
  }   
  else if(OsObject.isIE)   
  {   
    delta = evt.wheelDelta/60;   
    return false;   
  }   
}  
$(function(){
  $(".pay_infor .infor_box").append("<div class='clear'></div>");
  $(".thickdiv").height(Math.max($("body").innerHeight(),$("html").innerHeight()));
  $(window).resize(function() {
      $(".thickdiv").height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
       var scrollTop = $(document).scrollTop();
       var scrollLeft = $(document).scrollLeft();
      if($("#topshowwindow").css("display")!="none"){
    	  var top = ($(window).height() - $("#topshowwindow").height())/2;
          var left = ($(window).width() - $("#topshowwindow").width())/2;
    	  if (top<0) {
          	var top = 30;
          }
	      if($.browser.msie&&($.browser.version == "6.0")&&!$.support.style ){
				$("#topshowwindow").css( {"position" :"absolute", "top": top+scrollTop, left : left + scrollLeft } );
	        }else{
	           $("#topshowwindow").css( {"position" : "fixed","top": top, left : left + scrollLeft } );
	      }
      }
      if($("#topshowwindowcredit").css("display")!="none"){
    	  var top = ($(window).height() - $("#topshowwindowcredit").height())/2;
          var left = ($(window).width() - $("#topshowwindowcredit").width())/2;
    	  if (top<0) {
          	var top = 30;
          }
		  if($.browser.msie&&($.browser.version == "6.0")&&!$.support.style ){
				$("#topshowwindowcredit").css( {"position" :"absolute", "top": top+scrollTop, left : left + scrollLeft } );
	       }else{
	           $("#topshowwindowcredit").css( {"position" : "fixed","top": top, left : left + scrollLeft } );
	      } 
      }
      if($("#topshowwindowvalidate").css("display")!="none"){
    	  var top = ($(window).height() - $("#topshowwindowvalidate").height())/2;
          var left = ($(window).width() - $("#topshowwindowvalidate").width())/2;
    	  if (top<0) {
          	var top = 30;
          }
		  if($.browser.msie&&($.browser.version == "6.0")&&!$.support.style ){
				$("#topshowwindowvalidate").css( {"position" :"absolute", "top": top+scrollTop, left : left + scrollLeft } );
	       }else{
	           $("#topshowwindowvalidate").css( {"position" : "fixed","top": top, left : left + scrollLeft } );
	      }  	  
      }
  });
  var errorMsg=$("#errorMsg").val();
  var warnMsg=$("#warnMsg").val();
  
  if(errorMsg != null && errorMsg != ""){
      $("#topshowwindow").center().show();
      $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
	  $("#safecontinue").hide();
	  EnableWheelScroll(false);
  }
  else if(warnMsg != null && warnMsg != ""){
	  $("#topshowwindow").center().show();
	  $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
	  EnableWheelScroll(false);
  }

  $(".mode_1").click(function(){
    var _this = $(this);
    _this.addClass("current").siblings("li").removeClass("current");
    $(".savings_card").show();
    $(".credit").hide();
    $(".accounts_pay").hide();
    $(".enterprise_network").hide();
  });
  
  $(".mode_2").click(function(){
    var _this = $(this);
    _this.addClass("current").siblings("li").removeClass("current");
    $(".savings_card").hide();
    $(".credit").show();
    $(".accounts_pay").hide();
    $(".enterprise_network").hide();
  });
  $(".mode_3").click(function(){
    var _this = $(this);
    _this.addClass("current").siblings("li").removeClass("current");
    $(".savings_card").hide();
    $(".credit").hide();
    $(".accounts_pay").show();
    $(".enterprise_network").hide();
  });
  $(".mode_4").click(function(){
    var _this = $(this);
    _this.addClass("current").siblings("li").removeClass("current");
    $(".savings_card").hide();
    $(".credit").hide();
    $(".accounts_pay").hide();
    $(".enterprise_network").show();
  });

  $(".default label").live("click",function(){
    var _this = $(this);
    $(".sel_list label a").removeClass("border_f60");
    _this.find("a").addClass("border_f60");
    $("input:radio[name='bank_radio']").attr("checked",false);
    _this.find("input:radio[name='bank_radio']").attr("checked",true);
  });

  $(".sel_list label").live("click",function(){
    var _this = $(this);
    $(".sel_list label a").removeClass("border_f60");
    $(".default label a").removeClass("border_f60");
    _this.find("a").addClass("border_f60");
  });
  
  $(".helpInfo").hover(
    function(){
        var info=$(this).find(".helpDelimiterInfo");
        $(this).find(".helpDelimiter").show();
        info.show();
        var left=info.offset().left,w=info.width();
        if((left+w)>$(window).width())info.css("left","-306px").find(".arrow").addClass("arrowNew");
        
      },
    function(){
        $(this).find(".helpDelimiterInfo").hide().css("left","").find(".arrow").removeClass("arrowNew");
        $(this).find(".helpDelimiter").hide();
      }
  );
  $("a[data-title]",".sel_list").hover(
    function(){
      var _this=$(this),title=_this.attr("data-title");
      _this.css("position","relative").prepend("<div class='titleYh'>"+title+"</div>")
      
    },function(){
      var _this=$(this);
      _this.css("position","").find(".titleYh").remove();
    }
  )
});

  function showAllChannel(obj) {
		var _oId = document.getElementById("showAll");
		if (_oId.style.display == 'none') {
			_oId.style.display = '';
			$("#backimag").removeClass("downarrow");
			$("#backimag").addClass("uparrow");
			$("#buttonfooter").hide();
			$('#showAll').show();
		} else {
			_oId.style.display = 'none'; 
			$("#backimag").removeClass("uparrow");
			$("#backimag").addClass("downarrow");
			$("#buttonfooter").show();
			$('#showAll').hide();
		}
  }

  function showHidden(obj, oId) {
		var _oId = $("."+oId);
		for (var i = 0; i < _oId.length; i++) {
			if (_oId[i].style.display == 'none') {
				_oId[i].style.display = '';
				$("#"+obj).removeClass("downarrow");
				$("#"+obj).addClass("uparrow");
			} else {
				_oId[i].style.display = 'none';
				$("#"+obj).removeClass("uparrow");
				$("#"+obj).addClass("downarrow");
			}
		}
	}

 function getNext() {
	var bank = $("input[name='paymentInfo.bankSelect']:checked").val();
	if (bank == null || bank == "") {
		alert("请选择支付方式!!");
		return false;
	}
	if ($("input[value$='03']:checked").length > 0) {
			showConfirmDialog();
	} else {
		$("form").submit();
	}
}
 
function imageSel(str) {
	var bank = document.getElementById("bank_" + str);
	bank.checked = true;
	if ($("input[value$='03']:checked").length > 0) {
		validateCreditCard(str);
	}
}

function closetoplayer(){
	 var errorMsg=$("#errorMsg").val();
     if(errorMsg != null && errorMsg != ""){
    	 quitPay("web");
	  }
	  else{
		  continuePay();
	  }
}

function quitPay(type){
	 if(type=="web"){window.location.href='http://www.10010.com';}
}

function continuePay(){
	$("#topshowwindow").hide();
	$(this).closest("#topshowwindow").hide();
	$(".thickdiv").hide();
	EnableWheelScroll(true);
}

 function EnableWheelScroll(enable)   
{   
  if(enable)   
  {   
    if(OsObject.isFirefox)   
    {   
      window.removeEventListener('DOMMouseScroll', disWheel, false);   
    }   
    else if(OsObject.isIE)   
    {   
      window.onmousewheel = document.onmousewheel = function(){return true};   
    }   
  }   
  else // disable   
  {   
    if(OsObject.isFirefox)   
    {   
      window.addEventListener('DOMMouseScroll', disWheel, false);   
    }   
    else if(OsObject.isIE)   
    {   
      window.onmousewheel = document.onmousewheel = disWheel;   
    }   
  }   
}  
 
 function goRealUrl(obj){
	 window.location.href=obj;
 }
 
 function resizediv(obj){
	   var top = ($(window).height() - this.height())/2;
         var left = ($(window).width() - this.width())/2;
         var scrollTop = $(document).scrollTop();
         var scrollLeft = $(document).scrollLeft();
         
         if (top<0) {
          var top = 30;
         }
        if($.browser.msie&&($.browser.version == "6.0")&&!$.support.style ){
			$("#"+obj).css( {"position" :"absolute", "top": top+scrollTop, left : left + scrollLeft } );
        }else{
           $("#"+obj).css( {"position" : "fixed","top": top, left : left + scrollLeft } );
        }
 }
 (function($){    
     $.fn.center = function(){
         var top = ($(window).height() - this.height())/2;
         var left = ($(window).width() - this.width())/2;
         var scrollTop = $(document).scrollTop();
         var scrollLeft = $(document).scrollLeft();
         
         if (top<0) {
          var top = 30;
         }
        if($.browser.msie&&($.browser.version == "6.0")&&!$.support.style ){
			return this.css( {"position" :"absolute", "top": top+scrollTop, left : left + scrollLeft } );
        }else{
           return this.css( {"position" : "fixed","top": top, left : left + scrollLeft } );
        }
     }
 })(jQuery)

 //creditCard.js
 function showConfirmDialog(){
	if($("input[value$='03']:checked").length>0){
		 $("#topshowwindowcredit").center().show();
		 $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
      	 EnableWheelScroll(false);
	}
}

function validateCreditCard(obj){
	 var enBuyTel=$('input[name=paymentInfo.enBuyTel]').val();
	 var enServiceOrder=$('input[name=paymentInfo.enServiceOrder]').val();
	 var enTimeStamp=$('input[name=paymentInfo.enTimeStamp]').val();
	 var enServiceInfo=$('input[name=paymentInfo.enServiceInfo]').val();
	 var  returntag="success";
	 $.ajax({ url:'validateCreditCard.action', 
                data:{'enBuyTel':enBuyTel,'enServiceOrder':enServiceOrder,'enTimeStamp':enTimeStamp,'enServiceInfo':enServiceInfo,'date':new Date().getTime()},
                type: 'POST', 
                dataType: 'JSON',
                beforeSend: function(XMLHttpRequest){},
                success:function (data){
                    if($.trim (data)=="false"){
                    	  $("#validatecontent").html("您所交费充值的号码在联通预留的机主姓名、身份证等信息不完整，无法使用信用卡支付，请您选择其它支付方式。");
                    	  $("#topshowwindowvalidate").center().show();
	  					  $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));

                    	  EnableWheelScroll(false);
                    	  var bank = document.getElementById("bank_" + obj);
						  bank.checked = false;
					      returntag = "fail";
			    	}
			    	if($.trim (data)=="timeout"){
			    		  $("#validatecontent").html("由于系统维护，暂时无法使用信用卡支付，请您选择其它支付方式。");
					      $("#topshowwindowvalidate").center().show();
						  $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
					      EnableWheelScroll(false);
					      var bank = document.getElementById("bank_" + obj);
						  bank.checked = false;
					      returntag = "fail";
			    	}
                    },
               complete: function(XMLHttpRequest){},
               error: function(xml){
            	    $("#validatecontent").html("由于系统维护，暂时无法使用信用卡支付，请您选择其它支付方式。");
					 $("#topshowwindowvalidate").center().show();
				     $(".thickdiv").show().height(Math.max($("body").innerHeight(),$("html").innerHeight())).width(Math.max($("body").outerWidth(),$("html").outerWidth()));
					  EnableWheelScroll(false);
					  var bank = document.getElementById("bank_" + obj);
					  bank.checked = false;
					 returntag = "fail";
               }
           });
	 return returntag;
}

function canclevalidate(){
	$("#topshowwindowvalidate").attr("style","display:none");
	$(this).closest("#topshowwindowvalidate").hide();
	EnableWheelScroll(true);
	$(".thickdiv").hide();
}
function canclecredit(){
	$("#topshowwindowcredit").attr("style","display:none");
	$(this).closest("#topshowwindowcredit").hide();
	EnableWheelScroll(true);
	$(".thickdiv").hide();
}

function sure2next(){
	$("#topshowwindowcredit").attr("style","display:none");
	$(this).closest("#topshowwindowcredit").hide();
	$(".thickdiv").hide();
	EnableWheelScroll(true);
	$("form").submit();
}
