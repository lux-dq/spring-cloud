package com.lux.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lux
 * @Date 2021/2/3 22:16
 *
 * Ribbon默认的负载均衡策略是轮询，如果我们想要修改负载均衡策略，该怎么做呢？
 *  -自定义一个配置类
 *
 * 注意：这个自定义配置类不能放在@ComponentScan()所扫描的当前包以及子包下，否则我们自定义的这个配置类就会被所有Ribbon客户端所共享，达不到特殊化定制的目的
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RandomRule();
    }
}
