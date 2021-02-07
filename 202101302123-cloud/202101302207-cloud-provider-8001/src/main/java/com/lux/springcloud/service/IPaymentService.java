package com.lux.springcloud.service;

import com.lux.core.pojo.BaseResult;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;

/**
 * @Author lux
 * @Date 2021/1/31 18:17
 */
public interface IPaymentService {
    BaseResult insert(PaymentCustom paymentCustom) throws Exception;

    DataResult<PaymentCustom> getById(Long id);
}
