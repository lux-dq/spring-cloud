package com.lux.springcloud.rest;

import com.lux.core.pojo.BaseResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;
import com.lux.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    // 对于注册进eureka里面的微服务，可以通过'服务发现'来获得服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

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

    @RequestMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for(String service : services) {
            log.info(service);
        }

        log.info("-------------------------------");

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    // 测试手写的Ribbon轮询算法，实际就是返回端口号
    @RequestMapping(value = "/payment/lb")
    public String getLBPort() {
        return serverPort;
    }
}
