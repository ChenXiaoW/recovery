package com.example.recovery.exception;


import com.example.recovery.enums.ResponseCodeEnum;

/**
 * @author chenw
 * @date 2021/5/7 10:00
 * 无权限异常
 *
 */
public class UnAuthorityException extends RuntimeException{
    private int code;


    public UnAuthorityException(String message) {
        super(message);
        code = ResponseCodeEnum.UNACCESSDENIED.getCode();
    }

    public int getCode() {
        return code;
    }
}
