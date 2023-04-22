package com.example.recovery.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: PasswordLogin
 * @Description: PasswordLogin
 * @Author ChenXiaoW
 * @Date 2023/04/22 - 11:01
 */
@Data
public class PasswordLogin {

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;
}
