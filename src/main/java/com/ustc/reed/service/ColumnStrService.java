package com.ustc.reed.service;

import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.mapper.ColumnStrMapper;
import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.pojo.TbColumnStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by reedfan on 2019/9/29 0029
 */

@Service
public class ColumnStrService {
    @Autowired
    private ColumnStrMapper columnStrMapper;

    public List<TbColumnStr> findColumnLinkList(){

        return columnStrMapper.findColumnStrList();
    }

    public Integer addColumnLink(String columnStr){
        return columnStrMapper.addColumnStr(columnStr);
    }


}
