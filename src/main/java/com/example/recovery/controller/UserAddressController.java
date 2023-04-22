package com.example.recovery.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.recovery.pojo.Category;
import com.example.recovery.pojo.UserAddress;
import com.example.recovery.vo.CategoryPageQuery;
import com.example.recovery.vo.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户地址信息表 前端控制器
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @ApiOperation("查询地址列表")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/list")
    Response<List<UserAddress>> listQuery(){
        return Response.success();
    }

    @ApiOperation("新增地址")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping()
    Response<Boolean> insert(@RequestBody UserAddress userAddress){
        return Response.success();
    }

    @ApiOperation("更新地址")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/{id}")
    Response<Boolean> update(@PathVariable("id")Integer id,@RequestBody UserAddress userAddress){
        return Response.success();
    }

    @ApiOperation("删除地址")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/{id}")
    Response<Boolean> delete(@PathVariable("id")Integer id){
        return Response.success();
    }
}
