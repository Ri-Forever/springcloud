package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// 激活熔断器功能
@EnableCircuitBreaker
public class MicroServiceCloudEurekaProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudEurekaProvider01Application.class, args);
    }

}
