package com.ycb.controller.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONObject;


/**
 * guoqf
 * @author Administrator
 *
 */
@RequestMapping("/rest")
@Controller
public class WebserviceController {
	private static final Logger log = LoggerFactory.getLogger(WebserviceController.class);
	//A线
	private static String  Img_base64="";
	private static  String  Img_base64_show="";
	private static String  badnesssummary_dict="";
	private static String  Img_src="";
	private static String  Img_src_show="";
	private static String  showtime="";
	//B线
	private static String  Img_base64B="";
	private static String  Img_base64_showB="";
	private static String  badnesssummary_dictB="";
	private static String  Img_srcB="";
	private static String  Img_src_showB="";
	private static String  showtimeB="";
	private static JSONObject jsonObjectA=null;
	private static JSONObject jsonObjectB=null;
	private static Map<String, Object> mapA=new HashMap<String, Object>();
	private static Map<String, Object> mapB=new HashMap<String, Object>();
	
	/**
	 * A接口测试
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/GetImgserviceA",method = RequestMethod.POST)
	@ResponseBody
	public String webserviceReportA(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String json) throws Exception{
		String sucees="success";
		long startTime = System.currentTimeMillis();
		try {
			// 解析正常json
			jsonObjectA= JSONObject.fromObject(json);
			 Img_base64 = jsonObjectA.get("Img_base64").toString();
			 Img_base64_show = jsonObjectA.get("Img_base64_show").toString();
			 badnesssummary_dict = jsonObjectA.get("badnesssummary_dict").toString();
			 Img_src = jsonObjectA.get("Img_src").toString();
			 Img_src_show = jsonObjectA.get("Img_src_show").toString();
			 showtime= jsonObjectA.get("showtime").toString();
			long endTime = System.currentTimeMillis();
			log.info("rest  GetImgserviceA  cost=[" + (endTime - startTime)+"]ms");
		} catch (Exception e) {
			sucees="fail";
			log.error("webserviceReportA  error "+e.getMessage());
			return sucees;
		}
		
		return sucees;
	}
	
	/**
	 * B接口测试
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/GetImgserviceB",method = RequestMethod.POST)
	@ResponseBody
	public String webserviceReportB(HttpServletRequest request,
			HttpServletResponse response,@RequestBody String json) throws Exception{
		String sucees="success";
		long startTime = System.currentTimeMillis();
		try {
			// 解析正常json
			jsonObjectB = JSONObject.fromObject(json);
			 Img_base64B = jsonObjectB.get("Img_base64").toString();
			 Img_base64_showB = jsonObjectB.get("Img_base64_show").toString();
			 badnesssummary_dictB = jsonObjectB.get("badnesssummary_dict").toString();
			 Img_srcB = jsonObjectB.get("Img_src").toString();
			 Img_src_showB = jsonObjectB.get("Img_src_show").toString();
			 showtimeB= jsonObjectA.get("showtime").toString();
			long endTime = System.currentTimeMillis();
			log.info("rest  GetImgserviceB  cost=[" + (endTime - startTime)+"]");
		} catch (Exception e) {
			sucees="fail";
			log.error("webserviceReportB  error "+e.getMessage());
			return sucees;
		}
		
		return sucees;
	}
	
	/**
	 * 获取A线传递过来图片参数 显示在桌面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showImageA",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showImageA(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		try {
			mapA.put("Img_base64", Img_base64);
			mapA.put("Img_base64_show", Img_base64_show);
			mapA.put("badnesssummary_dict", badnesssummary_dict);
			mapA.put("Img_src", Img_src);
			mapA.put("Img_src_show", Img_src_show);
			mapA.put("showtime", showtime);
		} catch (Exception e) {
			log.error(e.getMessage());
			mapA.put("error", e.getMessage());
			return mapA;
		}
		return mapA;
	}
	
	/**
	 * 获取B线传递过来图片参数 显示在桌面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/showImageB",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showImageB(HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			mapB.put("Img_base64", Img_base64B);
			mapB.put("Img_base64_show", Img_base64_showB);
			mapB.put("badnesssummary_dict", badnesssummary_dictB);
			mapB.put("Img_src", Img_srcB);
			mapB.put("Img_src_show", Img_src_showB);
			mapB.put("showtime", showtimeB);
		} catch (Exception e) {
			log.error(e.getMessage());
			mapB.put("error", e.getMessage());
			return mapB;
		}
		return mapB;
	}
}