package com.alibaba.taobao.exception;

public class AlibabaTaobaoException extends Exception {
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
