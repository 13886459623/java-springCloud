package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.Alarm_a;
import com.ycb.domain.Alarm_b;
import com.ycb.mapper.Alarm_bMapper;

@Service
@Transactional
public class AlarmbService {
	@Autowired
	private Alarm_bMapper Alarm_bMapper;


	/**
	 * 根据key 取值
	 * @param params
	 * @return
	 */
	public List<Alarm_b> getKeyByvalue(Map<String,Object> params){
		
		return Alarm_bMapper.getKeyByvalue(params);
	}
	
	/**
	 * 
	 * 获取全部数据
	 * @return
	 */
	public List<Alarm_b> getKeyList(){
		
		return Alarm_bMapper.getKeyList();
	}

	public List<Alarm_b> getAlarmBList(Map<String,Object> map,int cPage,int pSize){
		map.put("cPage",cPage);
		map.put("pSize",pSize);
		return Alarm_bMapper.getAlarmBList(map);
	}

	public int getAlarmBCount(){
		return Alarm_bMapper.getAlarmBCount();
	}

	public void updateAlarmB(Map<String,Object> map){
		Alarm_bMapper.updateByPrimaryKeySelective(map);
	}
	
	
}
