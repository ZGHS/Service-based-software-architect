package com.pojo.order.service;


import com.pojo.order.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private static final Map<Long, User> ALL_USERS = new HashMap<Long, User>();

    static {
        // 模拟数据库，构造测试数据
        ALL_USERS.put(1L, new User(1L, 123L, 0));
        ALL_USERS.put(2L, new User(2L, 123L, 0));
        ALL_USERS.put(3L, new User(3L, 123L, 0));
    }


    public User queryUserById(Long userId) {
        return ALL_USERS.get(userId);
    }

    public Map<Long, User> getAllUsers() {
        return ALL_USERS;
    }

    public void changeState(Long userId, Integer state) {
        ALL_USERS.put(userId, new User(userId, 123L, state));
    }


}
