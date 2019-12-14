package com.tjCourse.softwareEngineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class gatewayClientApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(gatewayClientApplication.class,args);
    }
}
