package com.lux.springcloud.rest;

import com.lux.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lux
 * @Date 2021/2/21 21:35
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/hystrix/ok/{id}")
    public String getInfo_OK(@PathVariable("id") Integer id) {
        return paymentService.getInfo_OK(id);
    }

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String getInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentService.getInfo_TimeOut(id);
    }
}
