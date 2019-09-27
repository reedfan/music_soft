package com.ustc.reed.controller;

import com.ustc.reed.mapper.CateMapper;
import com.ustc.reed.pojo.DtCate;
import com.ustc.reed.pojo.DtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private CateMapper cateMapper;


    @GetMapping("/test2")
    public Integer getTasks(){
        Integer a = cateMapper.findCateListCount();
        System.out.println(a);
        return a;

    }
}
