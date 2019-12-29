package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.backend.service.implementation.ActivityServiceImpl;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
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
        if(limit==-1){
            return new ResponseEntity<>(activityService.getActivitiesBasicInfo(variety), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(activityService.getActivitiesBasicInfo_5(variety),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ReturnBasicActivityInfoDTO>> getUserActivities(@PathVariable("id")Integer id){
        return new ResponseEntity<>(activityService.getMyActivitiesBasicInfo(id),HttpStatus.OK);
    }


}
