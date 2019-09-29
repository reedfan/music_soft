package com.ustc.reed.service;


import com.ustc.reed.mapper.CycleUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleUrlService {

    @Autowired
    private CycleUrlMapper cycleUrlMapper;

    public Integer addCycleUrl(){
        return cycleUrlMapper.addCycleUrl("www.alibaba.com");
    }

    @Cacheable(cacheNames ={"home"} ,key = "'bottomColumnList'")
    public List<String> getCycleUrlList(){
        return cycleUrlMapper.findCycleUrlList();
    }
}
