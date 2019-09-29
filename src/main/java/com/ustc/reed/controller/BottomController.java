package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.mapper.ColumnLinkMapper;
import com.ustc.reed.pojo.BottomColumnVO;
import com.ustc.reed.pojo.TbBottomColumn;
import com.ustc.reed.pojo.TbColumnLink;
import com.ustc.reed.service.BottomColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BottomController {
    @Autowired
    private BottomColumnService bottomColumnService;

    @Autowired
    private ColumnLinkMapper columnLinkMapper;


    @PostMapping("/add_bottom_column")
    public CommonRet addBottomColumn(

            @RequestParam(value = "bottom_column", required = true)String bottomColumn,
            @RequestParam(value = "bottom_column_url", required = true)String bottomColumnUrl){

        CommonRet commonRet = new CommonRet();
        Integer data = bottomColumnService.addBottomColumn(1,bottomColumn,"www.ustc.url");
        commonRet.setData(data);

        return commonRet;

    }

    @GetMapping("/bottom_column_list")
    public CommonRet getbottomColumnList(){
        CommonRet commonRet = new CommonRet();

        Map<String,Object> resMap = new HashMap<>();
        Map<String, List<BottomColumnVO>> map = bottomColumnService.bottomColumnList();

        List<TbColumnLink> bottomColumnList = columnLinkMapper.findColumnLinkList(2);

        resMap.put("bottomColumn",map);
        resMap.put("ColumnLink",bottomColumnList);

        commonRet.setData(resMap);
        return commonRet;
    }






}
