package com.lux.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author lux
 * @Date 2021/2/12 11:09
 */
@SpringBootApplication
// 在cloud中，凡是要用哪个组件，都要记住分使用和激活
// 所谓使用，就是在哪里用，在上面加注解即可，如@FeignClient
// 而想要使用，就要在主启动上激活(加注解)
@EnableFeignClients
public class Application80 {
    public static void main(String[] args) {
        SpringApplication.run(Application80.class, args);
    }
}
