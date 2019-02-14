package com.ycb.mapper;

import com.ycb.domain.messageAB;
import com.ycb.domain.messageABExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface messageABMapper {
    int insert(messageAB record);

    int insertSelective(messageAB record);

    List<messageAB> selectByExample(messageABExample example);

    int updateByExampleSelective(@Param("record") messageAB record, @Param("example") messageABExample example);

    int updateByExample(@Param("record") messageAB record, @Param("example") messageABExample example);
}