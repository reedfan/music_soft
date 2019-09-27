package com.ustc.reed.service;

import com.ustc.reed.mapper.UserMapper;
import com.ustc.reed.pojo.DtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseService {

    @Autowired
    private UserMapper userMapper;

    public List<DtUser> findUserForMobile(String phoneNumber) {

        List<DtUser> userList = userMapper.findUserForMobile(phoneNumber);
        return userList;

    }
}
