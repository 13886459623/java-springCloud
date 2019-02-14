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

@Controller
public class BlProjectController {
	
	@Autowired
    RestTemplate restTemplate;
	
	@Value("${aksapserver}")
    private String aksapserver;
	
	/**
	 * B级原因分析
	 */
	@RequestMapping(value="/blproject/bl-view")
	public String qsView(){
		return "blproject/bl-view";
	}
	
	/**
	 * B级原因分析
	 */
	@RequestMapping(value="/bl-zj")
	public String blView(){
		return "blproject/bl-zj";
	}
	
	/**
	 * B级原因分析(数据加载)
	 */
	@RequestMapping(value="/blproject/data", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getBlProjectData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "viewType", required = false, defaultValue = "view") String viewType) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("countType", countType);
		requestEntity.add("company", company);
		requestEntity.add("depart", depart);
		requestEntity.add("line", line);
		requestEntity.add("product", product);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("viewType", viewType);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/blproject/data", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	@RequestMapping(value="/blproject/get-supplier", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getSupplier(
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("product", product);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/blproject/get-supplier", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	/**
	 * B级原因分析
	 */
	@RequestMapping(value="/blproject/bl-new-view")
	public String blNewView(){
		return "blproject/bl-new-view";
	}
	
	/**
	 * B级原因分析(数据加载)
	 */
	@RequestMapping(value="/blproject/new-data", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getBlProjectNewData(
			@RequestParam(name = "dimension", required = false, defaultValue = "organization") String dimension,
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "viewType", required = false, defaultValue = "view") String viewType,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
			@RequestParam(name = "buliang", required = false, defaultValue = "all") String buliang) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("dimension", dimension);
		requestEntity.add("countType", countType);
		requestEntity.add("company", company);
		requestEntity.add("depart", depart);
		requestEntity.add("line", line);
		requestEntity.add("product", product);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("viewType", viewType);
		requestEntity.add("supplier", supplier);
		requestEntity.add("buliang", buliang);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/blproject/new-data", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
}
