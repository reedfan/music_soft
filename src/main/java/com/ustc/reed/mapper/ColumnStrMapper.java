package com.ustc.reed.mapper;

import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.pojo.TbColumnStr;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper
public interface ColumnStrMapper {
    Integer addColumnStr(String columnStr);

    List<TbColumnStr> findColumnStrList();
}
