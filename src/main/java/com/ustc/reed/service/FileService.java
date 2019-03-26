package com.ustc.reed.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FileService {
    private static Logger logger = LoggerFactory.getLogger(FileService.class);


    public String getData(String location) {
        ClassPathResource classPathResource = new ClassPathResource(location);
        StringBuffer stringBuffer = new StringBuffer();

        try {
            InputStreamReader reader = new InputStreamReader(classPathResource.getInputStream(),"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (bufferedReader.ready()){
                stringBuffer.append((char) reader.read());
            }

            bufferedReader.close();
            reader.close();


        } catch (IOException e) {
            logger.info("IOException",e.toString());
        }
        if(stringBuffer != null){
            return stringBuffer.toString();
        }
        return null;

    }

    public String getFile(String keyWord){


        return "";



    }


}

