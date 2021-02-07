package com.lux.springcloud.rest;

import com.lux.core.pojo.BaseResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author lux
 * @Date 2021/1/31 20:04
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    // 未使用服务注册中心时，可以写死服务提供者的地址，但是使用注册中心之后，就不能这么写了，此时只认服务，不认具体地址
//    public static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @RequestMapping(value = "/consumer/payment/insert")
    public BaseResult insert(PaymentCustom paymentCustom) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", paymentCustom, BaseResult.class);
    }

    @RequestMapping(value = "/consumer/payment/get/{id}")
    public DataResult<PaymentCustom> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, DataResult.class);
    }

    // Ribbon是客户端负载均衡的工具，因此应该在80这一侧
    // Ribbon：负载均衡 + RestTemplate调用
}
