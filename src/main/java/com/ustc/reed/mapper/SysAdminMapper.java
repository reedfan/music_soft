package com.ustc.reed.mapper;

import com.ustc.reed.pojo.TbSysAdmin;
import org.apache.ibatis.annotations.Param;

/**
 * created by reedfan on 2019/9/29 0029
 */
public interface SysAdminMapper {
    TbSysAdmin selectSysAdminByPhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord);
}
