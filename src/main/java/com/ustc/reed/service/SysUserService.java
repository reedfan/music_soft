package com.ustc.reed.service;

import com.ustc.reed.exception.InternalException;
import com.ustc.reed.mapper.SysAdminMapper;
import com.ustc.reed.mapper.SysUserMapper;
import com.ustc.reed.pojo.TbSysAdmin;
import com.ustc.reed.pojo.TbSysUser;
import com.ustc.reed.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by reedfan on 2019/9/29 0029
 */

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    public TbSysUser selectSysUserByPhoneNumber(String phoneNumber, String passWord){
        passWord = MD5.string2MD5(passWord);
        TbSysUser tbSysUser = sysUserMapper.selectSysUserByPhoneNumber(phoneNumber, passWord);
        return tbSysUser;
    }


    public Boolean addSysUser(String phoneNumber, String passWord){
        try {
            sysUserMapper.addSysUser(phoneNumber,passWord);
        } catch (Exception e) {
            throw new InternalException("add user error");
        }
        return true;

    }
}
