package com.liang.service.impl;

import com.liang.mapper.UserMapper;
import com.liang.pojo.User;
import com.liang.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    // @HystrixCommand(fallbackMethod = "fallbackMethod",
    //         commandProperties = {
    //                 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    //         })
    public List<User> findUsers() throws InterruptedException {
        Thread.sleep(6000);
//        List<User> users = userMapper.findUsers();
        List<User> users = new ArrayList<>();
        users.add(new User(8001, "provider01", "provider01"));
        return users;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            //以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "1000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    public User findUserById(Integer id) {
//        User user = userMapper.findUserById(id);
        if (id<=0){
            throw new RuntimeException("id不能小于0...");
        }
        return new User(8001, "测试", "测试");
    }

    public List<User> fallbackMethod() {
        List<User> users = new ArrayList<>();
        users.add(new User(500, "...访问超时...8001", "...访问超时...8001"));
        return users;
    }

    public User fallbackMethod(Integer id) {
        return new User(id, "...id不能小于0...8001", "...id不能小于0...8001");
    }
}
