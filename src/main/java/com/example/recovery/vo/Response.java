package com.example.recovery.vo;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.recovery.enums.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: Response
 * @Description: Response
 * @Author
 * @Date 2023/03/10 - 21:33
 */
@ApiModel("响应模型")
@Data
public class Response<T> {

    public static final Integer SUCCESS_CODE = ResponseCodeEnum.SUCCESS.getCode();
    public static final String SUCCESS_MSG =ResponseCodeEnum.SUCCESS.getMessage();
    public static final Integer FAIL_CODE = ResponseCodeEnum.FAIL.getCode();
    public static final String FAIL_MSG = ResponseCodeEnum.FAIL.getMessage();

    @ApiModelProperty(value = "业务码：200-成功，500-失败")
    private Integer code;

    @ApiModelProperty(value = "信息")
    private String message;

    @ApiModelProperty(value = "数据")
    private T data;


    public static <T> Response<T> success(){
        return new Response<>(SUCCESS_CODE,SUCCESS_MSG,null);
    }

    public static <T> Response<T> success(T data){
        return new Response<T>(SUCCESS_CODE,SUCCESS_MSG,data);
    }

    public static <T> Response<T> fail(){
        return new Response<>(FAIL_CODE,FAIL_MSG,null);
    }

    public static <T> Response<T> fail(String message){
        return new Response<>(FAIL_CODE,message,null);
    }


    public static <T> Response<T> unAuthority(){
        return new Response<>(ResponseCodeEnum.UNAUTHORIZED.getCode(), ResponseCodeEnum.UNAUTHORIZED.getMessage(), null);
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
