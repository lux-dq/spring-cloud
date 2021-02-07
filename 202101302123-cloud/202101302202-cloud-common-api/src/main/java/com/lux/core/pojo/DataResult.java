package com.lux.core.pojo;

import lombok.Data;

/**
 * @Author lux
 * @Date 2021/1/31 9:54
 *
 * 返回给前端的通用json
 */
@Data
public class DataResult<T> extends BaseResult{

    private T result;

    public DataResult() {
    }

    public DataResult(Integer code) {
        this.code = code;
        this.message = null;
    }

    public DataResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
