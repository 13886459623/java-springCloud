package com.ycb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ycb.domain.messageAB;
import com.ycb.domain.messageABExample;
import com.ycb.mapper.messageABMapper;

/**
 * 
 * 报警信息
 * @author Administrator
 *
 */
@Service
@Transactional
public class MessageService {
	@Autowired
	private messageABMapper messageabmapper;

	/**
	 * 
	 * 更新报警信息
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
	public int updateByExampleSelective(messageAB record,messageABExample example){
		
		return messageabmapper.updateByExampleSelective(record, example);
	}
	

	
}
