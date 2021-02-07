package com.lux.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author lux
 * @Date 2021/2/2 22:22
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zookeeper")
    public String invoke() {
        return "spring cloud server port in zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
