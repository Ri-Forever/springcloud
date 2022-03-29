package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudRibbonConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudRibbonConsumerUserApplication.class, args);
    }

}
