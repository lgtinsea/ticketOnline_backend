package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.LoginDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnLogInDTO;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.backend.service.UserService;
import com.tjCourse.softwareEngineering.backend.service.implementation.UserServiceImpl;
import com.tjCourse.softwareEngineering.backend.utils.JWTUtil;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account", produces = "application/json;charset=utf-8")
public class AccountController {
    @Autowired
    UserServiceImpl userService;


    @GetMapping(value = "/verification")
    public ResponseEntity<String> getVerificationCode(@RequestParam("emailAddress")String emailAddress){
        try {
            return new ResponseEntity<>(userService.getVerifyCode(emailAddress), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Boolean> signIn(@RequestBody User user){
        try {
            userService.add(user);
            return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginDTO> logIn(@RequestParam("emailAddress")String emailAddress,@RequestParam("password")String password){
        try {
            User user = userService.getUserByEmailAndPassword(emailAddress,password);
            if (user==null){
                throw new UnauthenticatedException("username or password incorrect!");
            }else {
                LoginDTO loginDTO = new LoginDTO(user);
                loginDTO.setAuthorization(JWTUtil.sign(emailAddress,password,"user"));
                return new ResponseEntity<>(loginDTO,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
