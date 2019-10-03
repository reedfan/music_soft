package com.ustc.reed.controller;

/**
 * created by reedfan on 2019/9/28 0028
 *
 * /**
 * 超级管理员专属Controller
 */

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.pojo.TbSysAdmin;
import com.ustc.reed.service.SysAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController


public class AdminController {

    @Autowired
    private SysAdminService sysAdminService;

    @PostMapping("/admin/login")
    public CommonRet getBottomColumnList( @RequestParam(value = "phone_number", required = true) String phoneNumber,
                                          @RequestParam(value = "pass_word", required = true) String passWord) {
        CommonRet commonRet = new CommonRet();
        TbSysAdmin tbSysAdmin = sysAdminService.selectSysAdminByPhoneNumber(phoneNumber,passWord);
        commonRet.setData(tbSysAdmin);
        return commonRet;
    }

}
