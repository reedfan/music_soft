package com.ustc.reed.mapper;


import com.ustc.reed.pojo.TbPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
@Mapper

public interface PriceMapper {
    List<TbPrice> findPriceList();
    Integer addPrice(Integer period, Integer price, String version);
}
