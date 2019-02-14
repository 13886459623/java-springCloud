package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.Alarm_a;
import com.ycb.mapper.Alarm_aMapper;

@Service
@Transactional
public class AlarmaService {
	@Autowired
	private Alarm_aMapper alarm_amapper;


	/**
	 * 根据key 取值
	 * @param params
	 * @return
	 */
	public List<Alarm_a> getKeyByvalue(Map<String,Object> params){
		
		return alarm_amapper.getKeyByvalue(params);
	}
	
	/**
	 * 
	 * 获取全部数据
	 * @return
	 */
	public List<Alarm_a> getKeyList(){
		
		return alarm_amapper.getKeyList();
	}

	public List<Alarm_a> getAlarmAList(Map<String,Object> map,int cPage,int pSize){
        map.put("cPage",cPage);
        map.put("pSize",pSize);
	    return alarm_amapper.getAlarmAList(map);
    }

    public int getAlarmACount(){
        return alarm_amapper.getAlarmACount();
    }

    public void updateAlarmA(Map<String,Object> map){
        alarm_amapper.updateByPrimaryKeySelective(map);
    }
	
}
