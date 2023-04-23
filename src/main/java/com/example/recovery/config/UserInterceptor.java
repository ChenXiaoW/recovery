package com.example.recovery.config;

import cn.hutool.core.util.StrUtil;
import com.example.recovery.utils.JwtUtil;
import com.example.recovery.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JwtProperties jwtProperties = SpringContextUtil.getBean(JwtProperties.class);
        String token = request.getHeader(jwtProperties.getTokenHeader());
        if (StrUtil.isNotBlank(token)){
            JwtUtil jwtUtil = SpringContextUtil.getBean(JwtUtil.class);
            String userId = jwtUtil.getIdFromToken(token);
            ConcurrentHashMap map = new ConcurrentHashMap();
            map.put("userId",userId);
            UserContextHolder.getInstance().setContext(map);
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        UserContextHolder.getInstance().clear();
    }
}