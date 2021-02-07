package com.lux.springcloud.dao;

import com.lux.springcloud.pojo.custom.PaymentCustom;
import com.lux.springcloud.pojo.generator.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author lux
 * @Date 2021/1/31 17:54
 */
@Mapper
public interface PaymentMapper {
    int insert(@Param("record") PaymentCustom paymentCustom);

    PaymentCustom getById(@Param("id") Long id);
}
