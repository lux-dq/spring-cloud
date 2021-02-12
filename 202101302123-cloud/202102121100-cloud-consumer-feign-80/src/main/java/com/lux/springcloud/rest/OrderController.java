package com.lux.springcloud.rest;

import com.lux.core.pojo.DataResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lux
 * @Date 2021/2/12 15:13
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private FeignService feignService;

    @RequestMapping(value = "/consumer/payment/get/{id}")
    public DataResult<PaymentCustom> getById(@PathVariable("id") Long id) {
        return feignService.getById(id);
    }

    @RequestMapping(value = "/consumer/payment/timeout")
    public String feignTimeout() {
        // 客户端默认等待1秒
        return feignService.feignTimeout();
    }
}
