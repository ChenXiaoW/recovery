package com.example.recovery.enums;

public enum ResponseCodeEnum {

    SUCCESS(200,"SUCCESS"),
    FAIL(500,"FAIL"),


    UNAUTHORIZED(401, "not login or token expired"),
    UNACCESSDENIED(403, "not permission"),
    ;

    private Integer code;

    private String message;

    ResponseCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
