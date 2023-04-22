package com.example.recovery.utils;

import com.example.recovery.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Resource
    private JwtProperties jwtProperties;


    private static final String CLAIM_KEY_TEL =  "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /**
     * 生成token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        //存放userId,生成时间,过期时间,加密规则
        return Jwts.builder().setClaims(claims).setExpiration(generatorExpirationData()).signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
    }

    private Date generatorExpirationData() {
        return new Date(System.currentTimeMillis() + jwtProperties.getExpiration());
    }

    /**
     * 根据用户ID生成token
     * @param userId
     * @return
     */
    public String generateToken(Integer userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_TEL, userId);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 根据token 获取用户ID
     * @param token
     * @return
     */
    public String getIdFromToken(String token) {
        String email;
        Claims claims = getClaimsFromToken(token);
        email = claims.getSubject();
        return email;
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
    }

    /**
     * token 校验token
     * @param token
     * @param userId
     * @return
     */
    public boolean validateToken(String token, Integer userId) {
        String id = getIdFromToken(token);
        return id.equals(userId.toString()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
}
