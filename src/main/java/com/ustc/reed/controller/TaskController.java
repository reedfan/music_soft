package com.ustc.reed.controller;

import com.ustc.reed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by reedfan on 2019/9/26 0026
 */

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/test")
    public int getTasks(){
        return taskService.findTasks();

    }
}
