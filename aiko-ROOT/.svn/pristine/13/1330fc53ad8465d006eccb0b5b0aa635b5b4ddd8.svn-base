package com.ycb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
		 // =============== 生成订单 交易日期 =================  
		 public static String orderDate(){
			 Date date = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			 String orderdate = sdf.format(date);
			 
			 return orderdate;
		 }
		 // =============== 生成订单 交易日期 ================= 
			
			
		 // =============== 生成订单编号 ========= 
			
			public static String orderNo(){
				SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
				Date dt = new Date();
				String OrdIdNo = "00" + sf.format(dt);
				
				return OrdIdNo;
			}	
			
		 // ================ 生成订单编号  ======== 
		
	
		//  ----------  支付参数
			public static String chinapay_MerId = "808080201309015";  // 商户号
		// public static String chinapay_OrdId = OrdIdNo;  // 订单号 
			// public static String chinapay_TransAmt = "000000000001";  // 订单金额 
		//	public static String chinapay_TransDate = orderdate;  // 交易日期
			public static String chinapay_TransType = "0001";  // 交易类型        
			public static String chinapay_CuryId = "156";  // 交易币种
			public static String chinapay_Version = "20070129";  // 版本号               
			public static String chinapay_GateId = "";  // 支付网关号
			public static String chinapay_PageRetUrl = "http://www.chzhd.com/succReturn.htm";  // 前台应答接收URL                     
			public static String chinapay_BgRetUrl = "http://www.chzhd.com/paybgresult.htm";  // 后台应答接收URL                   
			public static String chinapay_Priv1 = "";  // 商户私有域   
		//  ----------  支付参数
	
}
