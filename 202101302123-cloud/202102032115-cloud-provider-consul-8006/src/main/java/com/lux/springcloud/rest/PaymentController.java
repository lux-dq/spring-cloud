package com.lux.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author lux
 * @Date 2021/2/3 21:31
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String invoke() {
        return "spring cloud server port in consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
