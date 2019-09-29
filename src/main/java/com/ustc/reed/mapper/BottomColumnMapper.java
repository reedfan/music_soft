package com.ustc.reed.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
@Mapper
public interface BottomColumnMapper {
    Integer addBottomColumn(@Param("cateId") Integer cateId, @Param("bottomColumn") String bottomColumn,@Param("bottomColumnUrl") String bottomColumnUrl);
}
