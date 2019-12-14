package com.tjCourse.softwareEngineering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testGateway {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
