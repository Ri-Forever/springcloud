package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//开启 Eureka server,接受其他微服务的注册
@EnableEurekaServer
public class MicroServiceCloudEurekaRegistration01Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudEurekaRegistration01Application.class, args);
    }

}
