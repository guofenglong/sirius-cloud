package com.sirius.user.service;

import com.sirius.user.repository.entity.User;

/**
 * @Author: zhengyoule
 * @Date: 2020/6/16 11:56 上午
 */
public interface UserService {

    User queryByAccount(String account);
}
