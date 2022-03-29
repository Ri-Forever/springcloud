package com.liang.service.impl;

import com.liang.pojo.User;
import com.liang.service.UserFeignService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFeignFallBackService implements UserFeignService {
    public List<User> findUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(500, "...全局解耦访问超时...", "...全局解耦访问超时..."));
        return users;
    }

    public User findUserById(Integer id) {
        return new User(id, "...全局解耦访问超时...", "...全局解耦访问超时...");
    }
}
