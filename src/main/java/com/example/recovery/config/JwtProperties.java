package com.example.recovery.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName JwtProperties
 * @Description:  JWT token 生成信息
 * @Author chenw
 * @Date 2022/9/23
 * @Version
**/

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 密钥
     */
    private String secret;
    /**
     * 过期时间(秒) 默认7天
     */
    private Long expiration = 60*60*24*7L;

    private String tokenHeader = "token";
}
