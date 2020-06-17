package com.sirius.user;

import com.sirius.user.repository.entity.User;
import com.sirius.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zhengyoule
 * @Date: 2020/6/16 11:55 上午
 */

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping(value = "/hi")
    public String hi() {
        User user = userService.queryByAccount("18324742048");
        return user.getName();
    }


}
