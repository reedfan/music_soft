package com.ustc.reed.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper

public interface CycleUrlMapper {
    List<String> findCycleUrlList();
    Integer addCycleUrl(String cycleUrl);
}
