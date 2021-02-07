package com.lux.springcloud.pojo.generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author lux
 * @Date 2021/1/31 9:42
 */
@Data
public class Payment implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;

    /**
     * 删除标示
     */
    private Boolean delFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建者
     */
    private Long createUser;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private Long updateUser;

    /**
     * 版本
     */
    private Long version;
}
