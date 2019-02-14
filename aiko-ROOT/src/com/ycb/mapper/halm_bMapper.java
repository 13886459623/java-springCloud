package com.ycb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ycb.domain.halm_b;

public interface halm_bMapper {
    int insert(halm_b record);

    int insertSelective(halm_b record);
    
	 List<halm_b> getTtimeList(@Param("params") Map<String, Object> params);
}