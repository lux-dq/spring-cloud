package com.lux.springcloud.rest;

import com.lux.core.pojo.BaseResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;
import com.lux.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    // 测试手写的Ribbon轮询算法，实际就是返回端口号
    @RequestMapping(value = "/payment/lb")
    public String getLBPort() {
        return serverPort;
    }

    // 测试feign的超时控制(模拟长流程调用)
    @RequestMapping(value = "/payment/timeout")
    public String feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
