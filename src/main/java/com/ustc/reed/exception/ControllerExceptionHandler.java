package com.ustc.reed.exception;

import com.ustc.reed.common.CommonRet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * created by reedfan on 2019/4/16 0016
 */

@ControllerAdvice  //@ControllerAdvice是一个@Component，用于定义@ExceptionHandler
public class ControllerExceptionHandler {
    @ExceptionHandler(InternalException.class)  //    表明其用于处理MusicEntryNotFoundException异常
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonRet handlerMusicEntryNotFoundException(InternalException ex){
        CommonRet commonRet = new CommonRet();
        commonRet.setSuccess(false);
        commonRet.setCode(CommonRet.ERROR_code);
        commonRet.setMessage(ex.getMessage());

        return commonRet;
    }
}
