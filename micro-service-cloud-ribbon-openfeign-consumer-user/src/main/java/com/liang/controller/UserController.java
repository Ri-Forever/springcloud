package com.liang.controller;

import com.liang.pojo.User;
import com.liang.service.UserFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feign")
// @DefaultProperties(defaultFallback = "fallbackMethod") //全局的服务降级方法
public class UserController {

    @Autowired
    private UserFeignService userFeignService;


    @GetMapping("/findUsers")
    // @HystrixCommand(fallbackMethod = "fallbackMethod")
    // @HystrixCommand
    List<User> findUsers() {
        System.out.println("findUsers...");
        return userFeignService.findUsers();
    }

    @GetMapping("/findUserById/{id}")
    User findUserById(@PathVariable("id") Integer id) {
        System.out.println("findUserById...");
        return userFeignService.findUserById(id);
    }

    public List<User> fallbackMethod() {
        List<User> users = new ArrayList<>();
        users.add(new User(500, "...访问超时...", "...访问超时..."));
        return users;
    }
}
