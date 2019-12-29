package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnLogInDTO;
import com.tjCourse.softwareEngineering.backend.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account", produces = "application/json;charset=utf-8")
public class AccountController {
    @GetMapping(value = "/verification")
    public ResponseEntity<String> getVerificationCode(@RequestParam("emailAddress")String emailAddress){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> signIn(@RequestBody User user){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ReturnLogInDTO> logIn(@RequestParam("emailAddress")String emailAddress,@RequestParam("password")String password){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
