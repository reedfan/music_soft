package com.ustc.reed.controller;

/**
 * created by reedfan on 2019/9/28 0028
 *
 * /**
 * 超级管理员专属Controller
 */

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.TbSysAdmin;
import com.ustc.reed.pojo.TbSysUser;
import com.ustc.reed.service.SysAdminService;
import com.ustc.reed.service.SysUserService;
import com.ustc.reed.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/api/login")
    public CommonRet sysUserLogin( @RequestParam(value = "phone_number", required = true) String phoneNumber,
                                          @RequestParam(value = "pass_word", required = true) String passWord) {
        CommonRet commonRet = new CommonRet();
        TbSysUser sysUser = sysUserService.selectSysUserByPhoneNumber(phoneNumber, passWord);
        if(sysUser == null){
            commonRet.setSuccess(false);
            commonRet.setMessage("用户名密码不匹配");
            return commonRet;
        }
        commonRet.setData(sysUser);
        return commonRet;
    }

    @PostMapping("/api/register")
    public CommonRet sysUserRegister(@RequestParam(value = "phone_number", required = true) String phoneNumber,
                                     @RequestParam(value = "pass_word", required = true) String passWord,
                                     @RequestParam(value = "sms_code", required = true) String smsCode){
        CommonRet commonRet = new CommonRet();
        if(!"123456".equals(smsCode)){
            commonRet.setSuccess(false);
            commonRet.setMessage("验证码不正确，请重新输入");
            return commonRet;
        }

        passWord = MD5.string2MD5(passWord);
        sysUserService.addSysUser(phoneNumber,passWord);
        commonRet.setData(true);
        return commonRet;

    }

}
