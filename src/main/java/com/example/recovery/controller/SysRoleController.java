package com.example.recovery.controller;

import com.example.recovery.pojo.SysRole;
import com.example.recovery.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: SysRoleController
 * @Description: SysRoleController
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 18:40
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {


    @ApiOperation("获取角色列表")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/list")
    Response<List<SysRole>> listQuery(){
        return Response.success();
    }
}
