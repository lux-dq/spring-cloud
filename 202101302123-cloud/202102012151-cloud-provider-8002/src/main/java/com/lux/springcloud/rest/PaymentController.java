package com.lux.springcloud.rest;

import com.lux.core.pojo.BaseResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;
import com.lux.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author lux
 * @Date 2021/1/31 18:30
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/insert")
    public BaseResult insert(@RequestBody PaymentCustom paymentCustom) throws Exception {
        System.out.println(serverPort);
        return paymentService.insert(paymentCustom);
    }

    @GetMapping(value = "/payment/get/{id}")
    public DataResult<PaymentCustom> getById(@PathVariable("id") Long id) {
        System.out.println(serverPort);
        return paymentService.getById(id);
    }
}
