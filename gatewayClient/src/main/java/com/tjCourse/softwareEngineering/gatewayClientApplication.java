package com.tjCourse.softwareEngineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ServletComponentScan
@EnableDiscoveryClient
public class gatewayClientApplication
{
/*
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(gatewayClientApplication.class);
    }
*/
    public static void main( String[] args )
    {
        SpringApplication.run(gatewayClientApplication.class,args);
    }
}
