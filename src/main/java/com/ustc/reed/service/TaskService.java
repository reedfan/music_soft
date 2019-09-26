package com.ustc.reed.service;

import com.ustc.reed.mapper.DtTaskMapper;
import com.ustc.reed.mapper.TaskMapper;
import com.ustc.reed.pojo.DtTaskExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by reedfan on 2019/9/26 0026
 */

@Service
public class TaskService {
   /* @Autowired
    private DtTaskMapper dtTaskMapper;

    private DtTaskExample dtTaskExample;


    public int getAdminTaskCount(){
        dtTaskExample = new DtTaskExample();
        dtTaskExample.
    }*/


   @Autowired
    private TaskMapper taskMapper;

    public Integer findTasks(){
        return taskMapper.findTasks();
    }


}
