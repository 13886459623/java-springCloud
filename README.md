# java-springCloud
springCloud项目部分代码 a

package com.aiko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aiko.common.ajax.AjaxObject;

import ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter;

@Controller
public class MaterialController {
	
	@Autowired
    RestTemplate restTemplate;
	
	@Value("${aksapserver}")
    private String aksapserver;
	
	@Value("${akmesserver}")
	private String akmesserver;
	
	/**
	 * 原材料合格率页面
	 */
	@RequestMapping(value="/material/qualifyRate-view")
	public String blNewView(){
		return "material/qualifyRate-view";
	}
	
	/**
	 * 原材料合格率
	 */
	@RequestMapping(value="/material/getIQCdata", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getABRukeData(
			@RequestParam(name = "dimension", required = false, defaultValue = "organization") String dimension,
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "viewType", required = false, defaultValue = "view") String viewType,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
			@RequestParam(name = "part", required = false, defaultValue = "all") String part,
			@RequestParam(name = "partNo", required = false, defaultValue = "all") String partNo,
			@RequestParam(name = "batchNo", required = false, defaultValue = "all") String batchNo
			){
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("dimension", dimension);
		requestEntity.add("countType", countType);
		requestEntity.add("company", company);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("viewType", viewType);
		requestEntity.add("supplier", supplier);
		requestEntity.add("part", part);
		requestEntity.add("partNo", partNo);
		requestEntity.add("batchNo", batchNo);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/materialRate/getIQCdata", requestEntity, AjaxObject.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	@RequestMapping(value="/material/getPartNoAndBatchNo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getSupplier(
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime,
			@RequestParam(name = "endTime") String endTime) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		try {
			returnVal = restTemplate.postForObject(akmesserver + "/mes/getIQCdata", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
}
