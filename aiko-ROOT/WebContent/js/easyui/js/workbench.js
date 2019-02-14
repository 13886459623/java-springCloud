var email,code,oauserid,oapwd;
var ctx;
$(function(){
	ctx=$("#ctx").val();
	loadNews(6);
	loadHRNews(6);
	checkOAInfo();
})
function checkOAInfo(){
	var userid=$('#useridspan').html();
 	var data={};
 	var a="<a href=\"javascript:openView('/aiko-home/system/userinfo','\u4e2a\u4eba\u4fe1\u606f','400px','300px');\">绑定OA</a>";
	
	loadData("/aiko-oa/oa/checkOAInfo",data,function(result){
		if(result==null || result=='0'){
			$('#daibancount').html(a);
			return false;
		}
		if(result.oaloginname!=null && result.oaloginname!=''){
			$("#oaworkcode").val(result.oaloginname);
			loadDaibanCount(result.oaloginname);
		}
		else{
			$('#daibancount').html(a);
		}
		if(result.email!=null && result.email!=''){
			email=result.email;
			//loadEmailCount(result.email);
		}
		else{
			$('#emailcount').html("<a id='emaila' style='color: white;text-decoration:none' href='javascript:void();' onclick='emailclick()'>绑定Email</a>");
		}
		
	},true);
	
}



function loadNews(num){
	var url="/aiko-oa/formTableMain/listT"
	loadData(url,{pageSize:6},function(data){
		var list=data.webpT.list;
		var lis="";
		for(var i=0;i<list.length;i++){
			var obj=list[i];
			var title=obj.title;
			var rid=obj.requestId;
			var time=(obj.applydate).substring(5).replace(/-/g,'/');
			lis=lis+"<li>"+
                      "<span></span>"+
                      "<a target='_blank' href='http://portal.aikosolar.com/aiko-oa/formTableMain/noticeApp?requestid="+rid+"' class='ellipsis'>"+title+"</a>"+
                        "<label>"+time+"</label>"+
                    "</li>";
		}
		$("#newsul").html(lis);
	},true);
}

function loadHRNews(num){
	var url="/aiko-oa/formTableMain/listR"
		loadData(url,{pageSize:6},function(data){
			var list=data.webpR.list;
			var lis="";
			for(var i=0;i<list.length;i++){
				var obj=list[i];
				var title=obj.title;
				var rid=obj.requestId;
				var time=(obj.applydate).substring(5).replace(/-/g,'/');
				lis=lis+"<li>"+
	                      "<span></span>"+
	                      "<a target='_blank'  href='http://portal.aikosolar.com/aiko-oa/formTableMain/noticeApp?requestid="+rid+"' class='ellipsis'>"+title+"</a>"+
	                        "<label>"+time+"</label>"+
	                    "</li>";
			}
			$("#hrnewsul").html(lis);
		},true);
}

function loadEmailCount(email){
	var url="/aiko-wxcp/txemail/getNewCount"
	var edate=nowDayStr("yyyy-MM-dd",0);
	loadData(url,{userid:email,bdate:'2017-12-01',edate:edate},function(data){
		var count=data.count;
		//getLoginUrl(count);
		$("#emailcount").html("<a id='emaila' target='_blank' style='color: white;text-decoration:none' href='javascript:void();' onclick='emailclick()'>"+count+"&nbsp;</a> <span class='unit'>封</span>");
		
	},false);
}

function emailclick(){
	var type=$("#emaila").html();
	alert(type)
	if(type=='绑定Email'){
		openWindow(ctx+'/system/userinfo','\u4e2a\u4eba\u4fe1\u606f','400','300');
	}
	else{
		getLoginUrl();
	}
	
}

function getLoginUrl(){
    
	var url="/aiko-wxcp/txemail/getLoginUrl"
		var edate=nowDayStr("yyyy-MM-dd",0);
		loadData(url,{userid:email},function(data){
			
			var loginurl=data.loginurl;
			openWindow(loginurl)
			//$("#emailcount").html("<a id='loginurl' target='_blank' style='color: white;text-decoration:none' href='"+loginurl+"'>"+count+"&nbsp;</a> <span class='unit'>封</span>");
			//$("#loginurl").attr("href",loginurl); 
			//$("#loginurl").click();
			
		},false);
}

function loadDaibanCount(oaloginname){
	var url='/aiko-oa/oaInerface/daibanlist';//?oaworkcode='+oaloginname;
	$('#dbiframe').attr('src', url);
	
}

//查看新闻通告列表
function showNewsList(){
	openWindow('/aiko-oa/formTableMain/noticeList','新闻通告列表','600','400');
}
function showHRMSGList(){
	openWindow('/aiko-oa/formTableMain/personnelList','人事奖惩列表','600','400');
}
