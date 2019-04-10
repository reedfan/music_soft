package com.ustc.reed.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    /**
     * 资源映射路径
     * addResourceHandler：访问映射路径
     * addResourceLocations：资源绝对路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //  registry.addResourceHandler("/image/**").addResourceLocations("file:/Users/qufan/Downloads/pic/");
        registry.addResourceHandler("/image/**").addResourceLocations("file:/home/pic");
    }

}
