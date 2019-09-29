package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.service.ColumnLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColumnLinkController {

    @Autowired
    private ColumnLinkService columnLinkService;

    @PostMapping("/admin/add_column_link")
    public CommonRet addColumnLink(Integer columnType, String columnLinkName, String columnLinkUrl){
        CommonRet commonRet = new CommonRet();
        Integer res = columnLinkService.addColumnLink(columnType,columnLinkName,columnLinkUrl);
        commonRet.setData(res);
        return commonRet;
    }



}
