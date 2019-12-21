package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.DTO.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Activity;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities",produces = "application/json;charset=utf-8")
public class ActivityController extends CURDController<Activity,Integer, ActivityService> {
    @GetMapping("/basic")
    public ResponseEntity<List<ReturnBasicActivityInfoDTO>> getBasicActivityInfo(@RequestParam("limit")Integer limit, @RequestParam("variety")String variety){
        if(limit==-1){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
    }
}
