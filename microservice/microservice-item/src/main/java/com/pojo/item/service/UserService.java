package com.pojo.item.service;

import com.pojo.item.entity.User;
import com.pojo.item.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {


    @Autowired
    private UserFeignClient userFeignClient;

    public User queryUserById(Long userId) {
        return userFeignClient.queryUserById(userId);
    }
}
