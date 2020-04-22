package com.pojo.payment.service;

import com.pojo.payment.entity.User;
import com.pojo.payment.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserFeignClient userFeignClient;

    public User queryUserById(Long userId) {
        return userFeignClient.queryUserById(userId);
    }


}
