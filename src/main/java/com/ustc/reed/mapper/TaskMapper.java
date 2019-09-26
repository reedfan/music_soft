package com.ustc.reed.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * created by reedfan on 2019/9/26 0026
 */
@MapperScan
@Mapper

public interface TaskMapper {

    Integer findTasks();
}
