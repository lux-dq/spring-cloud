package com.lux.springcloud.service.impl;

import com.lux.core.pojo.BaseResult;
import com.lux.core.utils.id.SFIDGenerator;
import com.lux.springcloud.dao.PaymentMapper;
import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.core.pojo.DataResult;
import com.lux.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author lux
 * @Date 2021/1/31 18:19
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public BaseResult insert(PaymentCustom paymentCustom) {
        BaseResult result = null;
        paymentCustom.setId(SFIDGenerator.nextId());
        paymentCustom.setCreateUser(1L);
        paymentCustom.setUpdateUser(1L);
        int effectCount = paymentMapper.insert(paymentCustom);
        if (effectCount < 1) {
            return new BaseResult(404, "插入信息失败");
        }
        return new BaseResult(200, "插入信息成功");
    }

    @Override
    public DataResult<PaymentCustom> getById(Long id) {
        DataResult<PaymentCustom> result = new DataResult<>(200, "查询成功");
        PaymentCustom entity = paymentMapper.getById(id);
        if (entity == null) {
            return new DataResult<>(404, "查询失败");
        }
        result.setResult(entity);
        return result;
    }
}
