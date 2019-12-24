package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.pojo.NormalAdmin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account",produces = "application/json;charset=utf-8")
public class AccountController {
    @PostMapping(value = "/admin/applications")
    public ResponseEntity<Boolean> addAdminApplication(@RequestParam("emailAddress")String emailAddress,@RequestParam("password")String password){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/applications")
    public ResponseEntity<NormalAdmin> getAdminApplications(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PutMapping(value = "/admin/applications")
    public ResponseEntity<Boolean> updateAdminApplication(@RequestParam("ID")Integer ID, @RequestParam("ifChecked")Boolean ifChecked){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
