package com.example.recovery.vo;

import com.example.recovery.pojo.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: SysUserVO
 * @Description: SysUserVO
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 13:33
 */
@Data
public class SysUserVO extends SysUser {

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
