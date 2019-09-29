package com.ustc.reed.mapper;

import com.ustc.reed.pojo.TbBottomColumn;
import com.ustc.reed.pojo.TbColumnLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper
public interface ColumnLinkMapper {
    Integer addColumnLink( Integer columnType,  String columnLinkName, String columnLinkUrl);
    List<TbColumnLink> findColumnLinkList(Integer columnType);
}
