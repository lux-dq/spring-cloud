package com.lux.core.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BaseResult {
    private static final long serialVersionUID = 1L;

    protected Integer code;

    protected String message;

    public BaseResult() {
    }

    public BaseResult(Integer code) {
        this.code = code;
        this.message = null;
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
