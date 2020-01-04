package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.LoginDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.backend.service.Implementation.NormalAdminServiceImpl;
import com.tjCourse.softwareEngineering.backend.service.Implementation.SeniorAdminServiceImpl;
import com.tjCourse.softwareEngineering.backend.utils.JWTUtil;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Object> addAdminApplication(@RequestParam("emailAddress")String emailAddress, @RequestParam("reason")String reason){
        try {
            Map<String,Boolean> result = new HashMap<>();
            result.put("ifSuccess",normalAdminService.applyForAdmin(emailAddress,reason));
            return new ResponseEntity<Object>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/applications")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public ResponseEntity<List<NormalAdmin>> getAdminApplications(){
        try {
            return new ResponseEntity<>(normalAdminService.getUncheckedAdmin(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/applications")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public ResponseEntity<Boolean> updateAdminApplication(@RequestParam("seniorAdminID")Integer seniorAdminID, @RequestParam Integer normalAdminID ,@RequestParam("status")Integer status){
        try {
            return new ResponseEntity<>(normalAdminService.checkAdmin(seniorAdminID, normalAdminID,status),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
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
    public ResponseEntity<LoginDTO> loginNormal(@RequestParam String email,@RequestParam String password){
        try {
            NormalAdmin normalAdmin = normalAdminService.getNormalAdminByEmailAndPassword(email,password);
            if (normalAdmin==null){
                throw new UnauthenticatedException("username or password incorrect!");
            }else {
                LoginDTO loginDTO = new LoginDTO(normalAdmin);
                loginDTO.setAuthorization(JWTUtil.sign(email,password,"normalAdmin"));
                return new ResponseEntity<>(loginDTO,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/login/senior")
    public ResponseEntity<LoginDTO> loginSenior(@RequestParam String email,@RequestParam String password){
        try {
            SeniorAdmin seniorAdmin = seniorAdminService.getSeniorAdminByEmailAndPassword(email,password);
            if (seniorAdmin==null){
                throw new UnauthenticatedException("username or password incorrect!");
            }else {
                LoginDTO loginDTO = new LoginDTO(seniorAdmin);
                loginDTO.setAuthorization(JWTUtil.sign(email,password,"seniorAdmin"));
                return new ResponseEntity<>(loginDTO,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/verification")
    public ResponseEntity<String> getVerificationCode(@RequestParam("emailAddress")String emailAddress){
        try {
            return new ResponseEntity<>(normalAdminService.getVerifyCode(emailAddress), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

}
