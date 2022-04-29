package com.cdivtc.service;
import com.cdivtc.domain.User;

/*
* 用户接口
* */
public interface UserService {
    // 通过User的用户账号和用户密码查询用户信息
    User login(User user);
}
