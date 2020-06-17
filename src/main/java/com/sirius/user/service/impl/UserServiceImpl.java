package com.sirius.user.service.impl;

import com.sirius.user.repository.UserDao;
import com.sirius.user.repository.entity.User;
import com.sirius.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zhengyoule
 * @Date: 2020/6/16 11:56 上午
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User queryByAccount(String account) {
        return userDao.queryByAccount(account);
    }
}
