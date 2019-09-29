package com.ustc.reed.controller;

import com.ustc.reed.pojo.DtCate;
import com.ustc.reed.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CateController {

    @Autowired
    private CateService cateService;

    /**
     * 以前的http://xiaobai.jikewangluo.cn/renwu/admincatelistajax
     * @param page
     * @return
     */
    @GetMapping("/cateList")
    public Map<String, Object> adminCateList(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "5") Integer count){
        Map<String, Object> map = new HashMap<>();
        int totalCount = cateService.getCateCount();
        List<DtCate> cateList = cateService.cateList(page,count);
        map.put("totalCount",totalCount);
        map.put("cateList",cateList);
        return map;

    }


}
