package com.ustc.reed.mapper;

import com.ustc.reed.pojo.TbSysUser;
import org.apache.ibatis.annotations.Param;

/**
 * created by reedfan on 2019/9/29 0029
 */
public interface SysUserMapper {
    TbSysUser selectSysUserByPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord);

    Integer addSysUser(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord);
}
