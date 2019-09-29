package com.ustc.reed.service;

import com.ustc.reed.mapper.CateMapper;
import com.ustc.reed.pojo.DtCate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by reedfan on 2019/9/28 0028
 */

@Service
public class CateService {
    @Autowired
    private CateMapper cateMapper;

    public Integer getCateCount(){
        return cateMapper.findCateListCount();
    }

    public List<DtCate> cateList(int offSet, int limit){
        return cateMapper.findCateList(offSet,  limit);
    }


}
