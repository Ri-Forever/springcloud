package com.liang.controller;

import com.liang.pojo.User;
import com.liang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUsers")
    @ResponseBody
    public List<User> findUsers() throws InterruptedException {
        return userService.findUsers();
    }

    @RequestMapping(value = "/findUserById/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
}
