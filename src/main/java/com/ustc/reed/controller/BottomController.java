package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.service.BottomColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BottomController {
    @Autowired
    private BottomColumnService bottomColumnService;


    @GetMapping("/add_bottom_column")
    public CommonRet adminCateList(){

        CommonRet commonRet = new CommonRet();
        Integer data = bottomColumnService.addBottomColumn(1,"ustc","www.ustc.url");
        commonRet.setData(data);


        return commonRet;









    }






}
