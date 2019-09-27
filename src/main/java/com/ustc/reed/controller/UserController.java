package com.ustc.reed.controller;

import com.ustc.reed.pojo.DtUser;
import com.ustc.reed.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UseService useService;
    @GetMapping("/test1")
    public List<DtUser> getTasks(){
        return useService.findUserForMobile("18915228146");

    }
}
