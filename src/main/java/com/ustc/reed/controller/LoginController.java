package com.ustc.reed.controller;


import com.google.gson.JsonObject;
import com.ustc.reed.common.CommonRet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by reedfan on 2019/9/28 0028
 */

@RestController
public class LoginController {

    @PostMapping("/login")
    public CommonRet login(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password){
        CommonRet ret = new CommonRet();
        ret.setStatus("success");

        return ret;


    }


}
