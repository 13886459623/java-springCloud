//加载js css
//加载分页插件
/*document.write('<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/aiko/css/GridManager.css">');
document.write('<script type="text/javascript" src="${pageContext.request.contextPath}/aiko/js/GridManager.js"></script>');*/
//js

/*document.write('<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>');
document.write('<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.Sonline.js"></script>');
document.write('<script src="${pageContext.request.contextPath }/css/jquery.min.js"></script>"');
document.write('<script src="${pageContext.request.contextPath }/js/jquery.popbox.js"></script>"');

//layer ui
document.write('<script src="${pageContext.request.contextPath }/js/layui/layui.js" charset="utf-8"></script>');
document.write('<link rel="stylesheet" href="${pageContext.request.contextPath }/js/layui/css/layui.css" />');*/
/*document.write('<script src="${ctx}/js/date-tool.js"></script>');*/


//日期插件
$(function(){
        var DATAPICKERAPI = {
          // 默认input显示当前月,自己获取后填充
          activeMonthRange: function () {
            return {
              begin: moment().set({ 'date': 1, 'hour': 0, 'minute': 0, 'second': 0 }).format('YYYY-MM-DD HH:mm:ss'),
              end: moment().set({ 'hour': 23, 'minute': 59, 'second': 59 }).format('YYYY-MM-DD HH:mm:ss')
            }
          },
          shortcutMonth: function () {
            // 当月
            var nowDay = moment().get('date');
            var prevMonthFirstDay = moment().subtract(1, 'months').set({ 'date': 1 });
            var prevMonthDay = moment().diff(prevMonthFirstDay, 'days');
            return {
              now: '-' + nowDay + ',0',
              prev: '-' + prevMonthDay + ',-' + nowDay
            }
          },
          // 注意为函数：快捷选项option:只能同一个月份内的
          rangeMonthShortcutOption1: function () {
            var result = DATAPICKERAPI.shortcutMonth();
            return [{
              name: '昨天',
              day: '-1,-1',
              time: '00:00:00,23:59:59'
            }, {
              name: '这一月',
              day: result.now,
              time: '00:00:00,'
            }, {
              name: '上一月',
              day: result.prev,
              time: '00:00:00,23:59:59'
            }];
          },
          // 快捷选项option
          rangeShortcutOption1: [{
            name: '最近一周',
            day: '-7,0'
          }, {
            name: '最近一个月',
            day: '-30,0'
          }, {
            name: '最近三个月',
            day: '-90, 0'
          }],
          singleShortcutOptions1: [{
            name: '今天',
            day: '0'
          }, {
            name: '昨天',
            day: '-1',
            time: '00:00:00'
          }, {
            name: '一周前',
            day: '-7'
          }]
        };
          //十分秒年月日单个
          $('.J-datepicker').datePicker({
            hasShortcut:true,
            min:'2018-01-01 04:00:00',
            max:'2019-04-29 20:59:59',
            shortcutOptions:[{
              name: '今天',
              day: '0'
            }, {
              name: '昨天',
              day: '-1',
              time: '00:00:00'
            }, {
              name: '一周前',
              day: '-7'
            }],
            hide:function(){
              console.info(this)
            }
          });
          
          //年月日单个
          $('.J-datepicker-day').datePicker({
            hasShortcut: true,
            format:'YYYY-MM-DD',
            shortcutOptions: [{
              name: '今天',
              day: '0'
            }, {
              name: '昨天',
              day: '-1'
            }, {
              name: '一周前',
              day: '-7'
            }]
          });
          
          //年月日范围
          $('.J-datepicker-range-day').datePicker({
            hasShortcut: true,
            format: 'YYYY-MM-DD',
            isRange: true,
            shortcutOptions: DATAPICKERAPI.rangeShortcutOption1
          });

          //十分年月日单个
          $('.J-datepickerTime-single').datePicker({
            format: 'YYYY-MM-DD HH:mm'
          });
          
          //十分年月日范围
          $('.J-datepickerTime-range').datePicker({
            format: 'YYYY-MM-DD HH:mm',
            isRange: true
          });
          
          //十分秒年月日范围，包含最大最小值
          $('.J-datepicker-range').datePicker({
            hasShortcut: true,
            min: '2018-01-01 06:00:00',
            max: '2019-04-29 20:59:59',
            isRange: true,
            shortcutOptions: [{
              name: '昨天',
              day: '-1,-1',
              time: '00:00:00,23:59:59'
            },{
              name: '最近一周',
              day: '-7,0',
              time:'00:00:00,'
            }, {
              name: '最近一个月',
              day: '-30,0',
              time: '00:00:00,'
            }, {
              name: '最近三个月',
              day: '-90, 0',
              time: '00:00:00,'
            }],
            hide: function () {
              console.info(this.$input.eq(0).val(), this.$input.eq(1).val())
            }
          });
          //十分秒年月日范围，限制只能选择同一月，比如2018-10-01到2018-10-30
          $('.J-datepicker-range-betweenMonth').datePicker({
            isRange: true,
            between:'month',
            hasShortcut: true,
            shortcutOptions: DATAPICKERAPI.rangeMonthShortcutOption1()
          });
          
          //十分秒年月日范围，限制开始结束相隔天数小于30天
          $('.J-datepicker-range-between30').datePicker({
            isRange: true,
            between: 30
          });
          
          //年月单个
          $('.J-yearMonthPicker-single').datePicker({
            format: 'YYYY-MM',
            min: '2018-01',
            max: '2019-04'
          });
          
          //选择年
          $('.J-yearPicker-single').datePicker({
            format: 'YYYY',
            min: '2018',
            max: '2020'
          });
          
          
      });

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 

// 日期格式化,不是插件的代码,只用于处理时间格式化
Date.prototype.format = function(fmt){
	var o = {
		"M+": this.getMonth() + 1, //月份
		"D+": this.getDate(), //日
		"d+": this.getDate(), //日
		"H+": this.getHours(), //小时
		"h+": this.getHours(), //小时
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		"q+": Math.floor((this.getMonth() + 3)/3),
		"S": this.getMilliseconds()
	};
	if (/([Y,y]+)/.test(fmt)){
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for (var k in o){
		if(new RegExp("(" + k + ")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

//var time1 = new Date().Format("yyyy-MM-dd");
//var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");

//初始化jQueryDate 日期插件
//days:正数往后推移，负数往前推移，2017-05-06 -1  --> 2017-05-05
var jqDateOpt;
function initJQueryDate(target,format,daytype,days){
	var days = arguments[3] ? arguments[3] : 0;//设置参数days的默认值为0
	var now= new Date(); 
	var year=now.getFullYear(); 
	//var month=now.getMonth()+1; 
	//var day=now.getDate();
	now.setDate(now.getDate() + days);
	var timeStr=now.Format(format);
	jqDateOpt = {
	        preset: 'date', //日期
	        theme: 'android-ics light', //皮肤样式
	        display: 'modal', //显示方式 
	        mode: 'scroller', //日期选择模式
	        dateFormat: 'yy-mm-dd', // 日期格式
	        setText: '确定', //确认按钮名称
	        cancelText: '取消',//取消按钮名籍我
	        dateOrder: 'yymmdd', //面板中日期排列格式
	        dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
	        showNow: true,
			nowText: "今天",
	        startYear: year - 10, //开始年份
	        endYear: year + 10 //结束年份
	    };

		if(daytype=='D'){
			jqDateOpt.dateOrder='yymmdd';
			jqDateOpt.dateFormat='yy-mm-dd'; // 日期格式
		}
		else if(daytype=='M'){
			jqDateOpt.dateOrder='yymm';
			jqDateOpt.dateFormat='yy-mm'; // 日期格式
		}
		else if(daytype=='Y'){
			jqDateOpt.dateOrder='yy';
			jqDateOpt.dateFormat='yy'; // 日期格式
		}
  	//var optDateTime = $.extend(opt['datetime'], opt['default']);
  	//var optTime = $.extend(opt['time'], opt['default']);
  	jQuery("#"+target).mobiscroll(jqDateOpt).date(jqDateOpt);
  	jQuery("#"+target).val(timeStr);
  	
}
//日期类型改变，日期选项格式改变方法
function changtime(callback){
	var daytype=jQuery("#daytype").val();
	var now= new Date(); 
	var starttimeStr;
	var endtimeStr;
	if(daytype=='D'){
		jqDateOpt.dateOrder='yymmdd';
		jqDateOpt.dateFormat='yy-mm-dd'; // 日期格式
		starttimeStr=now.Format("yyyy-MM")+'-01';
		endtimeStr=now.Format("yyyy-MM-dd");
	}
	else if(daytype=='M'){
		jqDateOpt.dateOrder='yymm';
		jqDateOpt.dateFormat='yy-mm'; // 日期格式
		starttimeStr=now.Format("yyyy")+'-01';
		endtimeStr=now.Format("yyyy-MM");
	}
	else if(daytype=='Y'){
		jqDateOpt.dateOrder='yy';
		jqDateOpt.dateFormat='yy'; // 日期格式
		starttimeStr=parseInt(now.Format("yyyy"))-5;
		endtimeStr=now.Format("yyyy");
	}
	jQuery("#startTime").mobiscroll(jqDateOpt).date(jqDateOpt);
  	jQuery("#startTime").val(starttimeStr);
  	jQuery("#endTime").mobiscroll(jqDateOpt).date(jqDateOpt);
  	jQuery("#endTime").val(endtimeStr);
	
	if (typeof callback === "function"){
        callback(); 
    } else {
    	try{
    		window[callback]();
    	} catch(e){
    		
    	}
    }
	
}

function nowDayStr(format,days){
	var format = arguments[0] ? arguments[0] : "yyyy-MM-dd";//设置参数格式 的默认值为"yyyy-MM-dd"
	var days = arguments[1] ? arguments[1] : 0;//设置参数days的默认值为0
	var now= new Date(); 
	now.setDate(now.getDate() + days);
	var timeStr=now.Format(format);
	return timeStr
}


function getXAxis(comp,depart,line){
	if(comp=='all'){
		return "comp";
	}
	else if(depart=='all'){
		return "depart";
	}
	else if(depart!='all'){
		return "line";
	}
}

function getDeptName(deptCode){
	if(deptCode=='100001'){
		return "生产一部";
	}
	else if(deptCode=='100002'){
		return "生产二部";
	}
	else if(deptCode=='100003'){
		return "生产三部";
	}
	return deptCode;
}








