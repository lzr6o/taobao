package com.alibaba.taobao.exception;

/**
 * 描述: 统一异常
 */
public class AlibabaTaobaoException extends RuntimeException {
    private final Integer code;
    private final String message;

    public AlibabaTaobaoException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public AlibabaTaobaoException(AlibabaTaobaoExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
