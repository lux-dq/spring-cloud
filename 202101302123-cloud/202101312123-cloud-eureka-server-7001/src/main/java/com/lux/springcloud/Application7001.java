package com.lux.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author lux
 * @Date 2021/1/31 21:39
 */
@SpringBootApplication
@EnableEurekaServer // 代表7001就是eureka的服务注册中心
public class Application7001 {
    public static void main(String[] args) {
        SpringApplication.run(Application7001.class, args);
    }
}
