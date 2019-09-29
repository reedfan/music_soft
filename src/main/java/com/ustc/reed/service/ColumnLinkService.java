package com.ustc.reed.service;

import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.pojo.TbColumnLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by reedfan on 2019/9/29 0029
 */

@Service
public class ColumnLinkService {
    @Autowired
    private ColumnLinkMapper columnLinkMapper;

    public List<TbColumnLink> findColumnLinkList(Integer columnType){

        return columnLinkMapper.findColumnLinkList(columnType);
    }

    public Integer addColumnLink( Integer columnType,  String columnLinkName, String columnLinkUrl){
        return columnLinkMapper.addColumnLink(columnType,columnLinkName,columnLinkUrl);
    }
}
