package com.ycb.mapper;

import com.ycb.domain.config_a;
import com.ycb.domain.config_b;

import java.util.List;
import java.util.Map;

public interface config_bMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(config_b record);

    int insertSelective(config_b record);

    config_b selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Map<String,Object> map);

    int updateByPrimaryKey(config_b record);

    List<config_b> getConfigBList(Map<String, Object> params);

    int getConfigBCount();

    List<config_b> getBvariables();

    int updateProductSwitch(Map<String,Object> map);

    List<config_b> getConfigBproduct();
}