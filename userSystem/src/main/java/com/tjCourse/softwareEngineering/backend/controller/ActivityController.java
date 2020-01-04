package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.backend.service.implementation.ActivityServiceImpl;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities",produces = "application/json;charset=utf-8")
public class ActivityController extends CURDController<Activity,Integer, ActivityService> {
    @Autowired
    ActivityServiceImpl activityService;

    @GetMapping("/basic")
    public ResponseEntity<List<ReturnBasicActivityInfoDTO>> getBasicActivityInfo(@RequestParam("limit")Integer limit, @RequestParam("variety")String variety){
        try {
            if(limit<=0){
                return new ResponseEntity<>(activityService.getActivitiesBasicInfo(variety), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(activityService.getActivitiesBasicInfo_limit(limit,variety),HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }


    }

    @GetMapping(value = "/user/{id}")
    @RequiresAuthentication
    public ResponseEntity<List<ReturnBasicActivityInfoDTO>> getUserActivities(@PathVariable("id")Integer id){
        try {
            return new ResponseEntity<>(activityService.getMyActivitiesBasicInfo(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }


    }


}
