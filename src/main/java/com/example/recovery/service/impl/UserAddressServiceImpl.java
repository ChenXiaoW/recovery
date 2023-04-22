package com.example.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.recovery.mapper.UserAddressMapper;
import com.example.recovery.pojo.UserAddress;
import com.example.recovery.service.IUserAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址信息表 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-04-22
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

}
