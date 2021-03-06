package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.halm_a;
import com.ycb.mapper.halm_aMapper;

@Service
@Transactional
public class HalmaService {
	@Autowired
	private halm_aMapper halm_amapper;

	/**
	 * 
	 * 统计时间内的故障数量
	 * @param params
	 * @return
	 */
	public List<halm_a> getTtimeList(Map<String,Object> params){
		
		return halm_amapper.getTtimeList(params);
	}
	

	
}
