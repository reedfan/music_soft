package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.pojo.TbColumnStr;
import com.ustc.reed.service.ColumnLinkService;
import com.ustc.reed.service.ColumnStrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColumnStrController {


    @Autowired
    private ColumnStrService columnStrService;

    @PostMapping("/admin/add_column_str")
    public CommonRet addColumnLink(@RequestParam(value = "column_str", required = true) String columnStr){
        CommonRet commonRet = new CommonRet();
        Integer res = columnStrService.addColumnLink(columnStr);
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


    @GetMapping("/api/find_column_str")
    public CommonRet findColumnStrList(){
        CommonRet commonRet = new CommonRet();
        List<TbColumnStr> list = columnStrService.findColumnLinkList();
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
