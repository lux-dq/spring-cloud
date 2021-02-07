package com.lux.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lux
 * @Date 2021/2/2 23:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application80 {
    public static void main(String[] args) {
        SpringApplication.run(Application80.class, args);
    }
}
