package com.ycb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ycb.domain.details_list;
import com.ycb.domain.details_listExample;
public interface details_listMapper {
    long countByExample(details_listExample example);

    int deleteByExample(details_listExample example);

    int insert(details_list record);

    int insertSelective(details_list record);

    List<details_list> selectByExample(details_listExample example);

    int updateByExampleSelective(@Param("record") details_list record, @Param("example") details_listExample example);

    int updateByExample(@Param("record") details_list record, @Param("example") details_listExample example);
    
	 List<details_list> findList(@Param("params") Map<String, Object> params,@Param("cPage") int cPage,@Param("pSize") int pSize);
	 
	int selectBycount(@Param("params") Map<String, Object> params);
}