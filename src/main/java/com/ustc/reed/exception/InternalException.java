package com.ustc.reed.exception;

import lombok.Data;

/**
 * created by reedfan on 2019/4/16 0016
 */
@Data
public class InternalException extends RuntimeException {
    private String keyWords;
    public InternalException(String keyWords){
        super(keyWords);
        this.keyWords = keyWords;
    }
}
