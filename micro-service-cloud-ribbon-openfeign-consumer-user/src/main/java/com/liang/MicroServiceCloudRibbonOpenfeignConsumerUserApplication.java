package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //启用 Hystrix
public class MicroServiceCloudRibbonOpenfeignConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudRibbonOpenfeignConsumerUserApplication.class, args);
    }

}
