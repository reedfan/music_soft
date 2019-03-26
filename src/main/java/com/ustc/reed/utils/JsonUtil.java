package com.ustc.reed.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ustc.reed.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static Object readObjectFromJson(String sourceJsonStr, Class<?> targetClazz) {
        if(StringUtils.isEmpty(sourceJsonStr)) {
            return null;
        }

        Object targetObj = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            targetObj = objectMapper.readValue(sourceJsonStr, targetClazz);
        } catch (JsonParseException e) {
            logger.error("The exception detailed info is : " + e);
        } catch (JsonMappingException e) {
            logger.error("The exception detailed info is : " + e);
        } catch (IOException e) {
            logger.error("The exception detailed info is : " + e);
        }

        return targetObj;
    }
}
