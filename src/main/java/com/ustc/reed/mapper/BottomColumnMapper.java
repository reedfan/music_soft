package com.ustc.reed.mapper;

import com.ustc.reed.pojo.TbBottomColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper
public interface BottomColumnMapper {
    Integer addBottomColumn(@Param("cateId") Integer cateId, @Param("bottomColumn") String bottomColumn,@Param("bottomColumnUrl") String bottomColumnUrl);
    List<TbBottomColumn> findBottomColumnList();
}
