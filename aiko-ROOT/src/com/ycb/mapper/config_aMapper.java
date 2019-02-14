package com.ycb.mapper;

import java.util.List;
import java.util.Map;


import com.ycb.domain.config_a;

public interface config_aMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(config_a record);

    int insertSelective(config_a record);

    config_a selectByPrimaryKey(Integer id);
    
    List<config_a> getConfigAList(Map<String, Object> params);

    int updateByPrimaryKeySelective(Map<String,Object> map);

    int updateByPrimaryKey(config_a record);

    int getConfigACount();

    List<config_a> getAvariables();

    List<config_a> getConfigAproduct();

    int updateProductSwitch(Map<String,Object> map);
}