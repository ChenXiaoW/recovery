package com.example.recovery.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.recovery.pojo.Category;
import com.example.recovery.vo.CategoryPageQuery;
import com.example.recovery.vo.Response;
import com.example.recovery.vo.SysUserPageQuery;
import com.example.recovery.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: CategoryController
 * @Description: CategoryController
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 13:48
 */
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @ApiOperation("分页查询分类列表")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/page")
    Response<Page<Category>> pageQuery(CategoryPageQuery pageQuery){
        return Response.success();
    }

    @ApiOperation("新增分类")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping()
    Response<Boolean> insert(@RequestBody Category category){
        return Response.success();
    }

    @ApiOperation("更新分类信息")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    Response<Boolean> update(@PathVariable("id")Integer id,@RequestBody Category category){
        return Response.success();
    }

    @ApiOperation("禁用/启用分类")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/state/{id}")
    Response<Boolean> updateState(@PathVariable("id")Integer id,@RequestParam("state")Boolean state){
        return Response.success();
    }


    @ApiOperation("删除分类")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    Response<Boolean> delete(@PathVariable("id")Integer id){
        return Response.success();
    }

}
