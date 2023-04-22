package com.example.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.recovery.pojo.SysUser;
import com.example.recovery.vo.PasswordLogin;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
public interface ISysUserService extends IService<SysUser> {


    /**
     * 密码登录
     * @param login
     * @return
     */
    String passwordLogin(PasswordLogin login);

}
