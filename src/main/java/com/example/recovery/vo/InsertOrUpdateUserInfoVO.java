package com.example.recovery.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: InsertOrUpdateUserInfoVO
 * @Description: InsertOrUpdateUserInfoVO
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 18:43
 */
@Data
public class InsertOrUpdateUserInfoVO {

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 状态：0-禁用，1-启用
     */
    @ApiModelProperty(value = "状态：0-禁用，1-启用")
    private Boolean state;

    @ApiModelProperty("角色ID")
    private Integer roleId;
}
