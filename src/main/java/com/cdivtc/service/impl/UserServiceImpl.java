package com.cdivtc.service.impl;

import com.cdivtc.domain.User;
import com.cdivtc.mapper.UserMapper;
import com.cdivtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // 注入UserMapper对象
    @Autowired
    private UserMapper userMapper;
    // 通过User的用户账号和用户密码查询用户信息
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
