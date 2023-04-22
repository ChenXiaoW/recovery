package com.example.recovery.exception;


import com.example.recovery.enums.ResponseCodeEnum;

/**
 * @author daihaoran
 *业务异常，需要描述具体问题，将直接抛出到用户端
 */
public class BusinessException extends RuntimeException {
    private int code;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
        code = ResponseCodeEnum.FAIL.getCode();
    }

    public int getCode() {
        return code;
    }
}
