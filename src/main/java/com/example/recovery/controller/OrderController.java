package com.example.recovery.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.recovery.vo.InsertOrderVO;
import com.example.recovery.vo.OrderPageQuery;
import com.example.recovery.vo.OrderVO;
import com.example.recovery.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@Api(tags = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperation("分页查询订单列表")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/system/page")
    Response<Page<OrderVO>> pageQuery(OrderPageQuery query){
        return Response.success();
    }
    @ApiOperation("查询订单详情")
    @ApiImplicitParam(name = "id",value = "订单ID")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    Response<OrderVO> queryDetail(@PathVariable("id")Integer id){
        return Response.success();
    }

    //创建订单
    @ApiOperation("创建订单")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping()
    Response<Boolean> createOrder(@RequestBody InsertOrderVO vo){
        return Response.success();
    }
    @ApiOperation("取消订单")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/cancel/{id}")
    Response<Boolean> cancelOrder(@PathVariable("id")Integer id){
        return Response.success();
    }
    @ApiOperation("完成订单")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping("/finish/{id}")
    Response<Boolean> finishOrder(@PathVariable("id")Integer id){
        return Response.success();
    }

}
