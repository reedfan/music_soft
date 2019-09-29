package com.ustc.reed.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * created by reedfan on 2019/9/29 0029
 */
public class DomainUtils {
    /**
     * 查询域名是否已被注册
     * @param domain
     * @return
     */
    public static boolean hasRegistered(String domain){
        boolean hasRegistered = false;  //该域名是否被注册
        try {
            URL url = new URL("http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=" + domain);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);  //毫秒
            connection.setReadTimeout(5000);

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";  //每次读取一行数据
            String reg = "<original>(.*?)</original>";  //正则
            while((line = reader.readLine()) != null){
                if(line.matches(reg)){
//                  System.out.println(line);
                    //只有两种状态，210表示可用，211表示不可用
                    String state = line.substring(10, 13);
                    if("211".equals(state))
                        hasRegistered = true;
                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return hasRegistered;
    }

}
