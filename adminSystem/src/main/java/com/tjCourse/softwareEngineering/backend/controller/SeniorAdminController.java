package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.backend.service.SeniorAdminService;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/senior",produces = "application/json;charset=utf-8")
public class SeniorAdminController extends CURDController<SeniorAdmin,Integer, SeniorAdminService> {
    @GetMapping(value = "/basic/{id}")
    public ResponseEntity<ReturnAdminInfoDTO> getSeniorAdminBasicInfo(@PathVariable("id")Integer id){
        try {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
