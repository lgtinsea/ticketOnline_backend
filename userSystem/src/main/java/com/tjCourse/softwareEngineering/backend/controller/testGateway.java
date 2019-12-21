package com.tjCourse.softwareEngineering.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json;charset=utf-8")
public class testGateway {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
