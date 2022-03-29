package com.liang.service.impl;

import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
            })
    public List<User> findUsers() throws InterruptedException {
        // Thread.sleep(6000);
        List<User> users = userMapper.findUsers();
        users.add(new User(8002, "provider01", "provider01"));
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.findUserById(id);
        user.setId(8002);
        return user;
    }


    public List<User> fallbackMethod() {
        List<User> users = new ArrayList<>();
        users.add(new User(500, "hystrix熔断...访问超时...8002", "hystrix熔断...访问超时...8002"));
        return users;
    }
}
