package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.User;
import com.tjCourse.softwareEngineering.backend.service.UserService;
import com.tjCourse.softwareEngineering.backend.service.implementation.UserServiceImpl;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/information",produces = "application/json;charset=utf-8")
public class UserController extends CURDController<User,Integer, UserService> {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/basic/{id}")
    public ResponseEntity<ReturnBasicInfoDTO> getBasicInfo(@PathVariable("id")Integer userID){
        return new ResponseEntity<>(userServiceImpl.getBasicInfoById(userID), HttpStatus.OK);
    }
}
