package com.ustc.reed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * created by reedfan on 2019/4/16 0016
 */

@ControllerAdvice  //@ControllerAdvice是一个@Component，用于定义@ExceptionHandler
public class ControllerExceptionHandler {
    @ExceptionHandler(MusicEntryNotFoundException.class)  //    表明其用于处理MusicEntryNotFoundException异常
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerMusicEntryNotFoundException(MusicEntryNotFoundException ex){
        Map<String,Object> result = new HashMap<>();
        result.put("keyWords",ex.getKeyWords());
        result.put("message","springBoot 错误处理测试");
        return result;
    }
}
