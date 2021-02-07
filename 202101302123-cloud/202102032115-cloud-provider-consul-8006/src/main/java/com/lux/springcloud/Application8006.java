package com.lux.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lux
 * @Date 2021/2/3 21:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application8006 {
    public static void main(String[] args) {
        SpringApplication.run(Application8006.class, args);
    }
}
