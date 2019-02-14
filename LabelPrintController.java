package com.aiko.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiko.domain.ElPrint;
import com.aiko.domain.ElPrintDetail;
import com.aiko.service.ElPrintDetailService;
import com.aiko.service.ElPrintService;

@Controller 
public class LabelPrintController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private  ElPrintService elPrintService;
	
	@Autowired
	private  ElPrintDetailService elPrintDetailService;
	
	@RequestMapping(value = "/labelPrint/index")
	public String index() {	
		return "labelPrint/index";
	}
	
	@RequestMapping(value = "/labelPrint/searchLastLabel", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void searchLastLabel(HttpServletResponse response,HttpServletRequest request) {
		Map<String,Object> paramsDetail= new HashMap<>();
		paramsDetail.put("flag", "1");
		List<ElPrint> listDetail = elPrintService.findElPrint(paramsDetail);
		String topUrl="";
		String topName="";
		String upUrl="";
		String upName="";
		String mainId="";
		String detailId="";
		String error="";
		if(listDetail.size()==0){
			Map<String,Object> params= new HashMap<>();
			List<ElPrint> list = elPrintService.findElPrint(params);
			topUrl = list.get(list.size()-1).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
			topName = list.get(list.size()-1).getPic_name();
			Map<String,Object> paramsEl= new HashMap<>();
			paramsEl.put("flag", "1");
			paramsEl.put("mainId", listDetail.get(0).getId());
		    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
		    if(elDetail.size()!=0){
				upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				upName = elDetail.get(elDetail.size()-1).getPic_name();
				mainId = listDetail.get(0).getId();
				detailId = elDetail.get(elDetail.size()-1).getId();
				error =  elDetail.get(elDetail.size()-1).getLabelType();
			}else{
				Map<String,Object> paramsElNew= new HashMap<>();
				paramsElNew.put("mainId", listDetail.get(0).getId());
				List<ElPrintDetail> elDetailNew = elPrintDetailService.findElPrintDetail(paramsElNew);
				upUrl = elDetailNew.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				upName = elDetailNew.get(0).getPic_name();
				mainId = listDetail.get(0).getId();
				detailId = elDetailNew.get(0).getId();
				error =  elDetailNew.get(0).getLabelType();
			}
		}else{
			topUrl = listDetail.get(listDetail.size()-1).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
			topName = listDetail.get(listDetail.size()-1).getPic_name();
			Map<String,Object> paramsEl= new HashMap<>();
			paramsEl.put("flag", "1");
			paramsEl.put("mainId", listDetail.get(listDetail.size()-1).getId());
			List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
			if(elDetail.size()!=0){
				upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				upName = elDetail.get(elDetail.size()-1).getPic_name();
				mainId = listDetail.get(listDetail.size()-1).getId();
				detailId = elDetail.get(elDetail.size()-1).getId();
				error =  elDetail.get(elDetail.size()-1).getLabelType();
			}else{
				Map<String,Object> paramsElNew= new HashMap<>();
				paramsElNew.put("mainId", listDetail.get(0).getId());
				List<ElPrintDetail> elDetailNew = elPrintDetailService.findElPrintDetail(paramsElNew);
				upUrl = elDetailNew.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				upName = elDetailNew.get(0).getPic_name();
				mainId = listDetail.get(listDetail.size()-1).getId();
				detailId = elDetailNew.get(0).getId();
				error =  elDetailNew.get(0).getLabelType();
			}
		}
		
		Map map = new HashMap();
		map.put("upUrl", upUrl);
		map.put("upName", upName);
		map.put("topUrl", topUrl);
		map.put("topName", topName);
		map.put("mainId", mainId);
		map.put("detailId", detailId);
		map.put("error", error);
	    response.setContentType("text/plain");
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0L);
	    PrintWriter out;
		try {
			out = response.getWriter();
			JSONObject resultJSON = JSONObject.fromObject(map);
		    String jsonpCallback = request.getParameter("jsonpCallback");
		    out.println(jsonpCallback + "(" + resultJSON.toString(1, 1) + ")");
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/labelPrint/elPrint", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void elPrint(HttpServletResponse response,HttpServletRequest request,@RequestParam(name="name", required = false) String name,@RequestParam(name="type", required = false) String type,@RequestParam(name="mainId", required = false) String mainId,@RequestParam(name="detailId", required = false) String detailId) {
		String topUrl="";
		String topName="";
		String upUrl="";
		String upName="";
		String mainIdNew="";
		String detailIdNew="";
		String error = "";
		String num="";
		if(type.equals("nextMal")){
			//下一个故障
			Map<String,Object> paramsEl= new HashMap<>();
			paramsEl.put("mainId", mainId);
			paramsEl.put("Id",Integer.valueOf(detailId)+1);
		    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
		    Map<String,Object> paramsDetail= new HashMap<>();
			paramsDetail.put("Id", mainId);
			List<ElPrint> listDetail = elPrintService.findElPrint(paramsDetail);
			topUrl = listDetail.get(0).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
			topName = listDetail.get(0).getPic_name();
			mainIdNew = listDetail.get(0).getId();
		    if(elDetail.size()!=0){
		    	upUrl = elDetail.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
				upName = elDetail.get(0).getPic_name();
				detailIdNew = elDetail.get(0).getId();
				error = elDetail.get(0).getLabelType();
		    }else{//最后一个故障
		    	Map<String,Object> paramsLast= new HashMap<>();
		    	paramsLast.put("mainId", mainId);
		    	paramsLast.put("Id",Integer.valueOf(detailId));
			    List<ElPrintDetail> elDetailLast = elPrintDetailService.findElPrintDetail(paramsLast);
			    upUrl = elDetailLast.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
				upName = elDetailLast.get(0).getPic_name();
				detailIdNew = elDetailLast.get(0).getId();
				error = elDetailLast.get(0).getLabelType();
				num="1";
		    }
		}else if(type.equals("lastMal")){
			//上一个故障
			Map<String,Object> paramsEl= new HashMap<>();
			paramsEl.put("mainId", mainId);
			paramsEl.put("Id",Integer.valueOf(detailId)-1);
		    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
		    Map<String,Object> paramsDetail= new HashMap<>();
			paramsDetail.put("Id", mainId);
			List<ElPrint> listDetail = elPrintService.findElPrint(paramsDetail);
			topUrl = listDetail.get(0).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
			topName = listDetail.get(0).getPic_name();
			mainIdNew = listDetail.get(0).getId();
		    if(elDetail.size()!=0){
		    	upUrl = elDetail.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
				upName = elDetail.get(0).getPic_name();
				detailIdNew = elDetail.get(0).getId();
				error = elDetail.get(0).getLabelType();
		    }else{//最后一个故障
		    	Map<String,Object> paramsLast= new HashMap<>();
		    	paramsLast.put("mainId", mainId);
		    	paramsLast.put("Id",Integer.valueOf(detailId));
			    List<ElPrintDetail> elDetailLast = elPrintDetailService.findElPrintDetail(paramsLast);
			    upUrl = elDetailLast.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
				upName = elDetailLast.get(0).getPic_name();
				detailIdNew = elDetailLast.get(0).getId();
				error = elDetailLast.get(0).getLabelType();
				num="1";
		    }
		}else if(type.equals("last")){
			//上一个el
			Map<String,Object> params= new HashMap<>();
			params.put("Id",Integer.valueOf(mainId)-1);
			List<ElPrint> listDetail = elPrintService.findElPrint(params);
			if(listDetail.size()!=0 && Integer.valueOf(mainId)!=1){
				topUrl = listDetail.get(listDetail.size()-1).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				topName = listDetail.get(listDetail.size()-1).getPic_name();
				mainIdNew = listDetail.get(listDetail.size()-1).getId();
				Map<String,Object> paramsEl= new HashMap<>();
				paramsEl.put("mainId", Integer.valueOf(mainId)-1);
				paramsEl.put("flag","1");
			    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
			    if(elDetail.size()!=0){
			    	upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetail.get(elDetail.size()-1).getPic_name();
					detailIdNew = elDetail.get(elDetail.size()-1).getId();
					error = elDetail.get(elDetail.size()-1).getLabelType();
			    }else{
			    	Map<String,Object> paramsElOne= new HashMap<>();
			    	paramsElOne.put("mainId", Integer.valueOf(mainId)-1);
				    List<ElPrintDetail> elDetailOne = elPrintDetailService.findElPrintDetail(paramsElOne);
				    upUrl = elDetailOne.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetailOne.get(0).getPic_name();
					detailIdNew = elDetailOne.get(0).getId();
					error = elDetailOne.get(0).getLabelType();
					
			    }
			}else{
				Map<String,Object> paramsNew= new HashMap<>();
				paramsNew.put("Id",Integer.valueOf(mainId));
				List<ElPrint> listDetailNew = elPrintService.findElPrint(paramsNew);
				topUrl = listDetailNew.get(0).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				topName = listDetailNew.get(0).getPic_name();
				mainIdNew = listDetailNew.get(0).getId();
				Map<String,Object> paramsEl= new HashMap<>();
				paramsEl.put("mainId", mainId);
				paramsEl.put("flag","1");
			    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
			    num="1";
			    if(elDetail.size()!=0){
			    	upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetail.get(elDetail.size()-1).getPic_name();
					detailIdNew = elDetail.get(elDetail.size()-1).getId();
					error = elDetail.get(elDetail.size()-1).getLabelType();
			    }else{
			    	Map<String,Object> paramsElOne= new HashMap<>();
			    	paramsElOne.put("mainId", mainId);
				    List<ElPrintDetail> elDetailOne = elPrintDetailService.findElPrintDetail(paramsElOne);
				    upUrl = elDetailOne.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetailOne.get(0).getPic_name();
					detailIdNew = elDetailOne.get(0).getId();
					error = elDetailOne.get(0).getLabelType();
			    }
			}
		}else if(type.equals("next")){
			//下一个el
			Map<String,Object> paramsAll= new HashMap<>();
			List<ElPrint> listDetaiAll = elPrintService.findElPrint(paramsAll);
			Map<String,Object> params= new HashMap<>();
			params.put("Id",Integer.valueOf(mainId)+1);
			List<ElPrint> listDetail = elPrintService.findElPrint(params);
			if(listDetail.size()!=0 && Integer.valueOf(mainId)!=listDetaiAll.size()){
				topUrl = listDetail.get(listDetail.size()-1).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				topName = listDetail.get(listDetail.size()-1).getPic_name();
				mainIdNew = listDetail.get(listDetail.size()-1).getId();
				Map<String,Object> paramsEl= new HashMap<>();
				paramsEl.put("mainId", Integer.valueOf(mainId)+1);
				paramsEl.put("flag","1");
			    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
			  
			    if(elDetail.size()!=0){
			    	upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetail.get(elDetail.size()-1).getPic_name();
					detailIdNew = elDetail.get(elDetail.size()-1).getId();
					error = elDetail.get(elDetail.size()-1).getLabelType();
			    }else{
			    	Map<String,Object> paramsElOne= new HashMap<>();
			    	paramsElOne.put("mainId", Integer.valueOf(mainId)+1);
				    List<ElPrintDetail> elDetailOne = elPrintDetailService.findElPrintDetail(paramsElOne);
				    upUrl = elDetailOne.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetailOne.get(0).getPic_name();
					detailIdNew = elDetailOne.get(0).getId();
					error = elDetailOne.get(0).getLabelType();
			    }
			}else{
				num="1";
				Map<String,Object> paramsNew= new HashMap<>();
				paramsNew.put("Id",Integer.valueOf(mainId));
				List<ElPrint> listDetailNew = elPrintService.findElPrint(paramsNew);
				topUrl = listDetailNew.get(0).getTzqt_el_path().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");;
				topName = listDetailNew.get(0).getPic_name();
				mainIdNew = listDetailNew.get(0).getId();
				Map<String,Object> paramsEl= new HashMap<>();
				paramsEl.put("mainId", mainId);
				paramsEl.put("flag","1");
			    List<ElPrintDetail> elDetail = elPrintDetailService.findElPrintDetail(paramsEl);
			    if(elDetail.size()!=0){
			    	upUrl = elDetail.get(elDetail.size()-1).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetail.get(elDetail.size()-1).getPic_name();
					detailIdNew = elDetail.get(elDetail.size()-1).getId();
					error = elDetail.get(elDetail.size()-1).getLabelType();
			    }else{
			    	Map<String,Object> paramsElOne= new HashMap<>();
			    	paramsElOne.put("mainId", mainId);
				    List<ElPrintDetail> elDetailOne = elPrintDetailService.findElPrintDetail(paramsElOne);
				    upUrl = elDetailOne.get(0).getPic_url().replace("//172.16.101.200/Image", "http:\\\\\\\\portal.aikosolar.com\\\\aiko-kpiel").replace("/", "\\\\");
					upName = elDetailOne.get(0).getPic_name();
					detailIdNew = elDetailOne.get(0).getId();
					error = elDetailOne.get(0).getLabelType();
				
			    }
			}
		}
        
		Map map = new HashMap();
		map.put("upUrl", upUrl);
		map.put("upName", upName);
		map.put("topUrl", topUrl);
		map.put("topName", topName);
		map.put("mainId", mainIdNew);
		map.put("detailId", detailIdNew);
		map.put("error", error);
		map.put("num", num);
	    response.setContentType("text/plain");
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0L);
	    PrintWriter out;
		try {
			out = response.getWriter();
			JSONObject resultJSON = JSONObject.fromObject(map);
		    String jsonpCallback = request.getParameter("jsonpCallback");
		    out.println(jsonpCallback + "(" + resultJSON.toString(1, 1) + ")");
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/labelPrint/elPrintLabel", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void elPrintLabel(HttpServletResponse response,HttpServletRequest request,@RequestParam(name="error", required = false) String error,@RequestParam(name="mainId", required = false) String mainId,@RequestParam(name="detailId", required = false) String detailId) {
		ElPrint elPrint = new ElPrint();
		elPrint.setId(mainId);
		ElPrintDetail elPrintDetail = new ElPrintDetail();
		elPrintDetail.setId(detailId);
		elPrintDetail.setLabelType(error);
		elPrintService.updateElPrint(elPrint);
		elPrintDetailService.updateElPrintDetail(elPrintDetail);
	}
	
	 public static boolean deleteFile(String fileName) {
	        File file = new File(fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else {
	            System.out.println("删除单个文件失败：" + fileName + "不存在！");
	            return false;
	        }
	    }
	 
	public static void copyFile(File fromFile,File toFile) throws IOException{
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        
        ins.close();
        out.close();
    }
	
	public static void main(String[] args) {    
       // This is the path where the file's name you want to take.    
      
        File source = new File("//192.168.0.253/设备工艺/test/EL/20180111.jpg");
		File dest = new File("//192.168.0.253/设备工艺/test/NewEL/20180111.jpg");
		
		deleteFile("//192.168.0.253/设备工艺/test/NewEL/zcy/2.jpg");
       /* try {
			copyFile(source,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
       // getFile("//192.168.0.253/设备工艺/test/EL");    
    }  


	 private static void getFile(String path){    
		         // get file list where the path has    
	        File file = new File(path);    
		        // get the folder list    
		       File[] array = file.listFiles();    
		       for(int i=0;i<array.length;i++){    
		            if(array[i].isFile()){    
		               // only take file name    
		                System.out.println("name:" + array[i].getName());  
		                // take file path and name    
		              //  System.out.println("#####" + array[i]);    
		              // take file path and name    
		              //  System.out.println("*****" + array[i].getPath());    
		           }else if(array[i].isDirectory()){    
		                getFile(array[i].getPath());    
		            }    
		         }    
		    }    


}
