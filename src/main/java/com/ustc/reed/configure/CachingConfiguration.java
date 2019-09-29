package com.ustc.reed.configure;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableCaching
public class CachingConfiguration extends CachingConfigurerSupport {
    private static final Logger log = LoggerFactory.getLogger(CachingConfiguration.class);

    @Bean
    @ConfigurationProperties(prefix = "cache.spec")
    public Map<String, String> cacheSpec() {
        return new HashMap<>();
    }

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        List<CaffeineCache> caches = new ArrayList<>();
        Map<String, String> cacheSpecs = cacheSpec();
        for (Map.Entry<String, String> entry : cacheSpecs.entrySet()) {
            CaffeineCache c = buildCache(entry.getKey(), entry.getValue(), ticker);
            caches.add(c);
        }

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(caches);
        return manager;
    }

    private CaffeineCache buildCache(String name, String spec, Ticker ticker) {
        log.info(spec);
        return new CaffeineCache(name, Caffeine.from(spec)
                .ticker(ticker).recordStats()
                .build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
