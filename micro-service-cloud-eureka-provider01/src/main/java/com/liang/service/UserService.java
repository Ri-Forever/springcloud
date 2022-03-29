package com.liang.service;

import com.liang.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findUsers() throws InterruptedException;

    User findUserById(Integer id);
}
