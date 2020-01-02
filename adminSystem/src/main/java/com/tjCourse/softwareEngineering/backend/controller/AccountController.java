package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.Implementation.NormalAdminServiceImpl;
import com.tjCourse.softwareEngineering.backend.service.Implementation.SeniorAdminServiceImpl;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.backend.service.SeniorAdminService;
import com.tjCourse.softwareEngineering.backend.utils.JWTUtil;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/account/admin",produces = "application/json;charset=utf-8")
public class AccountController {
    @Autowired
    NormalAdminServiceImpl normalAdminService;

    @Autowired
    SeniorAdminServiceImpl seniorAdminService;


    @PostMapping(value = "/applications")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public ResponseEntity<Boolean> addAdminApplication(@RequestParam("emailAddress")String emailAddress,@RequestParam("reason")String reason){
        return new ResponseEntity<>(normalAdminService.applyForAdmin(emailAddress,reason), HttpStatus.OK);
    }

    @GetMapping(value = "/applications")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public ResponseEntity<List<NormalAdmin>> getAdminApplications(){
        return new ResponseEntity<>(normalAdminService.getUncheckedAdmin(),HttpStatus.OK);
    }

    @PutMapping(value = "/applications")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public ResponseEntity<Boolean> updateAdminApplication(@RequestParam("seniorAdminID")Integer seniorAdminID, @RequestParam Integer normalAdminID ,@RequestParam("status")Integer status){
        return new ResponseEntity<>(normalAdminService.checkAdmin(seniorAdminID, normalAdminID,status),HttpStatus.OK);
    }

    @PostMapping(value = "/sign")
    public ResponseEntity<Boolean> signInNormalAdmin(@RequestBody NormalAdmin normalAdmin){
        try {
            normalAdminService.add(normalAdmin);
            return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping(value = "/login/normal")
    public ResponseEntity<String> loginNormal(@RequestParam String email,@RequestParam String password){
        if (normalAdminService.getNormalAdminByEmailAndPassword(email,password)==null){
            throw new UnauthenticatedException("username or password incorrect!");
        }else {
            return new ResponseEntity<>(JWTUtil.sign(email,password,"normalAdmin"),HttpStatus.OK);
        }
    }

    @PostMapping(value = "/login/senior")
    public ResponseEntity<String> loginSenior(@RequestParam String email,@RequestParam String password){
        if (seniorAdminService.getSeniorAdminByEmailAndPassword(email,password)==null){
            throw new UnauthenticatedException("username or password incorrect!");
        }else {
            return new ResponseEntity<>(JWTUtil.sign(email,password,"seniorAdmin"),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/verification")
    public ResponseEntity<String> getVerificationCode(@RequestParam("emailAddress")String emailAddress){
        return new ResponseEntity<>(normalAdminService.getVerifyCode(emailAddress), HttpStatus.OK);
    }

}
