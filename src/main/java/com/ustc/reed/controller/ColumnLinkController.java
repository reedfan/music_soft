package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.service.ColumnLinkService;
import com.ustc.reed.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColumnLinkController {

    @Autowired
    private ColumnLinkService columnLinkService;

    @PostMapping("/admin/add_column_link")
    public CommonRet addColumnLink(@RequestParam(value = "columnLinkName", required = true) String columnLinkName,

                                   @RequestParam(value = "columnLinkUrl", required = true)String columnLinkUrl){
        CommonRet commonRet = new CommonRet();
        Integer res = columnLinkService.addColumnLink(columnLinkName,columnLinkUrl);
        commonRet.setData(res);
        return commonRet;
    }

//    @PostMapping("/admin/add_column_str")
//    public CommonRet addColumnStr(@RequestParam(value = "column_link_str", required = true)String columnLinkStr){
//        CommonRet commonRet = new CommonRet();
//        Integer res = columnLinkService.addColumnLink(columnLinkStr,null);
//        commonRet.setData(res);
//        return commonRet;
//    }


    @GetMapping("/api/find_column_link")
    public CommonRet findColumnLinkList(){
        CommonRet commonRet = new CommonRet();
        List<TbColumnLink> list = columnLinkService.findColumnLinkList();
        commonRet.setData(list);
        return commonRet;
    }


    @GetMapping("/api/find_top_column_link")
    public CommonRet findTopColumnLinkList(){
        CommonRet commonRet = new CommonRet();
        List<TbColumnLink> list = columnLinkService.findColumnLinkList();
        commonRet.setData(list);
        return commonRet;
    }


//    @GetMapping("/api/find_column_str")
//    public CommonRet findColumnStrList(){
//        CommonRet commonRet = new CommonRet();
//        List<TbColumnLink> list = columnLinkService.findColumnLinkList();
//        commonRet.setData(list);
//        return commonRet;
//    }





}
