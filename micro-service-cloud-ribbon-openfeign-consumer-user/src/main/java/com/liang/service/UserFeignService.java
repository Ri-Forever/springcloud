package com.liang.service;

import com.liang.pojo.User;
import com.liang.service.impl.UserFeignFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICRO-SERVICE-CLOUD-API")
@Service
public interface UserFeignService {

    @GetMapping("/user/findUsers")
    List<User> findUsers();

    @GetMapping("/user/findUserById/{id}")
    User findUserById(@PathVariable("id") Integer id);

}
