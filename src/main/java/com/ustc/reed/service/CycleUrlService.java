package com.ustc.reed.service;


import com.ustc.reed.exception.InternalException;
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

    public Integer updateCycleUrl(String cycleUrl,Integer id){
        return cycleUrlMapper.updateCycleUrl(cycleUrl,id);
    }

    public Integer deleteCycleUrlById(Integer id){
        return cycleUrlMapper.deleteCycleUrlById(id);
    }

    @Cacheable(cacheNames ={"home"} ,key = "'getCycleUrlList'")
    public List<String> getCycleUrlList(){
        List<String> list = null;
        try {
            list = cycleUrlMapper.findCycleUrlList();
        } catch (Exception e) {
            throw new InternalException("findCycleUrlList error");
        }
           return list;
    }
}
