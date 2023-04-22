package com.example.recovery.dto;

import com.example.recovery.pojo.SysRole;
import com.example.recovery.pojo.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author chenw
 * @date 2021/5/13 10:29
 */
@Data
public class UserDto extends SysUser {

    /**
     * 角色列表
     */
    private List<SysRole> roles;
}
