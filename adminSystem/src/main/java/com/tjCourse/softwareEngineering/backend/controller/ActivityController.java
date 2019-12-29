package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesCoverDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivityReportDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.backend.service.Implementation.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities",produces = "application/json;charset=utf-8")
public class ActivityController {
    @Autowired
    ActivityServiceImpl activityService;

    @GetMapping(value = "/basic")
    public ResponseEntity<List<ReturnActivitiesDTO>> getActivitiesBasicInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        List<ReturnActivitiesDTO> list_activity = activityService.getActivityInfo(ID,role);
        if(list_activity == null){
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }else {
            return new ResponseEntity(list_activity, HttpStatus.OK) ;
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ReturnActivitiesCoverDTO>> getActivitiesCoverInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
       List<ReturnActivitiesCoverDTO> list = activityService.getActivityCover(ID,role);
       if (list == null){
           return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
       }else {
           return new ResponseEntity<>(list,HttpStatus.OK);
       }
    }

    @GetMapping(value = "/report")
    public ResponseEntity<List<ReturnActivityReportDTO>> getActivitiesReport(){
        return new ResponseEntity<>(activityService.getActivityReport(), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> updateActivityInfo(@RequestBody Activity activity){
        return new ResponseEntity<>(activityService.updateActivity(activity),HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Boolean> checkActivity(@RequestParam("draftID")Integer draftID,@RequestParam Integer adminID,@RequestParam String opinion, @RequestParam Integer result){
        return new ResponseEntity<>(activityService.checkActivity(draftID, adminID, opinion, result),HttpStatus.OK);
    }
}
