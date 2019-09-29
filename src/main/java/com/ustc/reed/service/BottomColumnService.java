package com.ustc.reed.service;

import com.ustc.reed.mapper.BottomColumnMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BottomColumnService {
    @Autowired
    private BottomColumnMapper bottomColumnMapper;

    public Integer addBottomColumn(Integer cateId, String bottomColumn, String bottomColumnUrl){
        Integer res = bottomColumnMapper.addBottomColumn(cateId,bottomColumn,bottomColumnUrl);
        return res;
    }

}
