package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroServiceCloudRibbonOpenfeignConsumerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudRibbonOpenfeignConsumerHystrixDashboardApplication.class, args);
    }

}
