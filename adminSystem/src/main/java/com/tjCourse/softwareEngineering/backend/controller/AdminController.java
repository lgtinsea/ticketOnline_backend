package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.DTO.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin",produces = "application/json;charset=utf-8")
public class AdminController extends CURDController<NormalAdmin,Integer, NormalAdminService> {

    @GetMapping(value = "/basic/{id}")
    public ResponseEntity<ReturnAdminInfoDTO> getBasicInfo(@PathVariable("id")int ID){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
