package com.sirius.user.repository;

import com.sirius.user.repository.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhengyoule
 * @Date: 2020/6/16 12:00 下午
 */

@Repository
public interface UserDao {

    User queryByAccount(String account);

}
