package com.aiko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
@Controller
public class CommonController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    RestTemplate restTemplate;
	@Value("${aksapserver}")
    private String aksapserver;
	
	@RequestMapping(value="/common/checkGDH",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkGDH(@RequestParam(name="gongdh",required=true) String gongdh){
		MultiValueMap<String, Object> requestEntity = new LinkedMultiValueMap<String, Object>();
		requestEntity.add("gongdh", gongdh);
		String result="0";
		try {
			result = restTemplate.postForObject(aksapserver + "/common/checkGDH", requestEntity, String.class);
		} catch (Throwable e) {
			logger.error("检验工单号过程中出现异常！", e);
		}
		return result;
	}
}
