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
public class EfficController {
	
	@Autowired
    RestTemplate restTemplate;
	
	@Value("${aksapserver}")
    private String aksapserver;
	
	@RequestMapping(value="/effic/get-supplier", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getSupplier(
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime,
			@RequestParam(name = "endTime") String endTime) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("company", company);
		requestEntity.add("product", product);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-supplier", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	/**
	 * 当期效率分布
	 */
	@RequestMapping(value="/effic/fb-view")
	public String fbView(){
		return "effic/fb-view";
	}

	/**
	 * 当期效率分布数据
	 * @param countType   统计类型(当前：dq,同比：tb,趋势：qs)
	 * @param company     公司
	 * @param depart      部门
	 * @param line        产线
	 * @param product     产品
	 * @param dateType    统计范围(年：year, 月：month, 日：date)
	 * @param startTime   开始日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param endTime     结束日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param viewType
	 * @return
	 */
	@RequestMapping(value="/effic/get-data")
	@ResponseBody
	public AjaxObject getEfficData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
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
		requestEntity.add("supplier", supplier);
		requestEntity.add("viewType", viewType);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-data", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	
	/**
	 * 当期级别分布
	 */
	@RequestMapping(value="/effic/gradefb-view")
	public String gradeFBView(){
		return "effic/gradefb-view";
	}

	/**
	 * 当期级别分布数据
	 * @param countType   统计类型(当前：dq,同比：tb,趋势：qs)
	 * @param company     公司
	 * @param depart      部门
	 * @param line        产线
	 * @param product     产品
	 * @param dateType    统计范围(年：year, 月：month, 日：date)
	 * @param startTime   开始日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param endTime     结束日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param viewType
	 * @return
	 */
	@RequestMapping(value="/effic/get-grade-data")
	@ResponseBody
	public AjaxObject getGradeData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
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
		requestEntity.add("supplier", supplier);
		requestEntity.add("viewType", viewType);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-grade-data", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	/**
	 * 某档位效率趋势图
	 */
	@RequestMapping(value="/effic/qs-view")
	public String qsView(){
		return "effic/qs-view";
	}
	
	@RequestMapping(value="/effic/get-qs-data", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AjaxObject getEfficQSData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dw") String dw,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
			@RequestParam(name = "viewType", required = false, defaultValue = "view") String viewType) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("countType", countType);
		requestEntity.add("company", company);
		requestEntity.add("depart", depart);
		requestEntity.add("line", line);
		requestEntity.add("product", product);
		requestEntity.add("dw", dw);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("supplier", supplier);
		requestEntity.add("viewType", viewType);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-qs-data", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	
	/**
	 * 当期效率分布
	 */
	@RequestMapping(value="/effic/new-fb-view")
	public String newFbView(){
		return "effic/new-fb-view";
	}

	/**
	 * 转换效率分析数据
	 * @param countType   统计类型(当前：dq,同比：tb,趋势：qs)
	 * @param company     公司
	 * @param depart      部门
	 * @param line        产线
	 * @param product     产品
	 * @param dateType    统计范围(年：year, 月：month, 日：date)
	 * @param startTime   开始日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param endTime     结束日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param viewType
	 * @return
	 */
	@RequestMapping(value="/effic/get-new-data")
	@ResponseBody
	public AjaxObject getNewEfficData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name="dimension",required=false,defaultValue="organization") String dimension,
			@RequestParam(name = "company", required = false, defaultValue = "all") String company,
			@RequestParam(name = "factory", required = false, defaultValue = "all") String factory,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name="grade",required=false,defaultValue="A") String grade,
			@RequestParam(name="dw",required=false) String dw,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
			@RequestParam(name = "datasource", required = false, defaultValue = "sap") String datasource,
			@RequestParam(name = "supplicat", required = false) String supplicat,
			@RequestParam(name = "productView", required = false, defaultValue = "all") String productView,
			@RequestParam(name = "productAttribute", required = false, defaultValue = "all") String productAttribute,
			@RequestParam(name = "workOrderType", required = false, defaultValue = "all") String workOrderType) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("countType", countType);
		requestEntity.add("dimension", dimension);
		requestEntity.add("company", company);
		requestEntity.add("factory", factory);
		requestEntity.add("depart", depart);
		requestEntity.add("line", line);
		requestEntity.add("product", product);
		requestEntity.add("dw", dw);
		requestEntity.add("grade", grade);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("supplier", supplier);
		requestEntity.add("datasource", datasource);
		requestEntity.add("supplicat", supplicat);
		requestEntity.add("productView", productView);
		requestEntity.add("productAttribute", productAttribute);
		requestEntity.add("workOrderType", workOrderType);
		
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-new-datav3", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
	
	/**
	 * 当期级别分布(new)
	 */
	@RequestMapping(value="/effic/new-gradefb-view")
	public String newGradeFBView(){
		return "effic/new-gradefb-view";
	}

	/**
	 * 级别分布数据(new)
	 * @param countType   统计类型(当前：dq,同比：tb,趋势：qs)
	 * @param company     公司
	 * @param depart      部门
	 * @param line        产线
	 * @param product     产品
	 * @param dateType    统计范围(年：year, 月：month, 日：date)
	 * @param startTime   开始日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param endTime     结束日期(年：2017, 月：2017-05, 日：2017-05-25)
	 * @param viewType
	 * @return
	 */
	@RequestMapping(value="/effic/get-newgrade-data")
	@ResponseBody
	public AjaxObject getNewGradeData(
			@RequestParam(name = "countType", required = false, defaultValue = "dq") String countType,
			@RequestParam(name = "company", required = false, defaultValue = "1000") String company,
			@RequestParam(name = "factory", required = false, defaultValue = "all") String factory,
			@RequestParam(name = "depart", required = false, defaultValue = "all") String depart,
			@RequestParam(name = "line", required = false, defaultValue = "all") String line,
			@RequestParam(name = "product", required = false, defaultValue = "all") String product,
			@RequestParam(name = "dateType", required = false, defaultValue = "date") String dateType,
			@RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime,
			@RequestParam(name = "supplier", required = false, defaultValue = "all") String supplier,
			@RequestParam(name = "viewType", required = false, defaultValue = "view") String viewType,
			@RequestParam(name="grade",required=false,defaultValue="all") String grade,
			@RequestParam(name="dimension",required=false,defaultValue="organization") String dimension) {
		AjaxObject returnVal = null;
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("countType", countType);
		requestEntity.add("company", company);
		requestEntity.add("factory", factory);
		requestEntity.add("depart", depart);
		requestEntity.add("line", line);
		requestEntity.add("product", product);
		requestEntity.add("dateType", dateType);
		requestEntity.add("startTime", startTime);
		requestEntity.add("endTime", endTime);
		requestEntity.add("supplier", supplier);
		requestEntity.add("viewType", viewType);
		requestEntity.add("grade", grade);
		requestEntity.add("dimension", dimension);
		try {
			returnVal = restTemplate.postForObject(aksapserver + "/effic/get-newgrade-datav3", requestEntity, AjaxObject.class);
		} catch (Throwable e) {

		}
		if (returnVal == null) {
			returnVal = new AjaxObject();
		}
		return returnVal;
	}
}
