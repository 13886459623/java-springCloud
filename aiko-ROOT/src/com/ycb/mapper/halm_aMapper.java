package com.ycb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ycb.domain.halm_a;

public interface halm_aMapper {
    int insert(halm_a record);

    int insertSelective(halm_a record);
    
	 List<halm_a> getTtimeList(@Param("params") Map<String, Object> params);
}