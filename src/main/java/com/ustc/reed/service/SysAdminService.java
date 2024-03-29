package com.ustc.reed.service;

import com.ustc.reed.mapper.SysAdminMapper;
import com.ustc.reed.pojo.TbSysAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by reedfan on 2019/9/29 0029
 */

@Service
public class SysAdminService {
    @Autowired
    private SysAdminMapper sysAdminMapper;
    public TbSysAdmin selectSysAdminByPhoneNumber(String phoneNumber, String passWord){
        TbSysAdmin tbSysAdmin = sysAdminMapper.selectSysAdminByPhoneNumber(phoneNumber,passWord);
        return tbSysAdmin;
    }
}
