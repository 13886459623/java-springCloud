package com.aiko.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aiko.common.ajax.AjaxObject;
import com.aiko.service.ElbaddetailListService;
import com.aiko.service.ElbaddetailService;

@Controller
@RequestMapping(value="/eldetails")
public class EldetailsController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    RestTemplate restTemplate;
	
	
	@Autowired
	ElbaddetailService elbaddetailservice;
	
	@Autowired
	ElbaddetailListService elbaddetaillistservice;
	/**
	 * el页面
	 */
	@RequestMapping(value="/eldetails")
	public String elView(){
		return "eldetails/eldetails";
	}
	
	/**
	 * el分析图片加载
	 */
	@RequestMapping(value="/showImg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> getElshowData() {
		AjaxObject returnVal = new AjaxObject();
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			List<Map<String, Object>> Ellist=elbaddetailservice.findELbaddetails(params);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("Ellist", Ellist);
			return map;
		}catch (Throwable e) {
			logger.error("获取el分析图片出现异常！", e);
			returnVal.setMessage("获取el分析图片操作失败！");
		}
		return null;
	}
	
	/**
	 * el分析明细查询
	 */
	@RequestMapping(value="/ElshowList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> ElshowList(@RequestParam(name="el_bath",required=false) String el_bath) {
		AjaxObject returnVal = new AjaxObject();
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			Map<String,Object> map = new HashMap<String,Object>();
			if (el_bath!=null&&el_bath!="") {
				params.put("el_bath", el_bath);
				List<Map<String, Object>> mxList=elbaddetaillistservice.findELbaddetailsList(params);
				map.put("mxList", mxList);
			}
			return map;
		}catch (Throwable e) {
			logger.error("ElshowList  获取el分析明细出现异常！", e);
			returnVal.setMessage("获取el分析明细操作失败！");
		}
		return null;
	}
}
