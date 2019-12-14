package com.tjCourse.softwareEngineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class userSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(userSystemApplication.class,args);
    }
}
