package com.example.recovery.controller;

import com.example.recovery.service.ISysUserService;
import com.example.recovery.vo.PasswordLogin;
import com.example.recovery.vo.Response;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName: LoginController
 * @Description: LoginController
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 10:58
 */
@Api(tags = "登录管理")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 密码登录
     *
     * @param
     * @return
     */
    @PostMapping("/passwordLogin")
    Response passwordLogin(@Valid @RequestBody PasswordLogin passwordLogin){
        return Response.success(sysUserService.passwordLogin(passwordLogin));
    }




}
