package com.example.recovery.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.recovery.exception.BusinessException;
import com.example.recovery.exception.UnAuthorityException;
import com.example.recovery.mapper.SysUserMapper;
import com.example.recovery.pojo.SysUser;
import com.example.recovery.service.ISysUserService;
import com.example.recovery.utils.JwtUtil;
import com.example.recovery.utils.PasswordEncoderUtil;
import com.example.recovery.vo.PasswordLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private JwtUtil jwtUtil;

    /**
     * 密码登录
     *
     * @param login
     * @return
     */
    @Override
    public String passwordLogin(PasswordLogin login) {
        SysUser sysUser = baseMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getMobile, login.getMobile()));
        if (null == sysUser){
            throw new BusinessException("当前用户不存在");
        }
        Boolean validPassword = PasswordEncoderUtil.validPassword(login.getPassword(), sysUser.getPassword(), sysUser.getSalt());
        if (!validPassword){
            throw new BusinessException("密码错误");
        }
        return jwtUtil.generateToken(sysUser.getId());
    }
}
