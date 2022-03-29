package com.liang.controller;

import com.liang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://MICRO-SERVICE-CLOUD-API";
    //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/findUsers")
    public List<User> findUsers() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/user/findUsers", List.class);
    }

    @RequestMapping(value = "/findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/user/findUserById/" + id, User.class);
    }
}
