package com.example.recovery.security.config;

import com.example.recovery.security.filter.JwtAuthenticationTokenFilter;
import com.example.recovery.security.filter.RestUnauthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author chenw
 * @date 2021/4/8 14:56
 *
 * spring security 配置
 */
@Configurable
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private RestUnauthenticationEntryPoint restUnauthenticationEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //需要放行的接口
        String [] antMatchers = new String[]{
            "/login/passwordLogin"
        };
        //antMatchers = new String[]{"/**"};
        http.csrf().disable() // 关闭csrf功能
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/swagger-resources/**",
                "/swagger-html/**",
                "/v2/api-docs/**")
                .permitAll()
                //放通的api
                .antMatchers(antMatchers)
                .permitAll()
                .anyRequest().authenticated();
        // 禁用缓存
        http.headers().cacheControl();
        //添加注册表单过滤器 处理身份验证表单
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //开始身份验证 未登录异常
        http.exceptionHandling().authenticationEntryPoint(restUnauthenticationEntryPoint);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

