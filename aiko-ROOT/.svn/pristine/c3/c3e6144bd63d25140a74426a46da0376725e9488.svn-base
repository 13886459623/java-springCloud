package com.ycb.controller.alarm;

import chinapay.util.CommonUtil;
import chinapay.util.Page;
import com.ycb.domain.Alarm_a;
import com.ycb.domain.Alarm_b;
import com.ycb.service.AlarmaService;
import com.ycb.service.AlarmbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller 
public class AlarmController {
	@Autowired
	private AlarmaService alarmaService;

	@Autowired
	private AlarmbService alarmbService;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/alarmA/alarmAList")
	@ResponseBody
	public Map<String, Object> alarmAList(HttpServletRequest request, HttpServletResponse response,int cPage,int pSize) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<>();
			Page page=new Page();
			page.setPageAndSize(cPage,pSize);
			List<Alarm_a> list = alarmaService.getAlarmAList(params,page.getCurrentPage(),page.getPageSize());
			int totals = alarmaService.getAlarmACount();
			returnMap.put("data", list);
			returnMap.put("totals",totals);
		}catch (Exception e){
			logger.error("查询数据异常:" + e);
			e.printStackTrace();
		}
		return returnMap;
	}

	@RequestMapping(value = "/alarmA/updateAlarmA", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateAlarmA(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String,Object> returnMap = new HashMap<>();
		try{
			Map<String, Object> params = CommonUtil.getParameterMap(request);
            alarmaService.updateAlarmA(params);
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			logger.info("A线报警参数修改时间:" +df.format(date));
			returnMap.put("success","success");
		}catch (Exception e){
			logger.error("A线报警更新数据异常:" + e);
			e.printStackTrace();
		}
		return returnMap;
	}

	@RequestMapping(value="/alarmB/alarmBList")
	@ResponseBody
	public Map<String, Object> alarmBList(HttpServletRequest request, HttpServletResponse response,int cPage,int pSize) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<>();
			Page page=new Page();
			page.setPageAndSize(cPage,pSize);
			List<Alarm_b> list = alarmbService.getAlarmBList(params,page.getCurrentPage(),page.getPageSize());
			int totals = alarmbService.getAlarmBCount();
			returnMap.put("data", list);
			returnMap.put("totals",totals);
		}catch (Exception e){
			logger.error("查询数据异常:" + e);
			e.printStackTrace();
		}
		return returnMap;
	}

	@RequestMapping(value = "/alarmB/updateAlarmB", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateAlarmB(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String,Object> returnMap = new HashMap<>();
		try{
			Map<String, Object> params = CommonUtil.getParameterMap(request);
			alarmbService.updateAlarmB(params);
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			logger.info("B线报警参数修改时间:" +df.format(date));
			returnMap.put("success","success");
		}catch (Exception e){
			logger.error("B线报警更新数据异常:" + e);
			e.printStackTrace();
		}
		return returnMap;
	}
}
