package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.Implementation.NormalAdminServiceImpl;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin",produces = "application/json;charset=utf-8")
public class AdminController extends CURDController<NormalAdmin,Integer, NormalAdminService> {
    @Autowired
    NormalAdminServiceImpl normalAdminService;


    @GetMapping(value = "/basic/{id}")
    public ResponseEntity<ReturnAdminInfoDTO> getBasicInfo(@PathVariable("id")int ID){
        return new ResponseEntity<>(normalAdminService.getAdminOwnInfo(ID), HttpStatus.OK);
    }

}
