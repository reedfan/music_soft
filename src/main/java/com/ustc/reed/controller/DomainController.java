package com.ustc.reed.controller;

import com.ustc.reed.common.CommonRet;
import com.ustc.reed.utils.DomainUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by reedfan on 2019/9/29 0029
 */

@RestController
@RequestMapping("/api/domain")
public class DomainController {

    @PostMapping("/registered")
    public CommonRet booleanDomainRegist(@RequestParam String domain){
        CommonRet commonRet = new CommonRet();
        Boolean res = DomainUtils.hasRegistered(domain);
        commonRet.setData(res);
        return commonRet;
    }

}
