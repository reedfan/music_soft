package com.ustc.reed.mapper;

import com.ustc.reed.pojo.DtCate;
import com.ustc.reed.pojo.DtUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * created by reedfan on 2019/9/26 0026
 */
@MapperScan
@Mapper

public interface CateMapper {

    List<DtCate> findCate();

    List<DtCate> findCateList(@Param("offSet") int offSet, @Param("limit") int limit);

    Integer findCateListCount();
}
