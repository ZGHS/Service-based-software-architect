package com.pojo.order.controller;

import com.pojo.order.entity.User;
import com.pojo.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/order/login/{userId}/{pwd}")
    public String login(@PathVariable("userId") Long userId, @PathVariable("pwd") Long pwd) {
        User user = this.userService.queryUserById(userId);
        if (user == null) {
            return "用户不存在.";
        }

        if (user.getState() == 1) {
            return "用户已经登陆.";
        }
        if (pwd == user.getPassword()) {
            userService.changeState(userId, 1);
            return "login success.";
        }

        return "pwd wrong.";
    }

    @GetMapping(value = "/order/logout/{userId}")
    public String logout(@PathVariable("userId") Long userId) {
        User user = this.userService.queryUserById(userId);
        if (user == null) {
            return "用户不存在.";
        }

        if (user.getState() == 1) {
            userService.changeState(userId, 0);
            return "退出登录成功.";
        }

        return "用户没有登录.";
    }

    @GetMapping(value = "/order/getAllUsers")
    public Map<Long, User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @GetMapping(value = "/order/queryUserById/{userId}")
    public User queryUserById(@PathVariable("userId") Long userId) {
        return userService.queryUserById(userId);
    }

}
