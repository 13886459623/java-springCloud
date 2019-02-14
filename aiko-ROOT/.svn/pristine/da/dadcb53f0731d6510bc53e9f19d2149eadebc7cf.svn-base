package com.ycb.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.ycb.domain.Alarm_b;

public interface Alarm_bMapper {
    int insert(Alarm_b record);

    int insertSelective(Alarm_b record);
    
    List<Alarm_b> getKeyList();
    
    List<Alarm_b> getKeyByvalue(@Param("params") Map<String, Object> params);

    int updateByPrimaryKeySelective(Map<String,Object> record);

    List<Alarm_b> getAlarmBList(Map<String,Object> map);

    int getAlarmBCount();
    
}