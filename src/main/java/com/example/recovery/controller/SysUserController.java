package com.example.recovery.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.recovery.vo.Response;
import com.example.recovery.vo.SysUserPageQuery;
import com.example.recovery.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SysUserController
 * @Description: SysUserController
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 13:32
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @ApiOperation("获取当前登录用户信息")
    @GetMapping()
    Response<SysUserVO> currentUserInfo(){
        return Response.success();
    }

    @ApiOperation("分页查询用户列表")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/page")
    Response<Page<SysUserVO>> pageQuery(SysUserPageQuery pageQuery){
        return Response.success();
    }
    @ApiOperation("查询用户信息")
    @ApiImplicitParam(name = "id",value = "用户ID")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    Response<SysUserVO> queryUserInfo(@PathVariable("id")Integer id){
        return Response.success();
    }
    @ApiOperation("禁用/启用用户")
    @ApiImplicitParam(name = "id",value = "用户ID")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/state/{id}")
    Response<SysUserVO> updateState(@PathVariable("id")Integer id,@RequestParam("state")Boolean state){
        return Response.success();
    }
}
