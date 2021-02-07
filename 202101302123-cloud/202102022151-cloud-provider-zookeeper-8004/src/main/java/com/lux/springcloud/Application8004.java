package com.lux.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lux
 * @Date 2021/2/2 22:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application8004 {
    public static void main(String[] args) {
        SpringApplication.run(Application8004.class, args);
    }
}
