package com.lux.springcloud.service;

import com.lux.core.pojo.DataResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lux
 * @Date 2021/2/12 15:08
 */
@Component
// 注明调用的是哪个微服务
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {
    // feign是对ribbon进一步的封装，此时使用feign确实不需要再注入restTemplate
    // 但是现在调用另一个微服务暴露的功能，仍然要从controller层进入，然后再调用service层的具体业务方法，能否像dubbo一样直接去调用service层呢
    @GetMapping(value = "/payment/get/{id}")
    DataResult<PaymentCustom> getById(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/timeout")
    public String feignTimeout();
}
