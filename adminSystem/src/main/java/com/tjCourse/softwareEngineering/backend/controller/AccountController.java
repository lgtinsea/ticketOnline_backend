package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/account",produces = "application/json;charset=utf-8")
public class AccountController {
    @Autowired
    NormalAdminService normalAdminService;


    @PostMapping(value = "/admin/applications")
    public ResponseEntity<Boolean> addAdminApplication(@RequestParam("emailAddress")String emailAddress,@RequestParam("reason")String reason){
        return new ResponseEntity<>(normalAdminService.applyForAdmin(emailAddress,reason), HttpStatus.OK);
    }

    @GetMapping(value = "/admin/applications")
    public ResponseEntity<List<NormalAdmin>> getAdminApplications(){
        return new ResponseEntity<>(normalAdminService.getUncheckedAdmin(),HttpStatus.OK);
    }

    @PutMapping(value = "/admin/applications")
    public ResponseEntity<Boolean> updateAdminApplication(@RequestParam("seniorAdminID")Integer seniorAdminID, @RequestParam Integer normalAdminID ,@RequestParam("status")Integer status){
        return new ResponseEntity<>(normalAdminService.checkAdmin(seniorAdminID, normalAdminID,status),HttpStatus.OK);
    }
}
