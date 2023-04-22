package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: SysUserPageQuery
 * @Description: SysUserPageQuery
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 13:36
 */
@Data
public class SysUserPageQuery extends PageQuery {

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("状态：0-禁用，1-启用")
    private Boolean state;
}
