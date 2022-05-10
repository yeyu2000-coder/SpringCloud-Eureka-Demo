package com.example.yeyucloudservemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YeyuCloudServeMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(YeyuCloudServeMailApplication.class, args);
    }

}
