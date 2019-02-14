package com.ycb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycb.domain.details_list;
import com.ycb.domain.details_listExample;
import com.ycb.mapper.details_listMapper;

@Service
@Transactional
public class details_listService {
	@Autowired
	private details_listMapper details_listMapper;

	
	public List<details_list> selectByExample(details_listExample example){
		return details_listMapper.selectByExample(example);
	}
	
	/**
	 *	分页
	 * @param params      查询条件
	 * @param currentPage 当前页码
	 * @param pageSize    每页记录数
	 * @return            
	 */
	public List<details_list> findList(Map<String,Object> params,int cPage,int pSize){
		return details_listMapper.findList(params,cPage,pSize);
	}
	
	
	public int selectBycount (Map<String,Object> params){
		return details_listMapper.selectBycount(params);
	}
	
	
	
	/**
	 * 删除 根据传入值删除
	 * @param example
	 * @return
	 */
	public int deleteByExample(details_listExample example) {
		return details_listMapper.deleteByExample(example);
	}
	
	
}