package com.example.recovery.config;


import com.example.recovery.vo.Response;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 缺少请求体错误返回
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Response requestBodyMissingHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) e;
        return Response.fail(httpMessageNotReadableException.getMessage());
    }

    /**
     * 全局异常拦截
     * @param request
     * @param e
     * @return
     * @param <T>
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> Response<T> globalExceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return Response.fail( e.getMessage());
    }

}
