package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.restart_message;
import com.ycb.mapper.restart_messageMapper;

@Service
@Transactional
public class RestartService {
	@Autowired
	private restart_messageMapper restart_messagemapper;

	/**
	 * 
	 * 统计时间内软件的重启数量
	 * @param params
	 * @return
	 */
	public List<restart_message> getTtimeList(Map<String,Object> params){
		
		return restart_messagemapper.getTtimeList(params);
	}
	

	
}
