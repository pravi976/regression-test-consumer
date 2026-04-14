package com.enterprise.regression.downstream;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class RegressionTestDownstreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegressionTestDownstreamApplication.class, args);
    }
}
