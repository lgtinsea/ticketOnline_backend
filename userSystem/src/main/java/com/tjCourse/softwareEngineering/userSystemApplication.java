package com.tjCourse.softwareEngineering;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.tjCourse.softwareEngineering.dao")
@EnableCaching
@EnableSwagger2
@EnableTransactionManagement
public class userSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(userSystemApplication.class,args);
    }
}
