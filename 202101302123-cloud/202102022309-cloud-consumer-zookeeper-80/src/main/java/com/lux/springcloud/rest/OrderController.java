package com.lux.springcloud.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author lux
 * @Date 2021/2/2 23:13
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @RequestMapping(value = "/consumer/payment/zookeeper")
    public String invoke() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zookeeper", String.class);
    }
}
