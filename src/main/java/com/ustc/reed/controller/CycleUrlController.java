package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.service.BottomColumnService;
import com.ustc.reed.service.CycleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/admin/update_cycle_url")
    public CommonRet updateBottomColumn(@RequestParam(value = "cycle_url", required = true)  String cycleUrl,

                                        @RequestParam(value = "id", required = true)Integer id){
        CommonRet commonRet = new CommonRet();
        Integer data = cycleUrlService.updateCycleUrl(cycleUrl,id);
        commonRet.setData(data);
        return commonRet;
    }

    @DeleteMapping("/admin/delete_cycle_url")
    public CommonRet deleteCycleUrlById(@RequestParam(value = "id", required = true) Integer id){
        CommonRet commonRet = new CommonRet();
        Integer data = cycleUrlService.deleteCycleUrlById(id);
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
