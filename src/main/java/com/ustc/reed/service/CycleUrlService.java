package com.ustc.reed.service;


import com.ustc.reed.exception.InternalException;
import com.ustc.reed.mapper.CycleUrlMapper;
import com.ustc.reed.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CycleUrlService {

    @Autowired
    private CycleUrlMapper cycleUrlMapper;

    @CacheEvict(cacheNames ={"home"} ,key = "'getCycleUrlList'")
    public Integer addCycleUrl(String url){
        return cycleUrlMapper.addCycleUrl(url);
    }

    @CacheEvict(cacheNames ={"home"} ,key = "'getCycleUrlList'")
    public Integer updateCycleUrl(String cycleUrl,Integer id){
        return cycleUrlMapper.updateCycleUrl(cycleUrl,id);
    }

    @Transactional
    @CacheEvict(cacheNames ={"home"} ,key = "'getCycleUrlList'")
    public Boolean deleteCycleUrlById(Integer id,String cycleUrl){

        cycleUrl = cycleUrl.replace("image","home/pic");

        FileUtils.deleteServerFile(cycleUrl);
        cycleUrlMapper.deleteCycleUrlById(id);
        return true;
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
