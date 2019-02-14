//js日期比较(yyyy-mm-dd)
function compDay(a, b) {
	var arr = a.split("-");
	var starttime = new Date(arr[0], arr[1], arr[2]);
	var starttimes = starttime.getTime();

	var arrs = b.split("-");
	var lktime = new Date(arrs[0], arrs[1], arrs[2]);
	var lktimes = lktime.getTime();

	if (starttimes >= lktimes) {

		alert('开始时间大于结束时间，请检查！');
		return false;
	} else
		return true;

}

//js时间比较(yyyy-mm-dd hh:mi:ss)

function comptime(beginTime, endTime) {
	var a = (Date.parse(endTime) - Date.parse(beginTime)) / 3600 / 1000;
	if (a < 0) {
		return -1;
	} else if (a > 0) {
		return 1;
	} else if (a == 0) {
		return 0;
	} else {
		return 'exception'
	}
}

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) { //author: meizz 
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds()
	//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

//计算两个日期天数差的函数，通用
////////////////////////////////////////////////////////////////////////////////////////////
function DateDiff(sDate1, sDate2) { //sDate1和sDate2是yyyy-MM-dd格式
	var aDate, oDate1, oDate2, iDays;
	aDate = sDate1.split("-");
	oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]); //转换为yyyy-MM-dd格式
	aDate = sDate2.split("-");
	oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
	//iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
	iDays = parseInt((oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
	return iDays; //返回相差天数
}

//日期，在原有日期基础上，增加days天数，默认增加1天
function addDate(date, days) {
	if (days == undefined || days == '') {
		days = 1;
	}
	var date = new Date(date);
	date.setDate(date.getDate() + days);
	var month = date.getMonth() + 1;
	var day = date.getDate();
	return date.getFullYear() + '-' + getFormatDate(month) + '-'
			+ getFormatDate(day);
}

//日期，在原有日期基础上,增加月份数,跳到每月的1号
function addMonth(date, months) {
	if (months == undefined || months == '') {
		months = 1;
	}
	var date = new Date(date);
	date.setDate(1);
	date.setMonth(date.getMonth() + months);
	var month = date.getMonth() + 1;
	var day = date.getDate();
	return date.getFullYear() + '-' + getFormatDate(month) + '-'
			+ getFormatDate(day);
}

// 日期月份/天的显示，如果是1位数，则在前面加上'0'
function getFormatDate(arg) {
	if (arg == undefined || arg == '') {
		return '';
	}

	var re = arg + '';
	if (re.length < 2) {
		re = '0' + re;
	}

	return re;
}
//

//+---------------------------------------------------  
//| 获取日期间的所有日期
//+---------------------------------------------------  
function getDays(DateOne, DateTwo) {
	var listday = [];
	if (DateOne == DateTwo) {//只有一天
		listday.push(DateOne);
		return listday;
	}

	var getDate = function(str) {

		var tempDate = new Date();
		var list = str.split("-");
		tempDate.setFullYear(list[0]);
		tempDate.setMonth(list[1] - 1);
		tempDate.setDate(list[2]);

		return tempDate;
	}
	var date1 = getDate(DateOne);
	var date2 = getDate(DateTwo);

	if (date1 > date2) {
		var tempDate = date1;
		date1 = date2;
		date2 = tempDate;
	}

	/*listday.push(DateOne);
	if (DateOne != DateTwo) {
		listday.push(DateTwo);
	}
	date1.setDate(date1.getDate() + 1);*/
	while (!(date1.getFullYear() == date2.getFullYear()&& date1.getMonth() == date2.getMonth() 
			&& date1.getDate() == date2.getDate())) {
		listday.push(date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-"+ date1.getDate());
		date1.setDate(date1.getDate() + 1);
	}

	return listday;
}


//+---------------------------------------------------  
//| 获取日期间的所有月
//+---------------------------------------------------  
function getMonths(DateOne, DateTwo) {

	var listmonth = [];
	if (DateOne == DateTwo) {//只有一天
		listmonth.push(DateOne);
		return listmonth;
	}

	var getMonth = function(str) {

		var tempDate = new Date();
		var list = str.split("-");
		tempDate.setFullYear(list[0]);
		tempDate.setMonth(list[1] - 1);

		return tempDate;
	}
	var date1 = getMonth(DateOne);
	var date2 = getMonth(DateTwo);

	if (date1 > date2) {
		var tempDate = date1;
		date1 = date2;
		date2 = tempDate;
	}

	listmonth.push(DateOne);
	if (DateOne != DateTwo) {
		listmonth.push(DateTwo);
	}
	date1.setMonth(date1.getMonth() + 1);
	while (!(date1.getFullYear() == date2.getFullYear()
			&& date1.getMonth() == date2.getMonth())) {
		listmonth.push(date1.getFullYear() + "-" + (date1.getMonth() + 1));
		date1.setMonth(date1.getMonth() + 1);
	}

	return listmonth;
}

//+---------------------------------------------------  
//| 获取日期间的所有月
//+---------------------------------------------------  
function getYears(DateOne, DateTwo) {

	var listyear = [];
	if (DateOne == DateTwo) {//只有一天
		listyear.push(DateOne);
		return listyear;
	}

	var getYear = function(str) {

		var tempDate = new Date();
		var list = str.split("-");
		tempDate.setFullYear(list[0]);

		return tempDate;
	}
	var date1 = getFullYear(DateOne);
	var date2 = getFullYear(DateTwo);

	if (date1 > date2) {
		var tempDate = date1;
		date1 = date2;
		date2 = tempDate;
	}

	listyear.push(DateOne);
	if (DateOne != DateTwo) {
		listyear.push(DateTwo);
	}
	date1.setFullYear(date1.getMonth() + 1);
	while (!(date1.getFullYear() == date2.getFullYear())) {
		listyear.push(date1.getFullYear());
		date1.setFullYear(date1.getFullYear() + 1);
	}

	return listyear;
}