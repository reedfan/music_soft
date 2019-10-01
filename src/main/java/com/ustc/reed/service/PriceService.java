package com.ustc.reed.service;


import com.ustc.reed.exception.InternalException;
import com.ustc.reed.mapper.CycleUrlMapper;
import com.ustc.reed.mapper.PriceMapper;
import com.ustc.reed.pojo.TbPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceMapper priceMapper;

    public Integer addPrice(Integer period, Integer price, String version){
        return priceMapper.addPrice(period,price,version);
    }

    @Cacheable(cacheNames ={"home"} ,key = "'getPriceList'")
    public List<TbPrice> getPriceList(){
        List<TbPrice> list = null;
        try {
            list = priceMapper.findPriceList();
        } catch (Exception e) {
            throw new InternalException("getPriceList error");
        }
           return list;
    }
}
