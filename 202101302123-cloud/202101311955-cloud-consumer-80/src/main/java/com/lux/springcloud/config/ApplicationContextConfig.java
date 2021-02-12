package com.lux.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lux
 * @Date 2021/1/31 20:07
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    // 如果想要使用自己的Ribbon负载均衡算法，一定要将该注解先注释掉
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
