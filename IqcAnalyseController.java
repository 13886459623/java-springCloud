package com.aiko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
@Controller
public class IqcAnalyseController {
	
	@RequestMapping(value="/iqc/BadMaterialReason")
	public String kanban() {
		return "iqc/BadMaterialReason";
	}

}
