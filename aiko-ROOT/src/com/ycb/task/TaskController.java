package com.ycb.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ycb.controller.PCController;
import com.ycb.domain.Alarm_a;
import com.ycb.domain.Alarm_b;
import com.ycb.domain.halm_a;
import com.ycb.domain.halm_b;
import com.ycb.domain.messageAB;
import com.ycb.domain.messageABExample;
import com.ycb.domain.messageABExample.Criteria;
import com.ycb.domain.restart_message;
import com.ycb.service.AlarmaService;
import com.ycb.service.AlarmbService;
import com.ycb.service.HalmaService;
import com.ycb.service.HalmbService;
import com.ycb.service.MessageService;
import com.ycb.service.RestartService;

import chinapay.util.DateUtil;

/**
 * 
 * 定时器
 * @author Administrator
 *
 */
@Component
public class TaskController {
	private Logger log = Logger.getLogger(PCController.class);
	
	/**
	 * A线 AI结果信息
	 */
	@Autowired
	private HalmaService HalmaService;
	
	
	/**
	 * B线 AI结果信息
	 */
	@Autowired
	private HalmbService HalmbService;
	
	/**
	 *报警信息 
	 */
	@Autowired
	private MessageService messageservice;
	
	/**
	 *软件重启
	 */
	@Autowired
	private RestartService restartservice;
	
	/**
	 *报警配置A
	 */
	@Autowired
	private AlarmaService alarmaservice;
	
	/**
	 *报警配置B
	 */
	@Autowired
	private AlarmbService alarmbservice;
	
    /**
     * 
     *A线 统计数据库，2分钟内的数据，根据规则一次判断 满足要求，则报警写入数据库
     * 
     * 定时器 间隔一秒执行
     * 
     */
    @Scheduled(cron = "0/10 * * * * ? ") // 间隔10秒执行
    private void taskA() {
    	Map<String, Object> map=new HashMap<String, Object>();
    	try {
        	//初始化参数	
        	String startTime=DateUtil.getCurDateTime();
        	Map<String, Object> keymap=new HashMap<String, Object>();
        	keymap.put("key", "sumtime");
        	List<Alarm_a> Alarma=alarmaservice.getKeyByvalue(keymap);
        	String endTime=DateUtil.getTheminute(Alarma.get(0).getPzValue()==null?2:Alarma.get(0).getPzValue());//默认 2
        	map.put("startTime",startTime);
    		map.put("endTime",endTime);
/*    		map.put("startTime", "2019-01-11 15:08:53");
    		map.put("endTime", "2019-01-11 15:10:53");*/
    		//软件重启报警
    		List<restart_message> restart=restartservice.getTtimeList(map);
    		restartA(restart);
    		//故障报警
    		List<halm_a> list=HalmaService.getTtimeList(map);
    		AlarmrulesA(list);
    		log.info("定时任务==============A线============taskA   已执行["+startTime+"]========");
		} catch (Exception e) {
			log.error("定时任务==============A线============taskA    error      "+e);
		}
    	
    }
    
   
    
    /**
     * 
     *B线 统计数据库，2分钟内的数据，根据规则一次判断 满足要求，则报警写入数据库
     * 
     * 定时器 间隔一秒执行
     * 
     */
    @Scheduled(cron = "0/10 * * * * ? ") // 间隔10秒执行
    private void taskB() {
    	Map<String, Object> map=new HashMap<String, Object>();
    	try {
        	//初始化参数	
        	String startTime=DateUtil.getCurDateTime();
           	Map<String, Object> keymap=new HashMap<String, Object>();
        	keymap.put("key", "sumtime");
        	List<Alarm_b> Alarmb=alarmbservice.getKeyByvalue(keymap);
        	String endTime=DateUtil.getTheminute(Alarmb.get(0).getPzValue()==null?2:Alarmb.get(0).getPzValue());//默认 2
        	map.put("startTime",startTime);
    		map.put("endTime",endTime);
/*    		map.put("startTime", "2019-01-11 15:08:53");
    		map.put("endTime", "2019-01-11 15:10:53");*/
    		//软件重启报警
    		List<restart_message> restart=restartservice.getTtimeList(map);
    		restartB(restart);
    		//故障报警
    		List<halm_b> list=HalmbService.getTtimeList(map);
    		AlarmrulesB(list);
    		log.info("定时任务==============B线============taskB   已执行["+startTime+"]========");
		} catch (Exception e) {
			log.error("定时任务==============B线============taskB    error      "+e);
		}
    	
    }    
    
    
    /**
     * 
     * 报警规则逻辑
     * @param list
     */
    private void AlarmrulesA(List<halm_a> list) {
    	try {
    		
    		List<Alarm_a> Alarma=alarmaservice.getKeyList();
    		for(halm_a a : list) {
    			for(Alarm_a Alarm:Alarma) {
    				if(a.getResult().equals(Alarm.getPzKey()) && Double.parseDouble(a.getResultAll().toString())>Alarm.getPzValue()) {
    					update("A", Alarm.getPzContent(), "1");
    					break;
    				}
    			}
    		}
/*    		for(halm_a a : list) {
    			
    		 if("隐裂".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>4) {
    			 update("A", "隐裂故障", "1");
    			 break;
    		}
    		 else if("划痕".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>5) {
    			
    			 update("A", "划痕故障", "1");
    			 break;
    		}
    		 
    		 else if("黑斑黑点".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>6) {
    			 update("A", "黑斑黑点故障", "1");
    			 break;
     			
     		}
    		 else if("断栅".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>7) {
    			 update("A", "断栅故障", "1");
    			 break;
     			
     		}
    		 
    		else if("印刷偏移".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>8) {
    			 update("A", "印刷偏移故障", "1");
    			 break;
    			
    		}
    		else if("雾状发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>9) {
    			 update("A", "雾状发黑故障", "1");
    			 break;
    		}
    		 
    		else if("气流片".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>10) {
    			 update("A", "气流片故障", "1");
    			 break;
    		}
    		else if("皮带印滚轮印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>11) {
    			 update("A", "皮带印滚轮印故障", "1");
    			 break;
    		}
    		else if("吸球印吸盘印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>=12) {
    			 update("A", "吸球印吸盘印故障", "1");
    			 break;
    		}else if("舟框印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>13) {
    			 update("A", "舟框印故障", "1");
    			 break;
    		}
    		else if("黑边".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>14) {
    			 update("A", "黑边故障", "1");
    			 break;
    		}
    		else if("水印手指印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>15) {
    			 update("A", "水印手指印故障", "1");
    			 break;
    		}
    		else if("同心圆发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>16) {
    			 update("A", "同心圆发黑故障", "1");
    			 break;
    		}else if("四角发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>17) {
    			 update("A", "四角发黑故障", "1");
    			 break;
    		}
    		else if("未知大故障".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>18) {
    			 update("A", "未知大故障故障", "1");
    			 break;
    		}
    		else if("边界".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>19) {
    			 update("A", "边界故障", "1");
    			 break;
    		}
    	}	*/ 	 
    		
		} catch (Exception e) {
			log.error("A线   规则报警==========================AlarmrulesA    error      :"+e);
		}
    }
    
    /**
     * 
     * B线报警规则逻辑
     * @param list
     */
    private void AlarmrulesB(List<halm_b> list) {
    	try {
      		List<Alarm_b> Alarma=alarmbservice.getKeyList();
    		for(halm_b b : list) {
    			for(Alarm_b Alarm:Alarma) {
    				if(b.getResult().equals(Alarm.getPzKey()) && Double.parseDouble(b.getResultAll().toString())>Alarm.getPzValue()) {
    					update("B", Alarm.getPzContent(), "1");
    					break;
    				}
    			}
    		}
    		/*for(halm_b a : list) {
    			
    			
    		 if("隐裂".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>4) {
    			 update("B", "隐裂故障", "1");
    			 break;
    		}
    		 else if("划痕".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>5) {
    			
    			 update("B", "划痕故障", "1");
    			 break;
    		}
    		 
    		 else if("黑斑黑点".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>6) {
    			 update("B", "黑斑黑点故障", "1");
    			 break;
     			
     		}
    		 else if("断栅".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>7) {
    			 update("B", "断栅故障", "1");
    			 break;
     			
     		}
    		 
    		else if("印刷偏移".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>8) {
    			 update("B", "印刷偏移故障", "1");
    			 break;
    			
    		}
    		else if("雾状发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>9) {
    			 update("B", "雾状发黑故障", "1");
    			 break;
    		}
    		 
    		else if("气流片".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>10) {
    			 update("B", "气流片故障", "1");
    			 break;
    		}
    		else if("皮带印滚轮印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>11) {
    			 update("B", "皮带印滚轮印故障", "1");
    			 break;
    		}
    		else if("吸球印吸盘印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>=12) {
    			 update("B", "吸球印吸盘印故障", "1");
    			 break;
    		}else if("舟框印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>13) {
    			 update("B", "舟框印故障", "1");
    			 break;
    		}
    		else if("黑边".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>14) {
    			 update("B", "黑边故障", "1");
    			 break;
    		}
    		else if("水印手指印".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>15) {
    			 update("B", "水印手指印故障", "1");
    			 break;
    		}
    		else if("同心圆发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>16) {
    			 update("B", "同心圆发黑故障", "1");
    			 break;
    		}else if("四角发黑".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>17) {
    			 update("B", "四角发黑故障", "1");
    			 break;
    		}
    		else if("未知大故障".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>18) {
    			 update("B", "未知大故障故障", "1");
    			 break;
    		}
    		else if("边界".equals(a.getResult()) && Double.parseDouble(a.getResultAll().toString())>19) {
    			 update("B", "边界故障", "1");
    			 break;
    		}
    	}	 	 */
    		
		} catch (Exception e) {
			log.error("B线     规则报警==========================AlarmrulesB    error      :"+e);
		}
    }
    /**
     * 
     * 软件重启报警
     * @param list
     */
    private void restartA(List<restart_message> list) {
    	try {
    		List<Alarm_a> Alarma=alarmaservice.getKeyList();
    		for(restart_message a : list) {
    			
    			for(Alarm_a Alarm:Alarma) {
    				if(a.getExename().equals(Alarm.getPzKey()) && a.getCount()>Alarm.getPzValue()) {
    					update("A", Alarm.getPzContent(), "1");
    					break;
    				}
    			}
/*    		 if("watchA".equals(a.getExename()) && a.getCount()>10) {
    			 update("A", "监控软件连续重启中", "1");
    			 break;
    		}
    		else if("yuceA".equals(a.getExename()) && a.getCount()>5) {
    			 update("A", "算法连续重启中", "1");
     			break;
     		}*/
    	}	 	 
    		
		} catch (Exception e) {
			log.error("restartA=====================================error      :"+e);
		}
    }
    
    
    /**
     * 
     * B线软件重启报警
     * @param list
     */
    private void restartB(List<restart_message> list) {
    	try {
      		List<Alarm_b> Alarma=alarmbservice.getKeyList();
    		for(restart_message a : list) {
    			for(Alarm_b Alarm:Alarma) {
    				if(a.getExename().equals(Alarm.getPzKey()) && a.getCount()>Alarm.getPzValue()) {
    					update("B", Alarm.getPzContent(), "1");
    					break;
    				}
    			}
    		}
    		/*if("watchB".equals(a.getExename()) && a.getCount()>10) {
    			 update("B", "监控软件连续重启中", "1");
    			 break;
    		}
    		else if("yuceB".equals(a.getExename()) && a.getCount()>5) {
    			 update("B", "算法连续重启中", "1");
     			break;
     		}*/
		} catch (Exception e) {
			log.error("restartB=====================================error      :"+e);
		}
    }

    /**
     * 更新报警信息
     * 
     * @param AB  A，B线
     * @param message 报警内容
     * @param level  报警级别，1报警，0正常
     * @throws Exception
     */
    private void update(String AB,String message,String level)throws Exception{
    	try {
    		messageAB record=new messageAB();
    		messageABExample example=new messageABExample();
    		Criteria  criteria = example.createCriteria();
    		criteria.andAiTypeEqualTo(AB);
    		record.setErrorLevel(level);
    		record.setMessage(message);
    		record.setUpdatetime(DateUtil.getCurDateTime());
    		messageservice.updateByExampleSelective(record, example);
    		log.info("=============================["+AB+"]线        更新规则报警[level："+level+"]========内容:["+message+"]====["+DateUtil.getCurDateTime()+"]");
		} catch (Exception e) { 
			log.error("定时任务    update  ["+AB+"线]   修改报警信息报错    error      :"+e);
		}
    }
    
    
    public static void main(String[] args) {
    	System.out.println(DateUtil.getCurDateTime());
    	System.out.println(DateUtil.getThsecond(30));
    	
	}
    
}