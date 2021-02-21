package com.lux.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author lux
 * @Date 2021/2/21 21:28
 *
 * 正常情况下应该先写接口，再写实现类，这里为了节约时间，就直接写实现类了
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String getInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t" + "getInfo_OK";
    }

    /**
     * 超时
     * @param id
     * @return
     */
    public String getInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\t" + "getInfo_TimeOut：该方法运行耗时" + timeNumber + "秒钟";
    }
}
