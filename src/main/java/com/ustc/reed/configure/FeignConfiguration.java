package com.ustc.reed.configure;


import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.codec.Decoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

//import feign.form.FormEncoder;

@Configuration
public class FeignConfiguration {

    public static int connectTimeOutMillis = 30000;
    public static int readTimeOutMillis = 100000;




    private String logLevel = "debug";

    @Bean
    Logger.Level feignLoggerLevel() {
//        if (StringUtils.isNotEmpty(logLevel) && logLevel.compareToIgnoreCase("debug") == 0) {
//            return Logger.Level.FULL;
//        }
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    @Bean
    public Retryer feignRetryer(){
        Retryer retryer = new Retryer.Default(1000, 10000, 3);
        return retryer;
    }

//    @Bean
//    public Encoder encoder(){
//       // return new FormEncoder();
//        return new JacksonEncoder();
//    }

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
    }


    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new PhpMappingJackson2HttpMessageConverter());
        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return httpMessageConverters;
            }
        };
    }

    public class PhpMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        PhpMappingJackson2HttpMessageConverter(){
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")); //关键
            setSupportedMediaTypes(mediaTypes);
        }
    }

   // headers = {"content-type=application/x-www-form-urlencoded","content-length=663"}
//    @Bean
//    public RequestInterceptor headerInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate requestTemplate) {
//                // 小示例，没什么卵用
//                requestTemplate.header("Content-Type", "x-www-form-urlencoded");
//                requestTemplate.header("content-lengt","663");
//            }
//        };
//    }


//
//    @Bean
//    Logger getFeignClientLogger() {
//        return new MyFeignClientLogger();
//    }
//
//    private static class MyFeignClientLogger extends Logger {
//        @Autowired
//        private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MyFeignClientLogger.class);
//
//        @Override
//        protected void log(String method, String format, Object... objects) {
//            if (LOG.isInfoEnabled()) {
//                LOG.info(String.format(method + ": " + format, objects));
//            }
//        }
//    }
}
