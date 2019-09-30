package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.service.BottomColumnService;
import com.ustc.reed.service.CycleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CycleUrlController {
    @Autowired
    private CycleUrlService cycleUrlService;


    @PostMapping("/admin/add_cycle_url")
    public CommonRet addBottomColumn(){

        CommonRet commonRet = new CommonRet();
        Integer data = cycleUrlService.addCycleUrl();
        commonRet.setData(data);

        return commonRet;

    }

    @GetMapping("/api/cycle_url_list")
    public CommonRet getCycleUrlList () {
        CommonRet commonRet = new CommonRet();
        List<String> cycleUrlList = cycleUrlService.getCycleUrlList();

        commonRet.setData(cycleUrlList);
        return commonRet;
    }






}
