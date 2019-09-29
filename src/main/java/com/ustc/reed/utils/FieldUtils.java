package com.ustc.reed.utils;

import com.ustc.reed.common.CommonRet;

import java.lang.reflect.Field;

/**
 * created by reedfan on 2019/4/11 0011
 */
public class FieldUtils {
    public static CommonRet isFieldnotEmpty(Object o){
        CommonRet commonRet = new CommonRet();
        Field fields[]=o.getClass().getDeclaredFields();
        try {
            Field.setAccessible(fields, true);
            for(Field field:fields){
                if(field.get(o) == null){
                    commonRet.setStatus(CommonRet.ERROR);
                    String msg = commonRet.getCode()+" "+field.getName()+"不能为空";
                    commonRet.setCode(msg);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commonRet;
    }

}
