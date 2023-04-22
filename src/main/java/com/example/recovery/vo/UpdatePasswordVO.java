package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: UpdatePasswordVO
 * @Description: UpdatePasswordVO
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 13:56
 */
@Data
public class UpdatePasswordVO {

    @ApiModelProperty("旧密码")
    private String oldPassword;

    @ApiModelProperty("新密码")
    private String newPassword;
}
