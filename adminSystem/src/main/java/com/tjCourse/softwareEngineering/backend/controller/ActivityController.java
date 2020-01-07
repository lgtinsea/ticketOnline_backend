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
    public ResponseEntity<Object> getActivitiesBasicInfo(@RequestParam("ID")Integer ID, @RequestParam("role")Integer role){
        try {
            List<ReturnActivitiesDTO> list_activity = activityService.getActivityInfo(ID,role);
            if(list_activity == null){
                return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
            }else {
                return new ResponseEntity<Object>(list_activity, HttpStatus.OK) ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping(value = "")
    public ResponseEntity<List<ReturnActivitiesCoverDTO>> getActivitiesCoverInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        try {
            List<ReturnActivitiesCoverDTO> list = activityService.getActivityCover(ID,role);
            if (list == null){
                return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
            }else {
                return new ResponseEntity<>(list,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/report")
    public ResponseEntity<List<ReturnActivityReportDTO>> getActivitiesReport(){
        try {
            return new ResponseEntity<>(activityService.getActivityReport(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> updateActivityInfo(@RequestBody Activity activity){
        try {
            return new ResponseEntity<>(activityService.updateActivity(activity),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Boolean> checkActivity(@RequestParam("draftID")Integer draftID,@RequestParam Integer adminID,@RequestParam String opinion, @RequestParam Integer result){
        try {
            return new ResponseEntity<>(activityService.checkActivity(draftID, adminID, opinion, result),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }



    //test
    @GetMapping(value = "/data")
    public void generateData(){
        activityService.generateData();
    }
}
