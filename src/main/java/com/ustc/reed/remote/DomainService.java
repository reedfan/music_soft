package com.ustc.reed.remote;

import com.ustc.reed.configure.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 短信服务
 */
@FeignClient(name = "domain-service",url = "http://api.mix2.zthysms.com/v2", configuration = FeignConfiguration.class)
public interface DomainService {

}
