package com.lux.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lux
 * @Date 2021/2/12 15:55
 */
@Configuration
public class FeignConfig {

    // 配置日志bean
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
