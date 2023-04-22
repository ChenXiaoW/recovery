package com.example.recovery.security.filter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.recovery.config.JwtProperties;
import com.example.recovery.dto.UserDetailDto;
import com.example.recovery.dto.UserDto;
import com.example.recovery.exception.UnAuthorityException;
import com.example.recovery.mapper.SysRoleMapper;
import com.example.recovery.mapper.SysUserMapper;
import com.example.recovery.mapper.SysUserRelateRoleMapper;
import com.example.recovery.pojo.SysRole;
import com.example.recovery.pojo.SysUser;
import com.example.recovery.pojo.SysUserRelateRole;
import com.example.recovery.utils.JwtUtil;
import com.example.recovery.vo.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * jwt
 *
 * @author chenw
 * @date 2021/4/12 17:17
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private SysUserRelateRoleMapper sysUserRelateRoleMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中的字段
        String authHeader = request.getHeader(jwtProperties.getTokenHeader());
        log.info("Authorization Header：{} ", authHeader);
        log.info("request path：{}", request.getRequestURI());

        if (authHeader != null ) {
            String authToken = authHeader;
            String userId = null;
            try {
                userId = jwtUtil.getIdFromToken(authToken);
            } catch (Exception e) {
                log.error("Token过期：{}", e.getMessage());
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.setStatus(HttpStatus.OK.value());
                response.getWriter().println(JSONUtil.parse(Response.unAuthority()));
                response.getWriter().flush();
                return;
            }
            if (StringUtils.hasText(userId)) {
                SysUser sysUser = userMapper.selectById(Integer.parseInt(userId));
                if (ObjectUtils.isEmpty(sysUser)) {
                    log.info("当前用户（id:{}）不存在或者已被移除", userId);
                    throw new UnAuthorityException("当前用户不存在");
                }
                if (!sysUser.getState()) {
                    log.info("当前用户（id:{}）已封禁", userId);
                    throw new UnAuthorityException("当前用户已封禁");
                }
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(sysUser,userDto);
                List<SysUserRelateRole> sysUserRelateRoles = sysUserRelateRoleMapper.selectList(Wrappers.<SysUserRelateRole>lambdaQuery().eq(SysUserRelateRole::getUserId, sysUser.getId()));
                if (CollUtil.isNotEmpty(sysUserRelateRoles)){
                    List<SysRole> sysRoles = sysRoleMapper.selectBatchIds(sysUserRelateRoles.stream().map(SysUserRelateRole::getRoleId).collect(Collectors.toSet()));
                    userDto.setRoles(sysRoles);
                }
                UserDetailDto userDetails = new UserDetailDto(userDto);
                if (jwtUtil.validateToken(authToken, userDto.getId())) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}
