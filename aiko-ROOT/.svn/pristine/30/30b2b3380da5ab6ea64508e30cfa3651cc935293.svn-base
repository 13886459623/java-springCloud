package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.halm_b;
import com.ycb.mapper.halm_bMapper;

@Service
@Transactional
public class HalmbService {
	@Autowired
	private halm_bMapper halm_bmapper;

	/**
	 * 
	 * 统计时间内的故障数量
	 * @param params
	 * @return
	 */
	public List<halm_b> getTtimeList(Map<String,Object> params){
		
		return halm_bmapper.getTtimeList(params);
	}
	

	
}
